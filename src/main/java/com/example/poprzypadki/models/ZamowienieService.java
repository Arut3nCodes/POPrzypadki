package com.example.poprzypadki.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZamowienieService {

    private final ZamowienieRepository zamowienieRepository;

    @Autowired
    public ZamowienieService(ZamowienieRepository zamowienieRepository) {
        this.zamowienieRepository = zamowienieRepository;
    }

    public Iterable<Zamowienie> getAllZamowienia() {
        return zamowienieRepository.findAll();
    }

    public Zamowienie getZamowienieById(int id) {
        return zamowienieRepository.findById(id).orElse(null);
    }

    public Zamowienie saveZamowienie(Zamowienie zamowienie) {
        return zamowienieRepository.save(zamowienie);
    }

    public void deleteZamowienieById(int id) {
        zamowienieRepository.deleteById(id);
    }
}
