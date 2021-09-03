package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rezervare implements Comparable<Rezervare> {
    private int rezervare_id;
    private int client_id;
    private int hotel_id;
    private int camera_id;

    public Rezervare(int client_id, int hotel_id,  int camera_id) {
        this.client_id = client_id;
        this.hotel_id = hotel_id;
        this.camera_id = camera_id;
    }


    @Override
    public boolean equals(Object obj){
      Rezervare rezervare=(Rezervare) obj;
      return this.getRezervare_id()==rezervare.getRezervare_id();
    }

  @Override
    public String toString(){
        String text="";
        text+=this.getRezervare_id()+","+this.getClient_id()+","+this.getHotel_id()+","+this.getCamera_id();
        return text;

  }

  @Override
    public int compareTo(Rezervare rezervare){
        if(this.getRezervare_id()>rezervare.getRezervare_id()){
            return 1;
        }else if(this.getRezervare_id()<rezervare.getRezervare_id()){
            return -1;
        }
        return 0;
  }
}
