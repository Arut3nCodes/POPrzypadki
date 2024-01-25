package com.example.poprzypadki.models.ZamowienieProdukt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class ZamowienieProduktId implements Serializable {
    private int Id_P;
    private int Id_Z;
}
