package com.college.shre.repository;

import com.college.shre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Additional query methods can be defined here if needed
} 