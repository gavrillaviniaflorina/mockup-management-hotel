package repository;

import model.Rezervare;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RezervareRepositoryTest {

    @Test
    public void testInsertDelete(){

        Rezervare rezervare1=new Rezervare(15,1,58);


        RezervareRepository rezervareRepository=new RezervareRepository();

        rezervareRepository.insert(rezervare1);


        List<Rezervare> rezervari=rezervareRepository.totateRezervarile();


        rezervare1.setRezervare_id(35);
//

        assertEquals(true,rezervari.contains(rezervare1));
//
        rezervareRepository.delete(rezervare1.getRezervare_id());
//

        rezervari=rezervareRepository.totateRezervarile();


        assertEquals(false,rezervari.contains(rezervare1));
//
//





    }



}