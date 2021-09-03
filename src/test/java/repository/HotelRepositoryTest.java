package repository;

import model.Hotel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelRepositoryTest {

    @Test
    public void testInsertDelete(){

        Hotel hotel1=new Hotel(24,"nume1","locatie1",100);
        Hotel hotel2=new Hotel(24,"nume2","locatie2",100);
        Hotel hotel3=new Hotel(24,"nume3","locatie3",100);


        HotelRepository hotelRepository=new HotelRepository();


        hotelRepository.insert(hotel1);
        hotelRepository.insert(hotel2);
        hotelRepository.insert(hotel3);


        List<Hotel> hotels=hotelRepository.totateHotelurile();

        assertEquals(true,hotels.contains(hotel1));
        assertEquals(true,hotels.contains(hotel2));
        assertEquals(true,hotels.contains(hotel3));

        hotelRepository.delete(hotel1.getNume_hotel());
        hotelRepository.delete(hotel2.getNume_hotel());
        hotelRepository.delete(hotel3.getNume_hotel());

        hotels=hotelRepository.totateHotelurile();

        assertEquals(false,hotels.contains(hotel1));
        assertEquals(false,hotels.contains(hotel2));
        assertEquals(false,hotels.contains(hotel3));

    }

}