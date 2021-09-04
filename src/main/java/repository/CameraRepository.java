package repository;

import model.Camera;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CameraRepository {
    private String Jdbc="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private  String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public CameraRepository(){
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

    public void insert(Camera camera){
       String insert="";
       insert+="insert into camera(tip_camera,numar,hotel_id) values (";
       insert+=String.format("'%s',%d,%d",camera.getTip_camera(),camera.getNumar(),camera.getHotel_id());
       insert+=");";
       executeStatement(insert);

    }

    public void delete(int id){
        String delete="";
        delete+=String.format("delete from camera where camera_id=%d",id);
        delete+=";";
        executeStatement(delete);
    }

    public void updateTipCamera( int camera_id,String nou){

        String update="";
        update+=String.format("update camera set tip_camera='%s'",nou);
        update+=String.format("where camera_id=%d",camera_id);
        executeStatement(update);
    }

    public void updateNrCamere( int camera_id,int nrCamere){

        String update="";
        update+=String.format("update camera set numar=%d",nrCamere);
        update+=String.format("where camera_id=%d",camera_id);
        executeStatement(update);
    }


    private ResultSet all(){

        executeStatement("select * from camera");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Camera> toateCamerele(){

        ResultSet set=all();
        List<Camera> camere=new ArrayList<>();
        try{
            while(set.next()){
                camere.add(new Camera(set.getInt(1),set.getString(2),set.getInt(3),set.getInt(4)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return camere;
    }

}
