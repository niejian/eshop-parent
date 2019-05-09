### 简介
使用的是springboot搭建的快速开发框架。springboot模块只用了web模块。后续有需要会继续加上
需要装上lomok插件
#### 代码生成模块
代码在`admin模块`下的`utils`包下面。
1. 确定该模块下有哪些业务表。将页面表名复制到下面，144行左右
    ```java
       
       strategy.setInclude(new String[]{
                       "order_base_channel","order_base_logistics","order_base_logistics_area",
                       "order_strategy_convert","order_strategy_convert_detail","order_strategy_present",
                       "order_strategy_present_detail","order_unified_order","order_unified_order_detail",
                       "order_unified_order_extend","order_unified_package","order_unified_package_detail",
                       "order_unified_product_detail"
               });
    ```
2. 运行它的main方法。会提示你输入模块信息
3. 输入模块信息，建议跟项目名一致。比如项目名为eshop-admin，那么模块名就输入admin.这样，生成的代码就会在admin模块里面


