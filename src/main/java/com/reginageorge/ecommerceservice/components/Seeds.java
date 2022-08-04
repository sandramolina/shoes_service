package com.reginageorge.ecommerceservice.components;

import com.reginageorge.ecommerceservice.models.Colours;
import com.reginageorge.ecommerceservice.models.Product;
import com.reginageorge.ecommerceservice.models.Rating;
import com.reginageorge.ecommerceservice.repositories.ColoursRepository;
import com.reginageorge.ecommerceservice.repositories.ProductRepository;
import com.reginageorge.ecommerceservice.repositories.RatingsRepository;
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

        //TODO assign img to black
        Colours black = new Colours("Carbon Black", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(black);

        //TODO assign img to brown
        Colours brown = new Colours("Brownie", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(brown);

        //Generate specifications



        Product superLipstickStar = Product.builder()
                .title("Super Lipstick STAR")
                .price(Money.parse("GBP 18.99"))
                .productCategory("LIPS")
                .shortDescription("Our #1 lipstick now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.")
                .longDescription("Your favorite feel-good, look-great lipstick, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .colours(new ArrayList<>())
                .build();
        
        productRepository.save(superLipstickStar);
        superLipstickStar.setRating(rating1);
        superLipstickStar.addColour(red1);
        superLipstickStar.addColour(blue1);
        superLipstickStar.addColour(green1);
        productRepository.save(superLipstickStar);

    }
}

