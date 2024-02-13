package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Repository.DiningReviewRepository;
import com.project.Dining.Review.Repository.RestaurantRepository;
import com.project.Dining.Review.Repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiningReviewController {

    public DiningReviewRepository diningRepository;
    public RestaurantRepository restaurantRepository;
    public UserRepository userRepository;

    public DiningReviewController(DiningReviewRepository diningRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.diningRepository = diningRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }


}
