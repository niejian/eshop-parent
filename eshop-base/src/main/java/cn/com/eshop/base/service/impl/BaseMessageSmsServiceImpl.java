package cn.com.eshop.base.service.impl;

import cn.com.eshop.base.entity.BaseMessageSms;
import cn.com.eshop.base.mapper.BaseMessageSmsMapper;
import cn.com.eshop.base.service.IBaseMessageSmsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信或推送信息 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class BaseMessageSmsServiceImpl extends ServiceImpl<BaseMessageSmsMapper, BaseMessageSms> implements IBaseMessageSmsService {

}
