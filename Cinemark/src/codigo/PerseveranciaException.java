/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo;

/**
* Esta exception se genera cuando hay un error al leer o escribir el archivo binario con la informacion con el estado de la aplicacion
* Esto retorna un mensaje escribiendo el problema que se presento
*/
public class PerseveranciaException extends Exception{
    
    public PerseveranciaException( String causa )
    {
        super( causa );
    }
}
