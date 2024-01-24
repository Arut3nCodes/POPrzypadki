package com.example.poprzypadki.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/pracownik")
public class PracownikMenuController {
    @GetMapping("")
    public String pracownik(){
        return "menuObslugi";
    }
}
