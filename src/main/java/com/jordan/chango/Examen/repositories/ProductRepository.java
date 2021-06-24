package com.jordan.chango.Examen.repositories;

import com.jordan.chango.Examen.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
