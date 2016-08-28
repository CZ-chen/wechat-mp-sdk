package tech.nodex.mp.model.media;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class News {
    List<Article> news_item;

    public List<Article> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<Article> news_item) {
        this.news_item = news_item;
    }
}
