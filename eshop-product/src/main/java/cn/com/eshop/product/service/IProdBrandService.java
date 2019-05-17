package cn.com.eshop.product.service;

import cn.com.eshop.product.entity.ProdBrand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品品牌 服务类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
public interface IProdBrandService extends IService<ProdBrand> {

    /**
     * 获取所有
     * @return
     */
    List<ProdBrand> getAll();
}
