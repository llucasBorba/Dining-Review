package com.project.Dining.Review.Repository;

import com.project.Dining.Review.Model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
}
