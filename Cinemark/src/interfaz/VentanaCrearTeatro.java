/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class VentanaCrearTeatro extends JDialog {

 
    //es una referencia a la ventana principal de la aplicacion
    private InterfazCinemark principal;
    
    
    //panel que contiene los datos de los teatros
    private PanelCrearTeatro panelDatos;
    
    //panel que contiene los botones
    private PanelBotonesTeatros panelBotones;
    
    
    public VentanaCrearTeatro (InterfazCinemark id){
        super(id, true);
        principal = id;
        
        panelDatos = new PanelCrearTeatro();
        panelBotones = new PanelBotonesTeatros(this);
        
        getContentPane().add(panelDatos,BorderLayout.CENTER);
        getContentPane().add(panelBotones,BorderLayout.SOUTH);
        
        setTitle("Crear una nuevo teatro");
        pack();
        
    }

    
//    ----------------------
//    METODOS
//    ----------------------
   
    public void crearTeatro(){
        
        boolean parametro = true;
        String titulo = panelDatos.getTxtTitulo();
        String direccion = panelDatos.getTxtDireccion();
        String telefono = panelDatos.getTxtTelefono();
        String imagen = panelDatos.getTxtImagen();
        
        if((titulo.equals("") || direccion.equals("")) || (telefono.equals("") || imagen.equals("")) )
        {
        parametro = false;
        JOptionPane.showMessageDialog(this, "Error, todos los datos deben estar llenos para poder crear el teatro");
        }
        if(parametro)
        {
            boolean ok = principal.crearTeatro(titulo, direccion, telefono, imagen);
            if (ok)
            {
                dispose();
            }
        }
     }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
