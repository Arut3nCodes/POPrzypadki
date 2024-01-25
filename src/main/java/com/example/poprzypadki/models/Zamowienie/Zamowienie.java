package com.example.poprzypadki.models.Zamowienie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id_Z;
    int Id_K;
    int Id_Pr;
    int Id_Pl;
    String Status_zamowienia;
    Date Data_zamowienia;
    int KwotaDoZaplaty;
}
