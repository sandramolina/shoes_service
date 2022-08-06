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
    SpecificationRepository specificationRepository;

    @Autowired
    SizesRepository sizesRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    public Seeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        //Generate Ratings
        Rating rating1 = new Rating(4.5, 4500);
        ratingsRepository.save(rating1);

        Rating rating2 = new Rating(3.5, 600);
        ratingsRepository.save(rating2);

        Rating rating3 = new Rating(3.8, 600);
        ratingsRepository.save(rating3);

        Rating rating4 = new Rating(4.5, 1200);
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
        Colours red1 = new Colours("Passion Red", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-red.png");
        coloursRepository.save(red1);

        Colours blue1 = new Colours("React Blue", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-react-blue.png");
        coloursRepository.save(blue1);

        Colours green1 = new Colours("Emerald", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-emerald.png");
        coloursRepository.save(green1);

        Colours rosyMauve = new Colours("Rosy Mauve", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-rosy-maeve.png");
        coloursRepository.save(rosyMauve);

        Colours hotPink = new Colours("Hot Pink", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-hot-pink.png");
        coloursRepository.save(hotPink);

        Colours getNude = new Colours("Get Nude", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(getNude);

        //Generate specifications
        Specification specification1 = new Specification("Lether", "Lace-Up", "Sole: rubber", "39115101", "Timberland");
        specificationRepository.save(specification1);

        //Generate Sizes
        Size size1 = new Size(3.0);
        sizesRepository.save(size1);

        Product shoe1 = Product.builder()
                .title("Foot Cushion")
                .price(Money.parse("GBP 39.99"))
                .productCategory("MENS")
                .images(new ArrayList<>())
                .shortDescription("High quality foot cushion for all your cushiony needs")
                .longDescription("These Timberland shoes are classic and contemporary at the same time. As well as using recycled rubber for the soles, the linings have been made from recycled plastic bottles, creating an eco-friendly product.")
                .rating(new Rating())
                .specification(new Specification())
                .build();
        
        productRepository.save(shoe1);
        shoe1.setRating(rating1);
        shoe1.setSpecification(specification1);
        shoe1.addImage("thisimage.png");
        productRepository.save(shoe1);

        //Generate Product Stock
        ProductStock stock1 = new ProductStock();
        productStockRepository.save(stock1);
        stock1.setProduct(shoe1);
        stock1.setSize(size1);
        stock1.setColour(red1);
        stock1.setStock_count(10);

        productStockRepository.save(stock1);

        ProductStock stock2 = new ProductStock();
        productStockRepository.save(stock2);
        stock2.setProduct(shoe1);
        stock2.setSize(size1);
        stock2.setColour(green1);
        stock2.setStock_count(5);

        productStockRepository.save(stock2);

    }
}

