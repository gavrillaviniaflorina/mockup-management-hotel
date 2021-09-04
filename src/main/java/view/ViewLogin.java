package view;

import controller.AngajatController;
import controller.ClientController;
import model.Angajat;
import model.Client;

import javax.swing.text.View;
import java.util.Scanner;

public class ViewLogin {


    private Scanner scanner;
    private AngajatController angajati;
    private ClientController clienti;

    public ViewLogin() {
        this.scanner=new Scanner(System.in);
        this.angajati=new AngajatController();
        this.clienti=new ClientController();
    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a va loga\n";
        return text;

    }


    private void login(){

        System.out.println("Introduceti statusul dvs(ex:admin,client)");
        String status=scanner.nextLine();
        System.out.println("Introduceti numele dvs:");
        String nume=scanner.nextLine();
        System.out.println("Introduceti parola dvs:");
        String parola=scanner.nextLine();

        if(status.equals("admin")){
            if(angajati.parola(nume).equals(parola)){
                Angajat a= angajati.angajat(nume);
                ViewAdministrator administrator=new ViewAdministrator(a);
                administrator.play();
            }else{
                System.out.println("nume sau parola incorecta!");
            }
        }else{
            if(clienti.parola(nume).equals(parola)){
                Client c =clienti.client(nume);
                ViewClient client=new ViewClient(c);
                client.play();
            }else{
                System.out.println("nume sau parola incorecte!");
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
                    login();
                    break;
                default:
                    System.out.println(meniu());
            }
        }
    }
}
