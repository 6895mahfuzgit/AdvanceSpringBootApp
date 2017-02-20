package com.AdvanceSpringBootApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 21-Feb-17.
 */
@Controller
public class CopyController {

    @RequestMapping("/about")
    public String about() {

        return "copy/about";
    }

}
