package com.project.Dining.Review.Repository;

import com.project.Dining.Review.Model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

    public List<Restaurant> findRestaurantsByZipCodeAndDairyScoreIsNotNull(String zipCode);
    public List<Restaurant> findRestaurantsByZipCodeAndEggScoreIsNotNull(String zipCode);
    public List<Restaurant> findRestaurantsByZipCodeAndPeanutScoreIsNotNull(String zipCode);


}
