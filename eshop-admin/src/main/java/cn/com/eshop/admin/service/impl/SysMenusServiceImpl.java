package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.mapper.SysMenusMapper;
import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

        queryWrapper.isNull("parent_id");
        log.info(queryWrapper.getSqlSelect());
        List<SysMenus> rootMenus = this.list(queryWrapper);
        rootMenus.forEach(rootMenu -> {
            MenuNodeVo menuNodeVo = new MenuNodeVo();

            Long rootMenuId = rootMenu.getId();
            List<MenuNodeVo> subMenuNodeVoList = this.getSubMenuNodeVoList(rootMenuId);
            menuNodeVo.setChildren(subMenuNodeVoList);
            menuNodeVo.setSpread(true);
            menuNodeVo.setUrl(rootMenu.getMenuUrl());

            menuNodeVo.setName(rootMenu.getMenuName());
            menuNodeVo.setMenuId(rootMenuId);
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
        queryWrapper.eq("parent_id", menuId);
        List<SysMenus> parentMenus = this.list(queryWrapper);
        parentMenus.forEach(subMenu -> {
            MenuNodeVo menuNodeVo = new MenuNodeVo();

            Long rootMenuId = subMenu.getId();
            List<MenuNodeVo> subMenuNodeVoList = getSubMenuNodeVoList(rootMenuId);
            menuNodeVo.setChildren(subMenuNodeVoList);
            menuNodeVo.setSpread(true);
            menuNodeVo.setUrl(subMenu.getMenuUrl());

            menuNodeVo.setName(subMenu.getMenuName());
            menuNodeVo.setMenuId(rootMenuId);
            menuNodeVoList.add(menuNodeVo);
        });
        return menuNodeVoList;
    }
}
