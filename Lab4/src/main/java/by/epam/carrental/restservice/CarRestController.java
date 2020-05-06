package by.epam.carrental.restservice;

import by.epam.carrental.entity.Car;
import by.epam.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarRestController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCarsList(){
        return ResponseEntity.ok(carService.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        try{
            return ResponseEntity.ok(carService.read(id.toString()));
        } catch(IncorrectResultSizeDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        carService.create(car);
        return ResponseEntity.ok(car);
    }

    @PutMapping
    public ResponseEntity<Void> updateCar(@RequestBody Car car){
        carService.update(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        carService.delete(id.toString());
        return ResponseEntity.noContent().build();
    }

}
