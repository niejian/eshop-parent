package cn.com.eshop.base.service.impl;

import cn.com.eshop.base.entity.BaseOperatLog;
import cn.com.eshop.base.mapper.BaseOperatLogMapper;
import cn.com.eshop.base.service.IBaseOperatLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class BaseOperatLogServiceImpl extends ServiceImpl<BaseOperatLogMapper, BaseOperatLog> implements IBaseOperatLogService {

}
