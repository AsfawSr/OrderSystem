package com.FinalProject.Bank.services.adminService;

import com.FinalProject.Bank.models.Admin;
import com.FinalProject.Bank.models.OrderEntity;

import java.util.List;

public interface AdminService {
    void saveAdmin(Admin admin);
    void removeAdmin(Admin admin);
    Admin getCustomerById(long id);
    Admin getAdminByUsername(String username);
    Admin getAdminByEmail(String email);
    boolean existsByEmail(Admin admin);
    boolean existsByUsername(Admin admin);

}
