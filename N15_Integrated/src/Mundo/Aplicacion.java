package Mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import EstructuraDatos.IListaEncadenadaDoble;
import javafx.embed.swing.JFXPanel;
import uniandes.cupi2.cupIphone.core.ICore;

public class Aplicacion 
{
	
	private ArrayList listaPrueba;
	
	private JFXPanel pane;
	
	private ICore core;
	
	private Usuario usuarioSesion;
	
	private IListaEncadenadaDoble<Usuario> listaRegistrados;

	public Aplicacion(ICore pCore)
	{
		core = pCore;
		usuarioSesion = null;	
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


	public void construirMapaPosiciones() throws Exception
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
	
	public void definirUbicacion(String ubic)
	{
		listaPrueba = new ArrayList();
		listaPrueba.add(ubic);
	}
	
	public JFXPanel darMapa()
	{
		return pane;
	}
}


