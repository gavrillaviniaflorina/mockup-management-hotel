package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Client implements Comparable<Client>{
    private int client_id;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String adresa;
    private String parola;


    public Client( String nume, String prenume, String nrTelefon, String adresa,String parola) {

        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.adresa = adresa;
        this.parola=parola;

    }


    @Override
    public String toString(){
        String text="";
        text+=this.getClient_id()+","+this.getNume()+","+this.getPrenume()+","+this.getNrTelefon()+","+this.getAdresa()+","+this.getParola();
        return text;
    }


    @Override
    public boolean equals(Object obj){
       Client client=(Client) obj;
        return this.getClient_id()==client.getClient_id();
    }

    @Override
    public int compareTo(Client client){

        if(this.getClient_id()>client.getClient_id()){
            return 1;
        }else if(this.getClient_id()<client.getClient_id()){
            return -1;
        }
        return 0;
    }
}
