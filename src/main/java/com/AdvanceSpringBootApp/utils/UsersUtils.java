package com.AdvanceSpringBootApp.utils;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.web.controllers.ForgotPasswordController;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Created by user on 22-Feb-17.
 */
public class UsersUtils {


    private UsersUtils() {
        throw new AssertionError("&&&&&Non INstantiable&&&&&&&&&");
    }


    public static User createBasicUser(String username, String email) {


        User user = new User();

        user.setCounbtry("Bangladesh");
        user.setDescription("This is a test user");
        user.setEmail(email);
        user.setEnabled(true);
        user.setFirstName("Mahfuz");
        user.setLasttName("Shazol");
        user.setPassword("mahfuz");
        user.setPhoneNumber("+88943253453464646");
        user.setUsername(username);
        user.setProfileImageUrl("http://www.fakepass.com/12");

        return user;

    }

    public static String createPasswordResetUrl(HttpServletRequest httpServletRequest, long userId, String token) {


        String passwordResetUrl =
                httpServletRequest.getScheme() + "://" +
                        httpServletRequest.getServerName() +
                        ":" +
                        httpServletRequest.getServerPort() +
                        httpServletRequest.getContextPath() +
                        ForgotPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token" +
                        token;

        return passwordResetUrl;

    }
}
