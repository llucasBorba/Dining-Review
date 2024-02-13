package com.project.Dining.Review.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "DINING_REVIEW")
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "SUBMITTED_BY")
    private String restaurantCritic;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @Column(name = "PEANUT_SCORE")
    private Long peanutScore;

    @Column(name = "DAIRY_SCORE")
    private Long dairyScore;

    @Column(name = "EGG_SCORE")
    private Long eggScore;

    @Column(name = "COMMENTARY")
    private String comentary;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ReviewStatus reviewStatus;
}
