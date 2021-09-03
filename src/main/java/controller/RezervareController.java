package controller;

import model.Camera;
import model.Rezervare;
import repository.RezervareRepository;

import java.util.List;

public class RezervareController {


    private RezervareRepository rezervari;


    public RezervareController() {
        this.rezervari=new RezervareRepository();
    }

    public void insert(Rezervare rezervare){
        rezervari.insert(rezervare);
    }

    public void delete(int rezervare_id){
        rezervari.delete(rezervare_id);
    }

    public void updateClientId(int rezervare_id,int client_id){
        rezervari.updateClientId(rezervare_id, client_id);
    }

    public void updateHotelId(int rezervare_id,int hotel_id){
        rezervari.updateHotelId(rezervare_id, hotel_id);
    }

    public void updateCameraId(int rezervare_id,int camera_id){
        rezervari.updateCameraId(rezervare_id, camera_id);
    }

    public void afisare(){
      for(Rezervare rezervare:rezervari.totateRezervarile()){
          System.out.println(rezervare);
      }
    }

    public List<Rezervare> toate(){
        return rezervari.totateRezervarile();
    }

    public boolean cameraRezervata(int id_camera){

        List<Rezervare> rez=toate();

        for(Rezervare rezervare:rez){
            if(rezervare.getCamera_id()==id_camera){
                return true;
            }
        }

        return false;
    }


}
