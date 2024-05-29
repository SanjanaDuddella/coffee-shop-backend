package com.demo.coffeeshop.controller;

import com.demo.coffeeshop.exception.ResourceNotFound;
import com.demo.coffeeshop.model.Product;
import com.demo.coffeeshop.repository.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffee")
public class ProductController
{
   @Autowired
   private ProductDB productDB;

   @GetMapping
    public List<Product> getAllProducts()
    {
        return productDB.findAll();
    }
   @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id)
   {
       return productDB.findById(id).orElseThrow(() -> new ResourceNotFound("No such product available."));
   }
   @PostMapping
    public Product addProduct(@RequestBody Product product)
   {
       return productDB.save(product);
   }

   @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)
   {
       Product prod = productDB.findById(id).orElseThrow(() -> new ResourceNotFound("Not found, unable to update"));
       prod.setName(product.getName());
       prod.setDesc(product.getDesc());
       prod.setPrice(product.getPrice());
       return prod;
   }

   @DeleteMapping("/{id}")
    public void deleteProd(@PathVariable Long id)
   {
       Product prod = productDB.findById(id).orElseThrow(() -> new ResourceNotFound("Not found, unable to delete"));
       productDB.deleteById(id);
   }

}
