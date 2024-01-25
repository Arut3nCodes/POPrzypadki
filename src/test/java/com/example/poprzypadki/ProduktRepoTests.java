package com.example.poprzypadki;

import com.example.poprzypadki.models.Produkt.Produkt;
import com.example.poprzypadki.models.Produkt.ProduktRepository;
import com.example.poprzypadki.models.Produkt.ProduktService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProduktRepoTests {
    @Mock
    private ProduktRepository prodRep;
    @InjectMocks
    private ProduktService prodSer;

    @BeforeEach
    public void initForTests(){
        MockitoAnnotations.openMocks(this);

        Produkt produkt1 = new Produkt();
        produkt1.setId(1);
        produkt1.setNazwa("Produkt1");
        produkt1.setOpis("Opis1");
        produkt1.setCena(10.29);

        Produkt produkt2 = new Produkt();
        produkt2.setId(2);
        produkt2.setNazwa("Produkt2");
        produkt2.setOpis("Opis2");
        produkt2.setCena(11.29);

        Produkt produkt3 = new Produkt();
        produkt3.setId(3);
        produkt3.setNazwa("Produkt3");
        produkt3.setOpis("Opis3");
        produkt3.setCena(12.29);

        List<Produkt> list = new ArrayList<Produkt>();
        list.add(produkt1);
        list.add(produkt2);
        list.add(produkt3);
        when(prodRep.findAll()).thenReturn(list);
    }
    @Test
    public void addingTest(){
        assertNotNull(prodSer.getAllProdukty());
        assertEquals(prodSer.getAllProdukty().size(), 3);
    }

    @Test
    public void testSetters(){
        try {
            assertEquals(prodSer.getAllProdukty().get(0).getId(), 1);
            assertEquals(prodSer.getAllProdukty().get(1).getId(), 2);
            assertEquals(prodSer.getAllProdukty().get(2).getId(), 3);
            assertEquals(prodSer.getAllProdukty().get(0).getNazwa(), "Produkt1");
            assertEquals(prodSer.getAllProdukty().get(1).getNazwa(), "Produkt2");
            assertEquals(prodSer.getAllProdukty().get(2).getNazwa(), "Produkt3");
        }catch(Exception e){
            assert false;
        }
    }


}
