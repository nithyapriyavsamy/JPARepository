package com.ecommerce.shopping.Service;

import com.ecommerce.shopping.Exceptions.NotFoundException;
import com.ecommerce.shopping.Models.Entity.Order;
import com.ecommerce.shopping.Models.Entity.Address;
import com.ecommerce.shopping.Models.Entity.Role;
import com.ecommerce.shopping.Models.Entity.User;
import com.ecommerce.shopping.Repository.AddressRepository;
import com.ecommerce.shopping.Repository.OrderRepository;
import com.ecommerce.shopping.Repository.RoleRepository;
import com.ecommerce.shopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Order PlaceOrder(Order order){
        return orderRepository.save(order);
    }
    public Address GetAddress(int id){
        return addressRepository.findById(id)
                .orElseThrow(()->{throw new NotFoundException("There is no address in this id");});
    }
    public Order GetOrder(int id){
        return orderRepository.findById(id)
                .orElseThrow(()->{throw new NotFoundException("There is no order in this id");});
    }
    public User SaveUser(User user){
        return userRepository.save(user);
    }
    public Role GetRole(int id){
        return roleRepository.findById(id)
                .orElseThrow(()->{throw new NotFoundException("There is no role in this id");});
    }
}
