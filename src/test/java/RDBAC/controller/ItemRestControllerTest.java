package RDBAC.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/spring.xml", "/spring-db.xml"})
class ItemRestControllerTest {

    @Autowired
    private ItemRestController controller;

    @Test
    void getById() {
        controller.getById(1);
    }
}