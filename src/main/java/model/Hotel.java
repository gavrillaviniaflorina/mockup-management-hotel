package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class Hotel {


    private int hotel_id;
    private int angajat_id;
    private String nume_hotel;
    private String locatie;
    private int nr_camere;

    public Hotel(int angajat_id, String nume_hotel, String locatie, int nr_camere) {
        this.angajat_id = angajat_id;
        this.nume_hotel = nume_hotel;
        this.locatie = locatie;
        this.nr_camere = nr_camere;
    }
}
