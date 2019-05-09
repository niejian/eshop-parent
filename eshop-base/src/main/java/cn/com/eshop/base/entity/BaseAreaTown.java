package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 行政区域县区信息表
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAreaTown implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String areaCode;

    private String townCode;

    private String town;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getAreaCode() {
        return areaCode;
        }

            public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        }
        public String getTownCode() {
        return townCode;
        }

            public void setTownCode(String townCode) {
        this.townCode = townCode;
        }
        public String getTown() {
        return town;
        }

            public void setTown(String town) {
        this.town = town;
        }

    @Override
    public String toString() {
    return "BaseAreaTown{" +
            "id=" + id +
            ", areaCode=" + areaCode +
            ", townCode=" + townCode +
            ", town=" + town +
    "}";
    }
}
