package com.AdvanceSpringBootApp.test.intrigration;

import com.AdvanceSpringBootApp.AdvanceSpringBootAppApplication;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.Plan;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.Role;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.presistence.repositories.PlanRepository;
import com.AdvanceSpringBootApp.backend.presistence.repositories.RoleRepository;
import com.AdvanceSpringBootApp.backend.presistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by user on 22-Feb-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryIntrigrationTest {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private static final int BASIC_PLAN_ID = 1;
    private static final int BASIC_ROLE_ID = 1;


    @Before
    public void init() {

        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan plan = createBasicPlan();
        planRepository.save(plan);
        Plan retriview = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retriview);

    }

    @Test
    public void testCreateNewRole() throws Exception {

        Role role = createBasicRole();

        roleRepository.save(role);

        Role retriview = roleRepository.findOne(BASIC_ROLE_ID);
        Assert.assertNotNull(retriview);

    }


    @Test
    public void testCreateNewUser() throws Exception{

        User user=createBasicUser();

        userRepository.save(user);

        User retrivew=userRepository.findOne(1L);
        Assert.assertNotNull(retrivew);


    }

    private Plan createBasicPlan() {

        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");

        return plan;


    }

    private Role createBasicRole() {

        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("ROLE_USER");
        return role;


    }

    private User createBasicUser() {
        User user = new User();

        user.setCounbtry("Bangladesh");
        user.setDescription("This is a test user");
        user.setEmail("mahfuz@gmail.com");
        user.setEnabled(true);
        user.setFirstName("Mahfuz");
        user.setLasttName("Shazol");
        user.setPassword("mahfuz");
        user.setPhoneNumber("+88943253453464646");
        user.setUsername("mahfuz");
        user.setProfileImageUrl("http://www.fakepass.com/12");

        return user;

    }


}
