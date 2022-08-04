package com.reginageorge.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "colours")
public class Colours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colour_id;

    private String colourName;

    private String colourImage;

    @ManyToMany
    @JsonIgnoreProperties({"colours"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "products_colours",
            joinColumns = {@JoinColumn(name = "colour_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false, updatable = false)}
    )
    private List<Product> products;

    @OneToMany(mappedBy = "colour")
    Set<ProductStock> productStocks;

    public Colours() {
    }

    //TODO how to setup a default value
    public Colours(String colourName, String colourImage) {
        this.colourName = colourName;
        this.colourImage = colourImage;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public String getColourImage() {
        return colourImage;
    }

    public void setColourImage(String colourImage) {
        this.colourImage = colourImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Set<ProductStock> getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(Set<ProductStock> productStocks) {
        this.productStocks = productStocks;
    }
}
