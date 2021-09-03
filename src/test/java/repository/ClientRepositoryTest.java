package repository;

import static org.junit.jupiter.api.Assertions.*;

import model.Client;
import org.junit.jupiter.api.Test;

import java.util.List;

class ClientRepositoryTest {

    @Test
    public void testInsertDelete(){
        Client client1=new Client("pop","ion","07321999","adresa1");
        Client client2=new Client("as","andreea","0701111","adresa2");
        Client client3=new Client("bucataru","andrei","072192922","adresa3");


        ClientRepository clientiRepository=new ClientRepository();
        clientiRepository.insert(client1);
        clientiRepository.insert(client2);
        clientiRepository.insert(client3);
//
         List<Client> clienti=clientiRepository.totiClientii();

        System.out.println(clienti.size());
        System.out.println(client1.getClient_id());
        System.out.println(client2.getClient_id());
        System.out.println(client3.getClient_id());
//
      assertEquals(true,clienti.contains(client1));
      assertEquals(true,clienti.contains(client2));
      assertEquals(true,clienti.contains(client3));
//

      clientiRepository.delete(client1.getNume());
      clientiRepository.delete(client2.getNume());
      clientiRepository.delete(client3.getNume());

        clienti=clientiRepository.totiClientii();
        System.out.println(clienti.size());

        assertEquals(false,clienti.contains(client1));
        assertEquals(false,clienti.contains(client2));
        assertEquals(false,clienti.contains(client3));

    }

}