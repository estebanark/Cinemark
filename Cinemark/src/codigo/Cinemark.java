/***************************************************************
 * 
 *  Proyecto Cinemark - Programación 4
 * 
 * Autor : Elvis Esteban Aragón Castaño
 * Código: 1115077569
 * Universidad Tecnológica de Pereira
 **************************************************************/

package codigo;

import java.io.*;
import static java.lang.System.out;
import java.text.*;
import java.util.*;

/**
 *
 * @author Esteban
 */
public class Cinemark {
    
    //*******************************
    //Atributos
    //*******************************
    
    //La lista de teatros de la aplicacion cinemark
    private ArrayList teatros;
    
    //El nombre del archivo donde se guardan las peliculas
    
    private String archivoCinemark;
    
    /**
     * Se contruye la aplicacion
     * Si el archivo exist entonces la aplicacion se crea vacia y su estado u objeto se guarda en el archivo
     * si el archivo no existe entonces se saca la informacion de los teatros y las peliculas
     * @param nombreArchivoCinemark es e nombre del archivo que tiene los datos de la aplicacion - nombreArchivoCinemark != null
     * @throws FileNotFoundException se lanza excepcion si hay algún problema
     * @throws IOException 
     */
    public Cinemark(String nombreArchivoCinemark) throws  PerseveranciaException{
        archivoCinemark = nombreArchivoCinemark;
        File archivo = new File(archivoCinemark);
        
        if( archivo.exists( ) )
        {
            // El archivo existe: se debe recuperar de all� el estado del modelo del mundo
            try
            {
                ObjectInputStream objeto = new ObjectInputStream( new FileInputStream( archivo ) );
                teatros = ( ArrayList )objeto.readObject( );
                objeto.close( );
            }
            catch( Exception e )
            {
                // Se atrapan en este bloque todos los tipos de excepci�n
                throw new PerseveranciaException( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")" );
            }
        }
        else
        {
            // El archivo no existe: es la primera vez que se ejecuta el programa
            teatros = new ArrayList( );
        }
        
        verificarInvariancia();
  
    }
    
    //------------------------------
    // Metodos
    //------------------------------
    
    /**
     * Este metodo retorna un teatro de la aplicacion dado un nombre asignado
     * @param tituloTeatro es el nombre del teatro que se va a buscar - tituloTeatro != null
     * @return el titulo donde el nombre es igual al nombre que se va a dar , si no encuentra nada retorne null
     */
    public Teatro getTeatro(String tituloTeatro){
        for( int i = 0; i < teatros.size( ); i++ )
        {
            Teatro d = ( Teatro )teatros.get( i );
            if( d.equals( tituloTeatro ) )
                return d;
        }
        return null;
    }
    
    /**
     * Este metodo retorna un teatro a la aplicacion cinemark dado un nombre, una direccion y una pelicula
     * @param nombreTeatro Es el nombre del teatro donde debería de estar la cancion - nombreTeatro != null
     * @param nombreDireccion Es la direccion del teatro -  nombreDireccion != null
     * @param nombrePelicula Es el nombre de la pelicula que se quiere buscar - nombrePelicula != null
     * @return Retorna el teatro en el que se encuentre la canción buscada, si no la encuentra entonces retorne null
     */
    private Teatro getTeatro(String nombreTeatro, String nombreDireccion, String nombrePelicula){
        Teatro teatroBuscado = getTeatro( nombreTeatro );
        if (teatroBuscado != null && teatroBuscado.getDireccion().equalsIgnoreCase(nombreDireccion))
            return(teatroBuscado.getPelicula(nombrePelicula) != null) ? teatroBuscado : null;
        else
            return null;
    }
    
    /**
     * Este metodo agrega un nuevo teatro a la aplicacion cinemark
     * @param tituloCinemark es el titulo del tratro - tituloCinemark != null
     * @param direccionCinemark es la direccion del teatro - direccionCinemark != null
     * @param telefonoCinemark es el telefono del teatro - telefonoCinemark != null
     * @param imagenCinemark  es el nombre del archivo de la caratula del teatro != null
     */
    public void agregarTeatro(String tituloT, String direccionT, String telefonoT, String imagenT) throws ElementoException
    {
        if( getTeatro (tituloT) != null )
        {
            throw new ElementoException("El teatro" + tituloT + "ya existe en la aplicacion Cinemark");
        }
        
        teatros.add(new Teatro(tituloT,direccionT,telefonoT,imagenT));
        verificarInvariancia();        
    }
    
    /**
     * Agrega una nueva pelicula al teatro
     * @param nombreTeatro es el nombre del trato para adicionar la pelicula -  hay un teatro con ese nombre en la aplicacion cinemark
     * @param tituloP es el titulo de la pelicula - tituloP =! null
     * @param sipnosisP es la sipnosis de la pelicula - sipnosis =! null
     * @param generoP es el genero de la pelicula  - generoP =! null
     * @param idiomaP es el idioma de la pelicula - idiomaP =! null
     * @param clasificacionP es la clasificacion de la pelicula claisificacionP =! null
     * @param duracionP es la duracion de la pelicula - duracionP > 0
     * @param paisP es el pais de la pelicula - paisP =! null
     * @param directorP es el director de la pelicula - directorP =! null
     * @param calidadP es la calidad de la pelicula - calidadP =! null
     * @param imagenP es el nombre del archivo de la caratula de la pelicula - imagenP =! null
     * @param precio es el el precio que tiene la pelicula - precio > 0
     */
    public void agregarPeliculaATeatro(String nombreTeatro, String tituloP, String sipnosisP, String generoP, String idiomaP, String clasificacionP, double duracionP, String paisP, String directorP, String calidadP, String imagenP, double precioP) throws ElementoException {
        Teatro t = getTeatro(nombreTeatro);
        t.agregarPelicula(new Pelicula( tituloP,  sipnosisP,  generoP, idiomaP, clasificacionP, duracionP, paisP, directorP, calidadP, imagenP, precioP));
        verificarInvariancia();
    }
    
    /**
     * Registra la venta de una pelicula y genera una factura en un nuevo archivo
     * @param teatro Es el nombre del teatro a la cual pertenece la pelicula que se quiere vender - teatro != null
     * @param pelicula Es la pelicula la cual se quiere vender - pelicula != null
     * @param email Es el email de la persona a la que se le vendio la pelicula != null
     * @param Tiquete Es el numero del tiquete que se quiere vender tiquete != null 
     * @param rutaFactura Es el directorio donde se debe generar la factura - rutaFactura != null
     * @return Retorna el nombre del archivo que genero la factura
     * @throws IOException Genera una exception si hay problemas en el archivo
     */
    public String venderPelicula(Teatro teatro, Pelicula pelicula, String email, String Tiquete, String rutaFactura) throws IOException{
        
        //Generamos el nombre aleatorio para la factura.
        String tiquete = Tiquete.toString();
        
        int posArroba = email.indexOf("@");
        String login = email.substring(0, posArroba);
        String tiempo = Long.toString(System.currentTimeMillis());
        String nombreArchivo = login + "_" + tiempo + ".fac";
        
        //Guardamos el archivo en la factura
        File dirFactura = new File (rutaFactura);
        if (!dirFactura.exists())//Creates the directory named by this abstract pathname, including any necessary but nonexistent parent directories. Note that if this operation fails it may have succeeded in creating some of the necessary parent directories.
            dirFactura.mkdirs();
        File archivoFactura = new File (dirFactura, nombreArchivo); 
        PrintWriter salida = new PrintWriter(archivoFactura);
        Date fecha = new Date();
        salida.println("--------------- BIENVENIDO A CINEMARK----------------\n");
        salida.println("Esta es la factura generada:");
        salida.println("Fecha de creacion:      " +fecha.toString());
        salida.println("Tiquete:      " +tiquete.toString()); //?
        salida.println("Email:                  " + email);
        salida.println("Pelicula:               " + pelicula.getTitulo());
        salida.println("Clasificacion:               " + pelicula.getClasificacion());
        salida.println("Genero:               " + pelicula.getGenero());
        salida.println("Precio:               " + pelicula.getPrecio());
        salida.close();
        return nombreArchivo;
    }
    
//    
//    public String venderListaPeliculas( File archivoPedido, String rutaFactura ) throws FileNotFoundException, IOException, Exception
//    {
//        //abriendo el archivo con el pedido , si no existe entonces el constructor de flujo 
//        //lanza una exception filenotexception
//       
//        BufferedReader cabezalectora = new BufferedReader(new FileReader(archivoPedido));
//        String email = null;
//        String tiquete = null;
//        try {
//            //leemos la primera linea del archivo (el correo) y quita espacios
//            email = cabezalectora.readLine();
//            //lo mismo con tiquete
//            tiquete = cabezalectora.readLine();
//            
//        }
//        catch( IOException e ){
//            throw new IOException ("Hubo un error leyendo la primera linea de codigo"+e.getMessage());
//        }
//        //verificando parametros iniciales
//        if (email == null)
//            throw new Exception("El archivo esta vacio");
//        if (tiquete == null)
//            throw new Exception("El tiquete está vacio");
//        if (!validarEmail(email))
//            throw new Exception("El email que se indico no es valido");
//        
//        String pedido = null;
//        try{
//            //tratamos de leer el archivo de la primera pelicula que se quiere vender
//            pedido = cabezalectora.readLine();
//        }
//        catch(IOException e){
//            throw new Exception("Error tratando de leer la primera pelicula"+e.getMessage());
//        }
//        
//        if (pedido == null)
//            throw new Exception( "Debe haber por lo menos una pelicula en el pedido");
//        
//        //Se inicializa las estructuras de los datos necesarios para poder generar la factura
//        ArrayList teatrosFactura = new ArrayList();
//        ArrayList peliculasFactura = new ArrayList();
//        ArrayList peliculasNoEncontradas = new ArrayList();
//        //usando el patron de recorrido para los archivos secuencuales
//        while (pedido != null){
//            int p1=pedido.indexOf("")
//            
//        }
//                
//    }
    
       
    /**
     * Retorna el vector con los nombres de los teatros
     * @return Vector con los nombres de los teatros
     */
    public ArrayList getTeatros(){
        ArrayList nombresTeatros = new ArrayList();
        for(int i = 0; i < teatros.size(); i++){
            Teatro t = (Teatro)teatros.get(i);
            nombresTeatros.add(t.getTitulo());
        }
        return nombresTeatros;
    }
       
    
    /**
     *  Este metodo genera la factura de la venta de los teatros, en un nuevo archivo
     * @param teatros son los teatros a los que pertenecen las peliculas- teatros != null
     * @param peliculas son las peliculas que se van a vender - peliculas != null
     * @param noEncontradas es un vector con las lineas de codigo que no se procesadorn porque la pelicula no existe
     * @param email es el email de la persona a la cual se le vendio email != null
     * @param rutaFactura es el directorio donde se va a guardar la factura != null
     * @return Retorna el nombre del archivo en el que se genero la factura 
     * @throws IOException exception que se genera si hay probmeas guardando el archivo
     */
    private String generarFactura( ArrayList teatros, ArrayList peliculas, ArrayList noEncontradas, String email, String rutaFactura ) throws IOException{
    //generando un nombre aleatoreo para la factura
        int posArroba = email.indexOf( "@" );
        String login = email.substring( 0, posArroba );
        String tiempo = Long.toString( System.currentTimeMillis( ) );
        String nombreArchivo = login + "_" + tiempo + ".fac";
    //guardando el archivo en la factura
        File dirFacturas = new File( rutaFactura );
        if( !dirFacturas.exists( ) )
            dirFacturas.mkdirs( );
        
        File archivoFactura = new File(dirFacturas,nombreArchivo);
        PrintWriter salida = new PrintWriter( archivoFactura );
        Date fecha = new Date();
        salida.println("--------------- BIENVENIDO A CINEMARK----------------\n");
        salida.println("Esta es la factura generada:");
        salida.println("Fecha de creacion:      " +fecha.toString());
        salida.println("Email:                  " + email);
        
        for (int i = 0 ; i < teatros.size(); i++){
            Teatro t = (Teatro)teatros.get(i);
            Pelicula p = (Pelicula)peliculas.get(i);
            salida.println("Pelicula:             " + p.getTitulo());
            salida.println("Genero:               " + p.getGenero());
            salida.println("Idioma:               " + p.getIdioma());
            salida.println("Duracion:             " + p.getDuracion());
            salida.println("Pais:                 " + p.getPais());
            salida.println("Director:             " + p.getDirector());
            salida.println("Precio:               " + p.getPrecio());
        }
        
        //metiendo las peliculas que no van
        if (noEncontradas.size() > 0)
        {
            salida.println("peliculas no encontradas");
            for( int i = 0; i < noEncontradas.size( ); i++ )
            {
                salida.println( noEncontradas.get( i ) );
            }
        }
        salida.close( );

        return nombreArchivo;
        }
     
    
    
    /**
     * Este metodo indica si el correo cumple con un formato esperado
     * el formato tiene que ser usuario@correo.etc
     * Este correo tiene que estar unido por lo menos con dos partes separadas por un punto parte1.parte2
     * @param email Es la direccion del correo que se quiere verificar - eamil != null
     * @return Retorna verdadero si el email cumplio con las espeficicaciones dadas.
     */
    public boolean validarEmail( String email )
    {
        boolean resultado = true;
        int posArroba = email.indexOf( "@" );
        if( posArroba == -1 )
        {
            resultado = false;
        }
        else
        {
            String correo= email.substring( posArroba + 1 );
            resultado = correo.indexOf( "." ) != -1 && ! ( correo.substring( correo.indexOf( "." ) + 1 ).equals( "" ) );
        }
        return resultado;
    }
    
    /**
     * Es el que guarda el archivo de la aplicacion en un archivo binario
     * @throws Exception Genera un exception si hay problemas al guardar el archivo
     */
    public void guardarCinemark() throws PerseveranciaException{
        
        try
        {
            ObjectOutputStream objeto = new ObjectOutputStream(new FileOutputStream(archivoCinemark));
            objeto.writeObject(teatros);
            objeto.close();
        }
        catch(IOException e){
            throw new PerseveranciaException("Error al guardar el archivo" + e.getMessage());
            
        }
    }
    
    
    
    private void verificarInvariancia(){
        assert teatros != null : "la lista de teatros está vacia";
    }

   
//    public static void main(String[] args) {
//        
//        String titulot= "prueba";
//        ArrayList a = new ArrayList();
//        Teatro t = new Teatro(titulot,"Avenida circunvalar","23332322","imageb");
//        Pelicula p = new Pelicula("Capitan","Tras los devastadores acontecimientos ocurridos",
//                                    "Acción","Doblada al español","7 años", 6, 
//                "USA", "Anthony Russo", "3D", "helo");
//       
//        
//        
//        
//        
//        System.out.println(t.toString());
//    }
//    
    
    
}



