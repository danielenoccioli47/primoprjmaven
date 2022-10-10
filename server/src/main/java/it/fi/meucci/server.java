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
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        for(;;){
            ricevuto = inDalClient.readLine();
            if(ricevuto == null || ricevuto.equals("FINE")){
                outVersoClient.writeBytes(ricevuto+"(=> server in chiusura...)"+ "/n");
                System.out.println("echo sul server in chiusura :" + ricevuto);
                break;
            }
            else{
                outVersoClient.writeBytes(ricevuto + "(ricewvuta e ritrasmessa)" + "/n");
                System.out.println("6 echo sul server:" + ricevuto);
            }
        }
    }
      
}
