package it.fi.meucci;

import java.net.*;
import java.io.*;
import java.util.*;

public class server extends Thread{
    ServerSocket server = null;
    Socket client = null;
    String ricevuto = null;
    String modificato = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    public server(Socket socket){
        this.client = socket;
    }
    public void run(){
        try{
            comunica();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }

    /*public Socket attendi()
    {
        try
        {
            System.out.println("SERVER partito in esecuzione ...");
            server = new ServerSocket(9999);
            while(true){
                client = server.accept();
                
                
                comunica();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server !");
            System.exit(1);
        }
        return client;
    }*/

    public void comunica() throws Exception
    {
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        for(;;){
            ricevuto = inDalClient.readLine();

        }
            /*ricevuto=inDalClient.readLine();
            System.out.println("messaggio: " + ricevuto);
            modificato=ricevuto.toUpperCase();
            outVersoClient.writeBytes(modificato + "\n");
            System.out.println("invio risultati");
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

    
        
      
}
