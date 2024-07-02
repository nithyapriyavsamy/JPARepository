package com.ecommerce.shopping.Controllers;

import com.ecommerce.shopping.Models.Entity.Address;
import com.ecommerce.shopping.Models.Entity.Order;
import com.ecommerce.shopping.Models.Entity.Role;
import com.ecommerce.shopping.Models.Entity.User;
import com.ecommerce.shopping.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/a1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> PlaceOrder(@RequestBody Order order){
        Order placedOrder = orderService.PlaceOrder(order);
        return ResponseEntity.ok(placedOrder);
    }
    @GetMapping("address/{id}")
    public ResponseEntity<Address> GetAddress(@PathVariable int id){
        Address address = orderService.GetAddress(id);
        return ResponseEntity.ok(address);
    }
    @GetMapping("{id}")
    public ResponseEntity<Order> GetOrder(@PathVariable int id){
        Order order = orderService.GetOrder(id);
        return ResponseEntity.ok(order);
    }
    @PostMapping("user")
    public ResponseEntity<User> RegisterUser(@RequestBody User user){
        User registeredUser = orderService.SaveUser(user);
        return ResponseEntity.ok(registeredUser);
    }
    @GetMapping("role/{id}")
    public ResponseEntity<Role> GetRole(@PathVariable int id){
        Role role = orderService.GetRole(id);
        return ResponseEntity.ok(role);
    }
}
