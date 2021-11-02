package view;

import controller.CameraController;
import controller.HotelController;
import model.Camera;
import model.Hotel;

import java.util.List;
import java.util.Scanner;

public class ViewHome {
    private ViewLogin login;
    private CameraController camere;
    private HotelController hotel;
    private Scanner scanner;

    public ViewHome() {
        this.login=new ViewLogin();
        this.camere=new CameraController();
        this.hotel=new HotelController();
        this.scanner=new Scanner(System.in);

    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia \n";
        text+="Apasata tasta 1 pentru a va loga\n";
        text+="Apasati tasta 2 pentru a vedea toate hotelurile\n";
        text+="Apasati tasta 3 pentru a vedea toate camerele \n";
        text+="Apasati tasta 4 penrru a vedea toate camerele unui hotel\n";
        text+="Apasati tasta 5 pentru a  filtra camerele dupa pret\n";
        text+="Apasati tasta 6 pentru a filtra camerele dupa disponibilitate \n";
        return text;
    }

    private void seeHotels(){
        hotel.afisare();
    }
    private void seeRooms(){
        camere.afisare();
    }

    private void roomsOfTheHotel(){
        System.out.println("Introduceti numele hotelului");
        String nume=scanner.nextLine();
        int id= hotel.numeHotel(nume);
        if(id==-1){
            System.out.println("Nume incorect");
        }else{
           List<Camera> rooms=camere.camereleHotelului(id);
           for(Camera camera:rooms){
               System.out.println(camera);
           }
        }
    }
}
