package de.neuefische.neuefischespringsecuritydemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final AppUserService appUserService;

    public Car create(Car car) {
        car.setCreatedBy(appUserService.getAuthenticatedUser().getId());
        return carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAllByCreatedBy(
            appUserService.getAuthenticatedUser().getId()
        );
    }
}
