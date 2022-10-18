package it.fi.itismeucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //creo il client
        Client ilmiocClient = new Client();

        //ottengo il socket
        ilmiocClient.connetti();
        ilmiocClient.comunica();
    }
}
