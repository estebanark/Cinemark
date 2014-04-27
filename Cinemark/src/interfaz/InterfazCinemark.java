/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import codigo.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author Esteban
 */
public class InterfazCinemark extends JFrame {
    
    private JLabel imagen;

    private static final String RUTA_FACTURAS = "./data/facturas";

    private Cinemark cinemark;

    private Teatro teatroSeleccionado;
   
    private PanelImagen panelImagen;
    
    private PanelTeatros panelTeatros;
    
    private PanelDatosPeliculas panelDatosPeliculas;
    
    
    
    
    
    public InterfazCinemark( Cinemark d )
    {
        cinemark = d;
        // Panel con el logo de cinemark
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );
        
        //panel central que contiene toda la informacion sobre las peliculas, teatros, etc
        JPanel panelCentral = new JPanel( new BorderLayout( ) );
        add(panelCentral, BorderLayout.CENTER);
                
        //agrega el panelTeatro a el panelCentral
        panelTeatros = new PanelTeatros( this, cinemark.getTeatros());
        panelCentral.add( panelTeatros, BorderLayout.CENTER );
        
        panelDatosPeliculas = new PanelDatosPeliculas( this );
        panelCentral.add( panelDatosPeliculas, BorderLayout.EAST );
        
        ArrayList teatros = cinemark.getTeatros();
        if (teatros.size() > 0)
        {
            cambiarTeatroSeleccionado(((String)teatros.get(0)));
        }
         
        setTitle( "Bienvenidos - CINEMARK" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        pack( );
    }

    /**
     * Este metodo cambia el teatro seleccionado en el panel de los detalles del teatro
     * @param nombreTeatro  es el nombre del teatro a la cual se quieren mostrar los detalles
     */
    public void cambiarTeatroSeleccionado(String nombreTeatro){
        teatroSeleccionado = cinemark.getTeatro(nombreTeatro);
        panelTeatros.cambiarTeatro(teatroSeleccionado);
        panelDatosPeliculas.cambiarPelicula(teatroSeleccionado);;
    }
    
    /**
     * Este metodo abre la ventana para agregar una nueva pelicula a la aplicacion
     */
    public void mostrarVentanaAgregarTeatro(){
        
        VentanaCrearTeatro ventana = new VentanaCrearTeatro(this);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }
    
    /**
     * Metodo que abre la ventana para agregar una nueva cancion
     */
    public void mostrarVentanaAgregarPelicula()
    {
        VentanaCrearPelicula ventana = new VentanaCrearPelicula(this);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }
            
    /**
     * Este metodo crea un nuevo teatro en la aplicacion y actualiza el panel con la lista de teatros
     * @param tituloTeatro es el titulo del teatro a crear
     * @param direccion es la direccion del nuevo teatro
     * @param telefono es el telefono del nuevo teatro
     * @param imagen es la imagen del nuevo teatro
     * @return verdadero si la pelicula se pudo agregar, de lo contrario salte una exception
     */
    public boolean crearTeatro(String tituloTeatro,String direccion, String telefono, String imagen ){
        boolean ok = false;
        try
        {
            cinemark.agregarTeatro(tituloTeatro, direccion, telefono, imagen);
            panelTeatros.refrescarTeatros(cinemark.getTeatros());
            ok = true;
        }
        catch(ElementoException e)
        {
            JOptionPane.showMessageDialog(this, "Error (CrearTeatro-InterfazCinemark) "+e.getMessage());
        }
        return ok;
    }
    
    /**
     * Este metodo crea una pelicula en el teatro que se muestra actialmente en los detalles de los teatros en la aplicacion
     * @param titulo Es  titulo de la nueva pelicula
     * @param sipnosis Es la sipnosis de la nueva pelicula
     * @param genero Es genero de la nueva pelicula
     * @param idioma Es el idioma de la nueva pelicula
     * @param clasificacion Es la clasificacion de la nueva pelicula
     * @param duracion Es la duracion de la nueva pelicula
     * @param pais Es el pais  de la nueva pelicula
     * @param director Es el director de la nueva pelicula
     * @param calidad Es la calidad de la nueva pelicula
     * @param imagen Es la imagen  de la nueva pelicula
     * @param precio Es el precio de la nueva pelicula
     * @return  Retorna verdadero si la cancion se puede agregar.
     */
    public boolean crearPelicula(String titulo, String sipnosis, String genero, String idioma, String clasificacion, double duracion, String pais, String director, String calidad, String imagen, double precio)
    {
        boolean ok = false;
        if (teatroSeleccionado != null)
        {
            try
            {
                cinemark.agregarPeliculaATeatro(teatroSeleccionado.getTitulo(),titulo,sipnosis, genero, idioma, clasificacion, duracion, pais, director, calidad, imagen, precio);
                teatroSeleccionado = cinemark.getTeatro(teatroSeleccionado.getTitulo());
                panelTeatros.cambiarTeatro(teatroSeleccionado);
                ok = true;
            }
            catch(ElementoException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return ok;
    }
    /**
     * Este metodo guarda la informacion de la aplicacion, antes de cerrar la aplicacion
     */
    public void dispose()
    {
        try
        {
            cinemark.guardarCinemark();
            super.dispose();
        }
        catch (Exception e)
        {
            setVisible(true);
            int respuesta = JOptionPane.showConfirmDialog( this, "ERROR MUY GRAVE, Existen problemas guardando la informaci�n de la aplicacion:\n" + e.getMessage( ) + "\nQuiere cerrar el programa sin guardar?", "Error", JOptionPane.YES_NO_OPTION );
            if (respuesta == JOptionPane.YES_NO_OPTION)
            {
                super.dispose();
            }
        }
    }
    
    public static void main( String[] args )
    {
        Cinemark cinemark = null;
        try
        {
            cinemark = new Cinemark( "./data/cinemark.discos" );
        }
        catch( PerseveranciaException e )
        {
            e.printStackTrace();
            System.exit( 1 );
        }
        InterfazCinemark iniciar = new InterfazCinemark( cinemark );
        iniciar.setVisible( true );
    }
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelImagen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImagen;
    // End of variables declaration//GEN-END:variables
}
