package cn.com.eshop.admin.config.security;/**
 * Created by niejian on 2019/6/3.
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author niejian
 * @date 2019/6/3
 */
@Slf4j
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    //
//    @Autowired
//    private IVandesrUserService userService;
//    @Autowired
//    private IVandesrUserRoleService userRoleService;
//    @Autowired
//    private IVandesrRoleService roleService;
//
//
//    /**
//     * Locates the user based on the username. In the actual implementation, the search
//     * may possibly be case sensitive, or case insensitive depending on how the
//     * implementation instance is configured. In this case, the <code>UserDetails</code>
//     * object that comes back may have a username that is of a different case than what
//     * was actually requested..
//     *
//     * @param username the username identifying the user whose data is required.
//     * @return a fully populated user record (never <code>null</code>)
//     * @throws UsernameNotFoundException if the user could not be found or the user has no
//     *                                   GrantedAuthority
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        QueryWrapper<VandesrUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("email", username)
//                .eq("delete_flag", 0);
//        //通过登陆账号查询用户信息
//        VandesrUser user = userService.getOne(queryWrapper);
//        if (null == user) {
//            try {
//                throw new AccountNotFountException("登陆账号不存在");
//            } catch (Exception e) {
//
//            }
//
//            return new JwtUser(null, null, null);
//c
//
//        } else {
//
//            //获取密码。
//            String userPassword = user.getPwd();
//            //获取用户权限信息
//            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//            List<String> roleCodeList = getUserRolesByUserId(user.getId());
//            roleCodeList.forEach(roleCode -> {
//                authorities.add(new SimpleGrantedAuthority(roleCode));
//            });
//            return new JwtUser(username, userPassword, authorities);
//        }
//
//
//    }
//
//    /**
//     * 根据用户id获取用户角色信息
//     * @return
//     */
//    private List<String> getUserRolesByUserId(int userId) {
//        List<String> roleCodeList = new ArrayList<>();
//        QueryWrapper<VandesrUserRole> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("delete_flag", 0)
//                .eq("user_id", userId);
//        List<VandesrUserRole> userRoles = this.userRoleService.list(queryWrapper);
//        List<Integer> roleIdList = new ArrayList<>();
//        userRoles.forEach(userRole -> {
//            roleIdList.add(userRole.getRoleId());
//        });
//
//        List<VandesrRole> roleList = new ArrayList<>();
//
//        if (!CollectionUtils.isEmpty(roleIdList)) {
//            QueryWrapper<VandesrRole> roleWrapper = new QueryWrapper<>();
//            roleWrapper.eq("delete_flag", 0)
//                    .in("id", roleIdList);
//            roleList = this.roleService.list(roleWrapper);
//        }
//
//        if (!CollectionUtils.isEmpty(roleList)) {
//            roleList.forEach(role -> {
//                roleCodeList.add(role.getRoleCode());
//            });
//        }
//
//        log.info("---->角色信息：{}", roleCodeList.toString());
//
//        return roleCodeList;
//    }

}
