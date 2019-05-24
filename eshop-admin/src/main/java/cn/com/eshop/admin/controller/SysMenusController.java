package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Controller
@RequestMapping("/user/menu")
public class SysMenusController {

    @Autowired
    private ISysMenusService menusService;

    @GetMapping(value = "/menuList")
    public ModelAndView menuList(HttpServletRequest request) {
        ModelAndView modelAndView =new ModelAndView("user/menu/menuList");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/getMenuTree")
    private List<MenuNodeVo> getMenuTree(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();
        CommonFunction.beforeProcess(log, jsonObject);
        try {
            menuNodeVoList = this.menusService.getUserMenuNodeVoList(null);
        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
        }

        return menuNodeVoList;
    }

}
