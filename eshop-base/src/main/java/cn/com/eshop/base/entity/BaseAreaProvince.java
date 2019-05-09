package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 省份
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAreaProvince implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String provinceCode;

    private String province;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getProvinceCode() {
        return provinceCode;
        }

            public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        }
        public String getProvince() {
        return province;
        }

            public void setProvince(String province) {
        this.province = province;
        }

    @Override
    public String toString() {
    return "BaseAreaProvince{" +
            "id=" + id +
            ", provinceCode=" + provinceCode +
            ", province=" + province +
    "}";
    }
}
