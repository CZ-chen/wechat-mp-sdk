package tech.nodex.mp.api;

import tech.nodex.mp.model.*;
import tech.nodex.mp.model.msg.KfMsg;
import tech.nodex.tutils2.http.Requester;
import tech.nodex.tutils2.jackson.JsonUtils;

import java.io.File;
import java.util.List;

import static tech.nodex.mp.utils.InvokeUtils.*;

/**
 * Created by cz on 2016-8-28.
 */
public class MsgApi {
    /**
     * Add kf account.
     *
     * @param access_token the access token
     * @param kfAccount    the kf account
     */
    public static void addKfAccount(String access_token,KfAccount kfAccount){
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/customservice/kfaccount/add",
                JsonUtils.toJson(kfAccount),
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * Update kf account.
     *
     * @param access_token the access token
     * @param kfAccount    the kf account
     */
    public static void updateKfAccount(String access_token,KfAccount kfAccount){
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/customservice/kfaccount/update",
                JsonUtils.toJson(kfAccount),
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * Del kf account.
     *
     * @param access_token the access token
     * @param kfAccount    the kf account
     */
    public static void delKfAccount(String access_token,KfAccount kfAccount){
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/customservice/kfaccount/del",
                JsonUtils.toJson(kfAccount),
                "access_token",
                access_token
        );
        assertNoError(result);
    }

    /**
     * 开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果。
     *
     * @param access_token the access token
     * @param kf_account   the kf account
     * @param img          the img
     */
    public static void uploadKfAtatar(String access_token,String kf_account,File img){
        Requester req = Requester.instance();
        req.setUrl("http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg");
        req.addUrlParm("access_token",access_token);
        req.addUrlParm("kf_account",kf_account);
        req.addFormDataFire("file",img.getName(),img);
        String respBody = executeForString(req);
        assertNoError(respBody);
    }

    private static class KfAccountList{
        List<KfAccount> kf_list;
    }

    public static List<KfAccount> getKfList(String access_token){
        KfAccountList result = get(
                KfAccountList.class,
                "https://api.weixin.qq.com/cgi-bin/menu/get",
                "access_token",
                access_token
            );
        return result.kf_list;
    }

    public static void sendKfMsg(String access_token,KfMsg kfMsg){
        String result = postJson(
                String.class,
                "https://api.weixin.qq.com/customservice/kfaccount/del",
                kfMsg,
                "access_token",
                access_token
        );
        assertNoError(result);
    }
}
