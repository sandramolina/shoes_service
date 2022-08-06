package com.goldenshoe.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "specifications")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String mainShoeMaterial;
    private String fastening;
    private String rubber;
    private String productCode;
    private String brand;

    @JsonIgnoreProperties({"specification"})
    @OneToOne(mappedBy = "specification")
    private Product product;

    public Specification() {
    }

    public Specification(String mainShoeMaterial, String fastening, String rubber, String productCode, String brand) {
        this.mainShoeMaterial = mainShoeMaterial;
        this.fastening = fastening;
        this.rubber = rubber;
        this.productCode = productCode;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainShoeMaterial() {
        return mainShoeMaterial;
    }

    public void setMainShoeMaterial(String mainShoeMaterial) {
        this.mainShoeMaterial = mainShoeMaterial;
    }

    public String getFastening() {
        return fastening;
    }

    public void setFastening(String fastening) {
        this.fastening = fastening;
    }

    public String getRubber() {
        return rubber;
    }

    public void setRubber(String rubber) {
        this.rubber = rubber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
