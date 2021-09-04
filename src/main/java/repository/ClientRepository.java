package repository;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

        private String Jdbc="jdbc:mysql://localhost:3306/hotel_db";
        private String username="root";
        private  String password="root";
        private Connection connection=null;
        private Statement statement=null;

        public ClientRepository(){
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

        public void insert(Client client){
            String insert="";
            insert+="insert into clienti(nume,prenume,nrTelefon,adresa,parola) values (";
            insert+=String.format("'%s','%s','%s','%s','%s'",client.getNume(),client.getPrenume(),client.getNrTelefon(),client.getAdresa(),client.getParola());
            insert+=");";
            executeStatement(insert);

        }

        public void delete(String nume){
            String delete="";
            delete+=String.format("delete from clienti where nume='%s'",nume);
            delete+=";";
            executeStatement(delete);
        }

        public void updateNume( String vechi,String nou){

            String update="";
            update+=String.format("update clienti set nume='%s'",nou);
            update+=String.format("where nume='%s'",vechi);
            executeStatement(update);
        }

        public void updatePrenume( String nume,String prenume){

        String update="";
        update+=String.format("update clienti set prenume='%s'",nume);
        update+=String.format("where nume='%s'",nume);
        executeStatement(update);
    }

        public void updateNrTelefon( String nume,String nrTelefon){

        String update="";
        update+=String.format("update clienti set nrTelefon='%s'",nrTelefon);
        update+=String.format("where nume='%s'",nume);
        executeStatement(update);
    }

        public void updateAdresa( String nume,String adresa){

        String update="";
        update+=String.format("update clienti set adresa='%s'",adresa);
        update+=String.format("where nume='%s'",nume);
        executeStatement(update);
    }


        private ResultSet all(){

            executeStatement("select * from clienti");

            try{
                return statement.getResultSet();

            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        public List<Client> totiClientii(){

            ResultSet set=all();
            List<Client> clienti=new ArrayList<>();
            try{
                while(set.next()){
                   clienti.add(new Client(set.getInt(1),set.getString(2), set.getString(3),set.getString(4),set.getString(5),set.getString(6)));
                }
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
            return clienti;
        }

    }
