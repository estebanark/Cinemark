/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

public class PanelTeatros extends JPanel implements ActionListener
{

    

    //constante para el combobox de los titulos de los teatros
    private static final String CAMBIAR_TEATRO = "CambiarDisco";

    //constante para el boton de agregar un nuevo teatro
    private static final String AGREGAR_TEATRO = "AgregarDisco";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    //Es una referencia a la clase interfaz
    private InterfazCinemark principal;

    //teatros que actualmente se presenta en el panel de los teatros
    private Teatro teatro;

    /**
     * ATRIBUTOS DE LA INTERFAZ
     */
    
    //combobox que maneja los teatros
    private JComboBox comboTeatros;

    
    private JLabel etiquetaInformacion;
    private JLabel etiquetaDireccion;
    private JLabel etiquetaTelefono;
    
    private JTextField txtInformacion;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    
    private JButton botonAgregarTeatro;
    
    private JLabel etiquetaImagen;
    
    
    public PanelTeatros(InterfazCinemark ventanaPrincipal, ArrayList teatros){
        principal=ventanaPrincipal;
        
        //creando el diseño
        setLayout(new BorderLayout());
        
        //Agregando el bombobox de que despliega los teatros
        
        comboTeatros = new JComboBox (teatros.toArray());
        comboTeatros.setEditable(false);
        comboTeatros.addActionListener(this);
        comboTeatros.setActionCommand(CAMBIAR_TEATRO);
        add(comboTeatros, BorderLayout.NORTH);
        
        JPanel panelDatosTeatros = new JPanel( );
        add( panelDatosTeatros, BorderLayout.CENTER );

        panelDatosTeatros.setLayout( new GridLayout( 6, 1, 0, 5 ) );
        
        // agregando un nuevo panel para cargar toda la informacion
        
               
        //agregando la etiqueta de direccion
        etiquetaDireccion = new JLabel("Direccion");
        txtDireccion = new JTextField (10);
        txtDireccion.setEditable(false);
        txtDireccion.setFont( txtDireccion.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosTeatros.add(etiquetaDireccion);
        panelDatosTeatros.add(txtDireccion);
        
        //agregando la etiqueta de telefono
        etiquetaTelefono = new JLabel("Telefono");
        txtTelefono = new JTextField (10);
        txtTelefono.setEditable(false);
        txtTelefono.setFont( txtTelefono.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosTeatros.add(etiquetaTelefono);
        panelDatosTeatros.add(txtTelefono);
        
        panelDatosTeatros.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        
        //agregando la etiqueta de la imagen 
        etiquetaImagen = new JLabel();
        etiquetaImagen.setPreferredSize(new Dimension(274,144));
        etiquetaImagen.setBorder(new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ));
        add( etiquetaImagen, BorderLayout.BEFORE_LINE_BEGINS );
        
        botonAgregarTeatro = new JButton( "Agregar Teatro" );
        botonAgregarTeatro.setActionCommand( AGREGAR_TEATRO );
        botonAgregarTeatro.addActionListener( this );
        add( botonAgregarTeatro, BorderLayout.SOUTH );
        
        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Teatros" ) ) );
  
    }
    
//        ---------------------------------
//        Metodos
//        ---------------------------------
        
    /**
     * Este metodo sirve para cambiar los teatros que se muestran en el menu
     * @param t es el nuevo disco a mostrar en el menu
     */
        public void cambiarTeatro(Teatro t){
        teatro = t;
        if( teatro != null )
        {
            etiquetaImagen.setIcon( new ImageIcon( teatro.getImagen() ) );
            txtDireccion.setText( teatro.getDireccion());
            txtTelefono.setText( teatro.getTelefono());
        }
        else
        {
            setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Detalles del Teatro" ) ) );
        }
    }
        
        /**
         * Este metodo actualiza la informacion de los teatros
         * @param teatros es la lista de teatros que se dspliegga
         */
        public void refrescarTeatros(ArrayList teatros){
           comboTeatros.removeAllItems();
           for(int i = 0; i < teatros.size(); i++){
               comboTeatros.addItem(teatros.get(i));
            }
        }
        
        public void actionPerformed( ActionEvent event )
        {
            String test = event.getActionCommand( );
            
            if (AGREGAR_TEATRO.equals(test))
            {
                principal.mostrarVentanaAgregarTeatro(); 
            }
            else if (CAMBIAR_TEATRO.equals( test ))
            {
                String nombreTeatro = (String)comboTeatros.getSelectedItem();
                principal.cambiarTeatroSeleccionado(nombreTeatro); 
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
