package cn.com.eshop.product.test;

import cn.com.eshop.product.entity.ProdBrand;
import cn.com.eshop.product.service.IProdBrandService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author: nj
 * @date: 2019/5/9:下午2:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProdTest {
    @Autowired
    private IProdBrandService prodBrandService;

    @Ignore
    @Test
    public void addProdBrand() {
        Date date = new Date();
        ProdBrand prodBrand = new ProdBrand();
        prodBrand.setBrandCode("120001");
        prodBrand.setRemark("");
        prodBrand.setOrderNum(1);
        prodBrand.setModifyTime(date);
        prodBrand.setModifyByIds("12");
        prodBrand.setFlagDelete(0);
        prodBrand.setCreateTime(date);
        prodBrand.setCreateByIds("23");
        prodBrand.setBrandName("xsd");
        prodBrandService.save(prodBrand);
    }

    @Ignore
    @Test
    public void getOne() {
        List<ProdBrand> all = prodBrandService.getAll();
        System.out.println(all.toString());
    }

}
