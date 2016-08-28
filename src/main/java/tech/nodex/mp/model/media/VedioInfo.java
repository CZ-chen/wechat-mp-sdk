package tech.nodex.mp.model.media;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VedioInfo {
    String title,description,down_url;
}
