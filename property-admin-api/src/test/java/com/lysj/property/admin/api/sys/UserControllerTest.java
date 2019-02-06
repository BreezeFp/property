package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author fupeng
 * @date 2019/1/19
 */
public class UserControllerTest extends BaseTest {

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/user/1")
                .header(jwtProperties.getHeader(), createAdminToken()))
                .andExpect(jsonPath("$.statusCode").value("200"))
                .andExpect(jsonPath("$.value.user.username").value("admin"));
    }

    @Test
    public void me() throws Exception {
        MvcResult result = mockMvc.perform(get("/user")
                .header(jwtProperties.getHeader(), createAdminToken()))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void list() {
    }
}