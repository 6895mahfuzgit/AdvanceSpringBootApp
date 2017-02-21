package com.AdvanceSpringBootApp.backend.service;

import com.AdvanceSpringBootApp.web.domain.frontend.FeedBackPojo;
import org.springframework.mail.SimpleMailMessage;



public interface EmailService {

    public void sendFeedbackEmail(FeedBackPojo feedBackProjo);

    public void sendGenericEmailMessage(SimpleMailMessage message);
}