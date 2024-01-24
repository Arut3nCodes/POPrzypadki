package com.example.poprzypadki.controllers;

import org.springframework.ui.Model;
import com.example.poprzypadki.models.Zamowienie;
import com.example.poprzypadki.models.ZamowienieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pracownik/zamowienia")
public class ObslugaZamowienController {

    private final ZamowienieService zamowienieService;

    @Autowired
    public ObslugaZamowienController(ZamowienieService zamowienieService) {
        this.zamowienieService = zamowienieService;
    }
    @GetMapping("")
    public String method(Model model){
        Iterable<Zamowienie> zamowienia = zamowienieService.getAllZamowienia();
        model.addAttribute("zamowienia", zamowienia);
        return "obslugaZamowien";
    }

}
