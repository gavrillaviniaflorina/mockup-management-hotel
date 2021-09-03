package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Client {
    private int client_id;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String adresa;


    public Client( String nume, String prenume, String nrTelefon, String adresa) {

        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.adresa = adresa;

    }
}
