package controller;

import model.Camera;
import repository.CameraRepository;

import java.util.ArrayList;
import java.util.List;

public class CameraController {

    private CameraRepository camere;

    public CameraController() {

        this.camere=new CameraRepository();
    }

    private boolean exist(Camera camera){

       List<Camera> cameras=toate();

        for (Camera camera1: cameras){
            if(camera1.equals(camera)){
                return true;
            }
        }
        return false;
    }

    public void insert(Camera camera){
        if(exist(camera)==false) {
            System.out.println("Camera a fost adaugata.");
            camere.insert(camera);
        }else{
            System.out.println("Camera exista deja.");
        }
    }

    public void delete(int id){
        if(exist(cameraId(id))==true) {
            camere.delete(id);
            System.out.println("Camera a fost stearsa.");
        }else{
            System.out.println("Camera nu exista pt a o putea sterge.");
        }
    }

    public void updateTipCamera(int camera_id,String nou){
        if(exist(cameraId(camera_id))==true) {
            camere.updateTipCamera(camera_id, nou);
            System.out.println("Camera a fost updatata. ");
        }else{
            System.out.println("Camera nu exista pt a o putea updata.");
        }
    }

    public void updateNrCamere( int camera_id,int nr){
        if(exist(cameraId(camera_id))==true) {
            camere.updateNrCamere(camera_id, nr);
            System.out.println("Camera a fost updatata. ");
        }else {
            System.out.println("Camera nu exista pt a o putea updata.");
        }
    }

    public void afisare(){
    for (Camera camera:camere.toateCamerele()){
        System.out.println(camera);
    }
    }

    public List<Camera> toate(){
        return camere.toateCamerele();
    }

    public int numarTotal(String tip){

        List<Camera> cam=toate();

        for(Camera camera: cam){
            if(camera.getTip_camera().equals(tip)){
                return camera.getNumar();
            }
        }

        return -1;
    }

    public Camera cameraId(int camera_id){

        List<Camera> cam=camere.toateCamerele();
        for(Camera camera: cam){
            if(camera.getCamera_id()==camera_id){
                return camera;
            }
        }
        return new Camera(-1,"",-1,0);
    }

    public List<Camera> cameraTip(String tip){
        List<Camera> tipCamere=new ArrayList<>();
        List<Camera> cam=camere.toateCamerele();
        for(Camera camera: cam){
            if(camera.getTip_camera().equals(tip)){
           tipCamere.add(camera);
            }
        }
        return tipCamere;
    }




}
