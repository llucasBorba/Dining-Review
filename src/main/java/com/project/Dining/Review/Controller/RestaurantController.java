package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Model.Restaurant;
import com.project.Dining.Review.Repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    public RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("")
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant){

        long id = restaurant.getId();
        if(restaurantRepository.findById(id).isEmpty()) return null;

        return restaurantRepository.save(restaurant);

    }

    @GetMapping("")
    public String restaurantDetails(@PathVariable Long id){
        var optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty()) return null;
        var restaurant = optionalRestaurant.get();

        return restaurant.toString();
    }

    @GetMapping("")
    public List<Restaurant> findByZipCodeAndAllergiesNotEmpty(@PathVariable String zipCode){

        if(!restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreIsNotEmpty(zipCode).isEmpty()){
        return restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreIsNotEmpty(zipCode);}

        if(!restaurantRepository.findRestaurantsByZipCodeAndEggScoreIsNotEmpty(zipCode).isEmpty()){
            return restaurantRepository.findRestaurantsByZipCodeAndEggScoreIsNotEmpty(zipCode);}

        if(!restaurantRepository.findRestaurantsByZipCodeAndDairyScoreIsNotEmpty(zipCode).isEmpty()){
        return restaurantRepository.findRestaurantsByZipCodeAndDairyScoreIsNotEmpty(zipCode);}



        return new ArrayList<>();

    }
}
