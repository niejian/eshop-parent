package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 城市
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAreaCitie implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String provinceCode;

    private String cityCode;

    private String city;

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
        public String getCityCode() {
        return cityCode;
        }

            public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
        }
        public String getCity() {
        return city;
        }

            public void setCity(String city) {
        this.city = city;
        }

    @Override
    public String toString() {
    return "BaseAreaCitie{" +
            "id=" + id +
            ", provinceCode=" + provinceCode +
            ", cityCode=" + cityCode +
            ", city=" + city +
    "}";
    }
}
