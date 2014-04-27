

package codigo;

/**
 * Este exeption se genera cuando sse quiere aderir una pelicula duplicada a la aplicacion
 * Se retorna un mensaje asociado al nombre del elemento que esta causando el error 
 */

public class ElementoException extends Exception{
    
    public ElementoException( String nomElem )
    {
        super( nomElem );
    }
    
    
    
}
