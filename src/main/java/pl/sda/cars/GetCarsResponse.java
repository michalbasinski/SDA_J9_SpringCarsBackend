package pl.sda.cars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GetCarsResponse {

    private List<CarDto> cars;

    public GetCarsResponse(List<CarDto> carDtos) {
        this.cars = carDtos;
    }
}
