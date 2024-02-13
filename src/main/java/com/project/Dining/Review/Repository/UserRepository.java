package com.project.Dining.Review.Repository;

import com.project.Dining.Review.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
