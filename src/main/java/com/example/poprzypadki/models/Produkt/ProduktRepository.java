package com.example.poprzypadki.models.Produkt;

import com.example.poprzypadki.models.Zamowienie.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends JpaRepository<Produkt, Integer> {

}
