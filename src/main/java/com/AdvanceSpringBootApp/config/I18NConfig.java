package com.AdvanceSpringBootApp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by user on 20-Feb-17.
 */
@Configuration
public class I18NConfig {


    /*
    This ReloadableResourceBundleMessageSource
     should be named as messageSource() on the
      other hnd it gives an error*/
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:i18n/messages");
        reloadableResourceBundleMessageSource.setCacheMillis(1800); // for 30 minutes

        return reloadableResourceBundleMessageSource;
    }
}
