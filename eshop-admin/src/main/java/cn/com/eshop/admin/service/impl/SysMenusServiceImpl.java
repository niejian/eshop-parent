package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.entity.SysRoleMenu;
import cn.com.eshop.admin.mapper.SysMenusMapper;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.service.ISysRoleMenuService;
import cn.com.eshop.admin.service.ISysRoleService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.admin.utils.XtreeNodeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Service
public class SysMenusServiceImpl extends ServiceImpl<SysMenusMapper, SysMenus> implements ISysMenusService {

    @Autowired
    private ISysRoleMenuService roleMenuService;



    private Set<String> userUniqueMenuId(String userId) throws Exception {
        List<SysRoleMenu> roleMenuList = roleMenuService.getRoleMenuByUserId(userId);
        Set<String> set = new HashSet<>();
        roleMenuList.forEach(roleMenu -> {
            long menuId = roleMenu.getMenuId();
            SysMenus menu = this.getById(menuId);
            if (null != menu) {
                String parentIds = menu.getParentIds();
                String[] parentArr = parentIds.split(",");
                set.addAll(Arrays.asList(parentArr));
            }
            set.add(roleMenu.getMenuId() + "");
        });
        return set;

    }


    /**
     * 获取登陆用户的管理菜单信息，如果有传userId的话
     *
     * @param userId
     * @return
     */
    @Override
    public List<MenuNodeVo> getUserMenuNodeVoList(String userId) throws Exception {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();
        Set<String> userMenuIdSet = new HashSet<>();

        // userId不为空，说明登录用户是 普通用户否则是sysadmin
        if (!StringUtils.isEmpty(userId)) {
            userMenuIdSet = userUniqueMenuId(userId);
        }
        // 1.获取根节点信息
        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();

        // 根菜单并且菜单类型是0 的信息
        queryWrapper.isNull("parent_id")
                .eq("menu_type", 0)
                .orderByAsc("num");
        log.info(queryWrapper.getSqlSelect());
        List<SysMenus> rootMenus = this.list(queryWrapper);
        for (SysMenus rootMenu : rootMenus) {
            MenuNodeVo menuNodeVo = this.convertMenuNode(rootMenu);

            Long rootMenuId = rootMenu.getId();
            List<MenuNodeVo> subMenuNodeVoList = this.getSubMenuNodeVoList(rootMenuId, userId, userMenuIdSet);
            menuNodeVo.setChildren(subMenuNodeVoList);
            menuNodeVo.setSpread(true);

            menuNodeVoList.add(menuNodeVo);
        }
//        rootMenus.forEach(rootMenu -> {
//            MenuNodeVo menuNodeVo = this.convertMenuNode(rootMenu);
//
//            Long rootMenuId = rootMenu.getId();
//            List<MenuNodeVo> subMenuNodeVoList = this.getSubMenuNodeVoList(rootMenuId, userId, userMenuIdSet);
//            menuNodeVo.setChildren(subMenuNodeVoList);
//            menuNodeVo.setSpread(true);
////            menuNodeVo.setUrl(rootMenu.getMenuUrl());
//
////            menuNodeVo.setName(rootMenu.getMenuName());
////            menuNodeVo.setMenuId(rootMenuId);
//            menuNodeVoList.add(menuNodeVo);
//        });
        
        return menuNodeVoList;
    }


    /**
     * 循环递归获取子菜单信息
     * @param menuId
     * @return
     */
    public List<MenuNodeVo> getSubMenuNodeVoList(Long menuId, String userId, Set<String> userMenuIdSet) {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();

        if (!StringUtils.isEmpty(userId) && null == userMenuIdSet) {
            userMenuIdSet = new HashSet<>();
        }

        // 如果当前登录用户是sysadmin或者说菜单列表包含当前菜单id
        if (StringUtils.isEmpty(userId) ||
                (!StringUtils.isEmpty(userId) && userMenuIdSet.contains(menuId + ""))
                ) {

            QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", menuId)
                    .eq("menu_type", 0)
                    .orderByAsc("num");
            List<SysMenus> parentMenus = this.list(queryWrapper);
            for (SysMenus subMenu : parentMenus) {
                MenuNodeVo menuNodeVo = this.convertMenuNode(subMenu);

                Long rootMenuId = subMenu.getId();
                if (StringUtils.isEmpty(userId) ||
                        (!StringUtils.isEmpty(userId) && userMenuIdSet.contains(rootMenuId + ""))
                        ) {
                    List<MenuNodeVo> subMenuNodeVoList = getSubMenuNodeVoList(rootMenuId, userId, userMenuIdSet);
                    menuNodeVo.setChildren(subMenuNodeVoList);
                    menuNodeVo.setSpread(true);
//
                    menuNodeVoList.add(menuNodeVo);
                } else {
                    continue;
                }

            }
        }


//        parentMenus.forEach(subMenu -> {
//            MenuNodeVo menuNodeVo = this.convertMenuNode(subMenu);
//
//            Long rootMenuId = subMenu.getId();
//            List<MenuNodeVo> subMenuNodeVoList = getSubMenuNodeVoList(rootMenuId, userId, userMenuIdSet);
//            menuNodeVo.setChildren(subMenuNodeVoList);
//            menuNodeVo.setSpread(true);
////            menuNodeVo.setUrl(subMenu.getMenuUrl());
////
////            menuNodeVo.setName(subMenu.getMenuName());
////            menuNodeVo.setMenuId(rootMenuId);
//            menuNodeVoList.add(menuNodeVo);
//        });
        return menuNodeVoList;
    }

    private MenuNodeVo convertMenuNode(SysMenus sysMenus) {
        MenuNodeVo node = new MenuNodeVo();
        node.setMenuCode(sysMenus.getMenuCode());
        node.setNum(sysMenus.getNum());
        node.setUrl(sysMenus.getMenuUrl());
        node.setMenuId(sysMenus.getId());
        node.setName(sysMenus.getMenuName());
        node.setLeaf(sysMenus.getLeaf());
        node.setIcon(sysMenus.getIcon());

        return node;
    }

    @Override
    public List<XtreeNodeVo> getUserXtreeVo(String userId, String roleId) throws Exception {
        List<XtreeNodeVo> list = new ArrayList<>();

        // 获取该角色绑定的菜单信息
        Set<Long> menuIdSet = getMenuIdsByRoleId(roleId);

        // 1.获取根节点信息
        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();

        // 根菜单并且菜单类型是0 的信息
        queryWrapper.isNull("parent_id")
                .eq("menu_type", 0)
                .orderByAsc("num");
        log.info(queryWrapper.getSqlSelect());
        List<SysMenus> rootMenus = this.list(queryWrapper);
        rootMenus.forEach(rootMenu -> {
            XtreeNodeVo menuNodeVo = this.convertXTreeNode(rootMenu);

            Long rootMenuId = rootMenu.getId();
            if (menuIdSet.contains(rootMenuId)) {
                menuNodeVo.setChecked(true);
            }
            List<XtreeNodeVo> subMenuNodeVoList = this.getSubXtreeNode(rootMenuId, menuIdSet);
            menuNodeVo.setData(subMenuNodeVoList);

            list.add(menuNodeVo);
        });

        return list;
    }

    /**
     * 通过角色Id获取所有绑定的菜单集合信息
     * @param roleId
     * @return
     */
    private Set<Long> getMenuIdsByRoleId(String roleId) throws Exception{

        Set<Long> menuIdSet = new HashSet<>();
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<SysRoleMenu> sysRoleMenus = this.roleMenuService.list(queryWrapper);
        sysRoleMenus.forEach(sysRoleMenu -> {
            menuIdSet.add(sysRoleMenu.getMenuId());
        });


        return menuIdSet;

    }

    private XtreeNodeVo convertXTreeNode(SysMenus menu) {
        XtreeNodeVo vo = new XtreeNodeVo();
        vo.setTitle(menu.getMenuName());
        vo.setValue(menu.getId() + "");
        vo.setData(new ArrayList<>());

        return vo;
    }

    private List<XtreeNodeVo> getSubXtreeNode(long parentMenuId,  Set<Long> menuIdSet) {
        List<XtreeNodeVo> menuNodeVoList = new ArrayList<>();

        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentMenuId)
                .eq("menu_type", 0)
                .orderByAsc("num");
        List<SysMenus> parentMenus = this.list(queryWrapper);
        parentMenus.forEach(subMenu -> {
            XtreeNodeVo menuNodeVo = this.convertXTreeNode(subMenu);

            Long subMenuId = subMenu.getId();
            if (menuIdSet.contains(subMenuId)) {
                menuNodeVo.setChecked(true);
            }
            List<XtreeNodeVo> subMenuNodeVoList = getSubXtreeNode(subMenuId, menuIdSet);
            menuNodeVo.setData(subMenuNodeVoList);

            menuNodeVoList.add(menuNodeVo);

        });

        return menuNodeVoList;
    }

    /**
     * 新增菜单信息
     *
     * @param sysMenus
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addSysMenu(SysMenus sysMenus) throws Exception {
        return save(sysMenus);
    }

    /**
     * 更新
     *
     * @param sysMenus
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSysMenu(SysMenus sysMenus) throws Exception {
        return updateById(sysMenus);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean del(SysMenus sysMenus) throws Exception {
        return removeById(sysMenus.getId());
    }
}
