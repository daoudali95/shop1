package com.example.shop.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer order_id;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "order_date")
    private LocalDateTime order_date = LocalDateTime.now();


//    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Product> products;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "ordered_products",
            joinColumns ={@JoinColumn(name="order_id" , referencedColumnName ="order_id")},
            inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName = "product_id")})
    private Set<Product> ordered_products = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Order() {
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }


    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }


    public Set<Product> getOrdered_products() {
        return ordered_products;
    }

    public void setOrdered_products(Set<Product> ordered_products) {
        this.ordered_products = ordered_products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}