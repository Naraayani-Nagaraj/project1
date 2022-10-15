package com.sample.driveway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.driveway.model.Admin;;

public interface AdminRepository extends JpaRepository<Admin, String>
{
    
}
