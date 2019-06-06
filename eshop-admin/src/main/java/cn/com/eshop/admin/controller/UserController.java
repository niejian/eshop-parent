package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import cn.com.eshop.admin.config.security.TokenUtil;
import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.entity.SysUser;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.admin.service.ISysUserService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.CommonInstance;
import cn.com.eshop.common.vo.ResultBeanVo;
import cn.com.eshop.common.vo.TableResultVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author niejian
 * @date 2019/5/18
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysMenusService menusService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ResponseBody
    @PostMapping(value = "/doLogin")
    public ResultBeanVo<String> doLogin(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        CommonFunction.beforeProcess(log, jsonObject);
        boolean success = CommonInstance.ERR;
        boolean isContinue = true;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        String token = "";
        ResultBeanVo<String> vo = new ResultBeanVo<>();

        try {

            // TODO 校验验证码是否正确
            String username = jsonObject.optString("username", null);
            String password = jsonObject.optString("password", null);

            if (StringUtils.isEmpty(username)) {
                isContinue = false;
                errMsg = "请填写登录账号";

            }

            if (isContinue && org.springframework.util.StringUtils.isEmpty(password)) {
                isContinue = false;
                errMsg = "请输入密码";

            }

            if (isContinue) {
                UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
                Authentication authentication = authenticationManager.authenticate(upToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                UserDetails userDetails = (UserDetails)authentication.getPrincipal();
                // 将token返回出去
                token = tokenUtil.generateToken(userDetails);
                HttpSession session = request.getSession();
                session.setAttribute("login_token", token);
                session.setAttribute("auth_user_info_" + username, JSONObject.fromObject(userDetails));

                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }


        } catch (Exception e) {
            errMsg = e.getMessage();
            if (e instanceof BadCredentialsException) {
                errMsg = "密码错误，请重新输入";
            } else if (e instanceof InternalAuthenticationServiceException) {
                errMsg = "用户不存在，请先注册再登陆";
            }


            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();

        }

        return vo.data(token).success(success).errMsg(errMsg).errCode(errCode);
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("user/signup");
    }

    @ResponseBody
    @PostMapping(value = "/doRegistry")
    public ResultBeanVo<String> doRegistry(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        CommonFunction.beforeProcess(log, jsonObject);
        boolean success = CommonInstance.ERR;
        boolean isContinue = true;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> vo = new ResultBeanVo<>();

        try {
            String userName = jsonObject.optString("userName", "");
            String password = jsonObject.optString("userPassword", "");
            String userNickName = jsonObject.optString("userNickName", "");
            if (StringUtils.isEmpty(userName)) {
                errMsg = "请输入用户名";
                isContinue = false;

            }

            if (isContinue && StringUtils.isEmpty(password)) {
                errMsg = "请输入密码";
                isContinue = false;

            }

            if (isContinue && StringUtils.isEmpty(userNickName)) {
                errMsg = "请输入昵称";
                isContinue = false;
            }

            if (isContinue) {
                sysUserService.registryUser(userName, userNickName, password);

                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            errMsg = e.getMessage();
            e.printStackTrace();
        }


        return vo.data("").success(success).errMsg(errMsg).errCode(errCode);
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping(value = "/toIndex")
    public ModelAndView toIndex() {

        ModelAndView modelAndView = new ModelAndView();
        log.info("---->");

        modelAndView.setViewName("index/index2");
        return modelAndView;


    }

    @GetMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        CommonFunction.beforeProcess(log);
        // 获取用户菜单信息
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();

        try {
            menuNodeVoList = this.menusService.getUserMenuNodeVoList(null);
            if (null == menuNodeVoList) {
                menuNodeVoList = new ArrayList<>();
            }
            modelAndView.setViewName("index/index");
            modelAndView.addObject("menus", JSONArray.fromObject(menuNodeVoList).toString());
        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
        }



        return modelAndView;


    }

    /**
     * 菜单管理
     *
     * @return
     */
    @GetMapping(value = "/manageMenus")
    public ModelAndView menu() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/manageMenus");
        return modelAndView;
    }


    /**
     * 菜单管理
     *
     * @return
     */
    @GetMapping(value = "/manageRights")
    public ModelAndView manageRights() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("user/manageRights");
        return modelAndView;
    }


}