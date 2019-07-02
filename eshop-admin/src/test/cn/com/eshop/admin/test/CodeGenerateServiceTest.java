package cn.com.eshop.admin.test;/**
 * Created by niejian on 2019/7/2.
 */

import cn.com.eshop.admin.service.SysCodeAutoGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niejian
 * @date 2019/7/2
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CodeGenerateServiceTest {

    @Autowired
    private SysCodeAutoGenerateService sysCodeAutoGenerateService;

    @Ignore
    @Test
    public void getTablesNames() {
        List<String> tables = this.sysCodeAutoGenerateService.getTables();
        if (tables.isEmpty()) {
            tables = new ArrayList<>();
        }
        log.info(tables.toString());
    }
}
