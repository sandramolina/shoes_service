package com.goldenshoe.ecommerceservice.components;

import com.goldenshoe.ecommerceservice.models.*;
import com.goldenshoe.ecommerceservice.repositories.*;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
@Component
public class Seeds implements ApplicationRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ColoursRepository coloursRepository;

    @Autowired
    RatingsRepository ratingsRepository;

    @Autowired
    SizesRepository sizesRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    public Seeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        //Generate Ratings
        Rating rating1 = new Rating(4.5, 15);
        ratingsRepository.save(rating1);

        Rating rating2 = new Rating(3.5, 55);
        ratingsRepository.save(rating2);

//        Rating rating3 = new Rating(3.8, 600);
//        ratingsRepository.save(rating3);
//
//        Rating rating4 = new Rating(4.5, 1200);
//        ratingsRepository.save(rating3);
//
//        Rating rating5 = new Rating(2.5, 869);
//        ratingsRepository.save(rating3);
//
//        Rating rating6 = new Rating(3.5, 362);
//        ratingsRepository.save(rating3);
//
//        Rating rating7 = new Rating(4.5, 58);
//        ratingsRepository.save(rating3);
//
//        Rating rating8 = new Rating(5.0, 458);
//        ratingsRepository.save(rating3);

        //Generate Colours
        Colours blackShiny = new Colours("Shiny Black", "https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/colours/black.png");
        coloursRepository.save(blackShiny);

        Colours darkBlue = new Colours("Dark Blue", "https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/colours/dark-blue.png");
        coloursRepository.save(darkBlue);

        Colours brownOne = new Colours("Brown", "https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/colours/brown.png");
        coloursRepository.save(brownOne);

//        //Generate specifications
//        Specification specification1 = new Specification("Lether", , ", , );
//        specificationRepository.save(specification1);

        //Generate Sizes
        Size size3 = new Size(3.0);
        sizesRepository.save(size3);

        Size size5 = new Size(5.0);
        sizesRepository.save(size5);

        Size size6 = new Size(6.0);
        sizesRepository.save(size6);

        Size size65 = new Size(6.5);
        sizesRepository.save(size65);

        Size size7 = new Size(7.0);
        sizesRepository.save(size7);

        Size size75 = new Size(7.5);
        sizesRepository.save(size75);

        Size size8 = new Size(8.0);
        sizesRepository.save(size8);

        Product shoe1 = Product.builder()
                .title("Mayfair Dress")
                .price(Money.parse("GBP 39.99"))
                .productCategory("MENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Lace-Up")
                .rubber("Rubber")
                .productCode("39115101")
                .brand("Timberland")
                .shortDescription("High quality foot cushion for all your cushiony needs")
                .longDescription("These Timberland shoes are classic and contemporary at the same time. As well as using recycled rubber for the soles, the linings have been made from recycled plastic bottles, creating an eco-friendly product.")
                .rating(new Rating())
                .build();
        
        productRepository.save(shoe1);
        //region images shoe1
        shoe1.setRating(rating1);
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-Foot-Cushion-men.png");
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-Foot-Cushion-men-2.png");
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-Foot-Cushion-men-3.png");
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/blue-Foot-Cushion-men.png");
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/blue-Foot-Cushion-men-2.png");
        shoe1.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/blue-Foot-Cushion-men-3.png");
        //endregion s

        //region Generate shoe1 Stock
        ProductStock stock1 = new ProductStock();
        productStockRepository.save(stock1);
        stock1.setProduct(shoe1);
        stock1.setSize(size6);
        stock1.setColour(blackShiny);
        stock1.setStock_count(10);

        productStockRepository.save(stock1);

        ProductStock stock2 = new ProductStock();
        productStockRepository.save(stock2);
        stock2.setProduct(shoe1);
        stock2.setSize(size6);
        stock2.setColour(darkBlue);
        stock2.setStock_count(5);

        productStockRepository.save(stock2);

        ProductStock stock3 = new ProductStock();
        productStockRepository.save(stock3);
        stock3.setProduct(shoe1);
        stock3.setSize(size5);
        stock3.setColour(blackShiny);
        stock3.setStock_count(10);
        productStockRepository.save(stock3);

        productRepository.save(shoe1);
        //endregion

        Product shoe2 = Product.builder()
                .title("Rivington Derby")
                .price(Money.parse("GBP 94.99"))
                .productCategory("MENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Lace-Up")
                .rubber("Microlite")
                .productCode("39120101")
                .brand("Moss")
                .shortDescription("For that ultra-polished look, these patent leather dress shoes from Moss London are a great go-to option.")
                .longDescription("If you've got an excuse to dress up, take the black-tie style to another level with the help of these patent leather oxfords. With their highly polished uppers, they're the perfect accompaniment to a suave black jacket and trouser combo")
                .rating(new Rating())
                .build();

        productRepository.save(shoe2);
        shoe2.setRating(rating2);
        shoe2.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/dark-blue-verona-men.png");
        shoe2.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/dark-blue-verona-men-2.png");
        shoe2.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/dark-blue-verona-men-3.png");

        //region Generate shoe2 Stock
        ProductStock stock4 = new ProductStock();
        productStockRepository.save(stock4);
        stock4.setProduct(shoe2);
        stock4.setSize(size6);
        stock4.setColour(darkBlue);
        stock4.setStock_count(5);
        productStockRepository.save(stock4);

        ProductStock stock5 = new ProductStock();
        productStockRepository.save(stock5);
        stock5.setProduct(shoe2);
        stock5.setSize(size8);
        stock5.setColour(darkBlue);
        stock5.setStock_count(15);
        productStockRepository.save(stock5);

        ProductStock stock6 = new ProductStock();
        productStockRepository.save(stock6);
        stock6.setProduct(shoe2);
        stock6.setSize(size75);
        stock6.setColour(darkBlue);
        stock6.setStock_count(15);
        productStockRepository.save(stock6);

        productRepository.save(shoe2);
        //endregion
    }
}

