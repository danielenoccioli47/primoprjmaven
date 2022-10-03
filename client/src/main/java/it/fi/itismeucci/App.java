package it.fi.itismeucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        client ilmiocClient = new client();
        ilmiocClient.connetti();
        ilmiocClient.comincia();
    }
}
