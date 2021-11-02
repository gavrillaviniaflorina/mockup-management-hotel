package controller;

import model.Hotel;
import repository.HotelRepository;

public class HotelController {

    private HotelRepository hoteluri;

    public HotelController() {
        this.hoteluri=new HotelRepository();
    }

    public void insert(Hotel hotel){
        hoteluri.insert(hotel);
    }

    public void delete(String nume_hotel){
        hoteluri.delete(nume_hotel);
    }

    public void updateNume( String vechi,String nou){
        hoteluri.updateNume(vechi,nou);
    }

    public void updateAngajatId(String nume_hotel,int angajat_id){
        hoteluri.updateAngajatId(nume_hotel, angajat_id);
    }

    public void updateLocatie(String nume_hotel,String locatie){
        hoteluri.updateLocatie(nume_hotel,locatie);
    }

    public void updateNrCamere(String nume_hotel,int nr_camere){
        hoteluri.updateNrCamere(nume_hotel, nr_camere);
    }

    public void afisare(){
       for(Hotel hotel: hoteluri.totateHotelurile()){
           System.out.println(hotel);
       }
    }

    public int numeHotel(String nume){
        for(Hotel hotel: hoteluri.totateHotelurile()){
            if(hotel.getNume_hotel().equals(nume)){
                return hotel.getHotel_id();
            }
        }
        return -1;
    }
}
