package cn.com.eshop.common.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * layui table规定返回数据
 *  "code": res.status, //解析接口状态
 *       "msg": res.message, //解析提示文本
 *       "count": res.total, //解析数据长度
 *       "data": res.data.item //解析数据列表
 *
 * @author: nj
 * @date: 2019/5/23:下午2:37
 */
@ToString
@Data
public class TableResultVo<T> implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public TableResultVo<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public TableResultVo<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public TableResultVo<T> count(Integer count) {
        this.count = count;
        return this;
    }

    public TableResultVo<T> data(List<T> data) {
        this.data = data;
        return this;
    }

}
