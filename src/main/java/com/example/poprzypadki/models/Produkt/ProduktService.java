package com.example.poprzypadki.models.Produkt;

import com.example.poprzypadki.models.Produkt.Produkt;
import com.example.poprzypadki.models.Produkt.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduktService {
    private final ProduktRepository produktRepository;

    @Autowired
    public ProduktService(ProduktRepository produktRepository) {
        this.produktRepository = produktRepository;
    }

    public List<Produkt> getAllProdukty() {
        return produktRepository.findAll();
    }

    public Produkt getProduktById(int id) {
        return produktRepository.findById(id).orElse(null);
    }

    public Produkt saveProdukt(Produkt produkt) {
        return produktRepository.save(produkt);
    }

    public void deleteProduktById(int id) {
        produktRepository.deleteById(id);
    }
}
