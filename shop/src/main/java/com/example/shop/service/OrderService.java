package com.example.shop.service;

import com.example.shop.dao.Order;
import com.example.shop.dao.Product;
import com.example.shop.dao.User;
import com.example.shop.dto.Orderdto;
import com.example.shop.repo.OrderRepository;
import com.example.shop.repo.ProductRepository;
import com.example.shop.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(Orderdto orderdto){
        Order order1 = new Order();
//        Product products = new Product();
        Set<Product> productSet = new HashSet<>();

        Optional<User> userRes = userRepository.findById(orderdto.getUser_id());
        if (userRes.isPresent())
            order1.setUser(userRes.get());

            order1.setOrder_date(orderdto.getOrder_date());

            for (String product : orderdto.getProducts()) {
                Optional<Product> productRes = productRepository.findByProductName(product);
                if (productRes.isPresent())
                    productSet.add(productRes.get());
            }
//            order1.setProducts(productSet);
        order1.setOrdered_products(productSet);
        return orderRepository.save(order1);
    }
    public Optional<Order> findOrder(Integer id){return orderRepository.findById(id);}

    public List<Order> getAllOrders(){return orderRepository.findAll();}

    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

}
