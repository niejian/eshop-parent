package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysUser;
import cn.com.eshop.admin.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * <p>
 * 用户角色信息表 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据userId获取角色信息
     * @param userId
     * @return
     * @throws Exception
     */
    List<SysUserRole> getUserRoleByUserId(long userId) throws Exception;

    /**
     * 更新用户角色信息
     * @param userRoleList
     * @return
     */
    boolean updateUserRole(String userId,  List<SysUserRole> userRoleList);

}
