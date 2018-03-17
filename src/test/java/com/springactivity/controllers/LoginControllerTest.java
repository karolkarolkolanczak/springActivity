package com.springactivity.controllers;

import com.springactivity.config.StandaloneMvcTestViewResolver;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
/**
 * Created by a on 17/03/2018.
 */
public class LoginControllerTest {

    private MockMvc mockMvc;
    private LoginController loginController;

    @Before
    public void setup(){
        loginController=new LoginController();
        mockMvc= MockMvcBuilders.standaloneSetup(new LoginController())
                // prevent checking for circular view paths (this happens when e.g @RequestMapping("/loginForm") and return "loginForm";
                .setViewResolvers(new StandaloneMvcTestViewResolver())
                .build();
    }

    @Test
    public void TestShowloginForm() throws Exception {
        this.mockMvc.perform(get("/loginForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForm"))
                .andDo(print());
    }

    @Test
    public void loginError() throws Exception {
        this.mockMvc.perform(get("/login-error"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForm"))
                .andDo(print());
    }

}