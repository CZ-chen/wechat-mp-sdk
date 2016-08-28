package tech.nodex.mp.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessToken {
    String access_token; //	获取到的凭证
    Long expires_in; //	凭证有效时间，单位：秒

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
