package Mundo;

import EstructuraDatos.IListaEncadenadaDoble;

public class Hotel 
{
	
	private IListaEncadenadaDoble<Reserva> reservas;
	
	private String nombre;
	
	private String ciudad;
	
	private String estado;
	
	private String codigoPostal;
	
	private String telefono;
	
	private String latitud;
	
	private String longitud;
	
	private int numeroReservas;

	public Hotel(String nombre, String ciudad, String estado,
			String codigoPostal, String telefono, String latitud,
			String longitud, int numeroReservas) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroReservas = numeroReservas;
	}

	public IListaEncadenadaDoble<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(IListaEncadenadaDoble<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public int getNumeroReservas() {
		return numeroReservas;
	}

	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}
	
	

}
