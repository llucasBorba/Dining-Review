package com.project.Dining.Review.Repository;

import com.project.Dining.Review.Model.DiningReview;
import com.project.Dining.Review.Model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview,Integer> {

     List<DiningReview> findDiningReviewsByReviewStatus(ReviewStatus status);
}
