package repository;

import model.Rezervare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RezervareRepository {




        private String Jdbc="jdbc:mysql://localhost:3306/hotel_db";
        private String username="root";
        private  String password="root";
        private Connection connection=null;
        private Statement statement=null;

        public RezervareRepository(){
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

        public void insert(Rezervare rezervare){
            String insert="";
            insert+="insert into rezervari(client_id,hotel_id,id_camera) values (";
            insert+=String.format("%d,%d,%d",rezervare.getClient_id(),rezervare.getHotel_id(),rezervare.getCamera_id());
            insert+=");";
            executeStatement(insert);

        }

        public void delete(int rezervare_id){
            String delete="";
            delete+=String.format("delete from rezervari where rezervare_id=%d",rezervare_id);
            delete+=";";
            executeStatement(delete);
        }

        public void updateClientId(int rezervare_id,int client_id){

            String update="";
            update+=String.format("update rezervari set client_id=%d",client_id);
            update+=String.format(" where rezervare_id=%d",rezervare_id);
            executeStatement(update);
        }

        public void updateHotelId(int rezervare_id,int hotel_id){

        String update="";
        update+=String.format("update rezervari set hotel_id=%d",hotel_id);
        update+=String.format(" where rezervare_id=%d",rezervare_id);
        executeStatement(update);
    }

       public void updateCameraId(int rezervare_id,int camera_id){

        String update="";
        update+=String.format("update rezervari set camera_id=%d",camera_id);
        update+=String.format(" where rezervare_id=%d",rezervare_id);
        executeStatement(update);
    }



       private ResultSet all(){

        executeStatement("select * from rezervari");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

       public List<Rezervare> totateRezervarile(){

        ResultSet set=all();
        List<Rezervare> rezervari=new ArrayList<>();
        try{
            while(set.next()){
                rezervari.add(new Rezervare(set.getInt(1),set.getInt(2),set.getInt(3),set.getInt(4)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return rezervari;
    }

    }
