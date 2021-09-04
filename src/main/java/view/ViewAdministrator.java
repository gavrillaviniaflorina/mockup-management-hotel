package view;

import controller.*;
import model.*;

import java.util.Scanner;

public class ViewAdministrator {

   private Angajat angajat;
    private AngajatController angajati;
    private CameraController camere;
    private ClientController clienti;
    private FacturaController facturi;
    private RezervareController rezervari;
    private Scanner scanner;

    public ViewAdministrator(Angajat angajat){
        this.angajat=angajat;
        this.angajati=new AngajatController();
        this.camere=new CameraController();
        this.clienti=new ClientController();
        this.facturi=new FacturaController();
        this.rezervari=new RezervareController();
        this.scanner=new Scanner(System.in);

    }



    private String meniuCamere(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a vizualiza toate camerele\n";
        text+="Apasati tasta 2 pentru a adauga o camera\n";
        text+="Apasati tasta 3 pentru a sterge o camera\n";
        text+="Apasati tasta 4 pentru a updata tipul unei camere\n";
        return text;
    }

    private String meniuClienti(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a vizualiza toti clientii\n";
        text+="Apasati tasta 2 pentru a sterge un client\n";
        text+="Apasati tasta 3 pentru a updata numarul de telefon al unui client\n";
        text+="Apasati tasta 4 pentru a updata adresa unui client\n";
        return text;
    }

    private String meniuFactura(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a vizualiza toate facturile\n";
        text+="Apasati tasta 2 pentru a adauga o factura\n";
        text+="Apasati tasta 3 pentru a sterge o factura\n";
        text+="Apasati tasta 4 pentru a updata pretul unei camere\n";
        return text;
    }

    private String meniuRezervari(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a vizualiza toate rezervarile\n";
        text+="Apasati tasta 2 pentru a adauga o rezervare\n";
        text+="Apasati tasta 3 penru a sterge o rezervare\n";
        text+="Apasati tasta 4 pentru a updata id-ul camerei ce apartine de o rezervare\n";
        text+="Apasati tasta 5 pentru a updata id-ul unui client ce apartine de o rezervare\n ";

        return text;
    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a accesa camerele\n";
        text+="Apasati tasta 2 pentru a accesa clientii\n";
        text+="Apasati tasta 3 pentru a accesa facturile\n";
        text+="Apasati tasta 4 pentru a accesa rezervarile\n";
        return text;
    }






    private void playCamere(){
        System.out.println(meniuCamere());
        boolean run =true;

        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                     break;
                case 1:
                    camere.afisare();
                    break;
                case 2:
                    insertCamera();
                    break;
                case 3:
                    deleteCamera();
                    break;
                case 4:
                    tipCamera();
                    break;
                default:
                    System.out.println(meniuCamere());
                    break;

            }
            
        }
    }

    private void playClient(){
        System.out.println(meniuClienti());
        boolean run =true;

        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    clienti.afisare();
                    break;
                case 2:
                    insertClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    telefonClient();
                    break;
                case 5:
                    adresaClient();
                    break;
                default:
                    System.out.println(meniuCamere());
                    break;

            }

        }
    }

    private void playFacturi() {
        System.out.println(meniuFactura());
        boolean run = true;

        while (run) {
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 0:
                    run = false;
                    break;
                case 1:
                    facturi.afisare();
                    break;
                case 2:
                    insertFactura();
                    break;
                case 3:
                    deleteFactura();
                    break;
                case 4:
                    pretCameraFactura();
                    break;
                default:
                    System.out.println(meniuFactura());
                    break;

            }
        }
    }

    private void playRezervari(){

        System.out.println(meniuRezervari());
        boolean run=true;
        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    rezervari.afisare();
                    break;
                case 2:
                    insetRezervare();
                    break;
                case 3:
                    deleteRezervare();
                    break;
                case  4:
                    idCameraRezervare();
                    break;
                case 5:
                    idClientRezervare();
                    break;
                default:
                    System.out.println(meniuRezervari());
                    break;
            }
        }
    }

    public void play(){
        System.out.println(meniu());
        boolean run=true;

        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    playCamere();
                    break;
                case 2:
                    playClient();
                    break;
                case 3:
                    playFacturi();
                    break;
                case 4:
                    playRezervari();
                    break;
                default:
                    System.out.println(meniu());
                    break;

            }
        }
    }






    private void insertCamera(){
        System.out.println("Introduceti tipul camerei: ");
        String tip=scanner.nextLine();
        System.out.println("Introduceti numarul de camere de acest tip: ");
        int nr=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti i-ul hotelului: ");
        int hotel_id=Integer.parseInt(scanner.nextLine());

        Camera camera=new Camera(tip,nr,hotel_id);
        camere.insert(camera);
    }

    private void insertClient(){
        System.out.println("Introduceti numele : ");
        String nume=scanner.nextLine();
        System.out.println("Introduceti prenumele : ");
        String prenume=scanner.nextLine();
        System.out.println("Introduceti numarul de telefon: ");
        String telefon=scanner.nextLine();
        System.out.println("Introduceti adresa:");
        String adresa=scanner.nextLine();
        System.out.println("Introduceti parola:");
        String parola=scanner.nextLine();

        Client client=new Client(nume,prenume,telefon,adresa,parola);
        clienti.insert(client);
    }

    private void insertFactura(){
        System.out.println("Introduceti id-ul clientului\n");
        int idClient=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti pretul camerei\n");
        int pret=Integer.parseInt(scanner.nextLine());


        Factura factura=new Factura(idClient,pret);
        facturi.insert(factura);

    }

    private void insetRezervare(){
        System.out.println("Introduceti id-ul clientului:");
        int idClient=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti id-ul hotelului:");
        int idHotel=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti id-ul camerei:");
        int idCamera=Integer.parseInt(scanner.nextLine());


        Rezervare rezervare=new Rezervare(idClient,idHotel,idCamera);
        rezervari.insert(rezervare);


    }




    private void deleteCamera(){
        System.out.println("Introduceti id-ul camerei pe care doriti sa o stergeti: ");
        int id=Integer.parseInt(scanner.nextLine());

        camere.delete(id);

    }

    private void deleteClient(){
        System.out.println("Introduceti numele clientului pe care doriti sa il stergeti: ");
        String nume=scanner.nextLine();

        clienti.delete(nume);
    }

    private void deleteFactura(){
        System.out.println("Introduceti id-ul facturii pe care doriti sa o stergeti:");
        int id=Integer.parseInt(scanner.nextLine());

        facturi.delete(id);
    }

    private void deleteRezervare(){
        System.out.println("Introduceti id-ul rezervarii pe care doriti sa o stergeti: ");
        int id=Integer.parseInt(scanner.nextLine());

        rezervari.delete(id);
    }



    private void tipCamera(){
        System.out.println("Introduceti id-ul camerei careia doriti sa ii schimbati tipul: ");
       int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti noul tip :");
        String nou=scanner.nextLine();
       camere.updateTipCamera(id,nou);
    }

    private void telefonClient(){
        System.out.println("Introduceti numele clientului caruia doriti sa ii schimbati numarul de telefon: ");
        String nume=scanner.nextLine();
        System.out.println("Introduceti noul numar de telefon: ");
        String telefon=scanner.nextLine();

        clienti.updateNrTelefon(nume,telefon);
    }

    private void adresaClient(){
        System.out.println("Introduceti numele clientului caruia doriti sa ii schimbati adresa: ");
        String nume=scanner.nextLine();
        System.out.println("Introduceti noua adresa: ");
        String adresa=scanner.nextLine();

        clienti.updateAdresa(nume,adresa);

    }

    private void pretCameraFactura(){

        System.out.println("Introduceti id-ul facturii in care doriti sa schimbati pretul unei camere:");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti noul pret:");
        int pret=Integer.parseInt(scanner.nextLine());

        facturi.updatePretCamera(id,pret);

    }

    private void idClientRezervare(){
        System.out.println("Introduceti id-ul rezervarii carei doriti sa ii schimbati id-ul clientului:");
        int idRezervare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti noul id:");
        int idClient=Integer.parseInt(scanner.nextLine());

        rezervari.updateClientId(idRezervare,idClient);
    }

    private void idCameraRezervare(){
        System.out.println("Introduceti id-ul rezervarii carei doriti sa ii schimbati id-ul camerei:");
        int idRezervare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti noul id:");
        int idCamera=Integer.parseInt(scanner.nextLine());

        rezervari.updateCameraId(idRezervare,idCamera);
    }

}
