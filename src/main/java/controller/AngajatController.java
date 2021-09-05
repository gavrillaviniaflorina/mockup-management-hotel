package controller;
import model.Angajat;
import model.Client;
import repository.AngajatRepository;

public class AngajatController {

    private AngajatRepository angajati;

    public AngajatController() {
        this.angajati = new AngajatRepository();
    }

    public void insert(Angajat angajat) {
        angajati.insert(angajat);

    }

    public void delete(String nume) {
        angajati.delete(nume);
    }

    public void updateNume(String vechi, String nou) {
        angajati.updateNume(vechi, nou);
    }

    public void updatePrenume(String nume, String prenume) {
        angajati.updatePrenume(nume, prenume);
    }

    public void updateNrTelefon(String nume, String nrTelefon) {
        angajati.updateNrTelefon(nume, nrTelefon);
    }

    public void afisare() {

        for (Angajat angajat : angajati.totiAngajatii()) {
            System.out.println(angajat);
        }
    }

    public String parola(String nume) {

        for (Angajat angajat : angajati.totiAngajatii()) {
            if (angajat.getNume().equals(nume)) {
                return angajat.getParola();
            }
        }
        return null ;

    }

    public Angajat angajat(String nume){
        for(Angajat angajat: angajati.totiAngajatii()){
            if(angajat.getNume().equals(nume)){
                return  angajat;
            }
        }
        return null;
    }
}

