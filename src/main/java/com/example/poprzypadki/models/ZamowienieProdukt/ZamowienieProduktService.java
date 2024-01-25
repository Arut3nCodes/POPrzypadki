package com.example.poprzypadki.models.ZamowienieProdukt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZamowienieProduktService {

    private final ZamowienieProduktRepository zamowienieProduktRepository;

    @Autowired
    public ZamowienieProduktService(ZamowienieProduktRepository zamowienieProduktRepository) {
        this.zamowienieProduktRepository = zamowienieProduktRepository;
    }

    public Iterable<ZamowienieProdukt> getAllZamowienieProdukty() {
        return zamowienieProduktRepository.findAll();
    }

    // Pozostała część klasy pozostaje niezmieniona

    public Optional<ZamowienieProdukt> getZamowienieProduktByIds(int id_P, int id_Z) {
        return zamowienieProduktRepository.findById_PAndId_Z(id_P, id_Z);
    }

    public void addZamowienieProdukt(ZamowienieProdukt zamowienieProdukt) {
        zamowienieProduktRepository.save(zamowienieProdukt);
    }

    public List<Object[]> getOrderDetailsWithProducts(int id_Z) {
        return zamowienieProduktRepository.findOrderDetailsWithProducts(id_Z);
    }
}
