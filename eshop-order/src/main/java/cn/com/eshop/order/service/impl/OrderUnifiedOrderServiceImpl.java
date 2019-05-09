package cn.com.eshop.order.service.impl;

import cn.com.eshop.order.entity.OrderUnifiedOrder;
import cn.com.eshop.order.mapper.OrderUnifiedOrderMapper;
import cn.com.eshop.order.service.IOrderUnifiedOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 统一订单 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class OrderUnifiedOrderServiceImpl extends ServiceImpl<OrderUnifiedOrderMapper, OrderUnifiedOrder> implements IOrderUnifiedOrderService {

}
