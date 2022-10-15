package com.sample.driveway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.driveway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    
}
