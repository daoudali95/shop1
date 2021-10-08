package com.example.shop.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable (name = "product_record",
//            joinColumns ={@JoinColumn(name="product_id" , referencedColumnName ="product_id")},
//            inverseJoinColumns = {@JoinColumn(name="order_id", referencedColumnName = "order_id")})
//    private Set<Order> ordered_products = new HashSet<>();

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Set<Order> getOrdered_products() {
//        return ordered_products;
//    }
//
//    public void setOrdered_products(Set<Order> ordered_products) {
//        this.ordered_products = ordered_products;
//    }

//    public Set<Order> getProducts_record() {
//        return products_record;
//    }
//
//    public void setProducts_record(Set<Order> products_record) {
//        this.products_record = products_record;
//    }
}
