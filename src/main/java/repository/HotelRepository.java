package repository;

import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private String Jdbc="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private  String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public HotelRepository(){
        try{
            connection= DriverManager.getConnection(Jdbc,username,password);
            statement= connection.createStatement();
            System.out.println("S-a conectat");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void executeStatement(String execute){

        try{
            statement.execute(execute);

        }catch (SQLException e){
            System.out.println("Nu am reusit "+ execute);
        }
    }

    public void insert(Hotel hotel){
        String insert="";
        insert+="insert into hotel(angajat_id,nume_hotel,locatie,nr_camere) values (";
        insert+=String.format("%d,'%s','%s',%d",hotel.getAngajat_id(),hotel.getNume_hotel(),hotel.getLocatie(),hotel.getNr_camere());
        insert+=");";
        executeStatement(insert);

    }

    public void delete(String nume_hotel){
        String delete="";
        delete+=String.format("delete from hotel where nume_hotel='%s'",nume_hotel);
        delete+=";";
        executeStatement(delete);
    }

    public void updateNume( String vechi,String nou){

        String update="";
        update+=String.format("update hotel set nume_hotel='%s'",nou);
        update+=String.format("where nume_hotel='%s'",vechi);
        executeStatement(update);
    }

    public void updateAngajatId(String nume_hotel,int angajat_id){

        String update="";
        update+=String.format("update hotel set angajat_id=%d",angajat_id);
        update+=String.format("where nume_hotel='%s'",nume_hotel);
        executeStatement(update);
    }

    public void updateLocatie(String nume_hotel,String locatie){

        String update="";
        update+=String.format("update hotel set locatie='%s'",locatie);
        update+=String.format("where nume_hotel='%s'",nume_hotel);
        executeStatement(update);
    }

    public void updateNrCamere(String nume_hotel,int nr_camere){

        String update="";
        update+=String.format("update hotel set nr_camere=%d",nr_camere);
        update+=String.format("where nume_hotel='%s'",nume_hotel);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from hotel");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Hotel> totateHotelurile(){

        ResultSet set=all();
        List<Hotel> hoteluri=new ArrayList<>();
        try{
            while(set.next()){
                hoteluri.add(new Hotel(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getInt(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return hoteluri;
    }
}
