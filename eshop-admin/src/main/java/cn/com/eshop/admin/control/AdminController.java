package cn.com.eshop.admin.control;/**
 * Created by niejian on 2019/5/6.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niejian
 * @date 2019/5/6
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/index")
    public Map<String, String> index() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aa", "asd");

        return map;
    }
}
