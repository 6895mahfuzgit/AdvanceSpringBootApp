package com.AdvanceSpringBootApp.backend.service;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.Plan;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.UserRole;
import com.AdvanceSpringBootApp.backend.presistence.repositories.PlanRepository;
import com.AdvanceSpringBootApp.backend.presistence.repositories.RoleRepository;
import com.AdvanceSpringBootApp.backend.presistence.repositories.UserRepository;
import com.AdvanceSpringBootApp.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by user on 22-Feb-17.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        String encoder = passwordEncoder.encode(user.getPassword());

        user.setPassword(encoder);

        Plan plan = new Plan(plansEnum);

        if (!planRepository.exists(plansEnum.getId())) {

            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole role : userRoles) {

            roleRepository.save(role.getRole());
        }


        user.getUserRoles().addAll(userRoles);
        user = userRepository.save(user);

        return user;

    }


}
