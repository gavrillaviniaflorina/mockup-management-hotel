package repository;

import model.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository {

    private String Jdbc="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private  String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public FacturaRepository(){
        try{
            connection= DriverManager.getConnection(Jdbc,username,password);
            statement= connection.createStatement();
          //  System.out.println("S-a conectat");
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

    public void insert(Factura factura){
        String insert="";
        insert+="insert into factura(client_id,pret_camera) values (";
        insert+=String.format("%d,%d",factura.getClient_id(),factura.getPret_camera());
        insert+=");";
        executeStatement(insert);

    }

    public void delete(int factura_id){
        String delete="";
        delete+=String.format("delete from factura where factura_id=%d",factura_id);
        delete+=";";
        executeStatement(delete);
    }

    public void updateClientId(int factura_id,int client_id){

        String update="";
        update+=String.format("update factura set client_id=%d",client_id);
        update+=String.format("where factura_id=%d",factura_id);
        executeStatement(update);
    }

    public void updatePretCamera(int factura_id,int pret_camera){

        String update="";
        update+=String.format("update factura set pret_camera=%d",pret_camera);
        update+=String.format("where factura_id=%d",factura_id);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from factura");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Factura> totateFacturile(){

        ResultSet set=all();
        List<Factura> facturi=new ArrayList<>();
        try{
            while(set.next()){


                Factura factura=new Factura();


                factura.setFactura_id(set.getInt(1));
                factura.setClient_id(set.getInt(2));
                factura.setPret_camera(set.getInt(3));


                facturi.add(factura);


            }
            return facturi;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
