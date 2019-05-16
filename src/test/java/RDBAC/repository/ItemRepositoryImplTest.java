package RDBAC.repository;

import RDBAC.ItemTestData;
import RDBAC.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:/spring.xml", "classpath:/spring-db-test.xml"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class ItemRepositoryImplTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void get() {
        Item item = repository.get(1);
        assertEquals(item, ItemTestData.itemCheck1);
    }

    @Test
    void getAll() {
        List<Item> items = repository.getAll();
        assertIterableEquals(items, ItemTestData.itemsCheckList);
    }

    @Test
    void getNotExistItem() {
        Item item = repository.get(999);
        assertNull(item);
    }
}