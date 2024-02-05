package by.teachmeskills.lesson41.controller;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarRestController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<CarDto> create(@RequestPart("carFile") MultipartFile carFile,
                                         @RequestPart("car") CarDto carDto) {
        carDto.setFile(carFile.getBytes());
        log.info("file name {} {}", carFile.getName(), carFile.getBytes().length);
        CarDto car = carService.save(carDto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{carId}/file", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getFileById(@PathVariable("carId") Long id) {
        CarDto result = carService.getCarById(id);
        return ok(result.getFile());
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
        return ok(carDto);
    }
}
