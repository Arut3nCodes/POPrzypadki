package com.example.poprzypadki.models.ZamowienieProdukt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZamowienieProduktRepository extends JpaRepository<ZamowienieProdukt, Integer> {
    @Query("SELECT zp FROM ZamowienieProdukt zp WHERE zp.Id_P = :id_P AND zp.Id_Z = :id_Z")
    Optional<ZamowienieProdukt> findById_PAndId_Z(@Param("id_P") int id_P, @Param("id_Z") int id_Z);
    @Query("SELECT z, p.Nazwa, zp.Ilosc_produktu FROM Zamowienie z " +
            "JOIN ZamowienieProdukt zp ON z.Id_Z = zp.Id_Z " +
            "JOIN Produkt p ON zp.Id_P = p.Id " +
            "WHERE z.Id_Z = :id_Z")
    List<Object[]> findOrderDetailsWithProducts(@Param("id_Z") int id_Z);
}
