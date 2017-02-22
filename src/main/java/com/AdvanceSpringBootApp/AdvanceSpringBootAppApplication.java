package com.AdvanceSpringBootApp;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.Role;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.UserRole;
import com.AdvanceSpringBootApp.backend.service.UserService;
import com.AdvanceSpringBootApp.enums.PlansEnum;
import com.AdvanceSpringBootApp.enums.RolesEnum;
import com.AdvanceSpringBootApp.utils.UsersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AdvanceSpringBootAppApplication implements CommandLineRunner {


    private static final Logger LOG = LoggerFactory.getLogger(AdvanceSpringBootAppApplication.class);

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AdvanceSpringBootAppApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {


        User user = UsersUtils.createBasicUser();
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.PRO)));
        userService.createUser(user, PlansEnum.PRO, userRoles);

    }
}
