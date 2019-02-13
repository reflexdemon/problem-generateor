package io.vpv.math.problemgenerateor.controller;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplicationTests;
import io.vpv.math.problemgenerateor.interceptor.SecurityProtection;
import io.vpv.math.problemgenerateor.model.User;
import io.vpv.math.problemgenerateor.service.EncryptionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest extends ProblemGenerateorApplicationTests {
    private static String JSON =
            "{\"id\":\"4246853\",\"username\":\"reflexdemon\",\"email\":null,\"source\":\"github\",\"firstName\":\"Venkateswara\",\"lastName\":null,\"avatarUrl\":\"https://avatars3.githubusercontent.com/u/4246853?v=4\",\"profileUrl\":\"https://github.com/reflexdemon\"}";
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private EncryptionService encryptionService;

    private MockHttpSession mockHttpSession;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
        mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());
        User user = getUser();
        mockHttpSession.setAttribute(SecurityProtection.SESSION_USER, user);
    }

    @Test
    public void shouldLoginTheUserToTheApplication() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).content(buildUrlEncodedFormEntity(
                        "encryptedToken", encryptionService.encrypt(JSON),
                        "key", "value1"
                )))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void shouldLoginTheUserToTheApplicationLocal() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).content(buildUrlEncodedFormEntity(
                        "encryptedToken", encryptionService.encrypt(JSON),
                        "key", "local"
                )))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void shouldRedirectUserToHomePageWithSession() throws Exception {
        mockMvc.perform(get("/signin").session(mockHttpSession))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().exists("Location"));
    }

    @Test
    public void shouldRedirectUserToLoginPage() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().exists("Location"));
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowError() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).content(buildUrlEncodedFormEntity(
                        "encryptedToken", "BADVALUE",
                        "key", "value1"
                )))
                .andExpect(status().is3xxRedirection());
    }


    @Test
    public void shouldLogoutUserWithSession() throws Exception {
        mockMvc.perform(post("/logout").session(mockHttpSession))
                .andExpect(content().string("Signed out"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldLogoutUserWithOutSession() throws Exception {
        mockMvc.perform(get("/logout"))
                .andExpect(content().string("Signed out"))
                .andExpect(status().isOk());
    }


    private String buildUrlEncodedFormEntity(String... params) {
        if ((params.length % 2) > 0) {
            throw new IllegalArgumentException("Need to give an even number of parameters");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < params.length; i += 2) {
            if (i > 0) {
                result.append('&');
            }
            try {
                result.
                        append(URLEncoder.encode(params[i], StandardCharsets.UTF_8.name())).
                        append('=').
                        append(URLEncoder.encode(params[i + 1], StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return result.toString();
    }
}