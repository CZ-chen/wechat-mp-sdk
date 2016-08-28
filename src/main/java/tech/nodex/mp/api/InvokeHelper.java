package tech.nodex.mp.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import tech.nodex.tutils2.http.HttpResult;
import tech.nodex.tutils2.http.Requester;
import tech.nodex.tutils2.jackson.JsonUtils;
import tech.nodex.tutils2.lang.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by cz on 2016-8-27.
 */
public class InvokeHelper {
    private static final Map<String,String[]> PARM_NAMES_MAP = new HashMap<String,String[]>();

    public static <T>T postJson(Class<T> targetType,String url,Object postData,String parmNamesStr,Object ... parmVals){
        return post(targetType,url,Strings.getBytes(JsonUtils.toJson(postData)),parmNamesStr,parmVals);
    }

    public static <T>T post(Class<T> targetType,String url,byte[] postData,String parmNamesStr,Object ... parmVals){
        String[] parmNames = splitParmNames(parmNamesStr);
        Requester req = createRequester(url, postData, parmNames, parmVals);
        return executeForObject(req,targetType);
    }

    public static <T>T get(Class<T> targetType,String url,String parmNamesStr,Object ... parmVals){
        String[] parmNames = splitParmNames(parmNamesStr);
        Requester req = createRequester(url, parmNames, parmVals);
        return executeForObject(req,targetType);
    }

    private static Requester createRequester(String url, String[] parmNames, Object[] parmVals) {
        asserParmsCountMatch(parmNames,parmVals);
        Requester req = Requester.instance().setMethod(Requester.Method.GET).setUrl(url);
        if(parmNames!=null){
            for(int i=0;i<parmNames.length;i++){
                req.addUrlParm(parmNames[i],parmVals[i]);
            }
        }
        return req;
    }

    private static Requester createRequester(String url, byte[] postData,String[] parmNames, Object[] parmVals) {
        asserParmsCountMatch(parmNames,parmVals);
        Requester req = Requester.instance().setMethod(Requester.Method.POST).setUrl(url).setBody(postData);
        if(parmNames!=null){
            for(int i=0;i<parmNames.length;i++){
                req.addUrlParm(parmNames[i],parmVals[i]);
            }
        }
        return req;
    }

    public static <T> T executeForObject(Requester req,Class<T> targetType){
        if(CharSequence.class.isAssignableFrom(targetType)){
            return (T)executeForString(req);
        }
        return JsonUtils.fromJson(executeForString(req),targetType);
    }

    public static String executeForString(Requester req){
        HttpResult result = req.execute();
        assertHasContent(result);
        return Strings.fromBytes(result.getRespBody());
    }

    public static String[] splitParmNames(String parmNamesStr){
        if(StringUtils.isBlank(parmNamesStr)){
            return null;
        }
        String[] parmNames = PARM_NAMES_MAP.get(parmNamesStr);
        if(parmNames==null){
            parmNames = parmNamesStr.replaceAll("\\s+","").split(",");
            PARM_NAMES_MAP.put(parmNamesStr,parmNames);
        }
        return parmNames;
    }

    public static void assertNoError(String respBody){
        try{
            ObjectNode objNode = JsonUtils.readJsonObject(respBody);
            JsonNode errcode = objNode.get("errcode");
            if(errcode!=null && errcode.asLong()>0 ){
                throw new ApiInvokeException("Receive a error msg:" + respBody);
            }
        }catch (Exception ex){
            throw new ApiInvokeException(ex);
        }

    }

    private static void assertHasContent(HttpResult result){
        try{
            assert result!=null;
            assert Integer.valueOf(result.getCode()).equals(200);
            assert result.getRespBody()!=null;
        }catch (Exception ex){
            throw new ApiInvokeException(ex);
        }
    }

    private static void asserParmsCountMatch(String[] parmNames,Object[] parmVals){
        try{
            if(parmNames==null && parmVals==null){
                return;
            }
            assert parmNames.length == parmVals.length;
        }catch (Exception ex){
            throw new ApiInvokeException("HTPP请求参数数量不匹配: names:[" + Arrays.toString(parmNames) +"] , values:[" + Arrays.toString(parmVals) +"]",ex);
        }
    }
}