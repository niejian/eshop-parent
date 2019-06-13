package cn.com.eshop.admin.service.impl;

import cn.com.eshop.admin.entity.SysUser;
import cn.com.eshop.admin.mapper.SysUserMapper;
import cn.com.eshop.admin.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-19
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 注册用户
     *
     * @param userName
     * @param nickName
     * @param password
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean registryUser(String userName, String nickName, String password) throws Exception{
        SysUser user = new SysUser();
        user.setAvatar(null);
        user.setUserPassword(passwordEncoder.encode(password));
        user.setUserNickName(nickName);
        user.setUserName(userName);
        user.setUserCode(System.currentTimeMillis() + "");
        user.setModifyTime(new Date());
        user.setModifyBy("sys");
        user.setCreateTime(new Date());
        user.setCreateBy("sys");

        return save(user);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     * @throws Exception
     */
    @Override
    public SysUser getUserByUserName(String userName) throws Exception {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        SysUser user = this.getOne(queryWrapper);
        return user;
    }
}
