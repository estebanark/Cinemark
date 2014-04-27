

package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import codigo.*;
import java.lang.reflect.Array;
import javax.swing.JTextArea;
import javax.swing.border.Border;
 


public class PanelDatosPeliculas extends JPanel implements ActionListener
{
    //Constante para el bomboBox para cambiar la pelicula
    private static final String CAMBIAR_PELICULA = "CambiarPelicula";
    
    //constante para el boton para agregar una nueva pelicula
    private static final String AGREGAR_PELICULA = "AgregaPelicula";
    
    //constate para el boton de vender la pelicula
    private static final String VENDER_PELICULA = "VenderPelicula";
    
    //constate para cambiar el tipo de clasificacion de la pelicula
    private static final String CAMBIAR_CLASIFICACION = "ClasificacionPelicula";
    
    //constate para cambiar el tipo de calidad de la pelicula
    private static final String CAMBIAR_CALIDAD = "ClasificacionPelicula";
    
    
    
    
//    ---------------------------
//    ATRIBUTOS
//    ---------------------------
    
    //referencia a la clase principal de la aplicacion cinmark
    private InterfazCinemark principal;
    
    //referencia a la clase teatros
    private Teatro teatro;
    
    //referencia a la clase peliculas
    private Pelicula pelicula;
    
    //INTERFAZ
    
    private JComboBox comboPeliculas;
    private JComboBox comboClasificacion;
    private JComboBox comboCalidad;
    
    
    private JLabel etiquetaTitulo;
    private JLabel etiquetaSipnosis;
    private JLabel etiquetaGenero;
    private JLabel etiquetaIdioma;
    private JLabel etiquetaClasificacion;
    private JLabel etiquetaDuracion;
    private JLabel etiquetaPais;
    private JLabel etiquetaDirector;
    private JLabel etiquetaCalidad;
    private JLabel etiquetaImagen;
    private JLabel etiquetaPrecio;
    
    private JTextField txtTitulo;
    private JTextField txtSipnosis;
    private JTextField txtGenero;
    private JTextField txtIdioma;
    private JTextField txtDuracion;
    private JTextField txtPais;
    private JTextField txtDirector;
    private JTextField txtPrecio;
    
    private JButton botonAgregarPelicula;
    private JButton botonVenderPelicula;
    

    
    public PanelDatosPeliculas(InterfazCinemark ventanaPrincipal) {
    principal = ventanaPrincipal;
    setLayout(new BorderLayout());
    
    setBorder( new CompoundBorder( new EmptyBorder( 11, 11, 11, 11 ), new TitledBorder( "Peliculas" ) ) );
    
    comboPeliculas = new JComboBox();
    comboPeliculas.setEditable(false);
    comboPeliculas.addActionListener(this);
    comboPeliculas.setActionCommand(CAMBIAR_PELICULA);
    add(comboPeliculas,BorderLayout.NORTH);
    
    JPanel panelDatos = new JPanel(new GridLayout(10,2));
    
    etiquetaTitulo = new JLabel("Titulo");
    txtTitulo = new JTextField(7);
    txtTitulo.setEditable(false);
    txtTitulo.setFont( txtTitulo.getFont( ).deriveFont( Font.PLAIN ) );
    Border borde = txtTitulo.getBorder( );
    txtTitulo.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaTitulo );
    panelDatos.add( txtTitulo );
    
    etiquetaSipnosis = new JLabel("Sipnosis");
    txtSipnosis = new JTextField(7);
    txtSipnosis.setEditable(false);
    txtSipnosis.setFont( txtSipnosis.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtSipnosis.getBorder();
    txtSipnosis.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaSipnosis );
    panelDatos.add( txtSipnosis );
    
    etiquetaGenero = new JLabel("Genero");
    txtGenero = new JTextField(7);
    txtGenero.setEditable(false);
    txtGenero.setFont( txtGenero.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtGenero.getBorder();
    txtGenero.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaGenero );
    panelDatos.add( txtGenero );
    
    etiquetaIdioma = new JLabel("Idioma");
    txtIdioma = new JTextField(7);
    txtIdioma.setEditable(false);
    txtIdioma.setFont( txtIdioma.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtIdioma.getBorder();
    txtIdioma.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaIdioma );
    panelDatos.add( txtIdioma );
    
    etiquetaClasificacion = new JLabel("Clasificacion");
    String [] seleccionClasificacion={"7 Años","15 Años","Todos"};
    comboClasificacion = new JComboBox(seleccionClasificacion);
    comboClasificacion.setEditable(false);
    comboClasificacion.addActionListener(this);
    comboClasificacion.setActionCommand(CAMBIAR_CLASIFICACION);
    panelDatos.add(etiquetaClasificacion);
    panelDatos.add(comboClasificacion,BorderLayout.WEST);
    
    etiquetaDuracion = new JLabel("Duracion");
    txtDuracion = new JTextField(7);
    txtDuracion.setEditable(false);
    txtDuracion.setFont( txtDuracion.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtDuracion.getBorder();
    txtDuracion.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaDuracion );
    panelDatos.add( txtDuracion );
    
    etiquetaPais = new JLabel("Pais");
    txtPais = new JTextField(7);
    txtPais.setEditable(false);
    txtPais.setFont( txtPais.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtPais.getBorder();
    txtPais.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaPais );
    panelDatos.add( txtPais );
    
    etiquetaDirector = new JLabel("Director");
    txtDirector = new JTextField(7);
    txtDirector.setEditable(false);
    txtDirector.setFont( txtDirector.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtDirector.getBorder();
    txtDirector.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaDirector );
    panelDatos.add( txtDirector );
    
    
    etiquetaCalidad = new JLabel("Calidad");
    String [] seleccionCalidad={"Calidad 3D","Xtreme Definition"};
    comboCalidad = new JComboBox(seleccionCalidad);
    comboCalidad.setEditable(false);
    comboCalidad.addActionListener(this);
    comboCalidad.setActionCommand(CAMBIAR_CALIDAD);
    panelDatos.add(etiquetaCalidad);
    panelDatos.add(comboCalidad,BorderLayout.WEST);
    
    etiquetaPrecio = new JLabel( "Precio: " );
    txtPrecio = new JTextField( 7 );
    txtPrecio.setEditable( false );
    txtPrecio.setFont( txtPrecio.getFont( ).deriveFont( Font.PLAIN ) );
    borde = txtPrecio.getBorder();
    txtPrecio.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
    panelDatos.add( etiquetaPrecio );
    panelDatos.add( txtPrecio );
    
    etiquetaImagen = new JLabel( );
    etiquetaImagen.setPreferredSize( new Dimension( 200, 200 ) );
    etiquetaImagen.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
    add( etiquetaImagen, BorderLayout.LINE_START );

    add(panelDatos,BorderLayout.CENTER);
    
    JPanel panelBotones = new JPanel(new BorderLayout());
    
    botonAgregarPelicula = new JButton("Agregar Pelicula");
    botonAgregarPelicula.setActionCommand(AGREGAR_PELICULA);
    botonAgregarPelicula.addActionListener(this);
    botonAgregarPelicula.setEnabled(false);
    panelBotones.add(botonAgregarPelicula, BorderLayout.NORTH);
    
    botonVenderPelicula = new JButton("Vender Pelicula");
    botonVenderPelicula.setActionCommand(VENDER_PELICULA);
    botonVenderPelicula.addActionListener(this);
    botonVenderPelicula.setEnabled(false);
    panelBotones.add(botonVenderPelicula, BorderLayout.SOUTH);
    
    add(panelBotones,BorderLayout.SOUTH);
     
    }

  
//    -------------------------------
//    METODOS
//    --------------------------------
    /**
     * Este metodo cambia el teatro que se muestran las peliculas en el panel y se actualiza
     * @param t es el teatro en el que se quiere nmostrar las imagenes
     */
    public void cambiarPelicula(Teatro t){
        if(t != null)
        {
            teatro = t;
            botonAgregarPelicula.setEnabled(true);
            
            comboPeliculas.removeAllItems();
            ArrayList peliculas = teatro.getTitulosPeliculas();
            for(int i = 0; i < peliculas.size(); i++)
            {
                comboPeliculas.addItem(peliculas.get(i));
            }
            
            if (peliculas.size() > 0)
            {
                botonVenderPelicula.setEnabled(true);
            }
            else
            {
                botonVenderPelicula.setEnabled(false);
            }
            
        }
        
    }
    
    private void refrescarPeliculas(){
        comboPeliculas.removeAllItems();
        ArrayList peliculas = teatro.getTitulosPeliculas();
        for(int i = 0 ; i < peliculas.size() ; i++)
        {
            comboPeliculas.addItem(peliculas.get(i));
        }
        if (peliculas.size() > 0)
        {
            comboPeliculas.setEnabled(true);
        }
        else
        {
            botonVenderPelicula.setEnabled(false);
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
    public void actionPerformed(ActionEvent e) {
        String test = e.getActionCommand();
        if (CAMBIAR_PELICULA.equals(test))
        {
            String nombrePelicula =(String)comboPeliculas.getSelectedItem();
           
            if(nombrePelicula != null)
            {
                pelicula = teatro.getPelicula(nombrePelicula);
                txtTitulo.setText(pelicula.getTitulo());
                txtSipnosis.setText(pelicula.getSipnosis());
                txtGenero.setText(pelicula.getGenero());
                txtIdioma.setText(pelicula.getIdioma());
                txtDuracion.setText(Double.toString(pelicula.getDuracion()));
                txtPais.setText(pelicula.getPais());
                txtDirector.setText(pelicula.getDirector());
                txtPrecio.setText(Double.toString(pelicula.getPrecio()));
            }
            else
            {
                txtTitulo.setText( "" );
                txtSipnosis.setText( "" );
                txtGenero.setText( "" );
                txtIdioma.setText( "" );
                txtDuracion.setText( "" );
                txtPais.setText( "" );
                txtDirector.setText( "" );
                txtPrecio.setText( "" );
            }
        }
        else if (AGREGAR_PELICULA.equals(test))
        {
            principal.mostrarVentanaAgregarPelicula();
            refrescarPeliculas();
        }
        else if(VENDER_PELICULA.equals(test))
        {
            //principal.venderPelicula(teatro,pelicula); //?
            
        }
    }//final action performed
}
