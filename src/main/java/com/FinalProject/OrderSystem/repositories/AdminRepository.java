package com.FinalProject.OrderSystem.repositories;

import com.FinalProject.OrderSystem.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
    Admin findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String username);
}
