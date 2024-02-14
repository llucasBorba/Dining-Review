package com.project.Dining.Review.Controller;

import com.project.Dining.Review.Model.Client;
import com.project.Dining.Review.Repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/Client")
public class ClientController {

    public ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
@PostMapping("")
    public Client saveUser(@RequestBody Client user){
        return clientRepository.save(user);
    }
@PutMapping("/{id}")
    public Client updateUser(@PathVariable String id, @RequestBody Client user){
        var optionalUser = clientRepository.findById(id);
        if(optionalUser.isEmpty()){return null;}

        var updatedUser = optionalUser.get();

        if(user.getCity() != null){updatedUser.setName(user.getCity());}
        if(user.getState() != null){updatedUser.setState(user.getState());}
        if(user.getZipCode() != null){updatedUser.setZipCode(user.getZipCode());}
        if(user.getInterestedInPeanutAllergies() != null){updatedUser.setInterestedInPeanutAllergies(user.getInterestedInPeanutAllergies());}
        if(user.getInterestedInEggAllergies() != null){updatedUser.setInterestedInEggAllergies(user.getInterestedInEggAllergies());}
        if(user.getInterestedInDairyAllergies() != null){updatedUser.setInterestedInDairyAllergies(user.getInterestedInDairyAllergies());}

        return  clientRepository.save(updatedUser);
    }
@GetMapping("/{id}")
    public Optional<Client> getByUserId(@PathVariable String id){
        return clientRepository.findById(id);
    }
    public boolean existsByDisplayName(String displayName) {
        Optional<Client> userOptional = clientRepository.findById(displayName);
        return userOptional.isPresent();
    }
}
