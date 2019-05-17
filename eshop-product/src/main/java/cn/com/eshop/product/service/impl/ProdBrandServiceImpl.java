package cn.com.eshop.product.service.impl;

import cn.com.eshop.product.entity.ProdBrand;
import cn.com.eshop.product.mapper.ProdBrandMapper;
import cn.com.eshop.product.service.IProdBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品品牌 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class ProdBrandServiceImpl extends ServiceImpl<ProdBrandMapper, ProdBrand> implements IProdBrandService {

    @Autowired
    private ProdBrandMapper prodBrandMapper;
    @Override
    public List<ProdBrand> getAll() {

        return prodBrandMapper.getAll();
    }
}
