package uniandes.cupi2.cupiphone.reloj.app;

import javax.swing.JPanel;

import uniandes.cupi2.cupiphone.reloj.interfaz.ComponenteRelojPanel;
import uniandes.cupi2.cupiphone.reloj.mundo.Reloj;
import uniandes.cupi2.cupIphone.componentes.IAplicacion;
import uniandes.cupi2.cupIphone.core.ICore;

/**
 * Aplicaci�n para el manejo de contactos del CupiPhone <br>
 * Esta aplicaci�n esta compuesta por un panel principal y el modelo del mundo.
 */
public class ComponenteRelojAplicacion implements IAplicacion {
	 
	
	/**
	 * Referencia al core del cupiPhone, para localizar otros componentes y acceder al directorio de datos
	 */
	private ICore core;
	
	
	/**
	 * Panel principal del componente
	 */
	private ComponenteRelojPanel panel;
	
	
	/**
	 * Clase principal del mundo del componente
	 */
	private Reloj mundo;
	
	/**
	 * Esta aplicaci�n se implementa como un singleton
	 */
	private static ComponenteRelojAplicacion instancia;
	
	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darPanelPrincipal()
	 */
	public JPanel darPanelPrincipal() {
		return panel;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#terminarEjecucion()
	 */
	public void terminarEjecucion() {
		panel.terminar();
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darInstanciaModelo()
	 */
	public Object darInstanciaModelo() {
		return mundo;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#cambiarCore(uniandes.cupi2.cupIphone.core.ICore)
	 */
	public void cambiarCore(ICore c) {
		core = c;
		
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#iniciarEjecucion()
	 */
	public void iniciarEjecucion() {
	    mundo = new Reloj(core);
		panel = new ComponenteRelojPanel(mundo);
	}

	/**
	 * M�todo necesario para interactuar con el core
	 * del tel�fono
	 * @return La instancia de la clase
	 */
	public static IAplicacion darInstancia()
	{
		return instancia!=null? instancia: new ComponenteRelojAplicacion();
	}
}
