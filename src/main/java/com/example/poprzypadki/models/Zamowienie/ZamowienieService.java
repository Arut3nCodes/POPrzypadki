package com.example.poprzypadki.models.Zamowienie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void updateStatus(int id, String newStatus) {
        Optional<Zamowienie> optionalZamowienie = zamowienieRepository.findById(id);
        if (optionalZamowienie.isPresent()) {
            Zamowienie zamowienie = optionalZamowienie.get();
            zamowienie.setStatus_zamowienia(newStatus);
            zamowienieRepository.save(zamowienie);
        } else {
            throw new IllegalArgumentException("Zamowienie not found with id: " + id);
        }
    }
}
