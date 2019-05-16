package RDBAC;


import RDBAC.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemTestData {
    public static final Item itemCheck1 = new Item(1, "WD10EARX", "WX12018319423");
    public static final Item itemCheck2 = new Item(2, "ST500DM001", "SV39KDHE3");
    public static final Item itemCheck3 = new Item(3, "MK3259GSXP", "TV2KDMWU");

    public static List<Item> itemsCheckList = List.of(itemCheck1, itemCheck2, itemCheck3);

}
