package cn.com.eshop.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: nj
 * @date: 2019/5/21:上午9:43
 */
@Data
public class ResultBeanVo<T> implements Serializable {
    private Boolean success = false;
    private Integer errCode = -1;
    private String errMsg = "";
    private T data = null;

    public ResultBeanVo success(Boolean success) {
        this.success = success;
        return this;
    }

    public ResultBeanVo errCode(Integer errCode) {
        this.errCode = errCode;
        return this;
    }

    public ResultBeanVo errMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public ResultBeanVo data(T data) {
        this.data = data;
        return this;
    }
}
