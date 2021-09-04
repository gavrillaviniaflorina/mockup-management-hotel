package repository;

import model.Angajat;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;


class AngajatRepositoryTest {

//    @Test
//    public void testInsertDelete(){
//
//        Angajat angajat1=new Angajat("cartarescu","ion","0711111111");
//        Angajat angajat2=new Angajat("ionescu","ana","0711111111");
//        Angajat angajat3=new Angajat("marinescu","ion","0711111111");
//
//        AngajatRepository angajatRepository=new AngajatRepository();
//        angajatRepository.insert(angajat1);
//        angajatRepository.insert(angajat2);
//        angajatRepository.insert(angajat3);
//
//        List<Angajat> angajati=angajatRepository.totiAngajatii();
//
//
//
//
//        assertEquals(true, angajati.contains(angajat1));
//        assertEquals(true, angajati.contains(angajat2));
//        assertEquals(true, angajati.contains(angajat3));
//
//        angajatRepository.delete(angajat1.getNume());
//        angajatRepository.delete(angajat2.getNume());
//        angajatRepository.delete(angajat3.getNume());
//
//        angajati=angajatRepository.totiAngajatii();
//        assertEquals(false, angajati.contains(angajat1));
//        assertEquals(false, angajati.contains(angajat2));
//        assertEquals(false, angajati.contains(angajat3));
//
//
//
//
//
//    }
//
//    @Test
//    public void testUpdateNume(){
//        Angajat angajat1=new Angajat("cartarescu","ion","0711111111");
//        Angajat angajat2=new Angajat("ionescu","ana","0711111111");
//        Angajat angajat3=new Angajat("marinescu","ion","0711111111");
//
//        AngajatRepository angajatRepository=new AngajatRepository();
//
//        angajatRepository.updateNume("ionescu","paunescu");
//
//        List<Angajat> angajati=angajatRepository.totiAngajatii();
//
//        System.out.println(angajati.size());
//
//    assertEquals("paunescu",angajati.get(1).getNume());
//    }



}