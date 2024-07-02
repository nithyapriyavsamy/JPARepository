package com.ecommerce.shopping.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int doorNo;
    public String streetName;
    public String city;
    public String state;
    public int pinCode;

    // one to one Bidirectional mapping
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Order_id",referencedColumnName = "id")
//    public Order ord;
}
