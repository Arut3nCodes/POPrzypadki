package com.example.poprzypadki;

import com.example.poprzypadki.models.Produkt.Produkt;
import com.example.poprzypadki.models.Zamowienie.Zamowienie;
import com.example.poprzypadki.models.Zamowienie.ZamowienieRepository;
import com.example.poprzypadki.models.Zamowienie.ZamowienieService;
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

public class ZamowienieRepoTests {
    @Mock
    private ZamowienieRepository zamRep;
    @InjectMocks
    private ZamowienieService zamSer;



    @BeforeEach
    public void initForTests(){
        MockitoAnnotations.openMocks(this);

        Zamowienie zamowienie1 = new Zamowienie();
        zamowienie1.setId_K(1);
        zamowienie1.setId_Pr(2);
        zamowienie1.setId_Pl(3);
        zamowienie1.setStatus_zamowienia("NIEOPLACONE");
        zamowienie1.setData_zamowienia(new Date());
        zamowienie1.setKwotaDoZaplaty(100);

        Zamowienie zamowienie2 = new Zamowienie();
        zamowienie2.setId_K(2);
        zamowienie2.setId_Pr(3);
        zamowienie2.setId_Pl(4);
        zamowienie2.setStatus_zamowienia("OPLACONE");
        zamowienie2.setData_zamowienia(new Date());
        zamowienie2.setKwotaDoZaplaty(150);
        List<Zamowienie> zamList = new ArrayList<Zamowienie>();
        zamList.add(zamowienie1);
        zamList.add(zamowienie2);
        when(zamRep.findAll()).thenReturn(zamList);

    }
    @Test
    public void addingTest(){
        assertNotNull(zamSer.getAllZamowienia());
        assertEquals(zamSer.getAllZamowienia().size(), 2);
    }

    @Test
    public void testSetters(){
        try {
            assertEquals(zamSer.getAllZamowienia().get(0).getId_K(), 1);
            assertEquals(zamSer.getAllZamowienia().get(1).getId_K(), 2);
            assertEquals(zamSer.getAllZamowienia().get(0).getKwotaDoZaplaty(), 100);
            assertEquals(zamSer.getAllZamowienia().get(1).getKwotaDoZaplaty(), 150);
        }catch(Exception e){
            assert false;
        }
    }


}
