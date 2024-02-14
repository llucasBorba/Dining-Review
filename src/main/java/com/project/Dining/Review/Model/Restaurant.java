package com.project.Dining.Review.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name ="PEANUT_SCORE")
    private Double peanutScore;

    @Column(name = "EGG_SCORE")
    private Double eggScore;

    @Column(name = "DAIRY_SCORE")
    private Double dairyScore;

    @Column(name = "OVERALL_SCORE")
    private Double overallScore;

    @Column(name = "ZIPCODE")
    private String zipCode;

    public Restaurant(Double peanutScore, Double eggScore, Double dairyScore, String zipCode, String name) {
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.zipCode = zipCode;
        this.name = name;
        this.calculateOverallScore();
    }

    public Restaurant() {

    }

    public void calculateOverallScore() {
        int count = 0;
        double sum = 0.0;

        if (peanutScore != null) {
            sum += peanutScore;
            count++;
        }
        if (eggScore != null) {
            sum += eggScore;
            count++;
        }
        if (dairyScore != null) {
            sum += dairyScore;
            count++;
        }

        if (count > 0) {
            overallScore = sum / count;
        } else {
            overallScore = null;
        }
    }

}
