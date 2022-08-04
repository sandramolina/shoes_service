package com.reginageorge.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.List;

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
    private List<String> images;

    @NotNull
    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @JsonIgnoreProperties({"product"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @JsonIgnoreProperties({"product"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id", referencedColumnName = "id")
    private Rating specification;

    @ManyToMany
    @JsonIgnoreProperties({"products"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @Column(name = "colours")
    @JoinTable(
            name = "products_colours",
            joinColumns = {@JoinColumn(name = "product_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "colour_id", nullable = false, updatable = false)}
    )
    private List<Colours> colours;

    public void addColour(Colours colour){this.colours.add(colour);}

}
