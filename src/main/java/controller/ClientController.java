package controller;

import model.Client;
import repository.ClientRepository;

import java.util.List;

public class ClientController {

    private ClientRepository clienti;

    public ClientController() {
        this.clienti=new ClientRepository();
    }

    private boolean exist(Client client){

        List<Client>clients= clienti.totiClientii();
        for(Client client1:clients){
            if(client1.equals(client)){
                return true;
            }
        }
        return false;
    }

    public void insert(Client client){
        if(exist(client)==false) {
            clienti.insert(client);
            System.out.println("Clientul a fost adaugat");
        }else{
            System.out.println("Clientul exista deja.");
        }
    }

    public void delete(String nume){
        if(exist(client(nume))==true) {
            clienti.delete(nume);
            System.out.println("Clientul a fost sters.");
        }else{
            System.out.println("Clientul nu exista pt a il putea sterge.");
        }
    }

    public void updateNume( String vechi,String nou){
        clienti.updateNume(vechi, nou);
        System.out.println("Clientul a fost updatat.");
    }

    public void updatePrenume( String nume,String prenume){
        clienti.updatePrenume(nume, prenume);
        System.out.println("Clientul a fost updatat.");
    }

    public void updateNrTelefon( String nume,String nrTelefon){
        if(exist(client(nume))==true) {
        clienti.updateNrTelefon(nume, nrTelefon);
        System.out.println("Clientul a fost updatat.");
        }else{
            System.out.println("Clientul nu exista pt a il putea sterge.");
        }
    }

    public void updateAdresa( String nume,String adresa) {
        if (exist(client(nume)) == true) {
            clienti.updateAdresa(nume, adresa);
            System.out.println("Clientul a fost updatat.");
        } else {
            System.out.println("Clientul nu exista pt a il putea sterge.");
        }
    }

    public void afisare(){
      for(Client client: clienti.totiClientii()){
          System.out.println(client);
      }
    }

    //todo: functie careia ii dau numele unui client si imi returneaza parola lui
    public String parola(String nume){

        for(Client client: clienti.totiClientii()){
            if(client.getNume().equals(nume)){
                return client.getParola();
            }
        }
        return null;


    }


    //todo:returneaza toat clientul dupa nume

    public Client client(String nume){
        for (Client client:clienti.totiClientii()){
            if(client.getNume().equals(nume)){
                return client;
            }

        }

        return new Client(-1,"", "","","","");
    }
}
