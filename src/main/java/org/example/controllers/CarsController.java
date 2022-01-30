package org.example.controllers;

import javax.validation.Valid;
import org.example.dao.CarDAO;
import org.example.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    @GetMapping()
    public String index(Model model) {
        //We will get all the cars from the DAO and pass them to the view for display
        model.addAttribute("cars", carDAO.index());
        model.addAttribute("count", carDAO.getCount());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //We will get one car by id from the DAO and pass it to the view for display
        model.addAttribute("car", carDAO.show(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "cars/new";

        carDAO.save(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carDAO.delete(id);
        return "redirect:/cars";
    }
}
