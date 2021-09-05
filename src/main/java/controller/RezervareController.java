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

    private boolean exist(Rezervare rezervare){

        List<Rezervare> rezervares=toate();
        for(Rezervare rezervare1:rezervares){
            if(rezervare.equals(rezervare1)){
                return true;
            }
        }
        return false;
    }

    public void insert(Rezervare rezervare){
        if(exist(rezervare)==false) {
            rezervari.insert(rezervare);
            System.out.println("Rezervarea a fost adaugata.");
        }else{
            System.out.println("Rezervarea exista deja.");
        }
    }

    public void delete(int rezervare_id){
        if(exist(rezervare(rezervare_id))==true) {
            rezervari.delete(rezervare_id);
            System.out.println("Rezervarea a fost stearsa.");
        }else{
            System.out.println("Rezervarea nu exista pt a o sterge.");
        }
    }

    public void updateClientId(int rezervare_id,int client_id){
        if(exist(rezervare(rezervare_id))==true) {
        rezervari.updateClientId(rezervare_id, client_id);
        System.out.println("Rezervarea a fost updatata.");
        }else{
            System.out.println("Rezervarea nu exista pt a o updata.");
        }
    }

    public void updateHotelId(int rezervare_id,int hotel_id){
        rezervari.updateHotelId(rezervare_id, hotel_id);
        System.out.println("Rezervarea a fost updatata.");
    }

    public void updateCameraId(int rezervare_id,int camera_id){
        if(exist(rezervare(rezervare_id))==true) {
        rezervari.updateCameraId(rezervare_id, camera_id);
        System.out.println("Rezervarea a fost updatata.");
        }else{
            System.out.println("Rezervarea nu exista pt a o updata.");
        }
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

    private Rezervare rezervare(int id){

        List<Rezervare> rezervares=toate();
        for(Rezervare rezervare:rezervares){
            if(rezervare.getRezervare_id()==id){
                return rezervare;
            }
        }
        return new Rezervare(-1,-1,-1);
    }

}
