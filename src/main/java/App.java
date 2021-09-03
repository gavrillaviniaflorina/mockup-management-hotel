import model.Client;
import view.ViewClient;

public class App {



        public static void main(String[] args) {
                Client c=new Client(1,"popescu","ana","071111111","adresa1");
            ViewClient client=new ViewClient(c);
            client.rezervare();
        }
        }


