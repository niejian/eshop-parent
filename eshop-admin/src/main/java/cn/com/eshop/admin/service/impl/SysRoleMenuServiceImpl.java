package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysRoleMenu;
import cn.com.eshop.admin.mapper.SysRoleMenuMapper;
import cn.com.eshop.admin.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单角色信息表 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {


    /**
     * 新增
     *
     * @param roleId
     * @param menuIds
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addRoleMenu(String roleId, JSONArray menuIds) throws Exception {
        // 查roleId绑定的所有菜单信息
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);


        // 删除
        remove(queryWrapper);
        // 新增
        menuIds.forEach(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            Date date = new Date();
            sysRoleMenu.setCreateBy("sys");
            sysRoleMenu.setRoleId(Long.parseLong(roleId));
            sysRoleMenu.setModifyTime(date);
            sysRoleMenu.setModifyBy("sys");
            sysRoleMenu.setMenuId(Long.parseLong((String) menuId));
            sysRoleMenu.setCreateTime(date);
            sysRoleMenu.setCreateBy("sys");
            save(sysRoleMenu);
        });

        return true;
    }

    /**
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<SysRoleMenu> getRoleMenuByRoleId(String roleId) throws Exception {
        List<SysRoleMenu> list = new ArrayList<>();
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        list = this.list(queryWrapper);
        if (null == list) {
            list = new ArrayList<>();
        }
        return list;
    }
}
