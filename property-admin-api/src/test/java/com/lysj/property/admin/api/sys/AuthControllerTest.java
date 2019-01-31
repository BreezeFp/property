package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author fupeng
 * @date 2019/1/25
 */
public class AuthControllerTest extends BaseTest {

    @Test
    public void register() throws Exception {

        mockMvc.perform(post("/auth/register")
                .param("username", "admin")
                .param("password", "111111"))
                .andExpect(status().isOk());

    }

    @Test
    public void login() throws Exception {
        MvcResult result = mockMvc.perform(post("/auth/login")
                .param("username", "admin")
                .param("password", "111111"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void refreshToken() {
    }
}