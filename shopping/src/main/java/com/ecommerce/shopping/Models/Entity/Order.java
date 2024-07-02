package com.ecommerce.shopping.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @CreationTimestamp
    public LocalDateTime orderDate;
    public Double totalPrice;

    //one to many unidirectional mapping
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="order_id", referencedColumnName = "id")
//    public List<OrderItem> orderItems;

    //one to many Biidirectional mapping
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ords",fetch = FetchType.EAGER)
    public List<OrderItem> orderItems;

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrds(this);
            }
        }
    }

    //Unidirectinal One-To-One mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    public Address address;


   //Bidirectinal One-To-One mapping
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ord")
//    public Address address;
//
//    // Convenience method to set the bidirectional relationship
//    public void setAddress(Address address) {
//        this.address = address;
//        if (address != null) {
//            address.setOrd(this);
//        }
//    }
}
