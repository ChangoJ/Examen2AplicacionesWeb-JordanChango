package com.jordan.chango.Examen.controllers;

import com.jordan.chango.Examen.entities.Product;
import com.jordan.chango.Examen.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }

    public Optional<Product> findProductById(int id){
        return this.productRepository.findById(id);
    }


    public void createProduct(Product product){
        this.productRepository.save(product);
    }

    public boolean editProductById(int id, Product product){
        Optional<Product> productOptional = this.findProductById(id);
        if( !productOptional.isPresent()) return false;
        Product productdb = productOptional.get();
        productdb.setBrand(product.getBrand());
        productdb.setModel(product.getModel());
        productdb.setPrice(product.getPrice());
        productRepository.save(productdb);
        return true;
    }

    public boolean deleteProductById(int id) {
        Optional<Product> productOptional = this.findProductById(id);
        if (!productOptional.isPresent()) return false;
        productRepository.deleteById(id);
        return true;
    }



}
