package RDBAC.controller;

import RDBAC.ItemTestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringJUnitWebConfig(locations = {
        "classpath:/spring.xml",
        "classpath:/dispatcher-servlet.xml",
        "classpath:/spring-db-test.xml"})
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class ItemRestControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getById() throws Exception {
        mvc.perform(get("/v1/items/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(ItemTestData.contentJson(ItemTestData.itemCheck1));
    }

    @Test
    void getAll() throws Exception {
        mvc.perform(get("/v1/items/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(ItemTestData.iterableContentJson(ItemTestData.itemsCheckList));
    }
}