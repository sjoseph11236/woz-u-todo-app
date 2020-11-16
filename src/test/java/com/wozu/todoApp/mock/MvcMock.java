package com.wozu.todoApp.mock;

import com.wozu.todoApp.Config.PropConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *
 * References:
 * https://stackoverflow.com/questions/39770694/could-not-open-servletcontext-resource-in-test-context
 * https://www.baeldung.com/spring-boot-testing
 *
 * Note that this class utilizes JUnit 5
 */

@SpringBootTest
@AutoConfigureMockMvc()
public class MvcMock {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status()
                        .isOk())
                .andDo(print());
    }

}
