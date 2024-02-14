package com.project.Dining.Review.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Restaurant(Double peanutScore, Double eggScore, Double dairyScore, String zipCode) {
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.zipCode = zipCode;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeanutScore() {
        return peanutScore;
    }

    public void setPeanutScore(Double peanutScore) {
        this.peanutScore = peanutScore;
    }

    public Double getEggScore() {
        return eggScore;
    }

    public void setEggScore(Double eggScore) {
        this.eggScore = eggScore;
    }

    public Double getDairyScore() {
        return dairyScore;
    }

    public void setDairyScore(Double dairyScore) {
        this.dairyScore = dairyScore;
    }

    public Double getOverallScore() {
        return overallScore;
    }

}
