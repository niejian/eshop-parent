package cn.com.eshop.base.service.impl;

import cn.com.eshop.base.entity.BaseComment;
import cn.com.eshop.base.mapper.BaseCommentMapper;
import cn.com.eshop.base.service.IBaseCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author code4fun
 * @since 2019-05-09
 */
@Service
public class BaseCommentServiceImpl extends ServiceImpl<BaseCommentMapper, BaseComment> implements IBaseCommentService {

}
