package Mundo;


import java.io.Serializable;

public class Persona implements  Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String nombre;
	
	protected String apellido;
	
	protected String cedula;
	
	protected String email;
	
	public Persona(String nNombre, String nApellido, String nCedula, String nEmail)
	{
		nombre = nNombre;
		apellido = nApellido;
		cedula = nCedula;
		email=nEmail;
	}

	public String darApellido() {
		return apellido;
	}

	public String darNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String darCedula() {
		// TODO Auto-generated method stub
		return cedula;
	}

	public String darEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void cambiarApellido(String nApellido) {
		// TODO Auto-generated method stub
		
	}

	public void cambiarNombre(String nNombre) {
		// TODO Auto-generated method stub
		
	}

	public void cambiarCedula(int nCedula) {
		// TODO Auto-generated method stub
		
	}

	public void cambiarEmail(String nEmail) {
		// TODO Auto-generated method stub
		
	}

	public void recomendarDvd(String pEmail, String pComentario) {
		// TODO Auto-generated method stub
		
	}



}
