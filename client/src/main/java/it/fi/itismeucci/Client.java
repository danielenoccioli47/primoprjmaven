package it.fi.itismeucci;

import java.io.*;
import java.net.*;

public class Client {
    String nomeServer = "localHost";
    int portaServer = 9999;
    Socket ilmioSoket;
    BufferedReader tastiera;
    String stringaUtente;
    String strigaRicevDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;


    public Socket connetti(){
        System.out.println("2 il client è ora in esecuzione");

        try{
            //input da tastiera
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            //creo il soket con ip (nel nostro caso 127.0.0.1 o localhost) e porta
            ilmioSoket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(ilmioSoket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(ilmioSoket.getInputStream()));
        }catch(UnknownHostException u){
            System.out.println("host sconosciuto");    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione");
            System.exit(1);
        }
        return ilmioSoket;    
    }

    public void comunica(){
        for(;;){

            try{
                System.out.println("4 benvenuto, scrivi una frase");
                //richiedo una stringa dell utente
                stringaUtente = tastiera.readLine();
                System.out.println("5 invio la stringa al server e attendo.");
                //trasformo la stringa in bytes e la inoltro al server tramite il socket
                outVersoServer.writeBytes(stringaUtente+"\n");
                //aspetto e leggo la risposta dal server
                strigaRicevDalServer = inDalServer.readLine();
                System.out.println("7 risposta dal server "+"\n"+strigaRicevDalServer);
               
                //se il messaggio ricevuto dal server è FINE allora chiudo il socket
                if(strigaRicevDalServer.equals("FINE")){
                    System.out.println("8 client: termina operazione e chiude la connessione");
                    ilmioSoket.close();
                    break;
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("errore durante la connessione");
                System.exit(1);
            }

        }
        
    }

}
