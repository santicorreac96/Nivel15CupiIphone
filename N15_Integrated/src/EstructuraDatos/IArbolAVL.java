package EstructuraDatos;

import java.util.Comparator;


public interface IArbolAVL<T>
{
	
	/**
	 * Metodo que permite agregar un elemento al arbol
	 * @param elemento el elemento a ser agregado
	 * @param comparador el comparador usado para agregar el elemento
	 */
	public abstract void agregarElemento(T elemento, Comparator<T> comparador);
	
	/**
	 * Metodo que permite eliminar un elemento del arbol
	 * @param elemento el elemento a ser eliminado
	 */
	public abstract void eliminarElemento(T elemento);

	/**
	 * Metodo que permite conocer la altura del arbol
	 * @return un entero que es el valor de la altura del arbol
	 */
	public abstract int darAltura();
	
	/**
	 * Metodo que permite conocer el peso del arbol
	 * @return un entero que es el valor del peso del arbol
	 */
	public abstract int darPeso();
	
	/**
	 * Metodo que permite buscar un elemento en el arbol
	 * @param elemento el elemento que se busca dentro del arbol
	 * @return el elemento buscado en el arbol
	 */
	public abstract T buscarElemento(T elemento);
}
