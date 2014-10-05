package Mundo;



import java.io.Serializable;

import EstructuraDatos.IListaEncadenadaDoble;
import EstructuraDatos.ListaEncadenadaDoble;


public class Usuario extends Persona implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int CEDULA =1;
	public final static int USER  =2;
	
	public static final int MAYOR = 3;

	public static final int EXACTAMENTE = 4;
	
	private String user;
	
	private String password;
	
	private IListaEncadenadaDoble<Reserva> listaReservas;
	
	private IListaEncadenadaDoble<String> listaPosiciones;
	
	private String posicionActual;
	
	

	private Aplicacion usada;
	
	
	public Usuario(String nUser , String nPass, String nombre, String apellido, String cedula, String email, Aplicacion consultor)
	{
		super(nombre, apellido, cedula, email);
		usada = consultor;
		user =nUser;
		password = nPass;
		listaReservas = new ListaEncadenadaDoble<Reserva>();

	}

	public String darUsuario() 
	{
		return user;
	}

	public String darPassword() 
	{
		return password;
	}


	public void cambiarPassword(String nPass) 
	{
		password = nPass;
	}

	
	public void agregarReserva(Reserva nueva)
	{
		listaReservas.adicionar(nueva, new comparadorFecha());
	}
	
	public void eliminarFavorito( Reserva nueva) throws Exception
	{
		listaReservas.eliminar(nueva, new comparadorFecha());
	}

	public Reserva[]  mostrarTodasReservas()
	{
		Reserva[] resp = new Reserva[listaReservas.darTamano()];
		Reserva ini = listaReservas.volverActualPrimero();
		int indice = 0;
		while(ini!=null)
		{
			resp[indice] = ini;
			indice++;
			ini = listaReservas.adelantarse();
		}
		return resp;
	}
	
	public IListaEncadenadaDoble<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(IListaEncadenadaDoble<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public IListaEncadenadaDoble<String> getListaPosiciones() {
		return listaPosiciones;
	}

	public void setListaPosiciones(IListaEncadenadaDoble<String> listaPosiciones) {
		this.listaPosiciones = listaPosiciones;
	}

	public String getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(String posicionActual) {
		this.posicionActual = posicionActual;
	}

	public Aplicacion getUsada() {
		return usada;
	}

	public void setUsada(Aplicacion usada) {
		this.usada = usada;
	}

}
