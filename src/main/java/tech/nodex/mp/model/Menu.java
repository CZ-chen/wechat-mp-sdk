package tech.nodex.mp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
    List<MenuButton> button;
    ConditionalMatchRule matchrule;
    String menuid;

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }

    public ConditionalMatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(ConditionalMatchRule matchrule) {
        this.matchrule = matchrule;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
