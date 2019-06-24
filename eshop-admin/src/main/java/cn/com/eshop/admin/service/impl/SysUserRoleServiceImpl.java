package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysUserRole;
import cn.com.eshop.admin.mapper.SysUserRoleMapper;
import cn.com.eshop.admin.service.ISysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 用户角色信息表 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    /**
     * 根据userId获取角色信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUserRole> getUserRoleByUserId(long userId) throws Exception {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        return this.list(queryWrapper);
    }

    /**
     * 更新用户角色信息
     *
     * @param userRoleList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserRole(String userId, List<SysUserRole> userRoleList) {

        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        this.remove(queryWrapper);
        if (!CollectionUtils.isEmpty(userRoleList)) {
            saveBatch(userRoleList);

        }
        return true;
    }
}
