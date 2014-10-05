/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazCupIphone.java 1086 2010-03-01 21:08:17Z n-calder $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n15_cupIphone
 * Autor: Yeisson Oviedo - 23-feb-2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupIphone.interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.cupIphone.componentes.ProxyAplicacion;
import uniandes.cupi2.cupIphone.componentes.excepciones.EjecucionException;
import uniandes.cupi2.cupIphone.componentes.excepciones.InstalacionException;
import uniandes.cupi2.cupIphone.core.Core;

//Hola mundo!


/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazCupIphone extends JFrame
{
    private static final String ARCHIVO_DATOS = "data/cupiphone.dat";

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

	/**
     * Clase principal del mundo
     */
    private Core core;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelBoton panelBoton;
    
    /**
     * Panel con la imagen del encabezado
     */
    private PanelPantalla panelPantalla;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Descripci�n <br>
     * <b>post: </b> Descripci�n
     */
    public InterfazCupIphone()
    {
    	//Intentar carga informaci�n guardada previamente
    	try{
    		core = (Core) new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS)).readObject();
    	}
    	catch(Exception e){
	        // Crea la clase principal
	        core = new Core();
    	}
        //En cualquier caso, es necesario avisarle al core para
    	//que cargue los jars 
        core.inicializar();
        
        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 382, 752 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        setTitle("CupIphone");
        
        //Creaci�n de los paneles aqu�
        panelPantalla = new PanelPantalla(this);
        add( panelPantalla, BorderLayout.CENTER );
        
        panelBoton = new PanelBoton( this );
        add( panelBoton, BorderLayout.SOUTH );
        
        //Centrar la ventana
        setLocationRelativeTo(null);        
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
    
	/**
	 * Retorna un iterador sobre el listado de aplicaciones instaladas en el core 
	 * @return Las aplicaciones instaladas
	 */
	public Iterador<ProxyAplicacion> darAplicaciones() {
		return core.darAplicaciones();		
	}
    
	
	/**
	 * Permite ejecutar la aplicaci�n indicada
	 * @param idAplicacion ID de la aplicaci�n a ejecutar
	 * @return El panel de la aplicaci�n que se desea ejecutar
	 * @throws EjecucionException 
	 */
	public JPanel ejecutarAplicacion(String idAplicacion) throws EjecucionException {
		return core.ejecutarAplicacion(idAplicacion);
	}
	
    /**
     * Intenta instalar la aplicaci�n indicada por el archivo
     * @param archivoJar Archivo Jar a instalar
     * @return La aplicaci�n instalada
     * @throws InstalacionException 
     */
	public ProxyAplicacion instalarProxyAplicacion(File archivoJar) throws InstalacionException {
		return core.instalarProxyAplicacion(archivoJar);		
	}

	/**
	 * Des instala una aplicaci�n 
	 * @param app Aplicaci�n a instalar
	 * @throws InstalacionException 
	 */
	public void desInstalarProxyAplicacion(ProxyAplicacion app) throws InstalacionException {
		core.eliminarProxyAplicacion(app);
		
	}
    
	/**
     * M�todo para cerrar la aplicaci�n actual y volver al men� principal
     */
    public void mostrarMenuPrincipal( )
    {    	
    	core.terminarAplicacionActual();
        panelPantalla.mostrarMenuPrincipal();
    }

    public void dispose() {
    	super.dispose();
    	panelPantalla.detener();
    	try{
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS));
    		oos.writeObject(core);
    	}
    	catch (IOException e){}
    	    	    	
    }
    
    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {
        InterfazCupIphone interfaz = new InterfazCupIphone();
        interfaz.setVisible( true );
    }

}