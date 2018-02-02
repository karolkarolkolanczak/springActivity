package com.springactivity.controllers;

import com.springactivity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by a on 02/02/2018.
 */
@Controller
public class LoginController {

    @RequestMapping("/loginForm")
    String showloginForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "loginForm";
    }

    @RequestMapping(value = "/loginFormSubmit", method = RequestMethod.POST)
    String SubmitLoginForm(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "loginForm";
        }
        return "redirect:/products";
    }
}
