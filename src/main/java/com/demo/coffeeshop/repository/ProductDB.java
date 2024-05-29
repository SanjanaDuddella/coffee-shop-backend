package com.demo.coffeeshop.repository;

import com.demo.coffeeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Product, Long>
{

}
