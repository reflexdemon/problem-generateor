package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProblemGeneratorAPITest extends ProblemGenerateorApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
    }


    @Test
    public void getAllApiEndpoints() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }
    @Test
    public void getAddProblems() throws Exception {
        mockMvc.perform(get("/api/add"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].firstNumber").isNotEmpty());
    }

    @Test
    public void getSubProblems() throws Exception {
        mockMvc.perform(get("/api/sub"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].firstNumber").isNotEmpty());
    }

    @Test
    public void getMulProblems() throws Exception {
        mockMvc.perform(get("/api/mul"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].firstNumber").isNotEmpty());
    }

    @Test
    public void getDivProblems() throws Exception {
        mockMvc.perform(get("/api/div"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].firstNumber").isNotEmpty());
    }

    @Test
    public void shouldBeAbleToDoCORS() throws Exception {
        mockMvc.perform(options("/api"))
                .andExpect(status().isOk())
                .andExpect(header().string("Allow", "GET,HEAD"));
    }

    @Test
    public void shouldBeAbleToThrowError() throws Exception {
        mockMvc.perform(get("/api/div?size=badValue"))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath(".code").isNotEmpty())
                .andExpect(jsonPath(".message").isNotEmpty());
    }
}