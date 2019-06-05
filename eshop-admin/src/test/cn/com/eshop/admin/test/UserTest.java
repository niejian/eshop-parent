package cn.com.eshop.admin.test;


import cn.com.eshop.admin.service.ISysUserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

/**
 * @author: nj
 * @date: 2019/5/9:上午11:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    private ISysUserService sysUserService;

    @Ignore
    @Test
    public void test() {
        String pwd = "qq123123";
        String c = DigestUtils.md5DigestAsHex(pwd.getBytes());
        System.out.printf(c);
        System.out.printf("====");
    }

    @Ignore
    @Test
    public void registryUser() throws Exception{
        String pwd = "qq123123";
        String c = DigestUtils.md5DigestAsHex(pwd.getBytes());
        sysUserService.registryUser("sysadmin", "系统管理员", c);
    }
}
