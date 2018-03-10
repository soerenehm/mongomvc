package de.testbase;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MongoMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void personalTest() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("1969")));
    }

    @Test
    public void personalFilterTest() throws Exception {
        mockMvc.perform(get("/persoenlich/Ehm/filter?year=1969")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("1969")));
    }

    @Test
    public void personalFilterNotFoundTest() {
        try {
            mockMvc.perform(get("/persoenlich/Ehm/filter?year=1970")).andDo(print()).andExpect(status().isOk());
            fail("Person must not be found.");
        }
        catch (Exception ex) {
            assertTrue(true);
        }
    }

}
