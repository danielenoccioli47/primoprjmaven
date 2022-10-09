package it.fi.itismeucci;

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
        System.out.println("2 il client è ora in esecuzione");

        try{
            //x imput da tastiera
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            //creo il soket
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

    public void comincia(){
        for(;;){

            try{
                System.out.println("4 benvenuto, scrivi una frase"+"\n");
                stringaUtente = tastiera.readLine();
                System.out.println("5 invio la stringa al server e attendo.");
                outVersoServer.writeBytes(stringaUtente+"\n");
                strigaRicevDalServer = inDalServer.readLine();
                System.out.println("7 risposta dal server "+"\n"+strigaRicevDalServer);
               
                if(strigaRicevDalServer.equals("FINE"){
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
