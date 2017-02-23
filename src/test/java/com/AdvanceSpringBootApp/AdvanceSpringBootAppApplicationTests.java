package com.AdvanceSpringBootApp;

import com.AdvanceSpringBootApp.backend.service.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvanceSpringBootAppApplicationTests {

    @Autowired
    private I18NService i18NService;


    @Test
    public void contextLoads() {
    }


    @Test
    public void testMessageByLocalService() throws Exception {

        String excetedResult = "BootStrap";
        String messageId = "index.main.callout";
        String actual = i18NService.getMessage(messageId);

        Assert.assertEquals("********Do not matched********", excetedResult, actual);


    }

}
