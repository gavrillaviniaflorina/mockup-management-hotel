package controller;

import model.Factura;
import repository.FacturaRepository;

import java.util.List;

public class FacturaController {

    private FacturaRepository facturi;

    public FacturaController() {
        facturi=new FacturaRepository();
    }

    public void insert(Factura factura){
        facturi.insert(factura);
    }

    public void delete(int factura_id){facturi.delete(factura_id);}

    public void updateClientId(int factura_id,int client_id){
        facturi.updateClientId(factura_id,client_id);
    }

    public void updatePretCamera(int factura_id,int pret_camera){
        facturi.updatePretCamera(factura_id,pret_camera);
    }

    public void afisare(){
       for(Factura factura: facturi.totateFacturile()){
           System.out.println(factura);
       }
    }

    public List<Factura> toate(){
        return facturi.totateFacturile();
    }

}
