package com.example.poprzypadki.models.ZamowienieProdukt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(ZamowienieProduktId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZamowienieProdukt {
    @Id
    private int Id_P;
    @Id
    private int Id_Z;
    private int Ilosc_produktu;
}
