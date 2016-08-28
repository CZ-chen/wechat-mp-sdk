package tech.nodex.mp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallbacKip {
    List<String> ip_list;

    public List<String> getIp_list() {
        return ip_list;
    }

    public void setIp_list(List<String> ip_list) {
        this.ip_list = ip_list;
    }
}
