package com.project.Dining.Review.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;

    @Column(name = "INTERESTED_IN_PEANUT_ALLERGIES")
    private Boolean interestedInPeanutAllergies;

    @Column(name = "INTERESTED_IN_EGG_ALLERGIES")
    private Boolean interestedInEggAllergies;

    @Column(name = "INTERESTED_IN_DAIRY_ALLERGIES")
    private Boolean interestedInDairyAllergies;
@PrePersist
    public void generateId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = Integer.toString(name.hashCode());
        }
    }
}