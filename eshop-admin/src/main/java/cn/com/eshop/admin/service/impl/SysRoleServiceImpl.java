package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysRole;
import cn.com.eshop.admin.mapper.SysRoleMapper;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.common.utils.CommonFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateRole(SysRole sysRole) {
        log.info("更新角色信息：{}", sysRole.toString());
        return updateById(sysRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addRole(SysRole sysRole) {
        CommonFunction.beforeProcess(log, sysRole);
        return save(sysRole);
    }
}
