package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import cn.com.eshop.admin.config.security.TokenUtil;
import cn.com.eshop.admin.entity.SysUser;
import cn.com.eshop.admin.entity.SysUserRole;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.service.ISysUserRoleService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    private ISysMenusService menusService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationManager authenticationManager;
    private static final String LOGIN_TOKEN = "login_token";
    private static final String TOKEN_HEADER = "Bearer ";

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
                token = loginToken( username, password);

                if (!StringUtils.isEmpty(token)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("login_token", token);
//                session.setAttribute("auth_user_info_" + username, JSONObject.fromObject(userDetails));

                    success = CommonInstance.SUCCESS;
                    errCode = CommonInstance.SUCCESS_CODE;
                    errMsg = CommonInstance.SUCCESS_MSG;
                }

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

    private String loginToken(String userName, String password) throws Exception{
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        // 将token返回出去
        String token = tokenUtil.generateToken(userDetails);
        return token;
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
        List<MenuNodeVo> menuNodeVoList = null;
        boolean isContinue = true;

        try {
            String token = (String) request.getSession().getAttribute(LOGIN_TOKEN);
            String userName = tokenUtil.getUsernameFromToken(token.replace(TOKEN_HEADER, ""));
            String userId = null;
            if (!"sysadmin".equalsIgnoreCase(userName)) {
                SysUser sysUser = this.sysUserService.getUserByUserName(userName);
                if (null != sysUser) {
                    userId = sysUser.getId() + "";
                }else {
                    userId = "-1";
                }

                // 获取当前用户的角色是否包含sysadmin，如果包含，则userId置空
                List<SysUserRole> userRoles = userRoleService.getUserRoleByUserId(Long.parseLong(userId));
                if (userRoles == null) {
                    userRoles = new ArrayList<>();
                }

                for (SysUserRole userRole : userRoles) {
                    if ("sysadmin".equals(userRole.getRoleCode())) {
                        userId = null;
                        break;
                    }
                }


            }

            menuNodeVoList = this.menusService.getUserMenuNodeVoList(userId);
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

    @ResponseBody
    @PostMapping(value = "/getUserByUserName")
    public ResultBeanVo<SysUser> getUserByUserName(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        CommonFunction.beforeProcess(log, jsonObject);
        boolean success = CommonInstance.ERR;
        boolean isContinue = true;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<SysUser> vo = new ResultBeanVo<>();
        SysUser sysUser = null;

        try {
            String userName = jsonObject.optString("userName", "");
            if (StringUtils.isEmpty(userName)) {
                errMsg = "请输入用户名";
                isContinue = false;

            }

            if (isContinue) {
                sysUser = sysUserService.getUserByUserName(userName);

                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            errMsg = e.getMessage();
            e.printStackTrace();
        }


        return vo.data(sysUser).success(success).errMsg(errMsg).errCode(errCode);
    }

    /**
     * 退出登录
     * 1.清空session
     * 2.将token失效
     * @param request
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/logout")
    public ResultBeanVo<String> logout(HttpServletRequest request, @RequestBody  JSONObject jsonObject) {
        CommonFunction.beforeProcess(log, jsonObject);
        boolean success = CommonInstance.ERR;
        boolean isContinue = true;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> vo = new ResultBeanVo<>();
        String token = null;
        try {
            token = jsonObject.optString("token", "");
            if (StringUtils.isEmpty(token)) {
                errMsg = "请输入用户名";
                isContinue = false;

            }

            if (isContinue) {
                token = token.replace(TOKEN_HEADER, "");
                // 判断token是否过期
                Boolean tokenExpired = this.tokenUtil.isTokenExpired(token);
                if (tokenExpired) {
                    errMsg = "登录信息已过期，请重新登录！";
                    isContinue = false;
                }

            }

            if (isContinue) {
                //1.清空session
                request.getSession().removeAttribute(LOGIN_TOKEN);
                //2.将token失效
                errMsg = this.tokenUtil.expireToken(token);


                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                //errMsg = CommonInstance.SUCCESS_MSG;
            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            errMsg = e.getMessage();
            e.printStackTrace();
        }


        return vo.data(errMsg).success(success).errMsg("").errCode(errCode);
    }

    /**
     * 用户信息管理
     * @param request
     * @return
     */
    @PreAuthorize("hasRole('sysadmin')")
    @GetMapping("/userManage")
    public ModelAndView userManage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/userManage");
        return modelAndView;

    }

    @PreAuthorize("hasRole('sysadmin')")
    @ResponseBody
    @PostMapping(value = "/manageUserList")
    public TableResultVo<SysUser> editRole(HttpServletRequest request, @RequestBody JSONObject jsonObject) {

        TableResultVo<SysUser> tableResultVo = new TableResultVo<>();
        ResultBeanVo<List<SysUser>> userResultBeanVo = new ResultBeanVo<>();
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        List<SysUser> beans = new ArrayList<>();
        int count = 0;

        try {
            String userName = jsonObject.optString("userName", null);
            String userNickName = jsonObject.optString("userNickName", null);
            Integer pageNum = jsonObject.optInt("page", 1);
            Integer pageSize = jsonObject.optInt("limit", 10);
            Page<SysUser> page = new Page<>(pageNum, pageSize);
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

            if (null != userName) {
                queryWrapper.like("user_name", "%" + userName + "%");


            }

            if (null != userNickName) {
                queryWrapper.like("user_nick_name", "%" + userNickName + "%");

            }
            IPage<SysUser> sysUserPages = this.sysUserService.page(page, queryWrapper);
            if (null != sysUserPages) {
                beans = sysUserPages.getRecords();
            }
            // 获取记录总数
            count = this.sysUserService.count(queryWrapper);
            success = CommonInstance.SUCCESS;
            errCode = CommonInstance.SUCCESS_CODE;
            errMsg = CommonInstance.SUCCESS_MSG;


        } catch (Exception e) {
            errMsg = e.getMessage();
            log.error(e.getMessage());
            e.printStackTrace();
        }


        return tableResultVo.code(errCode).count(count).data(beans).msg(errMsg);

    }

    @PreAuthorize("hasRole('sysadmin')")
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public ResultBeanVo<String> updateUser(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> result = new ResultBeanVo<>();
        CommonFunction.beforeProcess(log, jsonObject);
        boolean isContinue = true;

        try {
            String id = jsonObject.optString("id", null);
            boolean deleteFlag = jsonObject.optBoolean("deleteFlag", false);

            if (StringUtils.isEmpty(id)) {
                isContinue = false;
                errMsg = "请选择一条数据";
            }

            // 当前登录用户名
            String currentUserName = "";

            //自己不能删除自己
            if (isContinue) {
                // 获取当前登录用户信息
                HttpSession session = request.getSession();
                String token = (String)session.getAttribute(LOGIN_TOKEN);

                currentUserName = tokenUtil.getUsernameFromToken(token.replace("Bearer ", ""));

                if (StringUtils.isEmpty(currentUserName)) {
                    isContinue = false;
                    errMsg = "用户不存在，请重新选择";
                }

            }
            SysUser user = null;
            if (isContinue) {
                user = this.sysUserService.getById(id);
                if (null == user) {
                    isContinue = false;
                    errMsg = "用户不存在，请重新选择";
                }
            }

            if (isContinue && currentUserName.equals(user.getUserName())
                    && deleteFlag) {
                isContinue = false;
                errMsg = "自己不能删除自己，请重新选择";
            }




            if (isContinue) {
                user.setDeleteFlag(deleteFlag);
                user.setModifyTime(new Date());
                this.sysUserService.updateUser(user);
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;

            }


        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();
        }

        return result.success(success)
                .errCode(errCode)
                .errMsg(errMsg);



    }

    @ResponseBody
    @PostMapping(value = "/validPassword")
    public ResultBeanVo<String> validPassword(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> result = new ResultBeanVo<>();
        CommonFunction.beforeProcess(log, jsonObject);
        boolean isContinue = true;
        String data = null;



        try {
            String userName = jsonObject.optString("userName", null);
            String password = jsonObject.optString("password", null);

            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
                isContinue = false;
                errMsg = "请输入旧密码";
            }

            if (isContinue) {
                String token = loginToken( userName, password);

                if (null != token) {
                    success = CommonInstance.SUCCESS;
                    errCode = CommonInstance.SUCCESS_CODE;
                } else {
                    success = CommonInstance.SUCCESS;
                    errCode = CommonInstance.SUCCESS_CODE;

                    errMsg = "原密码不对，请重新输入";
                    data = errMsg;
                }


            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            if (e instanceof BadCredentialsException) {
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = "原密码不对，请重新输入";
                data = errMsg;
            } else if (e instanceof InternalAuthenticationServiceException) {
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = "用户不存在，请先注册再登陆";
                data = errMsg;
            }

            e.printStackTrace();
        }

        return result.success(success)
                .errCode(errCode)
                .errMsg(errMsg).data(data);

    }

    /**
     * 更新密码处理方法
     * @param request
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/doUpdatePassword")
    public ResultBeanVo<String> doUpdatePassword(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> result = new ResultBeanVo<>();
        CommonFunction.beforeProcess(log, jsonObject);
        boolean isContinue = true;
        String data = null;

        try {
            String userName = jsonObject.optString("userName", null);
            String oldpassword = jsonObject.optString("olduserPassword", null);
            String newpassword = jsonObject.optString("newuserPassword", null);

            if (StringUtils.isEmpty(userName) ) {
                isContinue = false;
                errMsg = "用户名为空";
            }

            if (isContinue && StringUtils.isEmpty(oldpassword)) {
                isContinue = false;
                errMsg = "请输入旧密码";
            }

            if (isContinue && StringUtils.isEmpty(oldpassword)) {
                isContinue = false;
                errMsg = "请输入新密码";
            }

            if (isContinue) {
//                password = passwordEncoder.encode(password);
                String token = loginToken( userName, oldpassword);
                // 能登录
                if (null != token) {
                    success = CommonInstance.SUCCESS;
                    errCode = CommonInstance.SUCCESS_CODE;
                    QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("delete_flag", 0).eq("user_name", userName);
                    SysUser user = this.sysUserService.getOne(queryWrapper);
                    if (null != user) {
                        newpassword = passwordEncoder.encode(newpassword);
                        user.setModifyTime(new Date());
                        user.setUserPassword(newpassword);
                        sysUserService.updateUser(user);
                    } else {
                        errMsg = "原密码不对，请重新输入";
                    }
                } else {

                    errMsg = "原密码不对，请重新输入";
                    data = errMsg;
                }


            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            if (e instanceof BadCredentialsException) {
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = "原密码不对，请重新输入";
                data = errMsg;
            } else if (e instanceof InternalAuthenticationServiceException) {
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = "用户不存在，请先注册再登陆";
                data = errMsg;
            }

            e.printStackTrace();
        }

        return result.success(success)
                .errCode(errCode)
                .errMsg(errMsg).data(data);

    }



}