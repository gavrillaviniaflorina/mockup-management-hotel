package repository;



import model.Factura;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacturaRepositoryTest {



    @Test
    public void testInsertDelete(){
        Factura factura1=new Factura(1,200);
        Factura factura2=new Factura(2,300);
        Factura factura3 =new Factura(1,500);


        FacturaRepository facturaRepository=new FacturaRepository();

        facturaRepository.insert(factura1);
      //  facturaRepository.insert(factura2);
        //facturaRepository.insert(factura3);


        List<Factura> facturi=facturaRepository.totateFacturile();


        factura1.setFactura_id(97);


assertEquals(true,facturi.contains(factura1));
//assertEquals(true,facturi.contains(factura2));
//assertEquals(true,facturi.contains(factura3));





        facturaRepository.delete(factura1.getFactura_id());
//        facturaRepository.delete(factura2.getFactura_id());
//        facturaRepository.delete(factura3.getFactura_id());
//
////
       facturi=facturaRepository.totateFacturile();
        assertEquals(false,facturi.contains(factura1));
//        assertEquals(false,facturi.contains(factura2));
//        assertEquals(false,facturi.contains(factura3));

    }


}