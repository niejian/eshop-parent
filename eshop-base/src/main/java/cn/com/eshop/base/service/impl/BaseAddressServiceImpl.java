package cn.com.eshop.base.service.impl;

import cn.com.eshop.base.entity.BaseAddress;
import cn.com.eshop.base.mapper.BaseAddressMapper;
import cn.com.eshop.base.service.IBaseAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class BaseAddressServiceImpl extends ServiceImpl<BaseAddressMapper, BaseAddress> implements IBaseAddressService {

}
