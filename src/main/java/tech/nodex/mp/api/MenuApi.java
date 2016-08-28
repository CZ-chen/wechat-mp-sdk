package tech.nodex.mp.api;

import tech.nodex.mp.api.model.AccessToken;
import tech.nodex.mp.api.model.CallbacKip;
import tech.nodex.mp.api.model.Menu;
import tech.nodex.mp.api.model.Menus;
import tech.nodex.tutils2.jackson.JsonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static tech.nodex.mp.api.InvokeHelper.*;

/**
 * 公众号菜单API
 * Created by cz on 2016-8-28.
 */
public class MenuApi {
    /**
     * Create menu.
     *
     * @param access_token the access token
     * @param menu         the menu
     */
    public static void createMenu(String access_token,Menu menu){
        String result = postJson(
                    String.class,
                    "https://api.weixin.qq.com/cgi-bin/menu/create",
                    JsonUtils.toJson(menu),
                    "access_token",
                    access_token
            );
        assertNoError(result);
    }

    /**
     * Create conditional menu.
     *
     * @param access_token the access token
     * @param menu         the menu
     */
    public static void createConditionalMenu(String access_token,Menu menu){
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/cgi-bin/menu/addconditional",
                menu,
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * Get menu menus.
     *
     * @param access_token the access token
     * @return the menus
     */
    public static Menus getMenu(String access_token){
        return get(
                Menus.class,
                "https://api.weixin.qq.com/cgi-bin/menu/get",
                "access_token",
                access_token
        );
    }

    /**
     * Del menu.
     *
     * @param access_token the access token
     */
    public static void delMenu(String access_token){
        String result = get(
                String.class,
                "https://api.weixin.qq.com/cgi-bin/menu/delete",
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * Del conditional menu.
     *
     * @param access_token the access token
     * @param menuId       the menu id
     */
    public static void delConditionalMenu(String access_token,String menuId){
        Map<String,Object> postData = new HashMap<String,Object>();
        postData.put("menuid",menuId);
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/cgi-bin/menu/delconditional",
                postData,
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * 测试个性化菜单匹配
     *
     * @param access_token the access token
     * @param user_id      the user id
     * @return the menu
     */
    public static Menu tryMatch(String access_token,String user_id){
        Map<String,Object> postData = new HashMap<String,Object>();
        postData.put("user_id",user_id);
        return postJson(
                Menu.class,
                "https://api.weixin.qq.com/cgi-bin/menu/trymatch",
                postData,
                "access_token",
                access_token
        );
    }

    /**
     * 获取自定义菜单配置
     *
     * @param access_token the access token
     * @return the string - 参考https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1434698695&token=&lang=zh_CN
     */
    public static String getSelfMenuInfo(String access_token){
        String result = get(
                String.class,
                "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info",
                "access_token",
                access_token
        );
        assertNoError(result);
        return result;
    }
}
