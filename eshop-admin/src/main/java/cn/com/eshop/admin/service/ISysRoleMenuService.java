package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * <p>
 * 菜单角色信息表 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 新增
     * @param roleId
     * @param menuIds
     * @return
     * @throws Exception
     */
    boolean addRoleMenu(String roleId, JSONArray menuIds) throws Exception;

    /**
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    List<SysRoleMenu> getRoleMenuByRoleId(String roleId) throws Exception;

    /**
     * 通过用户Id获取该账号的菜单信息
     * @param userId
     * @return
     * @throws Exception
     */
    List<SysRoleMenu> getRoleMenuByUserId(String userId) throws Exception;

}
