package com.AdvanceSpringBootApp.backend.service;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.PasswordResetToken;
import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import com.AdvanceSpringBootApp.backend.presistence.repositories.PasswordResetTokenRepository;
import com.AdvanceSpringBootApp.backend.presistence.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by user on 23-Feb-17.
 */
@Service
@Transactional(readOnly = true)
public class PasswordResetTokenService {


    private static final Logger LOG = LoggerFactory.getLogger(PasswordResetTokenService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${token.expiration.length.minutes}")
    private int tokenExpirationInMinutes;



    @Transactional
    public PasswordResetToken createPasswordResetTokenForEmail(String email) {

        PasswordResetToken passwordResetToken = null;

        User user = userRepository.findByEmail(email);

        if (null != user) {
            String token = UUID.randomUUID().toString();
            LocalDateTime now = LocalDateTime.now(Clock.systemUTC());
            passwordResetToken = new PasswordResetToken(token, user, now, tokenExpirationInMinutes);

            passwordResetToken = passwordResetTokenRepository.save(passwordResetToken);
            LOG.debug("Successfully created token {}  for user {}", token, user.getUsername());
        } else {
            LOG.warn("We couldn't find a user for the given email {}", email);
        }

        return passwordResetToken;

    }


    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }


}
