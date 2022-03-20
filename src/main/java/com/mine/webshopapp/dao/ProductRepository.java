package com.mine.webshopapp.dao;

import com.mine.webshopapp.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {



    @Query("select p from ProductEntity p where p.category.id = ?1")
    Page<ProductEntity> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<ProductEntity> findByProductNameContaining(@RequestParam("name") String name, Pageable pageable);
}
