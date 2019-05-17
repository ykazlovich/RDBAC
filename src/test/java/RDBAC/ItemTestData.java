package RDBAC;


import RDBAC.model.Item;
import RDBAC.web.jakson.JacksonObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class ItemTestData {

    public static final Item itemCheck1 = new Item(1, "WD10EARX", "WX12018319423");
    public static final Item itemCheck2 = new Item(2, "ST500DM001", "SV39KDHE3");
    public static final Item itemCheck3 = new Item(3, "MK3259GSXP", "TV2KDMWU");

    public static List<Item> itemsCheckList = new ArrayList<>();
    static {
        itemsCheckList.add(itemCheck1);
        itemsCheckList.add(itemCheck2);
        itemsCheckList.add(itemCheck3);
    }
    public static ResultMatcher contentJson(Item expected){
        try {
            return content().json(JacksonObjectMapper.getMapper().writeValueAsString(expected));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid write to JSON:\n'" + expected + "'", e);
        }
    }

    public static ResultMatcher iterableContentJson(List<Item> items){
        try {
            return content().json(JacksonObjectMapper.getMapper().writeValueAsString(items));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid write to JSON:\n'" + items + "'", e);
        }
    }


}
