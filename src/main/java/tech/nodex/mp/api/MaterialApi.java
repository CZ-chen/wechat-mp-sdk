package tech.nodex.mp.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import tech.nodex.mp.model.Menu;
import tech.nodex.mp.model.Menus;
import tech.nodex.mp.model.media.*;
import tech.nodex.tutils2.http.DownloadStream;
import tech.nodex.tutils2.http.HttpResult;
import tech.nodex.tutils2.http.Requester;
import tech.nodex.tutils2.jackson.JsonUtils;
import tech.nodex.tutils2.lang.Strings;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tech.nodex.mp.utils.InvokeUtils.*;

/**
 * 永久素材管理
 * Created by cz on 2016-8-28.
 */
public class MaterialApi {

    /**
     * 新增永久图文素材
     *
     * @param access_token the access token
     * @param menu         the menu
     * @param articles     the articles
     * @return the media
     */
    public static Media addNews(String access_token, Menu menu, List<Article> articles){
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("articles",articles);
        return postJson(
                Media.class,
                "https://api.weixin.qq.com/cgi-bin/menu/create",
                data,
                "access_token",
                access_token
        );
    }

    /**
     * 上传文章用的图片
     *
     * @param access_token the access token
     * @param img          the img
     * @return 图片URL
     */
    public static String uploadImg(String access_token,File img){
        Requester req = Requester.instance();
        req.setUrl("https://api.weixin.qq.com/cgi-bin/media/uploadimg");
        req.addUrlParm("access_token",access_token);
        req.addFormDataFire("file",img.getName(),img);
        String result = executeForString(req);
        assertNoError(result);
        ObjectNode jsonObj = JsonUtils.readJsonObject(result);
        return jsonObj.get("url").asText();
    }

    /**
     * 获取图文素材详情
     * Get news info list.
     *
     * @return the list
     */
    public static News getNewsInfo(String access_token,String media_id){
        return get(
                News.class,
                "https://api.weixin.qq.com/cgi-bin/menu/create",
                "access_token,media_id",
                access_token,media_id
        );
    }

    /**
     * get
     * Get news info list.
     *
     * @return the list
     */
    public static VedioInfo getVedioInfo(String access_token, String media_id){
        return get(
                VedioInfo.class,
                "https://api.weixin.qq.com/cgi-bin/menu/create",
                "access_token,media_id",
                access_token,media_id
        );
    }

    /**
     * 下载永久素材到内存
     *
     * @return the list
     */
    public static byte[] getMaterialContent(String access_token, String media_id){
        Requester requester = createRequester(
                "https://api.weixin.qq.com/cgi-bin/menu/create",
                splitParmNames("access_token,media_id"),
                new Object[]{access_token,media_id}
            );
         return executeForBytes(requester);
    }

    /**
     * 获得临时永久素材下载流, 注意用后必须关闭下载流，否则会造成内存泄露
     *
     * @return the list
     */
    public static DownloadStream getMaterialStrem(String access_token, String media_id) throws IOException {
        Requester requester = createRequester(
                "https://api.weixin.qq.com/cgi-bin/menu/create",
                splitParmNames("access_token,media_id"),
                new Object[]{access_token,media_id}
        );
        return requester.download();
    }

    /**
     * Del material.
     *
     * @param access_token the access token
     * @param media_id     the media id
     */
    public static void delMaterial(String access_token,String media_id){
        Map<String,Object> postData = new HashMap<String,Object>();
        postData.put("media_id",media_id);
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/cgi-bin/material/del_material",
                postData,
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    public static MaterialCount getMaterialCount(String access_token){
        return get(
                MaterialCount.class,
                "https://api.weixin.qq.com/cgi-bin/material/get_materialcount",
                "access_token",
                access_token
        );
    }

    /**
     * 获取图文消息列表
     *
     * @param access_token the access token
     * @param offset       the offset
     * @param count        the count
     * @return the material list
     */
    public static MaterialList<AricleMedia> getNewsList(String access_token,String offset,String count){
        Map<String,Object> postData = new HashMap<String,Object>();
        postData.put("type","news");
        postData.put("offset",offset);
        postData.put("count",count);
        Requester requester = Requester.instance();
        requester.setUrl("https://api.weixin.qq.com/cgi-bin/material/batchget_material");
        requester.setBody(JsonUtils.toJson(postData));
        requester.addUrlParm("access_token",access_token);
        HttpResult result = requester.execute();
        return JsonUtils.fromJson(Strings.fromBytes(result.getRespBody()),new TypeReference<MaterialList<AricleMedia>>(){});
    }

    /**
     * 获取素材列表（除图文消息）
     *
     * @param access_token the access token
     * @param type         the type
     * @param offset       the offset
     * @param count        the count
     * @return the material list
     */
    public static MaterialList<Media> getNewsList(String access_token,String type,String offset,String count){
        if("news".equals(type)){
            throw new IllegalArgumentException("获取图文消息列表请试用: MaterialApi.getNewsList()");
        }
        Map<String,Object> postData = new HashMap<String,Object>();
        postData.put("type",type);
        postData.put("offset",offset);
        postData.put("count",count);
        Requester requester = Requester.instance();
        requester.setUrl("https://api.weixin.qq.com/cgi-bin/material/batchget_material");
        requester.setBody(JsonUtils.toJson(postData));
        requester.addUrlParm("access_token",access_token);
        HttpResult result = requester.execute();
        return JsonUtils.fromJson(Strings.fromBytes(result.getRespBody()),new TypeReference<MaterialList<Media>>(){});
    }

}
