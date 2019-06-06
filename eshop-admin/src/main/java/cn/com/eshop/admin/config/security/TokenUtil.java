package cn.com.eshop.admin.config.security;/**
 * Created by niejian on 2019/6/3.
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author niejian
 * @date 2019/6/3
 */
@Component
public class TokenUtil extends JwtTokenUtil {
//    @Autowired
//    private RedisService redisService;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * 从缓存中获取用户信息
     *
     * @param token
     * @return
     */
    @Override
    public UserDetails getUserDetails(String token) {
        String userName = getUsernameFromToken(token);
        try {
            // String userInfo = (String)redisService.getValue("auth_user_info_" + userName, String.class);
//            Authentication authentication = authenticationManager.authenticate(token);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            UserDetails jwtUser = (UserDetails)authentication.getPrincipal();
            String userInfo = "";
            JSONObject userObj = JSONObject.fromObject(userInfo);
            JwtUser jwtUser = this.convertUser(userObj);

            return jwtUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JwtUser convertUser(JSONObject userObj) throws Exception{
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername(userObj.optString("username", ""));
        jwtUser.setPassword(userObj.optString("password", ""));
        JSONArray authorities = userObj.getJSONArray("authorities");

        Collection<SimpleGrantedAuthority> authoritiesTmp = new HashSet<>();
        for (int i = 0; i < authorities.size(); i++) {
            JSONObject jsonObject = authorities.getJSONObject(i);
            String role = jsonObject.optString("authority", "");
            authoritiesTmp.add(new SimpleGrantedAuthority(role));
        }
        jwtUser.setAuthorities(authoritiesTmp);

        return jwtUser;
    }
}
