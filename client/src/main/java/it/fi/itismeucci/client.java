import java.io.*;
import java.net.*;

public class client {
    String nomeServer = "localHost";
    int portaServer = 9999;
    Socket ilmioSoket;
    BufferedReader tastiera;
    String stringaUtente;
    String strigaRicevDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;


    public Socket connetti(){
        System.out.println("il client è ora in esecuzione");

        try{
            //x imput da tastiera
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            //creo il soket
            mioSocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(mioSocket.getInputStream());
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione");
            System.exit(1);
        }
        return mioSocket;    
    }

    public void comincia(){
        try{
            System.out.println("inserisci la stringa da trasmettere  al server"+"\n");
            stringaUtente = tastiera.readLine();
            System.out.println("invio la stringa al server e attendo");
            outVersoServer.writeBytes(stringaUtente+"\n");
            strigaRicevDalServer = inDalServer.readLine();
            System.out.println("risposta dal server "+"\n"+strigaRicevDalServer);
            //chiudo la connessione
            mioSocket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione");
            System.exit(1);
        }
    }

}
