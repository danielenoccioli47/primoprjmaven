package it.fi.meucci;

import java.net.*;
import java.io.*;
import java.util.*;

public class MultiServer{
    //
    public void inizia(){
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            //ogni volta che che un client mi si connette, un nuovo thread si preoccupa di gestirlo tramite il metodo start
            for(;;){
                System.out.println("1 server in attesa ...");
                //aspetto che ul client mi si connetta-->ottengo il socket tramite il metodo accept
                Socket socket = serverSocket.accept();
                System.out.println("3 server socket "+ socket);
                Server serverThread = new Server(socket);
                serverThread.start();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante l'instanziamento del server");
            System.exit(1);
        }
    }
}