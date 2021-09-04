package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Angajat implements Comparable<Angajat>{
   private int angajat_id;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String parola;

    public Angajat(String nume, String prenume, String nrTelefon,String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.parola=parola;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getAngajat_id()+","+this.getNume()+","+this.getPrenume()+","+this.getNrTelefon()+","+this.parola;
        return text;
    }


    @Override
    public boolean equals(Object obj){
        Angajat angajat =(Angajat)obj;
    return this.getAngajat_id()==angajat.getAngajat_id();
    }

    @Override
    public int compareTo(Angajat angajat){

        if(this.getAngajat_id()>angajat.getAngajat_id()){
            return 1;
        }else if(this.getAngajat_id()<angajat.getAngajat_id()){
            return -1;
        }
        return 0;
    }
}
