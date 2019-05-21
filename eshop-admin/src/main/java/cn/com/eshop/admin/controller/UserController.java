package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.common.vo.ResultBeanVo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private ISysRoleService roleService;

    private static final String DATE_FORMAT_S = "yyyy-MM-dd HH:mm:ss";

    @GetMapping(value = "/toIndex")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("---->");

        modelAndView.setViewName("index/index2");
        return modelAndView;


    }

    @GetMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("---->");

        modelAndView.setViewName("index/index");
        return modelAndView;


    }

    /**
     * 菜单管理
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
     * @return
     */
    @GetMapping(value = "/manageRights")
    public ModelAndView manageRights() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("user/manageRights");
        return modelAndView;
    }

    /**
     * 角色管理
     * @return
     */
    @GetMapping(value = "/manageRoles")
    public ModelAndView manageRoles() {
        log.info("获取角色信息");
        ModelAndView modelAndView = new ModelAndView();
        // 获取所有角色信息

        List<SysRole> sysRoleList = this.roleService.list();
        if (CollectionUtils.isEmpty(sysRoleList)) {
            sysRoleList = new ArrayList<>();
        }

        modelAndView.addObject("roles", sysRoleList);

        modelAndView.setViewName("user/role/manageRoles");
        return modelAndView;
    }

    @GetMapping(value = "/editRole")
    public ModelAndView editRole(HttpServletRequest request) {
        log.info("获取角色信息");
        String type = request.getParameter("type");
        String id = request.getParameter("id");

        ModelAndView modelAndView = new ModelAndView();
        // 获取所有角色信息

        SysRole sysRole = this.roleService.getById(id);
        if (null == sysRole) {
            sysRole = new SysRole();
        }

        modelAndView.addObject("role", sysRole);
        modelAndView.addObject("type", type);

        modelAndView.setViewName("user/role/editRole");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/updateRole")
    public ResultBeanVo<SysRole> updateRole(@RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysRole> resultBeanVo = new ResultBeanVo<>();
        boolean success = false;
        Integer errCode = -1;
        String errMsg = "";
        SysRole bean = new SysRole();

        try {
            String createTimeStr = jsonObject.optString("createTime", null);
            if (null != createTimeStr) {
                Date createTime = DateUtils.parseDate(createTimeStr, new String[]{DATE_FORMAT_S});
                bean.setCreateTime(createTime);

            }
            jsonObject.remove("createTime");
            bean = (SysRole)JSONObject.toBean(jsonObject, SysRole.class);
            bean.setModifyTime(new Date());

            roleService.updateRole(bean);
            success = true;
            errCode = 0;

        } catch (Exception e) {
            log.info(e.getMessage());

            e.printStackTrace();
        }
        resultBeanVo.success(success)
                .errCode(errCode)
                .errMsg(errMsg);
        return resultBeanVo;
    }

}
