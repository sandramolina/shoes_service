package com.goldenshoe.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "price")
    private Money price;

    @NotNull
    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "images")
    private ArrayList<String> images;

    @Column(name = "mainShoeMaterial")
    private String mainShoeMaterial;

    @Column(name = "fastening")
    private String fastening;

    @Column(name = "rubber")
    private String rubber;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "brand")
    private String brand;

    @NotNull
    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @JsonIgnoreProperties({"product"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"product"})
    Set<ProductStock> productStocks;

    public void addImage(String imageUrl){this.images.add(imageUrl);}
}
