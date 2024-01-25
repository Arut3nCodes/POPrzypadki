package com.example.poprzypadki.controllers;

import com.example.poprzypadki.models.ZamowienieProdukt.ZamowienieProdukt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.poprzypadki.models.Zamowienie.*;
import com.example.poprzypadki.models.Produkt.*;
import com.example.poprzypadki.models.ZamowienieProdukt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pracownik/zamowienia")
public class ObslugaZamowienController {

    private final ZamowienieService zamowienieService;
    private final ProduktService produktService;
    private final ZamowienieProduktService zamowienieProduktService;

    @Autowired
    public ObslugaZamowienController(ZamowienieService zamowienieService, ProduktService produktService,ZamowienieProduktService zamprodService) {
        this.zamowienieService = zamowienieService;
        this.produktService = produktService;
        this.zamowienieProduktService = zamprodService;
    }
    @GetMapping("")
    public String method(Model model){
        Iterable<Zamowienie> zamowienia = zamowienieService.getAllZamowienia();
        Iterable<Produkt> produkty = produktService.getAllProdukty();
        //Iterable<ZamowienieProdukt> laczenie = zamowienieProduktService.getAllZamProd();
        model.addAttribute("zamowienia", zamowienia);
        return "obslugaZamowien";
    }
    @GetMapping("/{id_Z}")
    @ResponseBody
    public List<Object[]> getZamowienieDetails(@PathVariable int id_Z) {
        final Logger log = LoggerFactory.getLogger(ObslugaZamowienController.class);
        log.info("Getting details for Zamowienie with id: {}", id_Z);
        List<Object[]> list = zamowienieProduktService.getOrderDetailsWithProducts(id_Z);
        return list;
    }

    @PutMapping("/{id}/updateStatus")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestParam(name="newStatus") String newStatus) {
        try {
            zamowienieService.updateStatus(id, newStatus);
            return ResponseEntity.ok("Status updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status.");
        }
    }
}
