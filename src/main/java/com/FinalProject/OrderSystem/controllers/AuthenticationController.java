package com.FinalProject.OrderSystem.controllers;

import com.FinalProject.OrderSystem.models.Admin;
import com.FinalProject.OrderSystem.models.OrderEntity;
import com.FinalProject.OrderSystem.services.adminService.AdminService;
import com.FinalProject.OrderSystem.services.orderService.OrderEntityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AuthenticationController {
    AdminService adminService;
    OrderEntityService orderEntityService;
    @Autowired
    public AuthenticationController(AdminService adminService, OrderEntityService orderEntityService) {
        this.adminService = adminService;
        this.orderEntityService = orderEntityService;
    }


    @GetMapping("/adminPage")
    public String getAdminPage(Model model) {
        model.addAttribute("admin", new Admin());
        List<OrderEntity> orders = orderEntityService.findAll();
        model.addAttribute("orders",orders);
        return "adminPage";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminLoginPage";
    }
    @PostMapping("/login")
    public String getLogin(@ModelAttribute("admin") Admin admin,
                           BindingResult bindingResult,
                           Model model,
                           HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("admin", admin);
            return "adminPage";
        }

        if (adminService.existsByUsername(admin)) {
            Admin loggedAdmin = adminService.getAdminByUsername(admin.getUsername());
            if (loggedAdmin.getPassword().equals(admin.getPassword())) {
                session.setAttribute("loggedInAdmin", loggedAdmin);
                return "redirect:/admin/adminPage";
            } else {
                model.addAttribute("errorMessage", "Incorrect username or password");
                return "adminLoginPage";
            }
        } else {
            model.addAttribute("errorMessage", "Incorrect username or password");
            return "adminLoginPage";
        }
    }
}
