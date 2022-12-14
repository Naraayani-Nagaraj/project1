package com.sample.driveway.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.driveway.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    @Query("select p from Product p where p.price > :price")
    public List<Product> getProductByPrice(@Param("price") float price);
}
