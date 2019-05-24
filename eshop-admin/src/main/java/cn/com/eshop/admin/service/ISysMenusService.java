package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysMenus;
import cn.com.eshop.admin.utils.MenuNodeVo;
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
}
