package com.example.poprzypadki;

import com.example.poprzypadki.models.Produkt.Produkt;
import com.example.poprzypadki.models.Produkt.ProduktRepository;
import com.example.poprzypadki.models.Produkt.ProduktService;
import com.example.poprzypadki.models.Zamowienie.Zamowienie;
import com.example.poprzypadki.models.Zamowienie.ZamowienieRepository;
import com.example.poprzypadki.models.Zamowienie.ZamowienieService;
import com.example.poprzypadki.models.ZamowienieProdukt.ZamowienieProdukt;
import com.example.poprzypadki.models.ZamowienieProdukt.ZamowienieProduktRepository;
import com.example.poprzypadki.models.ZamowienieProdukt.ZamowienieProduktService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ZamowienieProduktRepoTests {

    @Mock
    private ProduktRepository prodRep;
    @InjectMocks
    private ProduktService prodSer;

    @Mock
    private ZamowienieRepository zamRep;
    @InjectMocks
    private ZamowienieService zamSer;

    @Mock
    private ZamowienieProduktRepository zamProdRep;
    @InjectMocks
    private ZamowienieProduktService zamProdSer;

    @BeforeEach
    public void init(){
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

        List<Produkt> prodList = new ArrayList<Produkt>();
        prodList.add(produkt1);
        prodList.add(produkt2);
        prodList.add(produkt3);
        when(prodRep.findAll()).thenReturn(prodList);

        ZamowienieProdukt zamProd1 = new ZamowienieProdukt(1, 1, 20);
        ZamowienieProdukt zamProd2 = new ZamowienieProdukt(1, 1, 21);
        ZamowienieProdukt zamProd3 = new ZamowienieProdukt(3, 2, 1);

        List<ZamowienieProdukt> zamProdList = new ArrayList<ZamowienieProdukt>();
        zamProdList.add(zamProd1);
        zamProdList.add(zamProd2);
        zamProdList.add(zamProd3);
        when(zamProdRep.findAll()).thenReturn(zamProdList);
    }

    @Test
    public void testingRepos(){
        assertEquals(2, zamSer.getAllZamowienia().size());
        assertEquals(3, prodSer.getAllProdukty().size());
        assertEquals(3, zamProdSer.getAllZamowienieProdukty().size());
    }

    @Test
    public void testingGetOrderSizes(){
        assertEquals(2, zamProdSer.getOrderDetailsWithProducts(1).size());
        assertEquals(1, zamProdSer.getOrderDetailsWithProducts(2).size());
        assertEquals(0, zamProdSer.getOrderDetailsWithProducts(3).size());
    }

    @Test
    public void testingGetOrderContent(){
        assertEquals(zamSer.getAllZamowienia().get(0), zamProdSer.getOrderDetailsWithProducts(1).get(0)[0]);
        assertEquals("Produkt1", zamProdSer.getOrderDetailsWithProducts(1).get(0)[1]);
        assertEquals(20, zamProdSer.getOrderDetailsWithProducts(1).get(0)[2]);
    }

}
