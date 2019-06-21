package cn.com.eshop.admin.service;

import cn.com.eshop.admin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 注册用户
     * @param userName
     * @param nickName
     * @param password
     * @return
     */
    boolean registryUser(String userName, String nickName, String password) throws Exception;

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    SysUser getUserByUserName(String userName) throws Exception;

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean updateUser(SysUser user) throws Exception;
}
