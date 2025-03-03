package com.bms.bookmyshow.repositories;
// NOW WILL BE FOLLOWING SINGLE RESPONSIBILITY PRINCIPLE TO INTERACT WITH DB
// FOR EACH MODEL WILL INTERACT WITH SEPARATE REPO..
// HERE WILL USE JPA THAT WOULD HELP US INTERACTING WITH DB..

import com.bms.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);

    Optional<User> findByEmail(String email);
}
/*
  user_id <-->
 */
