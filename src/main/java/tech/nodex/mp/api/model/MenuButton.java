package tech.nodex.mp.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuButton {
    /**
     * -key
     */
    public static final String BUTTON_TYPE_CLICK = "click";
    /**
     * URL
     */
    public static final String BUTTON_TYPE_VIEW = "view"; 
    /**
     * 扫码
     * 需要参数: key
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
    /**
     * 拍照发图
     * 需要参数: key
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_PIC_SYSPHOTO = "pic_sysphoto";
    /**
     * 拍照或者相册发图
     * 需要参数: key
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album"; 
    /**
     * 微信相册发图
     * 需要参数: key
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_PIC_WEIXIN = "pic_weixin"; 
    /**
     * 发送位置
     * 需要参数: key
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_LOCATION_SELECT = "location_select"; 
    /**
     * 发送图片
     * 需要参数: media_id
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */
    public static final String BUTTON_TYPE_MEDIA_ID = "media_id";

    /**
    * 发送图文消息
     * 需要参数: media_id
     * 仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
    * */
    public static final String BUTTON_TYPE_VIEW_LIMITED = "view_limited";

    String name;
    String type;
    List<MenuButton> sub_button;
    String key;
    String url;
    String media_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MenuButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<MenuButton> sub_button) {
        this.sub_button = sub_button;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
