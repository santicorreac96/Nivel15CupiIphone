package Mundo;

import java.util.Date;

public class Reserva 
{
	
	private int IDReserva;
	
	private Hotel hotelReserva;
	
	private Date fechaIngreso;
	
	private Date fechaSalida;

	public Reserva(int iDReserva, Hotel hotelReserva, Date fechaIngreso,
			Date fechaSalida) {
		super();
		IDReserva = iDReserva;
		this.hotelReserva = hotelReserva;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public int getIDReserva() {
		return IDReserva;
	}

	public void setIDReserva(int iDReserva) {
		IDReserva = iDReserva;
	}

	public Hotel getHotelReserva() {
		return hotelReserva;
	}

	public void setHotelReserva(Hotel hotelReserva) {
		this.hotelReserva = hotelReserva;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	

}
