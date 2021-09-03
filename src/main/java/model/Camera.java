package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Camera implements Comparable<Camera> {
    private int camera_id;
    private String tip_camera;
    private int numar;
    private int hotel_id;



    public Camera(String tip_camera, int numar,int hotel_id) {
        this.tip_camera = tip_camera;
        this.numar = numar;
        this.hotel_id=hotel_id;

    }

    @Override
    public boolean equals(Object obj){

        Camera camera=(Camera) obj;
        return this.getCamera_id()==camera.getCamera_id();
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getTip_camera()+","+this.getNumar()+","+this.getHotel_id();
        return text;
    }

    @Override
    public int compareTo(Camera camera){
        if(this.getCamera_id()>camera.getCamera_id()){
            return 1;
        }else if(this.getCamera_id()<camera.getCamera_id()){
            return -1;
        }
        return 0;

    }
}
