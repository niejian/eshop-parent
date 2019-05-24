package cn.com.eshop.admin.test;

import cn.com.eshop.admin.service.ISysMenusService;
import cn.com.eshop.admin.utils.MenuNodeVo;
import net.sf.json.JSONArray;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: nj
 * @date: 2019/5/24:下午9:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuTest {

    @Autowired
    private ISysMenusService menusService;

    @Ignore
    @Test
    public void testGetMenu() throws Exception{
        List<MenuNodeVo> userMenuNodeVoList = menusService.getUserMenuNodeVoList(null);
        System.out.println(JSONArray.fromObject(userMenuNodeVoList).toString());
    }
}
