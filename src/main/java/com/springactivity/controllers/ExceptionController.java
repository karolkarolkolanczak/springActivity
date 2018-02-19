package com.springactivity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by a on 17/02/2018.
 */
@Controller
public class ExceptionController {

    @RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
    public String handleException(@PathVariable("type") String type, Exception error, Model model) {
        return modelAttribute(error,model);
    }

    public String  modelAttribute(Exception error, Model model){
        model.addAttribute("message", error.getMessage());
        model.addAttribute("stackTrace", error.getStackTrace());
        model.addAttribute("exception", error);
        return "errorPage";
    }
}
