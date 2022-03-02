package com.mine.webshopapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "productcategory")
@Getter
@Setter
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productCategoryId")
    private Long productCategoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "productCategory")
    private Set<ProductEntity> product;


}
