package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Model.DiningReview;
import com.project.Dining.Review.Model.ReviewStatus;
import com.project.Dining.Review.Repository.DiningReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dining-Review")
public class DiningReviewController {

    public DiningReviewRepository diningRepository;
    private final ClientController clientController;

    public DiningReviewController(DiningReviewRepository diningRepository, ClientController clientController) {
        this.diningRepository = diningRepository;
        this.clientController = clientController;
    }
@PostMapping("")
  public DiningReview saveDiningReview(
          @RequestParam(name = "name") String userName,
          @RequestBody DiningReview diningReview
          ){
        if(clientController.existsByDisplayName(userName)){return null;}
        return diningRepository.save(diningReview);
  }
@GetMapping("/pending-dining-reviews")
  public List<DiningReview> getByReviewStatusPending(){
        return diningRepository.findDiningReviewsByReviewStatus(ReviewStatus.PENDING);
  }


}
