package tech.nodex.mp.model.media;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
public class MaterialList<T> {
    String total_count,item_count;
    List<T> item;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public List<T> getItem() {
        return item;
    }

    public void setItem(List<T> item) {
        this.item = item;
    }
}
