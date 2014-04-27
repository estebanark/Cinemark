
package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class PanelCrearTeatro extends JPanel implements ActionListener{

    //constante para el boton explorar y buscar el archivo
    private static final String EXPLORAR = "Explorar";
    
    //Etiquetas
    private JLabel etiquetaTitulo;
    private JLabel etiquetaDireccion;
    private JLabel etiquetaTelefono;
    private JLabel etiquetaImagen;
    private JLabel imagenCabecera;
    
    //campos de texto
    private JTextField txtTitulo;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtImagen;

    private JButton botonExplorar;
    /**
     * Este metodo construye en panel donde va la informacion de la ventana que agrega los teatros
     * 
     */
    public PanelCrearTeatro()
    {
        
        setLayout(new GridLayout(5, 2, 5, 5));
        
//        ImageIcon icono = new ImageIcon( "data/cinemark.png" );
//        imagenCabecera = new JLabel( "" );
//        imagenCabecera.setIcon( icono );
//        add( imagenCabecera );
        
        etiquetaTitulo = new JLabel("Titulo:");
        etiquetaTitulo.setFont(etiquetaTitulo.getFont().deriveFont(Font.PLAIN));
        add(etiquetaTitulo);
        
        txtTitulo = new JTextField(2);
        add(txtTitulo);
        
        etiquetaDireccion = new JLabel("Direccion:");
        etiquetaDireccion.setFont(etiquetaDireccion.getFont().deriveFont(Font.PLAIN));
        add(etiquetaDireccion);
        
        txtDireccion = new JTextField(2);
        add(txtDireccion);
        
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaTelefono.setFont(etiquetaTelefono.getFont().deriveFont(Font.PLAIN));
        add(etiquetaTelefono);
        
        txtTelefono = new JTextField(2);
        add(txtTelefono);
        
        etiquetaImagen = new JLabel("Imagen:");
        etiquetaImagen.setFont(etiquetaImagen.getFont().deriveFont(Font.PLAIN));
        add(etiquetaImagen);
        
        txtImagen = new JTextField(2);
        add(txtImagen);
        
        add( new JLabel( ) );
        botonExplorar = new JButton( "Explorar" );
        botonExplorar.setActionCommand( EXPLORAR );
        botonExplorar.addActionListener( this );
        add( botonExplorar );
        
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        
    }
    
    /**
     * Metodo que da el valor del campo de texto del titulo
     * @return el texto con el titulo del teatro
     */
    public String getTxtTitulo() {
        return txtTitulo.getText();
    }

    /**
     * Metodo que da el campo de texto de la direccion de teatro
     * @return El texto de la direccion del teatro
     */
    public String getTxtDireccion() {
        return txtDireccion.getText();
    }

    /**
     * Metodo que retorna el campo de texto del telefono del teatro
     * @return el texto del telefono del teatro
     */
    public String getTxtTelefono() {
        return txtTelefono.getText();
    }

    public String getTxtImagen() {
        return txtImagen.getText();
    }
      
    
    

     public void actionPerformed( ActionEvent event )
    {
        String test = event.getActionCommand();
        if (EXPLORAR.equals(test))
        {
            JFileChooser seleccion = new JFileChooser(".data/imagenes");
            seleccion.setDialogTitle("Agregar la imagen del teatro");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Esteban\\Documents\\NetBeansProjects\\Cinemark\\data\\cinemark.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(259, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
