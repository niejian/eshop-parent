package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/5/18.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author niejian
 * @date 2019/5/18
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/toIndex")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("---->");

        modelAndView.setViewName("index/index2");
        return modelAndView;


    }
}
