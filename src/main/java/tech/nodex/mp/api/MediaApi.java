package tech.nodex.mp.api;

import tech.nodex.mp.model.media.Media;
import tech.nodex.tutils2.http.DownloadStream;
import tech.nodex.tutils2.http.Requester;

import java.io.File;
import java.io.IOException;

import static tech.nodex.mp.utils.InvokeUtils.*;

/**
 * 临时素材API
 * Created by cz on 2016-8-28.
 */
public class MediaApi {
    /**
     * 上传临时素材.
     *
     * @param access_token the access token
     * @param type         the type
     * @param img          the img
     * @return the media
     */
    public static Media uploadMedia(String access_token, String type, File img){
        Requester req = Requester.instance();
        req.setUrl("https://api.weixin.qq.com/cgi-bin/media/upload");
        req.addUrlParm("access_token",access_token);
        req.addUrlParm("type",type);
        req.addFormDataFire("file",img.getName(),img);
        return executeForObject(req,Media.class);
    }

    /**
     * 获得临时素材下载流, 注意用后必须关闭下载流，否则会造成内存泄露
     *
     * @param access_token the access token
     * @param media_id     the media id
     * @return the download stream
     * @throws IOException the io exception
     */
    public static DownloadStream getMediaStrem(String access_token,String media_id) throws IOException {
        Requester requester = createRequester(
                "https://api.weixin.qq.com/cgi-bin/media/get",
                splitParmNames("access_token,media_id"),
                new String[]{access_token,media_id}
                );
        return requester.download();
    }

    /**
     * 下载临时素材到内存
     *
     * @param access_token the access token
     * @param media_id     the media id
     * @return the download stream
     * @throws IOException the io exception
     */
    public static byte[] getMedia(String access_token,String media_id) throws IOException {
        Requester requester = createRequester(
                "https://api.weixin.qq.com/cgi-bin/media/get",
                splitParmNames("access_token,media_id"),
                new String[]{access_token,media_id}
        );
        return executeForBytes(requester);
    }
}
