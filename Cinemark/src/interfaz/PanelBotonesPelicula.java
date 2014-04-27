

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesPelicula extends JPanel implements ActionListener {

    //constante para el boton de crear la pelicula
    private static final String CREAR_PELICULA = "Crearpelicula";
    //constante para el boton de cancelar 
    private static final String CANCELAR = "Cancelar";
    
    private VentanaCrearPelicula ventana;
    
    private JButton botonAgregarPelicula;
    private JButton botonCancelar;
    
    
    public PanelBotonesPelicula(VentanaCrearPelicula vcp)
    {
        ventana = vcp;
        botonAgregarPelicula = new JButton( "Crear" );
        botonAgregarPelicula.setActionCommand( CREAR_PELICULA );
        botonAgregarPelicula.addActionListener( this );
        add( botonAgregarPelicula );
        
        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );
    }
  
    public void actionPerformed( ActionEvent event )
    {
        String test = event.getActionCommand( );

        if( CREAR_PELICULA.equals( test ) )
        {
            ventana.crearPelicula( );
        }
        else if( CANCELAR.equals( test ) )
        {
            ventana.dispose();
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
