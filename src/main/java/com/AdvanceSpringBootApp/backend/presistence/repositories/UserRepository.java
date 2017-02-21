package com.AdvanceSpringBootApp.backend.presistence.repositories;

import com.AdvanceSpringBootApp.backend.presistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 22-Feb-17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
