package com.FinalProject.Bank.services.adminService;

import com.FinalProject.Bank.models.Admin;
import com.FinalProject.Bank.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService{
    AdminRepository adminRepository;
    @Autowired
    public AdminServiceImplementation(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void removeAdmin(Admin admin) {
        adminRepository.delete(admin);
    }

    @Override
    public Admin getCustomerById(long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(Admin admin) {
        return adminRepository.existsByEmail(admin.getEmail());
    }

    @Override
    public boolean existsByUsername(Admin admin) {
        return adminRepository.existsByUsername(admin.getUsername());
    }

}
