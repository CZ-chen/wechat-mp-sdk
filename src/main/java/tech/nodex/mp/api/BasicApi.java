package tech.nodex.mp.api;

import tech.nodex.mp.api.model.AccessToken;
import tech.nodex.mp.api.model.CallbacKip;

import static tech.nodex.mp.api.InvokeHelper.*;
/**
 * Created by cz on 2016-8-28.
 */
public class BasicApi {

    public static AccessToken getAaccessToken(String appid, String secret){
        return get(
                AccessToken.class,
                "https://api.weixin.qq.com/cgi-bin/token",
                "grant_type,appid,secret",
               "client_credential",appid,secret
        );
    }

    public static CallbacKip getCallbacKip(String access_token){
        return get(
                CallbacKip.class,
                "https://api.weixin.qq.com/cgi-bin/getcallbackip",
                "access_token",
                access_token
        );
    }
}
