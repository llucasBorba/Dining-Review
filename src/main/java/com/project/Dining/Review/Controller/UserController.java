package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Model.User;
import com.project.Dining.Review.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class UserController{

    public UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@PostMapping("")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
@PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        var optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){return null;}

        var updatedUser = optionalUser.get();

        if(user.getCity() != null){updatedUser.setName(user.getCity());}
        if(user.getState() != null){updatedUser.setState(user.getState());}
        if(user.getZipCode() != null){updatedUser.setZipCode(user.getZipCode());}
        if(user.getInterestedInPeanutAllergies() != null){updatedUser.setInterestedInPeanutAllergies(user.getInterestedInPeanutAllergies());}
        if(user.getInterestedInEggAllergies() != null){updatedUser.setInterestedInEggAllergies(user.getInterestedInEggAllergies());}
        if(user.getInterestedInDairyAllergies() != null){updatedUser.setInterestedInDairyAllergies(user.getInterestedInDairyAllergies());}

        return  userRepository.save(updatedUser);
    }
@GetMapping("/{id}")
    public Optional<User> getByUserId(@PathVariable String id){
        return userRepository.findById(id);
    }
    public boolean existsByDisplayName(String displayName) {
        Optional<User> userOptional = userRepository.findById(displayName);
        return userOptional.isPresent();
    }
}
