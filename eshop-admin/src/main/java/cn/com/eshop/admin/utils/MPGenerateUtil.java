package cn.com.eshop.admin.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: nj
 * @date: 2019/5/9:上午11:16
 */
public class MPGenerateUtil {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //输入模块名 admin, base product
        String eshopModelName = scanner("请输入模块名");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setDateType(DateType.ONLY_DATE);
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/eshop-"+eshopModelName+"/src/main/java");
        gc.setAuthor("code4fun");
        gc.setOpen(false);
        //设置为true，xml文件能生成baseResultMap等信息
        gc.setBaseColumnList(true)
                .setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://yun2:3306/bluestart?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();


        pc.setParent("cn.com.eshop." + eshopModelName);
        mpg.setPackageInfo(pc);



        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String modelName = pc.getModuleName();
                if (null == modelName) {
                    modelName = "";
                }
                // 通过输入的模块民自定义输出文件名
                return projectPath + "/eshop-"+eshopModelName+"/src/main/java/cn/com/eshop/"+ eshopModelName +"/mapper/" + modelName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表前缀
        //String tablePrefix = scanner("表名");
        //strategy.setInclude(scanner("表名"));
//        strategy.setInclude(new String[]{
//                "base_account_collection","base_account_track","base_address",
//                "base_advertising","base_area","base_area_citie","base_area_province",
//                "base_area_town","base_attachment","base_comment","base_dict",
//                "base_dict_attr","base_long_text","base_message_notice","base_message_sms",
//                "base_operat_log","base_picture_size","base_tag"
//        });
        // prod模块
//        strategy.setInclude(new String[]{
//                "prod_brand","prod_product_category","prod_product_infor",
//                "prod_product_infor_detail","prod_product_stock","prod_storehouse","prod_storehouse_area"
//        });
        //
//        strategy.setInclude(new String[]{
//                "order_base_channel","order_base_logistics","order_base_logistics_area",
//                "order_strategy_convert","order_strategy_convert_detail","order_strategy_present",
//                "order_strategy_present_detail","order_unified_order","order_unified_order_detail",
//                "order_unified_order_extend","order_unified_package","order_unified_package_detail",
//                "order_unified_product_detail"
//        });
        strategy.setInclude(new String[]{
               "sys_menus","sys_role","sys_role_menu","sys_user","sys_user_role"
        });


                //strategy.setTablePrefix(new String[]{tablePrefix});
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("cn.com.vandesr.admin.entity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");


//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setSuperControllerClass(null);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
