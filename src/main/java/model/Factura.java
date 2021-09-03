package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor

public class Factura implements Comparable<Factura>{


    private int factura_id;
    private int client_id;
    private int pret_camera;

    public Factura(int factura_id, int client_id, int pret_camera) {
        this.factura_id = factura_id;
        this.client_id = client_id;
        this.pret_camera = pret_camera;
    }

    public Factura(int client_id, int pret_camera) {
        this.client_id = client_id;
        this.pret_camera = pret_camera;
    }

    @Override
    public int compareTo(Factura factura){
        if(this.getFactura_id()>factura.getFactura_id()){
            return 1;
        }else if(this.getFactura_id()<factura.getFactura_id()){
            return -1;
        }
        return 0;
    }
    @Override
    public String toString(){
        String text="";
        text+=this.getFactura_id()+","+this.getClient_id()+","+this.getPret_camera();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Factura factura=(Factura)obj;
    return this.getFactura_id()==factura.getFactura_id();
    }
}
