package repository;

import model.Angajat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AngajatRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public AngajatRepository(){
        try {
            connection = DriverManager.getConnection(JdbcURl, username, password);
            statement = connection.createStatement();
           // System.out.println("S-a conectat");
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

    public void insert(Angajat angajat){
        String insert="";
        insert+="insert into angajati (nume,prenume,nrTelefon,parola ) values (";
        insert+=String.format("'%s','%s','%s','%s'",angajat.getNume(),angajat.getPrenume(),angajat.getNrTelefon(),angajat.getParola());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String nume){
        String delete="";
        delete+=String.format("delete from angajati where nume='%s'",nume);
        delete+=";";
        executeStatement(delete);
    }

    public void updateNume( String vechi,String nou){

        String update="";
        update+=String.format("update angajati set nume='%s'",nou);
        update+=String.format("where nume='%s'",vechi);
        executeStatement(update);
    }

    public void updatePrenume( String nume,String prenume){

        String update="";
        update+=String.format("update angajati set prenume='%s'",prenume);
        update+=String.format("where nume='%s'",nume);
        executeStatement(update);
    }

    public void updateNrTelefon( String nume,String nrTelefon){

        String update="";
        update+=String.format("update angajati set nrTelefon='%s'",nrTelefon);
        update+=String.format("where nume='%s'",nume);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from angajati");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Angajat> totiAngajatii(){

      ResultSet set=all();
      List<Angajat> angajati=new ArrayList<>();
      try{
          while(set.next()){
              angajati.add(new Angajat(set.getInt(1),set.getString(2),set.getString(3), set.getString(4),set.getString(5)));
          }
      }catch (Exception e){
          e.printStackTrace();
          return null;
      }
      return angajati;
    }



    
}
