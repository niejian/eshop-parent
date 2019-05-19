package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

        modelAndView.setViewName("user/manageRoles");
        return modelAndView;
    }
}
