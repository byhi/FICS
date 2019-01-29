package com.byhi.fics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping("/index")
    public String home() {
        logger.info("Welcome in home");
        return "index";
    }
}
