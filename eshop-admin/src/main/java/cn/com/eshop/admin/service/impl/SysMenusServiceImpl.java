package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.mapper.SysMenusMapper;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import cn.com.eshop.admin.utils.XtreeNodeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * 获取登陆用户的管理菜单信息，如果有传userId的话
     *
     * @param userId
     * @return
     */
    @Override
    public List<MenuNodeVo> getUserMenuNodeVoList(String userId) throws Exception {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();
        // 1.获取根节点信息
        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();

        // 根菜单并且菜单类型是0 的信息
        queryWrapper.isNull("parent_id")
                .eq("menu_type", 0)
                .orderByAsc("num");
        log.info(queryWrapper.getSqlSelect());
        List<SysMenus> rootMenus = this.list(queryWrapper);
        rootMenus.forEach(rootMenu -> {
            MenuNodeVo menuNodeVo = this.convertMenuNode(rootMenu);

            Long rootMenuId = rootMenu.getId();
            List<MenuNodeVo> subMenuNodeVoList = this.getSubMenuNodeVoList(rootMenuId);
            menuNodeVo.setChildren(subMenuNodeVoList);
            menuNodeVo.setSpread(true);
//            menuNodeVo.setUrl(rootMenu.getMenuUrl());

//            menuNodeVo.setName(rootMenu.getMenuName());
//            menuNodeVo.setMenuId(rootMenuId);
            menuNodeVoList.add(menuNodeVo);
        });
        
        return menuNodeVoList;
    }


    /**
     * 循环递归获取子菜单信息
     * @param menuId
     * @return
     */
    public List<MenuNodeVo> getSubMenuNodeVoList(Long menuId) {
        List<MenuNodeVo> menuNodeVoList = new ArrayList<>();

        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", menuId)
                .eq("menu_type", 0)
                .orderByAsc("num");;
        List<SysMenus> parentMenus = this.list(queryWrapper);
        parentMenus.forEach(subMenu -> {
            MenuNodeVo menuNodeVo = this.convertMenuNode(subMenu);

            Long rootMenuId = subMenu.getId();
            List<MenuNodeVo> subMenuNodeVoList = getSubMenuNodeVoList(rootMenuId);
            menuNodeVo.setChildren(subMenuNodeVoList);
            menuNodeVo.setSpread(true);
//            menuNodeVo.setUrl(subMenu.getMenuUrl());
//
//            menuNodeVo.setName(subMenu.getMenuName());
//            menuNodeVo.setMenuId(rootMenuId);
            menuNodeVoList.add(menuNodeVo);
        });
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
    public List<XtreeNodeVo> getUserXtreeVo(String userId) throws Exception {
        List<XtreeNodeVo> list = new ArrayList<>();

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
            List<XtreeNodeVo> subMenuNodeVoList = this.getSubXtreeNode(rootMenuId);
            menuNodeVo.setData(subMenuNodeVoList);

            list.add(menuNodeVo);
        });

        return list;
    }

    private XtreeNodeVo convertXTreeNode(SysMenus menu) {
        XtreeNodeVo vo = new XtreeNodeVo();
        vo.setTitle(menu.getMenuName());
        vo.setValue(menu.getId() + "");
        vo.setData(new ArrayList<>());

        return vo;
    }

    private List<XtreeNodeVo> getSubXtreeNode(long parentMenuId) {
        List<XtreeNodeVo> menuNodeVoList = new ArrayList<>();

        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentMenuId)
                .eq("menu_type", 0)
                .orderByAsc("num");
        List<SysMenus> parentMenus = this.list(queryWrapper);
        parentMenus.forEach(subMenu -> {
            XtreeNodeVo menuNodeVo = this.convertXTreeNode(subMenu);

            Long subMenuId = subMenu.getId();
            List<XtreeNodeVo> subMenuNodeVoList = getSubXtreeNode(subMenuId);
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
