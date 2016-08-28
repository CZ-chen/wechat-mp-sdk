package tech.nodex.mp;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import tech.nodex.mp.model.media.Article;
import tech.nodex.tutils2.jackson.JsonUtils;
import tech.nodex.mp.model.*;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
public class InvokeHelperTest {
    public static class Result {
        List<Article> news_item;

        public List<Article> getNews_item() {
            return news_item;
        }

        public void setNews_item(List<Article> news_item) {
            this.news_item = news_item;
        }
    }

    @Test
    public void test(){
        String json = "{\n" +
                "    \"news_item\": [\n" +
                "        {\n" +
                "            \"title\": \"TITLE\",\n" +
                "            \"thumb_media_id\": \"THUMB_MEDIA_ID\",\n" +
                "            \"show_cover_pic\": 0,\n" +
                "            \"author\": \"AUTHOR\",\n" +
                "            \"digest\": \"DIGEST\",\n" +
                "            \"content\": \"CONTENT\",\n" +
                "            \"url\": \"URL\",\n" +
                "            \"content_source_url\": \"CONTENT_SOURCE_URL\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        Result result = JsonUtils.fromJson(json, Result.class);
        System.out.println(result.news_item.size());
    }
}
