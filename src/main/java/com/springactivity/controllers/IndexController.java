package com.springactivity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a on 18/01/2018.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        System.out.println("OKKKK");
        return "index";
    }
}
