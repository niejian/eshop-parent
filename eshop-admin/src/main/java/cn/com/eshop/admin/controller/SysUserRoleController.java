package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.entity.SysRoleMenu;
import cn.com.eshop.admin.entity.SysUserRole;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.service.ISysRoleMenuService;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.admin.service.ISysUserRoleService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.CommonInstance;
import cn.com.eshop.common.vo.ResultBeanVo;
import cn.com.eshop.common.vo.TableResultVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
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
 * 用户角色信息表 前端控制器
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Controller
@RequestMapping("/user/role")
public class SysUserRoleController {


    @Autowired
    private ISysRoleMenuService roleMenuService;
    @Autowired
    private ISysMenusService menusService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysUserRoleService userRoleService;


    /**
     * 角色菜单管理
     * @param request
     * @return
     */
    @GetMapping(value = "/manageRoleMenu")
    public ModelAndView manageRoleMenuView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        CommonFunction.beforeProcess(log);
        try {

            modelAndView.setViewName("user/role/manageRoleMenu");
            String roleIdStr = request.getParameter("id");
            if (StringUtils.isEmpty(roleIdStr)) {
                return modelAndView;
            }

            modelAndView.addObject("roleId", roleIdStr);

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();
        }

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getMenusByRoleId")
    public TableResultVo<MenuNodeVo> getMenusByRoleId(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        TableResultVo<MenuNodeVo> tableResultVo = new TableResultVo<>();
        CommonFunction.beforeProcess(log, jsonObject);
        ResultBeanVo<List<SysRole>> roleResultBeanVo = new ResultBeanVo<>();
        boolean success = false;
        Integer errCode = -1;
        String errMsg = "";
        List<SysRole> beans = new ArrayList<>();
        int count = 0;
        boolean isContinue = true;
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();

        try {
            String roleId = request.getParameter("roleId");
            if (StringUtils.isEmpty(roleId)) {
                isContinue = false;
            }

            if (isContinue) {
                //通过roleId查询这个角色已经绑定的菜单信息
                QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("role_id", roleId);
                List<SysRoleMenu> roleMenus = this.roleMenuService.list(queryWrapper);
                if (null == roleMenus) {
                    roleMenus = new ArrayList<>();

                }
                menuNodeVoList = this.convertTreeNode(roleMenus);
                success = true;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }
        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();
        }


        return tableResultVo.code(errCode).data(menuNodeVoList).msg(errMsg);
    }

    private List<MenuNodeVo> convertTreeNode(List<SysRoleMenu> roleMenus) throws Exception {
        List<MenuNodeVo> list = new ArrayList<>();

        roleMenus.forEach(roleMenu -> {
            Long menuId = roleMenu.getMenuId();
            if (null != menuId) {
                MenuNodeVo vo = new MenuNodeVo();
                SysMenus menu = this.menusService.getById(menuId);
                vo.setName(menu.getMenuName());
                vo.setSpread(true);
                vo.setNum(menu.getNum());
                vo.setLeaf(menu.getLeaf());
                vo.setIcon(menu.getIcon());
                vo.setMenuCode(menu.getMenuCode());
                vo.setUrl(menu.getMenuUrl());
                vo.setMenuId(menuId);
                list.add(vo);
            }
        });

        return list;
    }

    @GetMapping(value = "/updateUserRole")
    public ModelAndView updateUserRole(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        // 获取所有角色信息
        List<SysRole> roleList = this.roleService.list();
        // 该用户的角色信息
        String userId = request.getParameter("userId");
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<SysUserRole> userRoleList = this.userRoleService.list(queryWrapper);
        if (CollectionUtils.isEmpty(userRoleList)) {
            userRoleList = new ArrayList<>();
        }

        JSONArray jsonArray = new JSONArray();
        for (SysRole sysRole : roleList) {
            boolean checked = false;

            JSONObject jsonObject = JSONObject.fromObject(sysRole);
            for (SysUserRole userRole : userRoleList) {
                if (sysRole.getId() == userRole.getRoleId()) {
                    checked = true;
                    break;
                }

            }
            jsonObject.put("checked", checked);

            jsonArray.add(jsonObject);

        }



        modelAndView.addObject("list", jsonArray);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName("user/manageUserRoles");


        return modelAndView;
    }

    @PreAuthorize("hasRole('sysadmin')")
    @ResponseBody
    @PostMapping(value = "/updateUserRole")
    public ResultBeanVo<String> updateUserRole(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<String> result = new ResultBeanVo<>();
        CommonFunction.beforeProcess(log, jsonObject);
        boolean isContinue = true;

        try {

            String userId = jsonObject.optString("userId", null);

            if (StringUtils.isEmpty(userId)) {
                isContinue = false;
                errMsg = "用户信息为空";
            }

            JSONArray datas = jsonObject.optJSONArray("data");
//            if (isContinue && CollectionUtils.isEmpty(datas)) {
//                isContinue = false;
//                errMsg = "角色信息为空";
//            }

            if (isContinue) {
                String currentUser = (String) request.getSession().getAttribute("current_user_name");
                List<SysUserRole> userRoles = new ArrayList<>();
                Date date = new Date();
                for (int i = 0; i < datas.size(); i++) {
                    SysUserRole userRole = new SysUserRole();
                    JSONObject data = datas.getJSONObject(i);
                    userRole.setCreateBy(currentUser);
                    userRole.setUserId(Long.parseLong(userId));
                    userRole.setRoleId(data.getLong("id"));
                    userRole.setRoleCode(data.getString("roleCode"));
                    userRole.setModifyTime(date);
                    userRole.setModifyBy(currentUser);
                    userRole.setCreateTime(date);
                    userRoles.add(userRole);
                }


                userRoleService.updateUserRole(userId, userRoles);


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

}
