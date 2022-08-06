package com.goldenshoe.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long size_id;

    private double size;

    @OneToMany(mappedBy = "size")
    @JsonIgnoreProperties({"size"})
    Set<ProductStock> productStocks;

    public Size() {
    }

    public Size(double size) {
        this.size = size;
    }

    public Long getSize_id() {
        return size_id;
    }

    public void setSize_id(Long size_id) {
        this.size_id = size_id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
