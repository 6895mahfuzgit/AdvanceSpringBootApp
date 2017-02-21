package com.AdvanceSpringBootApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 21-Feb-17.
 */
@Controller
public class PayloadController {

    public static final String PAYLOAD_VIEW_NAME = "payload/payload";

    @RequestMapping("/payload")
    public String payload() {

        return PAYLOAD_VIEW_NAME;
    }

}
