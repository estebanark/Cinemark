

package interfaz;

import codigo.Cinemark;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesTeatros extends JPanel implements ActionListener{
    
    //constante para el boton de crear teatro
    private static final String CREAR_PELICULA = "CrearPelicula";
    
    //constante para el boton de cancelar
    private static final String CANCELAR = "Cancelar";
    
    //referencia a la ventana para crear una pelicula
    private VentanaCrearTeatro ventana;
    
    //botones
    private JButton botonAceptar;
    private JButton botonCancelar;
    
    /**
     * Este metodo contruye los botones que estan pegado en la ventana de donde se agregan los teatros
     * @param vct es una referencia a la ventana que va a contener este panel
     */
    public PanelBotonesTeatros (VentanaCrearTeatro vct)
    {
        ventana = vct;
        
        botonAceptar = new JButton("Agregar Teatro");
        botonAceptar.setActionCommand(CREAR_PELICULA);
        botonAceptar.addActionListener(this);
        add(botonAceptar);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setActionCommand(CANCELAR);
        botonCancelar.addActionListener(this);
        add(botonCancelar);
        
        
        
        
    }
    
    public void actionPerformed (ActionEvent event)
    {
        String test = event.getActionCommand();
        
        if (CREAR_PELICULA.equals(test))
        {
            ventana.crearTeatro();
        }
        else if (CANCELAR.equals(test))
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
