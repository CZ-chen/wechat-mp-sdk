package tech.nodex.mp.model.media;

/**
 * Created by cz on 2016-8-28.
 */
public class MaterialCount {
    Long  voice_count,video_count,image_count,news_count;

    public Long getVoice_count() {
        return voice_count;
    }

    public void setVoice_count(Long voice_count) {
        this.voice_count = voice_count;
    }

    public Long getVideo_count() {
        return video_count;
    }

    public void setVideo_count(Long video_count) {
        this.video_count = video_count;
    }

    public Long getImage_count() {
        return image_count;
    }

    public void setImage_count(Long image_count) {
        this.image_count = image_count;
    }

    public Long getNews_count() {
        return news_count;
    }

    public void setNews_count(Long news_count) {
        this.news_count = news_count;
    }
}
