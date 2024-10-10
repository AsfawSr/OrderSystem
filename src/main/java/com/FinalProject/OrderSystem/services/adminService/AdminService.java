package com.FinalProject.OrderSystem.services.adminService;

import com.FinalProject.OrderSystem.models.Admin;

public interface AdminService {
    void saveAdmin(Admin admin);
    void removeAdmin(Admin admin);
    Admin getAdminById(long id);
    Admin getAdminByUsername(String username);
    Admin getAdminByEmail(String email);
    boolean existsByEmail(Admin admin);
    boolean existsByUsername(Admin admin);

}
