package cn.com.eshop.admin.interceptor;

import cn.com.eshop.admin.config.security.JwtUser;
import cn.com.eshop.admin.config.security.TokenUtil;
import cn.com.eshop.admin.entity.SysUser;
import cn.com.eshop.admin.entity.SysUserRole;
import cn.com.eshop.admin.service.ISysUserRoleService;
import cn.com.eshop.admin.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: nj
 * @date: 2019-06-06:08:57
 */
@Slf4j
@Component
@Order(1000)
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
        implements HandlerInterceptor {

    private static final String LOGIN_TOKEN = "login_token";

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private ISysUserService userService;

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>(
            "StopWatch-StartTime");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();// 1、开始时间
        startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
        // 获取session
        HttpSession session = request.getSession(true);
        String token = (String)session.getAttribute(LOGIN_TOKEN);
        // 判断用户是否存在，不存在就跳转到登录界面
        if (token == null) {
            log.info("------:跳转到login页面！");
            String path = request.getContextPath() + "/user/login";
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
            //builder.append("alert(\"登录已过期，请重新登录！\");");
            builder.append("parent.window.location.href='"+path+"';");
            builder.append("</script>");
            out.print(builder.toString());
            out.close();
//			response.sendRedirect(request.getContextPath() + "/toLogin?isPre=1");
            return false;
        } else {
            session.setAttribute(LOGIN_TOKEN, session.getAttribute(LOGIN_TOKEN));
            handleToken(token, request);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private void handleToken(String authToken, HttpServletRequest request) {
        String tokenHead = "Bearer ";
        authToken = authToken.substring(tokenHead.length());

        String username = tokenUtil.getUsernameFromToken(authToken);

        try {
            if (username != null) {
                UserDetails userDetails = this.convetJwtUser(username);

                log.info("查询的用户角色信息：{}", userDetails.toString());
//
                if (tokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private JwtUser convetJwtUser(String userName) throws Exception {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName).eq("delete_flag", 0);
        SysUser user = userService.getOne(queryWrapper);
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        // 获取用户权限信息
        List<SysUserRole> userRoles = this.userRoleService.getUserRoleByUserId(user.getId());
        userRoles.forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRoleCode()));
        });

        return new JwtUser(userName, user.getUserPassword(), authorities);
    }
}
