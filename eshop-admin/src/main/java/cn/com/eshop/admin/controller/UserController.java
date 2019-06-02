package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.ResultBeanVo;
import cn.com.eshop.common.vo.TableResultVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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