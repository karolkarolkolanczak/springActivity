package com.springactivity.controllers;

import com.springactivity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a on 02/02/2018.
 */
@Controller
public class LoginController {
    @RequestMapping("/loginForm")
    String loginForm(Model model){
        User user=new User();
        model.addAttribute("loginForm",user);
        return "loginForm";
    }
//
//    @RequestMapping()
//    String SubmitLoginForm(){
//        return"";
//    }
}
