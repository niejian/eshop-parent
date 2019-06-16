package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.ResultBeanVo;
import cn.com.eshop.common.vo.TableResultVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateUtils;
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
 * 角色信息表 前端控制器
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Controller
@RequestMapping("/user/role")
public class SysRoleController {

    @Autowired
    private ISysRoleService roleService;

    private static final String DATE_FORMAT_S = "yyyy-MM-dd HH:mm:ss";

    /**
     * 角色管理
     *
     * @return
     */
    @PreAuthorize("hasRole('sysadmin')")
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

    @PreAuthorize("hasRole('sysadmin')")
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
    @PostMapping(value = "/getRoles")
    public TableResultVo<SysRole> editRole(HttpServletRequest request, @RequestBody JSONObject jsonObject) {

        TableResultVo<SysRole> tableResultVo = new TableResultVo<>();
        ResultBeanVo<List<SysRole>> roleResultBeanVo = new ResultBeanVo<>();
        boolean success = false;
        Integer errCode = -1;
        String errMsg = "";
        List<SysRole> beans = new ArrayList<>();
        int count = 0;

        try {
            String roleCode = jsonObject.optString("roleCode", null);
            String roleName = jsonObject.optString("roleName", null);
            Integer pageNum = jsonObject.optInt("page", 1);
            Integer pageSize = jsonObject.optInt("limit", 10);
            Page<SysRole> page = new Page<>(pageNum, pageSize);
            QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();

            if (null != roleCode) {
                queryWrapper.like("role_code", "%" + roleCode + "%");


            }

            if (null != roleName) {
                queryWrapper.like("role_name", "%" + roleName + "%");

            }
            IPage<SysRole> sysRolePages = this.roleService.page(page, queryWrapper);
            if (null != sysRolePages) {
                beans = sysRolePages.getRecords();
            }
            // 获取记录总数
            count = this.roleService.count(queryWrapper);
            success = true;
            errCode = 0;
            errMsg = "请求成功";


        } catch (Exception e) {
            errMsg = e.getMessage();
            log.error(e.getMessage());
            e.printStackTrace();
        }


        return tableResultVo.code(errCode).count(count).data(beans).msg(errMsg);

    }

    @PreAuthorize("hasRole('sysadmin')")
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
            bean = (SysRole) JSONObject.toBean(jsonObject, SysRole.class);
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

    @GetMapping(value = "/addRole")
    public ModelAndView addRole() {
        return new ModelAndView("user/role/addRole");
    }

    @ResponseBody
    @PostMapping(value = "/getRoleByRoleCode")
    public ResultBeanVo<SysRole> getRoleByRoleCode(@RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysRole> roleResultBeanVo = new ResultBeanVo<>();
        boolean success = false;
        Integer errCode = -1;
        String errMsg = "";
        SysRole bean = new SysRole();

        try {
            String roleCode = jsonObject.optString("roleCode", null);
            if (null != roleCode) {
                QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("role_code", roleCode);
                bean = roleService.getOne(queryWrapper);

                success = true;
                errCode = 0;
                errMsg = "请求成功";

            }
        } catch (Exception e) {
            errMsg = e.getMessage();
            log.error(e.getMessage());
            e.printStackTrace();
        }


        return roleResultBeanVo.errCode(errCode).errMsg(errMsg).success(success).data(bean);
    }

    @PreAuthorize("hasRole('sysadmin')")
    @ResponseBody
    @PostMapping(value = "/addRoleHandler")
    public ResultBeanVo<SysRole> addRoleHandler(@RequestBody JSONObject jsonObject) {
        ResultBeanVo<SysRole> roleResultBeanVo = new ResultBeanVo<>();
        boolean success = false;
        Integer errCode = -1;
        String errMsg = "";
        SysRole bean = new SysRole();
        CommonFunction.beforeProcess(log, jsonObject);



        try {
            String roleCode = jsonObject.optString("roleCode", null);
            String roleName = jsonObject.optString("roleName", null);

            if (null != roleCode && null != roleName) {
                Date date = new Date();
                bean.setCreateBy("sys");
                bean.setRoleName(roleName);
                bean.setRoleCode(roleCode);
                bean.setModifyTime(date);
                bean.setModifyBy("sys");
                bean.setCreateTime(date);
                roleService.addRole(bean);
                success = true;
                errCode = 0;
                errMsg = "请求成功";

            }
        } catch (Exception e) {
            errMsg = e.getMessage();
            log.error(e.getMessage());
            CommonFunction.genErrorMessage(log, e);
            e.printStackTrace();
        }


        return roleResultBeanVo.errCode(errCode).errMsg(errMsg).success(success).data(bean);
    }
}
