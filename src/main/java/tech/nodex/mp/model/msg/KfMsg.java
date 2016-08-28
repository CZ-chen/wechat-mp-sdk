package tech.nodex.mp.model.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import tech.nodex.mp.model.KfAccount;
import tech.nodex.mp.model.media.Media;

/**
 * 当用户和公众号产生特定动作的交互时（具体动作列表请见下方说明），微信将会把消息数据推送给开发者，
 * 开发者可以在一段时间内（目前修改为48小时）调用客服接口，通过POST一个JSON数据包来发送消息给普通用户。此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
 *
 * 如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像），则需在JSON数据包的后半部分加入customservice参数
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KfMsg {
    String touser,msgtype;
    KfAccount customservice;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }


    public KfAccount getCustomservice() {
        return customservice;
    }

    /**
     * 如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像），则需在JSON数据包的后半部分加入customservice参数
     *
     * @param customservice the customservice
     */
    public void setCustomservice(KfAccount customservice) {
        this.customservice = customservice;
    }
}
