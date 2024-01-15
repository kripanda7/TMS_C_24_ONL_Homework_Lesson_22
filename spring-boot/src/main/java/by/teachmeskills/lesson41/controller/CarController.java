package by.teachmeskills.lesson41.controller;

import by.teachmeskills.lesson41.dto.CarDto;
import by.teachmeskills.lesson41.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Log4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("listCars", carService.getCars());
        return "cars";
    }

    @GetMapping("/new")
    public String newCar(Model model) {
        CarDto car = CarDto.builder().build();
        model.addAttribute("car", car);
        return "newCar";
    }

    @PostMapping("/new")
    public String saveCar(@Valid @ModelAttribute CarDto car, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().stream().map(DefaultMessageSourceResolvable::toString).toList());
            return "new";
        }
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam Long id) {
        carService.delete(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit")
    public String editCar(Model model, @RequestParam Long id) {
        CarDto car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/update")
    public String updateCar(@Valid @ModelAttribute CarDto car, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().stream().map(DefaultMessageSourceResolvable::toString).toList());
            return "editCar";
        }
        carService.update(car);
        return "redirect:/cars";
    }
}
