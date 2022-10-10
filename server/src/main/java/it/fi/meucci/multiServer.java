package it.fi.meucci;

import java.net.*;
import java.io.*;
import java.util.*;

public class multiServer{
    public void inizia(){
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            for(;;){
                System.out.println("1 server in attesa ...");
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