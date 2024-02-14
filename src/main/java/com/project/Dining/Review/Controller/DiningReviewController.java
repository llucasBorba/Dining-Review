package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Repository.DiningReviewRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiningReviewController {

    public DiningReviewRepository diningRepository;

    public DiningReviewController(DiningReviewRepository diningRepository) {
        this.diningRepository = diningRepository;
    }





}
