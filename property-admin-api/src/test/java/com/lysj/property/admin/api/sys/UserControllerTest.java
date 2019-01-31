package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author fupeng
 * @date 2019/1/19
 */
public class UserControllerTest extends BaseTest {

    @Test
    public void hello() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect((content()).string("Hello World"));

    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andExpect((jsonPath("$.username").value("admin")));
    }
}