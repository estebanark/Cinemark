/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo;

/**
 *
 * @author Esteban
 */
public class ArchivoException extends Exception {
    
     private int peliculasVendidas;
     
     public ArchivoException( String causa, int ventas )
    {
        super( causa );
        peliculasVendidas = ventas;
    }

    public int getPeliculasVendidas() {
        return peliculasVendidas;
    }
     
   
    
}
