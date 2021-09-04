package controller;

import model.Client;
import repository.ClientRepository;

public class ClientController {

    private ClientRepository clienti;

    public ClientController() {
        this.clienti=new ClientRepository();
    }

    public void insert(Client client){
        clienti.insert(client);
    }

    public void delete(String nume){
        clienti.delete(nume);
    }

    public void updateNume( String vechi,String nou){
        clienti.updateNume(vechi, nou);
    }

    public void updatePrenume( String nume,String prenume){
        clienti.updatePrenume(nume, prenume);
    }

    public void updateNrTelefon( String nume,String nrTelefon){
        clienti.updateNrTelefon(nume, nrTelefon);
    }

    public void updateAdresa( String nume,String adresa){
        clienti.updateAdresa(nume, adresa);
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

        return null;
    }
}
