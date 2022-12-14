package com.goldenshoe.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "product_stock")
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_stock_id;

    private int stock_count;

    @JsonIgnoreProperties({"productStocks"})
    @ManyToOne
    @JoinColumn(name = "size_id")
    Size size;

    @JsonIgnoreProperties({"productStocks"})
    @ManyToOne
    @JoinColumn(name = "colour_id")
    Colours colour;

    @JsonIgnoreProperties({"productStocks"})
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public ProductStock() {
    }

    public Long getProduct_stock_id() {
        return product_stock_id;
    }

    public void setProduct_stock_id(Long product_stock_id) {
        this.product_stock_id = product_stock_id;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Colours getColour() {
        return colour;
    }

    public void setColour(Colours colour) {
        this.colour = colour;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
