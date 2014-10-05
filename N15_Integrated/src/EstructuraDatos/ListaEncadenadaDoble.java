package EstructuraDatos;



import java.io.Serializable;
import java.util.Comparator;


public class ListaEncadenadaDoble <T > implements Serializable , IListaEncadenadaDoble<T>
{
	private Nodo<T> primero;
	private Nodo<T> actual;

	private int tamano ;
	
	
	public void adicionar(T elemento, Comparator<T> comparador)
	{
		if(noHayElementos())
		{
			primero = new Nodo(elemento,null,null);	
			tamano++;
		}
		else
		{
			if( comparador.compare(elemento, primero.darElemento())<=0)
			{
				Nodo<T> nuevo = new Nodo<T>(elemento, primero, null);
				primero.cambiarAnterior(nuevo);
				primero = nuevo;
			}
			else
			{
				Nodo<T> inicial = primero;
				Nodo<T> ref  = null;
				while(inicial != null && comparador.compare(elemento, inicial.darElemento())>=0)
				{
					ref = inicial;
					inicial= inicial.darSiguiente();
					
				}
				if(inicial != null)
				{
					Nodo<T> viejoAnterior = inicial.darAnterior();
					Nodo<T> nuevo = new Nodo<T>(elemento, inicial, viejoAnterior);
					inicial.cambiarAnterior(nuevo);
					viejoAnterior.cambiarSiguiente(nuevo);
				}
				else
				{
					Nodo<T> nuevo = new Nodo<T>(elemento, null,ref);
					ref.cambiarSiguiente(nuevo);
				}
				
			}
			tamano++;
		}
	}
	
	
	public boolean noHayElementos()
	{
		if(primero==null)
		{
			return true;
		}
		return false;
	}
	
	public T buscarElemento(T buscado, Comparator<T> comparador)
	{
		if(noHayElementos())
		{
			return null;
		}
		
		int posInicial =0;
		int posFinal = tamano-1;
		T respuesta = null;
		Nodo<T> mitad = primero;
		while(posInicial<= posFinal && respuesta== null)
		{
			int contador= 0;
			int mitadLista = (posFinal+posInicial)/2;
			Nodo<T> ref = primero;
			boolean find = false;
			while(ref != null && find==false)
			{
				if(contador==mitadLista)
				{
					find=true;
					mitad = ref;
				}
				ref = ref.darSiguiente();
				contador++;
			}
			if(comparador.compare(buscado, mitad.darElemento())==0)
			{
				respuesta = mitad.darElemento();
			}
			else if(comparador.compare(buscado, mitad.darElemento())<0)
			{
				posFinal =mitadLista-1;
			}
			else
			{
				posInicial = mitadLista+1;
			}
		}
		actual = mitad;
		if(respuesta != null)
		{
			return respuesta;
		}
		else
		{
			return null;
		}
	}

	
	public void eliminar(T elemento, Comparator<T> comparador) throws Exception
	{
		if(noHayElementos() )
		{
							
		}
		else
		{
			if(comparador.compare(elemento, primero.darElemento())==0)
			{
				Nodo<T> temp = primero.darSiguiente();
				primero.cambiarSiguiente(null);
				primero.cambiarAnterior(null);	
				primero = temp;
				if(primero !=null)
				{
					primero.cambiarAnterior(null);
				}
				tamano--;
			}
			else
			{
				Nodo<T> inicial = primero;
				Nodo<T> busca = null;
				while(busca== null && inicial!=null)
				{
					if(comparador.compare(elemento, inicial.darElemento())==0)
					{
						busca = inicial;
					}
					inicial = inicial.darSiguiente();
				}
				if(busca!= null)
				{
					busca.darAnterior().cambiarSiguiente(busca.darSiguiente());
					if(busca.darSiguiente()!=null)
					{
						busca.darSiguiente().cambiarAnterior(busca.darAnterior());
					}
					busca.cambiarAnterior(null);
					busca.cambiarSiguiente(null);
					tamano--;
				}
				
			}	
		}
	}
	public T volverActualPrimero() 
	{
		if(primero != null )
		{
			actual = primero;
			return primero.darElemento();
		}
		else
		{
			return null;
		}
	}


	@Override
	public T adelantarse()  
	{
		if(actual.darSiguiente()!=null)
		{
			T resp = actual.darSiguiente().darElemento();
			actual = actual.darSiguiente();
			return resp;
		}
		return null;
	}


	@Override
	public T devolverse() {
		
		if(actual.darAnterior()!=null)
		{
			T resp = actual.darAnterior().darElemento();
			actual = actual.darAnterior();
			return resp;
		}
		return null;
	}


	@Override
	public int darTamano() 
	{
		return tamano;
	}
	
	public T darActual()
	{
		return actual.darElemento();
	}

}
