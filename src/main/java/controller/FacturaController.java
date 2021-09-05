package controller;

import model.Factura;
import repository.FacturaRepository;

import java.util.List;

public class FacturaController {

    private FacturaRepository facturi;

    public FacturaController() {
        facturi=new FacturaRepository();
    }

    private boolean exist(Factura factura){
        List<Factura> facturas=toate();
        for(Factura factura1:facturas){
            if(factura1.equals(factura)){
                return true;
            }
        }
        return false;
    }

    public void insert(Factura factura){
        if(exist(factura)==false) {
            facturi.insert(factura);
            System.out.println("Factura a fost adaugata.");
        }else {
            System.out.println("Factura exista deja.");
        }
    }

    public void delete(int factura_id){
        if(exist(factura(factura_id))==true) {
            facturi.delete(factura_id);
            System.out.println("Factura a fost stearsa.");
        }else{
            System.out.println("Factura nu exista pt a o sterge.");
        }
       }

    public void updateClientId(int factura_id,int client_id){
        if(exist(factura(factura_id))==true) {
            facturi.updateClientId(factura_id, client_id);
            System.out.println("Factura a fost updatata");
        }else{
            System.out.println("Factura nu exita pt a o updata.");
        }
    }

    public void updatePretCamera(int factura_id,int pret_camera){
        if(exist(factura(factura_id))==true) {
        facturi.updatePretCamera(factura_id,pret_camera);
        System.out.println("Factura a fost updatata");
        }else{
            System.out.println("Factura nu exita pt a o updata.");
        }
    }

    public void afisare(){
       for(Factura factura: facturi.totateFacturile()){
           System.out.println(factura);
       }
    }

    public List<Factura> toate(){
        return facturi.totateFacturile();
    }

    public Factura factura(int id){
        for(Factura factura: facturi.totateFacturile()){
            if(factura.getFactura_id()==id){
                return factura;
            }
        }
        return new Factura(-1,-1,-1);
    }

}
