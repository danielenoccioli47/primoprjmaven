package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        while (true)
        {
            server ilmioserver = new server();
            ilmioserver.attendi();
            ilmioserver.comunica();
        }
        
    }
}
