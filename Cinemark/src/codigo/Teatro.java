/***************************************************************
 * 
 *  Proyecto Cinemark - Programación 4
 * 
 * @author Elvis Esteban Aragón Castaño
 * Código: 1115077569
 * @version 1.0
 * Universidad Tecnológica de Pereira
 **************************************************************/

package codigo;

import java.io.Serializable;
import java.util.ArrayList;


//Esta es la clase que representa un teatro en la aplicacion
public class Teatro implements Serializable{
    
private static final long serialVersionUID = 100L;

    //---------------------
    // Atibutos
    //---------------------
    
    
    //Es el vector con las peliculas del teatro
    private ArrayList peliculas;
    
    //Es el titulo del teatro
    private String titulo;
    
    //Es la direccion del teatro
    private String direccion;
    
    // Es el telefono del teatro
    private String telefono;
    
    //Nombre del archivo que contiene la imagen asociada con el disco
    private String imagen;

    /**
     * Contruye un nuevo teatro con los datos suministrados pero sin peliculas
     * @param tituloT es el titulo del teatro - tituloT != null, tituloT != ""
     * @param direccionTes la direccion del teatro- direccionTes != null, direccionTes != ""
     * @param telefonoT es el telefono del teatro- telefonoT != null, telefonoT != ""
     * @param imagenT  es la imagen del teatro - imagenT != null, imagenT != ""
     */
    public Teatro(String tituloT, String direccionT, String telefonoT, String imagenT) {
        this.peliculas = new ArrayList();
        this.titulo=tituloT;
        this.direccion = direccionT;
        this.telefono = telefonoT;
        this.imagen = imagenT;
        verificarInvariancia();
    }
    
    //---------------------
    // Metodos
    //--------------------- 

    
    
    /**
     * Metodo que retorna una pelicula dependiendo de su nombre
     * @param tituloP Es el nombre de la pelicula a buscar - tituloP !=null;
     * @return La pelicula cuyo nombre es igual al nombre dado en el parametro. Si no lo encuentra retorna NULL
     */
    public Pelicula getPelicula(String tituloP) {
        for(int i=0; i < peliculas.size();i++){
            Pelicula p = (Pelicula)peliculas.get(i);
            if (p.equals(tituloP))
                return p;
        }
        return null;
    }
    
    /**
     * Agrega una pelicula al teatro
     * @param c la nueva pelicula que se va a agregar al teatro
     */
    public void agregarPelicula(Pelicula c) throws ElementoException{
        if (getPelicula(c.getTitulo()) != null)
        {
            throw new ElementoException("La pelicula" + c.getTitulo() + "ya existe en el teatro");
        }
    
        peliculas.add(c);
        verificarInvariancia();
    }
    
    /**
     *  Retorna un vector con los nombres de las peliculas del teatro
     * @return vector con los nombres de las peliculas
     */
    public ArrayList getTitulosPeliculas(){
        ArrayList titulosPeliculas = new ArrayList();
        for (int i= 0; i < peliculas.size(); i++)    
        {
            Pelicula p = (Pelicula)peliculas.get(i);
            titulosPeliculas.add(p.getTitulo());
        }
        return titulosPeliculas;
    }

    /**
     * Metodo que retorna el titulo del teatro
     * @return el nombre del teatro
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Retorna la direccion del teatro
     * @return Direccion del teatro
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Retorna el numero de telefono del teatro
     * @return  Numero del telefono del teatro
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Retorna el nombre del archivo que tiene la imagen del teatro
     * @return nombre del archivo que tiene la imagen del disco
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
     * Metodo que indica si el teatro tiene el nombre que llega desde el parametro
     * @param titulo es el nombre de un teatro
     * @return  Verdadero si el tatro tiene un mismo nombre que llega como parametro
     */
    public boolean equal(String nombre){
        return titulo.equalsIgnoreCase(nombre);
    }
    
    /**
     * Verifica que no se admita las variaciones que afectan a otras partes del misma clase.
     * peliculas != null 
     * titulo != null && titulo != "" 
     * direccion != null && direccion != "" 
     * telefono != null && telefono != "" 
     * imagen != null && imagen != "" 
     */
    private void verificarInvariancia(){
        assert peliculas !=null: "La lista de peliculas esta vacia";
        assert titulo != null && !titulo.equals( "" ) : "El titulo es invalido, esta vacio";
        assert direccion != null && !direccion.equals( "" ) : "La direccion es invalida, esta vacio";
        assert telefono != null && !telefono.equals( "" ) : "El telefono es invalido, esta vacio";
        assert imagen != null && !imagen.equals( "" ) : "El nombre del archivo de imagen es erroneo";  
    }

    /**
     * Este metodoo sirve para revisar si hay peliculas repetidas dentro del teatro.
     * @return Retorna true si hay una pelicula que aparece repetida dentro de la lista de peliculas. Retorna false en caso contrario.
     */
    private boolean buscarPeliculasConElMismoNombre( )
    {
        for( int i = 0; i < peliculas.size( ); i++ )
        {
            Pelicula c1 = ( Pelicula )peliculas.get( i );
            for( int j = i + 1; j < peliculas.size( ); j++ )
            {
                Pelicula c2 = ( Pelicula )peliculas.get( j );
                if( c1.equals( c2.getTitulo()) )
                    return true;
            }
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        
//        
//        Teatro t = new Teatro("Cinemark parque Arboleda","Avenida circunvalar","23332322","imageb");
//        Pelicula p = new Pelicula("Capitan america 2","Tras los devastadores acontecimientos ocurridos",
//                                    "Acción","Doblada al español","7 años", 6, 
//                "USA", "Anthony Russo", "3D", "helo", 123);
//        
//        ArrayList a = new ArrayList();
//        t.agregarPelicula(p);
//       
//        
//        
//        System.out.println(t.toString());
//    }
    
    
    
}
