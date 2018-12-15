package pl.sda.cars;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CarsController {

    private CarRepository carRepository;

    @GetMapping("/cars")
    public ResponseEntity getCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars.stream()
                .map(x -> new CarDto(x.getBrand(), x.getModel(), x.getVin(),x.getPlateNumber()))
                .collect(Collectors.toList());
        return new ResponseEntity(new GetCarsResponse(carDtos), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity addCar(@RequestBody CarDto car) {
        Car carToSave = new Car(null, car.getBrand(), car.getModel(), car.getVin(), car.getPlateNumber());
        carRepository.save(carToSave);
        CarDto carDto = new CarDto(carToSave.getBrand(), carToSave.getModel(), car.getVin(), car.getPlateNumber());
        return new ResponseEntity(carDto, HttpStatus.OK);
    }

}
