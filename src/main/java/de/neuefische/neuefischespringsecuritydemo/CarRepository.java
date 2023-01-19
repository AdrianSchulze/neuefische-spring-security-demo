package de.neuefische.neuefischespringsecuritydemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findAllByCreatedBy  (String createdBy);
}
