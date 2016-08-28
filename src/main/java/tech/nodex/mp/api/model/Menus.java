package tech.nodex.mp.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by cz on 2016-8-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menus {
    Menu menu;
    List<Menu> conditionalmenu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(List<Menu> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }
}
