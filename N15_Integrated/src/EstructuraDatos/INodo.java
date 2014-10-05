package EstructuraDatos;


import java.util.Comparator;


public interface INodo <T >
{
	
	/**
	 * Cambia el siguiente nodo de el actual
	 * @param nSiguiente el nuevo nodo siguiente
	 * post: se cambio el siguiente nodo
	 */
	public void cambiarSiguiente(Nodo<T> nSiguiente);
	
	/**
	 * Cambia el anterior nodo de el actual
	 * @param nAnterior el nuevo nodo anterior
	 * post: se cambio el anterior nodo
	 */
	public void cambiarAnterior(Nodo<T> nAnterior);

	
	/**
	 * metodo que retorna el siguiente nodo del actual
	 * @return el siguiente nodo del nodo actual
	 */
	public Nodo<T> darSiguiente();

	/**
	 * metodo que retorna el anterior nodo del actual
	 * @return el anterior nodo del nodo actual
	 */
	public Nodo<T> darAnterior();

	/**
	 * Metodo que retorna el elemento que contiene el nodo actual
	 * @return El elemento que contiene el nodo actual
	 */
	public T darElemento();


}
