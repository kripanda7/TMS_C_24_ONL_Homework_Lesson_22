package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.model.Car;
import by.teachmeskills.lesson39.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j
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
        Car car = Car.builder().build();
        model.addAttribute("car", car);
        return "newCar";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
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
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/update")
    public String updateCar(@ModelAttribute("car") Car car) {
        carService.update(car);
        return "redirect:/cars";
    }
}
