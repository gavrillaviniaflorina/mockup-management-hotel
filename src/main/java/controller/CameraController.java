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

    public void insert(Camera camera){
        camere.insert(camera);
    }

    public void delete(int id){
        camere.delete(id);
    }

    public void updateTipCamera(int camera_id,String nou){
        camere.updateTipCamera(camera_id, nou);
    }

    public void updateNrCamere( int camera_id,int nr){
        camere.updateNrCamere(camera_id, nr);
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
        return null;
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
