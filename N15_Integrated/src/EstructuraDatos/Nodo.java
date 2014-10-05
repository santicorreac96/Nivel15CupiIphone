package EstructuraDatos;



import java.io.Serializable;

public class Nodo<T > implements Serializable , INodo<T>
{
	
	private Nodo siguiente;
	private Nodo anterior;
	private T objeto;

	
	public Nodo(T elemento,  Nodo<T> pSiguiente, Nodo<T> pAnterior)
	{
		objeto = elemento;
		siguiente = pSiguiente;
		anterior = pAnterior;
	}
	
	public void cambiarSiguiente(Nodo<T> nSiguiente)
	{
		siguiente= nSiguiente;
	}
	
	public void cambiarAnterior(Nodo<T> nAnterior)
	{
		anterior= nAnterior;
	}
	
	public Nodo<T> darSiguiente()
	{
		if(siguiente!=null)
		{
			return siguiente;
		}
		return null;
	}
	
	public Nodo<T> darAnterior()
	{
		if(anterior!=null)
		{
			return anterior;
		}
		return null;
	}
	
	public T darElemento()
	{
		return objeto;
	}



}
