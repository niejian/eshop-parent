package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/7/2.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author niejian
 * @date 2019/7/2
 */

@Slf4j
@Controller
@RequestMapping(value = "/codeGenerate")
public class CodeGenerateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_TABLES = "show tables;";

    /**
     * 获取数据库表信息
     */
    private void getTableInfo() {
        List<String> tableList = this.jdbcTemplate.queryForList(GET_TABLES, String.class);
    }




    public static void main(String[] args) {
        CodeGenerateController codeGenerateController = new CodeGenerateController();
        codeGenerateController.getTableInfo();
    }



}
