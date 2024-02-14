package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Model.Restaurant;
import com.project.Dining.Review.Repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    public RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("")
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/{id}")
    public String restaurantDetails(@PathVariable Long id){
        var optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty()) return null;
        var restaurant = optionalRestaurant.get();

        return restaurant.toString();
    }

    @GetMapping("/by-zip/{zipCode}")
    public List<Restaurant> findByZipCodeAndAllergiesNotEmpty(@PathVariable String zipCode){

        if(!restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreIsNotNull(zipCode).isEmpty()){
        return restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreIsNotNull(zipCode);}

        if(!restaurantRepository.findRestaurantsByZipCodeAndEggScoreIsNotNull(zipCode).isEmpty()){
            return restaurantRepository.findRestaurantsByZipCodeAndEggScoreIsNotNull(zipCode);}

        if(!restaurantRepository.findRestaurantsByZipCodeAndDairyScoreIsNotNull(zipCode).isEmpty()){
        return restaurantRepository.findRestaurantsByZipCodeAndDairyScoreIsNotNull(zipCode);}

        return new ArrayList<>();
    }
@GetMapping("")
    public Iterable<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
}
