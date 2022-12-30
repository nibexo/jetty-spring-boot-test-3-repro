package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerTest {
    private final int port;
    public ExampleControllerTest(@LocalServerPort int port) {
        this.port = port;
    }

    @Autowired
    private WebApplicationContext context;

    @Test
    public void test() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/example").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        assertNotEquals(0, port);
    }
}
