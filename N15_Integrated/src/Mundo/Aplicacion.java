package Mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import EstructuraDatos.ArbolAVL;
import EstructuraDatos.IListaEncadenadaDoble;
import EstructuraDatos.ListaEncadenadaDoble;
import javafx.embed.swing.JFXPanel;
import uniandes.cupi2.cupIphone.core.Core;
import uniandes.cupi2.cupIphone.core.ICore;

public class Aplicacion 
{
	
	private ArrayList listaPrueba;
	
	private JFXPanel pane;
	
	private ICore core;
	
	private Usuario usuarioSesion;
	
	private IListaEncadenadaDoble<Usuario> listaRegistrados;
	
	private ArbolAVL<Hotel> hoteles;
	
	public static DataConnection baseDatos = DataConnection.getInstance();

	public Aplicacion(ICore pCore)
	{
		core = pCore;
		usuarioSesion = null;	
		hoteles = new ArbolAVL<Hotel>();
		listaRegistrados = new ListaEncadenadaDoble<Usuario>();
		Object a = baseDatos.getInstance();
		System.out.println(a);
	}
	
	public void cargarDatos()
	{
		
		
	}
	
	
	public void construirMapaPorLatitudLongitud(String latitud, String longitud) throws Exception
	{
		if(longitud.equals("")||latitud.equals(""))
		{
			throw new Exception("Los datos no estan completos");
		}
		else
		{
			listaPrueba.add(latitud+","+longitud);
		} 
	}


	public void construirMapaPosActual() throws Exception
	{
		if(usuarioSesion!=null)
		{
			int i = 0;
			boolean dirc = new File("./datos/").mkdir();
			File mapa = new File( "./datos/","busqueda.html");
			PrintWriter escritor = new PrintWriter(mapa);
			BufferedReader lector = new BufferedReader(new InputStreamReader(getClass().getResource("baseBusquedas.html").openStream()));
			String linea = lector.readLine();
			while(linea!=null)
			{
				String texto = linea;
				if(linea.contains("var arreglo;"))
				{  
					texto = "var arreglo = ['"+usuarioSesion.getPosicionActual()+"'];";
				}
				escritor.println(texto);
				linea = lector.readLine();
			}
			escritor.close();
			lector.close();
		}
	}
	
	public void construirMapaPosisiciones(int numeroPos) throws Exception
	{
		if(usuarioSesion!=null)
		{
			int i = 0;
			boolean dirc = new File("./datos/").mkdir();
			File mapa = new File( "./datos/","busqueda.html");
			PrintWriter escritor = new PrintWriter(mapa);
			BufferedReader lector = new BufferedReader(new InputStreamReader(getClass().getResource("baseBusquedas.html").openStream()));
			String linea = lector.readLine();
			while(linea!=null)
			{
				String texto = linea;
				if(linea.contains("var arreglo;"))
				{
					while(i<listaPrueba.size())
					{
						if(i == 0)
						{
							texto = "var arreglo = ['"+listaPrueba.get(i)+"'";
						}
						else
						{
							texto += ",'"+ listaPrueba.get(i)+"'";
						}
						if(i+1 == listaPrueba.size())
						{
							texto +="];";
						}
						i++;
					}
				}
				escritor.println(texto);
				linea = lector.readLine();
			}
			escritor.close();
			lector.close();
		}
	}
	

	public JFXPanel darMapa()
	{
		return pane;
	}
	
	public void registrarUsuario(String pUser, String pPass, String nNombre, String nApellido, String nCedula,String nMail) throws Exception 
	{
		// TODO Auto-generated method stub
		Usuario nuevo = new Usuario(pUser,pPass,nNombre,nApellido,nCedula,nMail,this);
		Usuario nuevo1 = new Usuario(pUser,pPass,nNombre,nApellido,nCedula,nMail,this);
		if(listaRegistrados.buscarElemento(nuevo, new comparadorNombreUs()) != null || listaRegistrados.buscarElemento(nuevo1,new comparadorCedula()) != null)
		{
			throw new Exception("Ya existe una persona registrada con esos datos");
		}
		else
		{
			listaRegistrados.adicionar(nuevo,new comparadorNombreUs());
		}
		
	}
	
	public boolean verificarUsuario(String pPass, String pUser) 
	{
		Usuario buscado = new Usuario(pUser, pPass, "", "", "", "",this);
		Usuario encontrado = listaRegistrados.buscarElemento(buscado, new comparadorNombreUs());
		if(encontrado!=null)
		{
			if(encontrado.darPassword().equals(pPass))
			{
				usuarioSesion = encontrado;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public void cerrarSesion()
	{
		if(usuarioSesion!=null)
		{
			usuarioSesion = null;
		}
	}

	public Usuario darUsuarioActual() {
		// TODO Auto-generated method stub
		return usuarioSesion;
	}


	public void definirUbicacion(String ubic) 
	{
		if(usuarioSesion!=null)
		{
			usuarioSesion.setPosicionActual(ubic);
		}
		else
		{
			
		}
		
	}
	
	public static void main(String[] args) {
		Aplicacion p = new Aplicacion(new Core());
	}
}


