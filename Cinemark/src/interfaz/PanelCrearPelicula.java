

package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class PanelCrearPelicula extends JPanel implements ActionListener {

    //constante para el boton explorar y buscar el archivo
    private static final String EXPLORAR = "Explorar";
    
   private JLabel etiquetaTitulo;
   private JLabel etiquetaSipnosis;
   private JLabel etiquetaGenero;
   private JLabel etiquetaIdioma;
   private JLabel etiquetaClasificacion;
   private JLabel etiquetaDuracion;
   private JLabel etiquetaPais;
   private JLabel etiquetaDirector;
   private JLabel etiquetaCalidad;
   private JLabel etiquetaPrecio;
   private JLabel etiquetaImagen;
   
   
   private JTextField txtTitulo;
   private JTextField txtSipnosis;
   private JTextField txtGenero;
   private JTextField txtIdioma;
   private JTextField txtDuracion;
   private JTextField txtPais;
   private JTextField txtDirector;
   private JTextField txtPrecio;
   private JTextField txtImagen;
   
   private JComboBox comboClasificacion;
   private JComboBox comboCalidad;  
   private JButton botonExplorar;
   
   //constate para cambiar el tipo de clasificacion de la pelicula
    private static final String CAMBIAR_CLASIFICACION = "ClasificacionPelicula";
    
    //constate para cambiar el tipo de calidad de la pelicula
    private static final String CAMBIAR_CALIDAD = "ClasificacionPelicula";
   
   public PanelCrearPelicula()
   {
       
        setLayout(new GridLayout(10,2,5,5));
        
        etiquetaTitulo = new JLabel("Titulo");
        etiquetaTitulo.setFont( etiquetaTitulo.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaTitulo);
        txtTitulo = new JTextField(2);
        add(txtTitulo);
        
        
        etiquetaSipnosis = new JLabel("Sipnosis");
        etiquetaSipnosis.setFont( etiquetaSipnosis.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaSipnosis);
        txtSipnosis = new JTextField(2);
        add(txtSipnosis);
        
        
        etiquetaGenero = new JLabel("Genero");
        etiquetaGenero.setFont( etiquetaGenero.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaGenero);
        txtGenero = new JTextField(2);
        add(txtGenero);
        
        
        etiquetaIdioma = new JLabel("Idioma");
        etiquetaIdioma.setFont( etiquetaIdioma.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaIdioma);
        txtIdioma = new JTextField(2);
        add(txtIdioma);
        
        etiquetaClasificacion = new JLabel("Clasificacion");
        String [] seleccionClasificacion={"7 Años","15 Años","Todos"};
        comboClasificacion = new JComboBox(seleccionClasificacion);
        comboClasificacion.addActionListener(this);
        comboClasificacion.setActionCommand(CAMBIAR_CLASIFICACION);
        add(etiquetaClasificacion);
        //add(comboClasificacion,BorderLayout.WEST);
        
        etiquetaDuracion = new JLabel("Duracion");
        etiquetaDuracion.setFont( etiquetaDuracion.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaDuracion);
        txtDuracion = new JTextField(2);
        add(txtDuracion);
        
        etiquetaPais = new JLabel("Pais");
        etiquetaPais.setFont( etiquetaPais.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaPais);
        txtPais = new JTextField(2);
        add(txtPais);
        
        etiquetaDirector = new JLabel("Director");
        etiquetaDirector.setFont( etiquetaDirector.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaDirector);
        txtDirector = new JTextField(2);
        add(txtDirector);
        
        etiquetaCalidad = new JLabel("Calidad");
        String [] seleccionCalidad={"Calidad 3D","Xtreme Definition"};
        comboCalidad = new JComboBox(seleccionCalidad);
        comboCalidad.addActionListener(this);
        comboCalidad.setActionCommand(CAMBIAR_CALIDAD);
        add(etiquetaCalidad);
        //add(comboCalidad,BorderLayout.WEST);
        
        etiquetaPrecio = new JLabel("Precio");
        etiquetaPrecio.setFont( etiquetaPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        add(etiquetaPrecio);
        txtPrecio = new JTextField(2);
        add(txtPrecio);
        
        etiquetaImagen = new JLabel("Imagen:");
        etiquetaImagen.setFont(etiquetaImagen.getFont().deriveFont(Font.PLAIN));
        add(etiquetaImagen);

        txtImagen = new JTextField(10);
        add(txtImagen);

        add( new JLabel( ) );
        botonExplorar = new JButton( "Explorar: " );
        botonExplorar.setActionCommand( EXPLORAR );
        botonExplorar.addActionListener( this );
        add( botonExplorar );
        
   }

    public String getTxtTitulo() {
        return txtTitulo.getText( );
    }

    public String getTxtSipnosis() {
        return txtSipnosis.getText( );
    }

    public String getTxtGenero() {
        return txtGenero.getText( );
    }

    public String getTxtIdioma() {
        return txtIdioma.getText( );
    }

    public String getTxtDuracion() {
        return txtDuracion.getText( );
    }

    public String getTxtPais() {
        return txtPais.getText( );
    }

    public String getTxtDirector() {
        return txtDirector.getText( );
    }

    public String getTxtImagen() {
        return txtImagen.getText( );
    }

    public String getComboClasificacion() {
        return comboClasificacion.getName();
    }

    public String getComboCalidad() {
        return comboCalidad.getName();
    }

    public String getTxtPrecio() {
        return txtPrecio.getText();
    }
    
  
   
   
   
   public void actionPerformed( ActionEvent event )
    {
        String test = event.getActionCommand();
        if (EXPLORAR.equals(test))
        {
            JFileChooser seleccion = new JFileChooser(".data/imagenes");
            seleccion.setDialogTitle("Agregar la imagen de la pelicula");
            int r = seleccion.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION)
            {
                File archivo = seleccion.getSelectedFile();
                //Devuelve la cadena de ruta de acceso absoluto de esta vía de acceso abstracta.
                String stringArchivo = archivo.getAbsolutePath();
                String stringCarpeta = new File("data/imagenes").getAbsolutePath();
                
                //Prueba que si el string seleccionado empieza con el mismo prefijo
                if (stringArchivo.startsWith(stringCarpeta))
                {
                    //Retorna el nombre del archivo del directorio denotado por este nombre
                    txtImagen.setText("data/imagenes" +archivo.getName());
                }
                else
                {
                    //Si no encuentra la ruta entonces salga un mensaje diciendo que la imagen debe estar en la carpeta
                    JOptionPane.showMessageDialog(this, "Error, la imagen debe estar en la carpeta" +stringCarpeta);
                }
            }
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
}
