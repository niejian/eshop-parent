package cn.com.eshop.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping(value = "/menuList")
    public ModelAndView menuList(HttpServletRequest request) {
        ModelAndView modelAndView =new ModelAndView("user/menu/menuList");
        return modelAndView; 
    }

}
