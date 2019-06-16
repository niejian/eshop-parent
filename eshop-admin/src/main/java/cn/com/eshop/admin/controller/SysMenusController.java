package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.admin.utils.XtreeNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.CommonInstance;
import cn.com.eshop.common.vo.ResultBeanVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
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

    boolean success = CommonInstance.ERR;
    Integer errCode = CommonInstance.ERR_CODE;
    String errMsg = CommonInstance.ERR_MSG;

    @Autowired
    private ISysMenusService menusService;

    @PreAuthorize("hasRole('sysadmin')")
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
    @PreAuthorize("hasRole('sysadmin')")
    @GetMapping(value = "/addMenuView")
    public ModelAndView addMenuView(HttpServletRequest request) {
        String parentIdStr = request.getParameter("parentId");
        String menuIdStr = request.getParameter("menuId");
        Long parentId = -1L;
        Long menuId = -1L;
        if (!StringUtils.isEmpty(parentIdStr)) {
            parentId = Long.parseLong(parentIdStr);
        }

        if (!StringUtils.isEmpty(menuIdStr)) {
            menuId = Long.parseLong(menuIdStr);
        }

        // add, edit, view
        String type = request.getParameter("type");

        ModelAndView modelAndView = new ModelAndView("user/menu/addMenu");

        if (!StringUtils.isEmpty(type)) {
            modelAndView.addObject("type", type);

            if (null != parentId && parentId > 0 && "add".equals(type)) {
                // 获取父菜单相信信息
                SysMenus sysMenus = menusService.getById(parentId);
                modelAndView.addObject("parnetMenu", sysMenus);
            }

            //查看和编辑页面
            if (!"add".equals(type) && null != menuId && menuId > 0) {
                SysMenus menu = this.menusService.getById(menuId);
                modelAndView.addObject("menu", menu);
            }

        }

        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/getMenuTree")
    public List<MenuNodeVo> getMenuTree(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();
        CommonFunction.beforeProcess(log, jsonObject);
        try {
            menuNodeVoList = this.menusService.getUserMenuNodeVoList(null);
        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
        }

        return menuNodeVoList;
    }

    @ResponseBody
    @PostMapping(value = "/getMenuXTree")
    public List<XtreeNodeVo> getMenuXTree(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        CommonFunction.beforeProcess(log);
        List<XtreeNodeVo> xtreeNodeVos = new ArrayList<>();

        try {
            String roleId = jsonObject.optString("roleId", null);
            String userId = jsonObject.optString("userId", null);
            xtreeNodeVos = this.menusService.getUserXtreeVo(userId, roleId);
        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();

        }

        return xtreeNodeVos;
    }

    @ResponseBody
    @PostMapping(value = "/getMenuByMenuCode")
    public ResultBeanVo<SysMenus> getMenuByMenuCode(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysMenus> vo = new ResultBeanVo<>();

        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        SysMenus bean = null;

        CommonFunction.beforeProcess(log, jsonObject);

        try {
            String menuCode = jsonObject.optString("menuCode", null);

            if (!StringUtils.isEmpty(menuCode)) {
                QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("menu_code", menuCode);
                List<SysMenus> list = this.menusService.list(queryWrapper);
                if (!CollectionUtils.isEmpty(list)) {
                    bean = list.get(0);
                }

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

    /**
     * 添加菜单信息
     * @param request
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/addMenuHandler")
    public ResultBeanVo addMenuHandler(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysMenus> vo = new ResultBeanVo<>();

        SysMenus bean = new SysMenus();
        CommonFunction.beforeProcess(log, jsonObject);


        try {
            bean = (SysMenus)JSONObject.toBean(jsonObject, SysMenus.class);
            // 设置parentIds
            String parentIds = bean.getParentIds();
            bean.setParentIds(parentIds + "," + bean.getParentId());
            Date date = new Date();
            bean.setCreateBy("sys");
            bean.setCreateTime(date);
            bean.setModifyBy("sys");
            bean.setModifyTime(date);

            menusService.addSysMenu(bean);



            success = CommonInstance.SUCCESS;
            errCode = CommonInstance.SUCCESS_CODE;
            errMsg = CommonInstance.SUCCESS_MSG;
        } catch (Exception e) {
            errMsg = e.getMessage();
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();
        }

        return vo.data(bean).success(success).errMsg(errMsg).errCode(errCode);

    }

    /**
     * 更新菜单信息
     * @param request
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/editMenuHandler")
    public ResultBeanVo<SysMenus> editMenu(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysMenus> vo = new ResultBeanVo<>();

        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        SysMenus bean = new SysMenus();

        CommonFunction.beforeProcess(log, jsonObject);

        try {
            bean = (SysMenus) JSONObject.toBean(jsonObject, SysMenus.class);
            // 获取父菜单信息
            Long parentId = bean.getParentId();
            if (null != parentId) {
                SysMenus parentMenu = menusService.getById(parentId);
                if (null != parentMenu) {
                    String parentIds = parentMenu.getParentIds();
                    if (!StringUtils.isEmpty(parentIds)) {
                        bean.setParentIds(parentIds + "," + parentId);

                    }else {
                        bean.setParentIds("" + parentId);
                    }

                    bean.setParentId(parentId);
                    bean.setParentMenuCode(parentMenu.getMenuCode());
                    bean.setParentMenuName(parentMenu.getMenuName());
                }
                bean.setModifyTime(new Date());
                bean.setModifyBy("sys");
                // 更新
                menusService.updateSysMenu(bean);
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

    @ResponseBody
    @PostMapping(value = "/delMenuHandler")
    public ResultBeanVo<SysMenus> delMenuHandler(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysMenus> vo = new ResultBeanVo<>();

        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        SysMenus bean = null;
        Boolean isContinue = true;

        CommonFunction.beforeProcess(log, jsonObject);

        Integer menuId = jsonObject.optInt("menuId", -1);

        try {

            if (-1 == menuId) {
                isContinue = false;
                errMsg = "请选择要删除的菜单";
            }

            if (isContinue && menuId > 0) {
                // 查询是否存在
                bean = this.menusService.getById(menuId);
                if (null == bean) {
                    isContinue = false;
                    errMsg = "菜单不存在，请刷新重试";
                }
            }

            if (isContinue && null != bean) {
                // 更新
                menusService.del(bean);
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

