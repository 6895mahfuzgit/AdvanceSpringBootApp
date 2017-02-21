package com.AdvanceSpringBootApp.web.controllers;

import com.AdvanceSpringBootApp.backend.service.EmailService;
import com.AdvanceSpringBootApp.web.domain.frontend.FeedBackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 21-Feb-17.
 */
@Controller
public class ContactController {


    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    public static final String FEDBACK_MODEL_KEY = "feedback";
    public static final String COTACT_US_VIEW_NAME = "contact/contact";

    @Autowired
    private EmailService emailService;


    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap modelMap) {

        FeedBackPojo feedBackPojo = new FeedBackPojo();
        modelMap.addAttribute(ContactController.FEDBACK_MODEL_KEY, feedBackPojo);

        return ContactController.COTACT_US_VIEW_NAME;

    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEDBACK_MODEL_KEY) FeedBackPojo feedBackPojo) {


        LOG.debug("Feed Back Pojo Content{}", feedBackPojo);
        emailService.sendFeedbackEmail(feedBackPojo);
        return ContactController.COTACT_US_VIEW_NAME;

    }


}
