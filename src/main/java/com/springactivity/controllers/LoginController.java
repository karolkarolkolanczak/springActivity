package com.springactivity.controllers;

import com.springactivity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by a on 02/02/2018.
 */
@Controller
public class LoginController {

    public LoginController() {
    }

    @RequestMapping("/loginForm")
    String showloginForm(){
        return "loginForm";
    }

    @RequestMapping("/login-error")
    String loginError( Model model){
        model.addAttribute("loginError", true);
            return "loginForm";
    }
}
