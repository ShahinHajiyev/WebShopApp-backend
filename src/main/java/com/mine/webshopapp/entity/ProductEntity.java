package com.mine.webshopapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
//@Data
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private ProductCategoryEntity category;

    @Column(name="sku")
    private String sku;

    @Column(name="productName")
    private String productName;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="productUnitPrice")
    private BigDecimal productUnitPrice;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="active")
    private boolean active;

    @Column(name="piecesInStock")
    private int piecesInStock;

    @Column(name="creationDate")
    @CreationTimestamp
    private Date creationDate;

    @Column(name="lastUpdate")                 //timestamp will  automatically be managed by @....timeStamp annotation
    @UpdateTimestamp
    private Date lastUpdate;




    /*
    @startuml
 class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Long productId;

        @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private ProductCategoryEntity category;

    @Column(name="sku")
    private String sku;

    @Column(name="productName")
    private String productName;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="productUnitPrice")
    private BigDecimal productUnitPrice;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="active")
    private boolean active;

    @Column(name="piecesInStock")
    private int piecesInStock;

    @Column(name="creationDate")
    @CreationTimestamp
    private Date creationDate;

    @Column(name="lastUpdate")
    @UpdateTimestamp
    private Date lastUpdate;
}

    @enduml
     */

}
