package uniandes.cupi2.cupiphone.reloj.mundo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import uniandes.cupi2.cupIphone.core.ICore;
/**
 * Clase Principal del Mundo. Maneja una fecha que se actualiza 
 * en un hilo de ejecuci�n. Tambi�n representa el sujeto observable de la interfaz.
 */
public class Reloj extends Observable
{	
	
	private Date fecha;
	private DateFormat formatoFecha;
	private FechaThread hilo;
	private boolean inicializacionCompleta;
	
	/**
	 * Constructor del Reloj. Por ser una aplicaci�n para cupiphone recibe
	 * la interface del core como par�metro en caso de necesitar localizar
	 * un nuevo componente o el directorio de datos.
	 * @param core
	 */
	public Reloj()
	{
		inicializacionCompleta = false;
		formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		fecha =  new Date();
		hilo = new FechaThread(this);
		hilo.start();
	}

	/**
	 * Actualiza su fecha y notifica a los observadores el cambio
	 * @param actual
	 */
	public void actualizar(long actual)
	{ 
		fecha.setTime(actual);
		if(inicializacionCompleta)
		{
			setChanged();
			notifyObservers(formatoFecha.format(fecha));
		}
	}
	
	public boolean darEstado()
	{
		return inicializacionCompleta;
	}
	
	public void modificarEstado()
	{
		inicializacionCompleta = true;
	}
	
	/**
	 * Termina la ejecuci�n del reloj finalizando el thread.
	 */
	public void terminar()
	{
		hilo.terminar();
	}
}
