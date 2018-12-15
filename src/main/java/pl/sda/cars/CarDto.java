package pl.sda.cars;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDto {
    private String brand;
    private String model;
    private String vin;
    private String plateNumber;
}
