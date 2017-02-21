package com.AdvanceSpringBootApp.test.intrigration;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.Role;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.UserRole;
import com.AdvanceSpringBootApp.backend.service.UserService;
import com.AdvanceSpringBootApp.enums.PlansEnum;
import com.AdvanceSpringBootApp.enums.RolesEnum;
import com.AdvanceSpringBootApp.utils.UsersUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 22-Feb-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntrigationTest {

    @Autowired
    private UserService userService;


    @Test
    public void testCreateNewUer() throws Exception {
        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UsersUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService
                .createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());


    }

}
