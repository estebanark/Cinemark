
package interfaz;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class VentanaCrearPelicula extends JDialog {

    private InterfazCinemark principal;
    
    private PanelCrearPelicula panelDatos;
    private PanelBotonesPelicula panelBotones;
    
    public VentanaCrearPelicula(InterfazCinemark id)
    {
        super(id,true);
        principal = id;
        
        panelDatos = new PanelCrearPelicula( );
        panelBotones = new PanelBotonesPelicula( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Pelicula" );
        pack( );
               
    }

    public void crearPelicula()
    {
        boolean parametro = true;
        String titulo = panelDatos.getTxtTitulo();
        String sipnosis = panelDatos.getTxtSipnosis();
        String genero = panelDatos.getTxtGenero();
        String idioma = panelDatos.getTxtIdioma();
        String clasificacion = panelDatos.getComboClasificacion();
        String pais = panelDatos.getTxtPais();
        String director = panelDatos.getTxtDirector();
        String calidad = panelDatos.getComboCalidad();
        String imagen = panelDatos.getTxtImagen();
        
        double precio = 0;
        double duracion = 0;
        
        
        
        if( titulo.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la pelicula " );
        }
        
        if( sipnosis.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar la sipnosis de la pelicula " );
        }
        
        if( genero.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el genero de la pelicula " );
        }
        
        if( idioma.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el idioma de la pelicula " );
        }
        
        if( clasificacion.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar la de la pelicula " );
        }
        
        if( pais.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el pais de la pelicula " );
        }
        
        if( director.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el director de la pelicula " );
        }
        
        if( calidad.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar la de la pelicula " );
        }
        
        if( imagen.equals( "" ) )
        {
            parametro = false;
            JOptionPane.showMessageDialog( this, "Debe selccionar la imagen de caratura de la pelicula " );
        }
        
        try
        {
            duracion = Double.parseDouble(panelDatos.getTxtDuracion());
            if (duracion < 0)
            {
                parametro = false;
                JOptionPane.showMessageDialog(this,"Error, la duracion ingresada no es correcta");
            }
        }
        catch(Exception e)
        {
               parametro = false;
               JOptionPane.showMessageDialog(this, "Error Exception, la duracion ingresada no es correcta");
        }
        
        try
        {
            precio = Double.parseDouble(panelDatos.getTxtPrecio());
            if (precio < 0)
            {
                parametro = false;
                JOptionPane.showMessageDialog(this,"Error, el precio ingresado no es correcto");
            }
        }
        catch(Exception e)
        {
               parametro = false;
               JOptionPane.showMessageDialog(this, "Error Exception, el precio no es valido");
        }
    
        if(parametro)
        {
            boolean ok = principal.crearPelicula(titulo, sipnosis, genero, idioma, clasificacion, duracion, pais, director, calidad, imagen, precio);
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
