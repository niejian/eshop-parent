package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.CommonInstance;
import cn.com.eshop.common.vo.ResultBeanVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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
        ModelAndView modelAndView = new ModelAndView("user/menu/menuList");
        return modelAndView;
    }

    /**
     * 跳转添加菜单页面
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/addMenuView")
    public ModelAndView addMenuView(HttpServletRequest request) {
        Long parentId = Long.parseLong(request.getParameter("parentId"));
        ModelAndView modelAndView = new ModelAndView("user/menu/addMenu");

        if (null != parentId && parentId > 0) {
            // 获取父菜单相信信息
            SysMenus sysMenus = menusService.getById(parentId);
            modelAndView.addObject("parnetMenu", sysMenus);
        }

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

    @PostMapping(value = "/getMenuByMenuCode")
    public ResultBeanVo<SysMenus> getMenuByMenuCode(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysMenus> vo = new ResultBeanVo<>();
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        SysMenus bean = new SysMenus();

        CommonFunction.beforeProcess(log, jsonObject);

        try {
            String menuCode = jsonObject.optString("menuCode", null);

            if (!StringUtils.isEmpty(menuCode)) {
                QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("menu_code", menuCode);
                bean = this.menusService.getOne(queryWrapper);
                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }
        } catch (Exception e) {
            errMsg = e.getMessage();
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();

        }


        return vo.data(bean).success(success).errMsg(errMsg).errCode(errCode);
    }
}

