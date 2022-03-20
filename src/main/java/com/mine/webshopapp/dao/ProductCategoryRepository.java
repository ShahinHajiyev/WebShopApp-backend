package com.mine.webshopapp.dao;

import com.mine.webshopapp.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource (collectionResourceRel = "productCategory", path = "category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
