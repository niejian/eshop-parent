package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.admin.utils.XtreeNodeVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
public interface ISysMenusService extends IService<SysMenus> {

    /**
     * 获取登陆用户的管理菜单信息，如果有传userId的话
     * @param userId
     * @return
     */
    List<MenuNodeVo> getUserMenuNodeVoList(String userId) throws Exception;

    /**
     * 带复选框的树形菜单信息
     * @param userId
     * @param roleId
     * @return
     * @throws Exception
     */
    List<XtreeNodeVo> getUserXtreeVo(String userId, String roleId) throws Exception;

    /**
     * 新增菜单信息
     * @param sysMenus
     * @return
     * @throws Exception
     */
    boolean addSysMenu(SysMenus sysMenus) throws Exception;

    /**
     * 更新
     * @param sysMenus
     * @return
     * @throws Exception
     */
    boolean updateSysMenu(SysMenus sysMenus) throws Exception;

    boolean del(SysMenus sysMenus) throws Exception;
}
