package view;

import controller.CameraController;
import controller.ClientController;
import controller.FacturaController;
import controller.RezervareController;
import model.Camera;
import model.Client;
import model.Factura;
import model.Rezervare;
import repository.RezervareRepository;

import java.util.List;
import java.util.Scanner;

public class ViewClient {

    private Client client;
    private ClientController clienti;
    private FacturaController facturi;
    private CameraController camere;
    private RezervareController rezervari;
    private Scanner scanner;

    public ViewClient(Client client) {
        this.client=client;
        this.clienti=new ClientController();
        this.facturi=new FacturaController();
        this.camere=new CameraController();
        this.scanner=new Scanner(System.in);
        this.rezervari=new RezervareController();
    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a vizualiza toate facturile dumneavoastra\n";
        text+="Apasati tasta 2 pentru a vizualiza toate camerele in care ati stat\n";
        text+="Apasati tasta 3 pentru a face o rezervare\n";

        return text;
    }

  public void play(){
        System.out.println(meniu());
        boolean run =true;

        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    facturiClient();
                    break;
                case 2:
                    camereClient();
                    break;
                case 3:
                    rezervare();
                    break;
                default:
                    System.out.println(meniu());
                    break;

            }

        }
    }

    public void facturiClient(){

        List<Factura> fact=facturi.toate();
        int ok=0;
        for(Factura factura:fact){
            if(factura.getClient_id()== client.getClient_id()){
                System.out.println(factura);
                ok=1;
            }
        }
        if(ok==0){
            System.out.println("Nu aveti facturi.");
        }
    }

    public void camereClient(){
        List<Camera> cam=camere.toate();
        int ok=0;
        for(Camera camera: cam){
            if(camera.getNumar()== client.getClient_id()){
                System.out.println(camera);
                ok=1;
            }
        }
        if(ok==0){
            System.out.println("Nu ati rezervat nicio camera.");
        }
    }

    public void rezervare(){
        System.out.println("Specificati tipul de camera pe care il doriti");
        String tip=scanner.nextLine();
        int total= camere.numarTotal(tip);
        int indisponibil=numarIndisponibile(tip);

        if(total-indisponibil<=0){
            System.out.println("Nu mai avem camere disponibile!");
        }else{
            Camera camera=cameraNerzervata(tip);
            Rezervare rezervare=new Rezervare(client.getClient_id(),camera.getHotel_id(), camera.getCamera_id());
            rezervari.insert(rezervare);
            System.out.println(rezervare);
            System.out.println("Rezervarea a fost efectuata");
        }

            }

  public int numarIndisponibile(String tip){


      int nr=0;
        List<Rezervare> rez=rezervari.toate();
        for(Rezervare rezervare: rez){
        Camera camera= camere.cameraId(rezervare.getCamera_id());
        if(camera.getTip_camera().equals(tip)){
            nr++;
        }
        }
        return nr;
        }

  //todo:rezurneaza prima camera de un tip nerezervata

  public Camera cameraNerzervata(String tip){

        List<Camera> cameras=camere.cameraTip(tip);

        for(Camera camera: cameras){
            if(rezervari.cameraRezervata(camera.getCamera_id())==false){
                return camera;
            }
        }

        return null;

  }
}


