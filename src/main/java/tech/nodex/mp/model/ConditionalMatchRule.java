package tech.nodex.mp.model;

/**
 * Created by cz on 2016-8-28.
 */

public class ConditionalMatchRule {
    Integer group_id,sex,client_platform_type;
    String country,province,city;

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getClient_platform_type() {
        return client_platform_type;
    }

    public void setClient_platform_type(Integer client_platform_type) {
        this.client_platform_type = client_platform_type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
