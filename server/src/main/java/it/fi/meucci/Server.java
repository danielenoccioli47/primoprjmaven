package it.fi.meucci;

import java.net.*;
import java.io.*;
import java.util.*;

class Server extends Thread{
    ServerSocket server = null;
    Socket client = null;
    String ricevuto = null;
    String modificato = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    public Server(Socket socket){
        this.client = socket;
    }
    public void run(){
        try{
            comunica();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }


    public void comunica() throws Exception{
        //salvo le variabile di I/O con il client
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        for(;;){
            ricevuto = inDalClient.readLine();
            //se il messaggio ricevuto dal client è 'FINE' ...
            if(ricevuto == null || ricevuto.equals("FINE")){
                outVersoClient.writeBytes(ricevuto+"(=> server in chiusura...)"+ '\n');
                System.out.println("echo sul server in chiusura :" + ricevuto);
                break;
            }
            else{
                outVersoClient.writeBytes(ricevuto + "(ricevuta e ritrasmessa)" + '\n');
                System.out.println("6 echo sul server:" + ricevuto);
            }
        }
        //chiudo i canali tra cui anche il socket
        outVersoClient.close();
        inDalClient.close();
        System.out.println("9 chiudo il socket" + client);
        client.close();
    }
      
}
