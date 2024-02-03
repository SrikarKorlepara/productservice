package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);

    List<Product> findByTitleContaining(String word);

    Product save(Product product);

    @Query("select p from Product p where p.id = 52")
    List<Product> something();

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> somethingsomething(@Param("id") Long id);

    @Query(value = "select * from product p where p.id = 52",nativeQuery = true)
    List<Product> somesome2();



}




















