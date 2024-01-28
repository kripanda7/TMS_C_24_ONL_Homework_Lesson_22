package by.teachmeskills.lesson41.controller;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarRestController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @PostMapping
    public ResponseEntity<CarDto> create(@RequestBody CarDto carDto) {
        CarDto car = carService.save(carDto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody CarDto carDto) {
        if (!Objects.equals(id, carDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        carService.update(carDto);
        return ResponseEntity.ok(carDto);
    }
}
