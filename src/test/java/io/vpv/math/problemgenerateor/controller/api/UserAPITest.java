package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserAPITest extends ProblemGenerateorApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockHttpSession mockHttpSession;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
        mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());
        User user = getUser();
        mockHttpSession.setAttribute(SecurityProtection.SESSION_USER, user);
    }


    @Test
    public void getUserFromSession() throws Exception {
        mockMvc.perform(get("/api/user").session(mockHttpSession))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.firstName").isNotEmpty())
                .andExpect(jsonPath("$.lastName").isNotEmpty())
                .andExpect(jsonPath("$.email").isNotEmpty());
    }
}