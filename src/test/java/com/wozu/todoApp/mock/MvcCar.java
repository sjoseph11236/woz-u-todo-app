package com.wozu.todoApp.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MvcCar {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/api/car/beep"))
                .andExpect(status()
                    .isOk())
                .andDo(print());

        MvcResult mvcResult = mockMvc.perform(get("/api/car/vroom"))
                .andExpect(status()
                        .isOk())
                .andDo(print())
                .andReturn();

        String expected = "vroom vroom";
        String actual = mvcResult.getResponse().getContentAsString();

        assertEquals(expected, actual);
    }

}
