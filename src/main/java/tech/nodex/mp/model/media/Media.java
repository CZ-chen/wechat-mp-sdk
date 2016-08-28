package tech.nodex.mp.model.media;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 素材
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Media {
    public static final String media_type_image = "image";
    public static final String media_type_voice = "voice";
    public static final String media_type_video = "video";
    public static final String media_type_thumb = "thumb";

    String type,media_id,created_at,update_time,name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
