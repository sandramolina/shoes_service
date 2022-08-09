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

        Rating rating3 = new Rating(3.8, 60);
        ratingsRepository.save(rating3);

        Rating rating4 = new Rating(4.5, 120);
        ratingsRepository.save(rating3);

        Rating rating5 = new Rating(2.5, 869);
        ratingsRepository.save(rating3);

        Rating rating6 = new Rating(3.5, 362);
        ratingsRepository.save(rating3);

        Rating rating7 = new Rating(4.5, 58);
        ratingsRepository.save(rating3);

        Rating rating8 = new Rating(5.0, 458);
        ratingsRepository.save(rating3);

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

        //region Generate Sizes
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
        //endregion

        //region shoe1 build
        Product shoe1 = Product.builder()
                .title("Mayfair Dress Shoes")
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

        //region shoe2 build
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
        //endregion

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

        //region shoe3
        Product shoe3 = Product.builder()
                .title("Tassel Loafers")
                .price(Money.parse("GBP 89.99"))
                .productCategory("MENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Lace-Up")
                .rubber("Synthetic")
                .productCode("44249507")
                .brand("John Lewis")
                .shortDescription("Our tassel loafers are an effortlessly suave choice for smart casual styling.")
                .longDescription("Made from smooth leather in a classic slip-on design, they will combine equally neatly with tailoring or casual chinos.")
                .rating(new Rating())
                .build();

        productRepository.save(shoe3);
        shoe3.setRating(rating3);
        shoe3.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-loafers-men.png");
        shoe3.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-loafers-men-2.png");
        shoe3.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-loafers-men-3.png");

        ProductStock stock7 = new ProductStock();
        productStockRepository.save(stock7);
        stock7.setProduct(shoe3);
        stock7.setSize(size8);
        stock7.setColour(brownOne);
        stock7.setStock_count(5);
        productStockRepository.save(stock7);

        productRepository.save(shoe3);
        //endregion

        //region shoe4
        Product shoe4 = Product.builder()
                .title("Leather Brogues")
                .price(Money.parse("GBP 59.95"))
                .productCategory("MENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Lace-Up")
                .rubber("Rubber")
                .productCode("50581478")
                .brand("Moss")
                .shortDescription("These Moss brogues offer a smart option for work or for evening events.")
                .longDescription("With a leather upper, they feature classic broguing details and come complete with a stacked contrasting heel. Made from smooth leather in a classic slip-on design, they will combine equally neatly with tailoring or casual chinos.")
                .rating(new Rating())
                .build();

        productRepository.save(shoe4);
        shoe4.setRating(rating4);
        shoe4.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-brogues-men.png");
        shoe4.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-brogues-men-2.png");
        shoe4.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-brogues-men-3.png");

        ProductStock stock8 = new ProductStock();
        productStockRepository.save(stock8);
        stock8.setProduct(shoe4);
        stock8.setSize(size8);
        stock8.setColour(brownOne);
        stock8.setStock_count(5);
        productStockRepository.save(stock8);

        productRepository.save(shoe4);
        //endregion

        //region shoe5
        Product shoe5 = Product.builder()
                .title("Couture Bloom")
                .price(Money.parse("GBP 47.50"))
                .productCategory("WOMENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Elastic")
                .rubber("Rubber")
                .productCode("57581478")
                .brand("Clarks")
                .shortDescription("Couture Bloom, women's pumps, black leather - A timeless classic.")
                .longDescription("these pumps have been subtly refined with an ultra-feminine toe shape and bow detailing. Made from smooth leather in a classic slip-on design, they will combine equally neatly with tailoring or casual chinos.")
                .rating(new Rating())
                .build();

        productRepository.save(shoe5);
        shoe5.setRating(rating5);
        shoe5.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-couture-bloom-women.png");
        shoe5.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-couture-bloom-women-2.png");
        shoe5.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-couture-bloom-women-3.png");

        ProductStock stock9 = new ProductStock();
        productStockRepository.save(stock9);
        stock9.setProduct(shoe5);
        stock9.setSize(size8);
        stock9.setColour(blackShiny);
        stock9.setStock_count(5);
        productStockRepository.save(stock9);

        productRepository.save(shoe5);
        //endregion

        //region shoe6
        Product shoe6 = Product.builder()
                .title("The Teala Loafer")
                .price(Money.parse("GBP 70.99"))
                .productCategory("WOMENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Elastic")
                .rubber("TR")
                .productCode("57581478")
                .brand("Clarks")
                .shortDescription("Super-chunky soles are still having a moment (and we think they’re here to stay). Teala Loafer’s classic tasselled finish teams with a statement.")
                .longDescription("These chunky have been subtly refined with an ultra-feminine toe shape and bow detailing. Made from smooth leather in a classic slip-on design, they will combine equally neatly with tailoring or casual chinos.")
                .rating(new Rating())
                .build();

        productRepository.save(shoe6);
        shoe6.setRating(rating6);
        shoe6.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-teala-loafers-women.png");
        shoe6.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-teala-loafers-women-2.png");
        shoe6.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/black-teala-loafers-women-3.png");

        ProductStock stock10 = new ProductStock();
        productStockRepository.save(stock10);
        stock10.setProduct(shoe6);
        stock10.setSize(size65);
        stock10.setColour(blackShiny);
        stock10.setStock_count(5);
        productStockRepository.save(stock10);

        productRepository.save(shoe6);
        //endregion

        //region shoe7
        Product shoe7 = Product.builder()
                .title("Victoria 55 RAE")
                .price(Money.parse("GBP 79.99"))
                .productCategory("WOMENS")
                .images(new ArrayList<>())
                .mainShoeMaterial("Leather")
                .fastening("Elastic")
                .rubber("Resin Rubber")
                .productCode("87581478")
                .brand("Clarks")
                .shortDescription("The timeless classic taking you from the business to cocktail hour .")
                .longDescription("55 Rae heeled shoe. In British tan leather for a premium feel, it works an elegant pointed toe, versatile mid-heel and soft cushioning, creating the sophisticated heel you’ve been waiting for.")
                .rating(new Rating())
                .build();

        productRepository.save(shoe7);
        shoe7.setRating(rating6);
        shoe7.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-rae-women.png");
        shoe7.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-rae-women-2.png");
        shoe7.addImage("https://raw.githubusercontent.com/sandramolina/assets/main/golden_shoe_ecommerce/shoes/brown-rae-women-3.png");

        ProductStock stock11 = new ProductStock();
        productStockRepository.save(stock11);
        stock11.setProduct(shoe7);
        stock11.setSize(size65);
        stock11.setColour(brownOne);
        stock11.setStock_count(5);
        productStockRepository.save(stock11);

        productRepository.save(shoe7);
        //endregion
    }
}

