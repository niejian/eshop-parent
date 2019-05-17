package cn.com.eshop.product.mapper;

import cn.com.eshop.product.entity.ProdBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 产品品牌 Mapper 接口
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
public interface ProdBrandMapper extends BaseMapper<ProdBrand> {
    List<ProdBrand> getAll();
}
