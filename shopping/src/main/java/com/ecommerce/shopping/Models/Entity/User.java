package com.ecommerce.shopping.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String email;

    //UniDirectional Many-To-Many mapping
    //When using the mapped by Role table will make this as Bidirectional
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(
                    name="userId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="roleId",
                    referencedColumnName = "id"
            )
    )
    public List<Role> Roles;
}
