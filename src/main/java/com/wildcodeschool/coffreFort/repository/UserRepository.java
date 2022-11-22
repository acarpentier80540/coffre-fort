package com.wildcodeschool.coffreFort.repository;

import org.springframework.stereotype.Repository;
import com.wildcodeschool.coffreFort.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
