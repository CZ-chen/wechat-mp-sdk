package tech.nodex.mp.api;

import tech.nodex.mp.model.*;
import static tech.nodex.mp.utils.InvokeUtils.*;
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
