package cn.com.eshop.admin.controller;


import cn.com.eshop.admin.entity.SysRoleMenu;
import cn.com.eshop.admin.service.ISysRoleMenuService;
import cn.com.eshop.common.utils.CommonFunction;
import cn.com.eshop.common.vo.CommonInstance;
import cn.com.eshop.common.vo.ResultBeanVo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * <p>
 * 菜单角色信息表 前端控制器
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Controller
@RequestMapping("/user/roleMenu")
public class SysRoleMenuController {

    @Autowired
    private ISysRoleMenuService roleMenuService;

    @ResponseBody
    @PostMapping(value = "/addRoleMenuHandler")
    public ResultBeanVo<SysRoleMenu> addRoleMenuHandler(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        CommonFunction.beforeProcess(log, jsonObject);

        boolean success = CommonInstance.ERR;
        Integer errCode = CommonInstance.ERR_CODE;
        String errMsg = CommonInstance.ERR_MSG;
        ResultBeanVo<SysRoleMenu> vo = new ResultBeanVo<>();
        boolean isContinue = true;
        try {
            JSONArray menuIds = jsonObject.getJSONArray("menuIds");
            String roleId = jsonObject.optString("roleId", "");
            if (CollectionUtils.isEmpty(menuIds)) {
                errMsg = "请选择相应菜单信息";
                isContinue = false;
            }

            if (isContinue) {
                roleMenuService.addRoleMenu(roleId, menuIds);

                success = CommonInstance.SUCCESS;
                errCode = CommonInstance.SUCCESS_CODE;
                errMsg = CommonInstance.SUCCESS_MSG;
            }

        } catch (Exception e) {
            CommonFunction.genErrorMessage(log, e);
            errMsg = e.getMessage();
            e.printStackTrace();
        }

        return vo.errCode(errCode).errMsg(errMsg).success(success);
    }

}
