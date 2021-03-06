package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
public interface ISysRoleService extends IService<SysRole> {

    boolean updateRole(SysRole sysRole);

    /**
     * 新增
     * @param sysRole
     * @return
     */
    boolean addRole(SysRole sysRole);

}
