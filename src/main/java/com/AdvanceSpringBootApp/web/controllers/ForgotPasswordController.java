package com.AdvanceSpringBootApp.web.controllers;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.PasswordResetToken;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.service.EmailService;
import com.AdvanceSpringBootApp.backend.service.PasswordResetTokenService;
import com.AdvanceSpringBootApp.utils.UsersUtils;
import com.AdvanceSpringBootApp.backend.service.I18NService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by user on 23-Feb-17.
 */
@Controller
public class ForgotPasswordController {


    private static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordController.class);
    public static final String EMAIL_ADDRESS_VIEW_NAME = "forgotpassword/emailForm";
    public static final String FORGOT_PASSWORD_URL_MAPPING = "/forgotpassword";
    public static final String MAIL_SEND_KET = "mailSent";
    public static final String CHANGE_PASSWORD_PATH = "/changeuserpassword";
    public static final String EMAIL_MESSAGE_TEXT_PROPERTY_NAME = "forgot.password.email.text";

    @Autowired
    private I18NService i18NService;

    @Autowired
    private EmailService emailService;

    @Value("${webmaster.email}")
    private String webmasterEmail;

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @RequestMapping(value = FORGOT_PASSWORD_URL_MAPPING, method = RequestMethod.GET)
    public String forgotPasswordGet() {
        return EMAIL_ADDRESS_VIEW_NAME;
    }


    @RequestMapping(value = FORGOT_PASSWORD_URL_MAPPING, method = RequestMethod.POST)
    public String forgotPasswordPost(HttpServletRequest httpServletRequest, @RequestParam("email") String email, ModelMap modelMap) {


        PasswordResetToken passwordResetToken = passwordResetTokenService.createPasswordResetTokenForEmail(email);

        if (null == passwordResetToken) {
            LOG.warn("Email Does Not Exist{}", email);
        } else {

            User user = passwordResetToken.getUser();
            String token = passwordResetToken.getToken();

            String resetPasswordUrl = UsersUtils.createPasswordResetUrl(httpServletRequest, user.getId(), token);


            LOG.debug("Reset Password URL {}", resetPasswordUrl);


            /*String emailText = i18NService.getMessage(EMAIL_ADDRESS_VIEW_NAME, httpServletRequest.getLocale());*/

/*
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("[Devopsbuddy]: How to Reset Your Password");
            mailMessage.setText(emailText + "\r\n" + resetPasswordUrl);
            mailMessage.setFrom(webmasterEmail);

            emailService.sendGenericEmailMessage(mailMessage);*/
/*
            LOG.info("Token value;{}", passwordResetToken.getToken());
            LOG.debug("User;{}", passwordResetToken.getUser().getUsername());*/
        }

        modelMap.addAttribute(MAIL_SEND_KET, true);


        return EMAIL_ADDRESS_VIEW_NAME;
    }


}