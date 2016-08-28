package tech.nodex.mp;

import org.junit.Test;
import tech.nodex.mp.api.model.Menu;
import tech.nodex.mp.api.model.MenuButton;
import tech.nodex.tutils2.jackson.JsonUtils;

/**
 * Created by cz on 2016-8-28.
 */
public class InvokeHelperTest {

    @Test
    public void test(){
        MenuButton button = new MenuButton();
        button.setName("123");
        button.setUrl("456");

        System.out.println(JsonUtils.toJson(button));
    }
}
