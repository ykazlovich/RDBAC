package RDBAC;


import RDBAC.model.Item;
import RDBAC.web.jackson.JacksonObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class ItemTestData {

    private static final Item ITEM_1 = new Item(1, "WD10EARX", "WX12018319423");
    private static final Item ITEM_2 = new Item(2, "ST500DM001", "SV39KDHE3");
    private static final Item ITEM_3 = new Item(3, "MK3259GSXP", "TV2KDMWU");

    public static List<Item> itemsCheckList = new ArrayList<>(Arrays.asList(ITEM_1, ITEM_2, ITEM_3));

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
