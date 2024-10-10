package com.FinalProject.OrderSystem.controllers;

import com.FinalProject.OrderSystem.models.OrderEntity;
import com.FinalProject.OrderSystem.services.orderService.OrderEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderEntityController {
    OrderEntityService orderEntityService;
    @Autowired
    public OrderEntityController(OrderEntityService orderEntityService) {
        this.orderEntityService = orderEntityService;
    }
    @GetMapping("/newOrder")
    public String getOrderPage(Model model){
        model.addAttribute("order",new OrderEntity());
        return "customerPage";
    }
    @PostMapping("/submitOrder")
    public String submitOrder(@Valid @ModelAttribute("order") OrderEntity orderEntity,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage",  "Please fix the errors, order not place.");
            return "customerPage";
        }

        orderEntityService.saveOrderEntity(orderEntity);
        model.addAttribute("successMessage", "Order successfully placed!");
        return "customerPage";
    }


}
