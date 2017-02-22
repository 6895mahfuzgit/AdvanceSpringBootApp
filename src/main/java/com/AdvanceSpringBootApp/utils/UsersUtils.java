package com.AdvanceSpringBootApp.utils;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;

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
}
