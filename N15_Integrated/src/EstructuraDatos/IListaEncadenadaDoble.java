package EstructuraDatos;



import java.util.Comparator;


public interface IListaEncadenadaDoble<T> 
{
	
	/**
	 * Metodo que adiciona un elemento ordenado a la lista
	 * @param elemento El elemento a adicionar
	 * post: se adiciono el elemento de forma ordenada
	 */
	public abstract void adicionar(T elemento,  Comparator<T> comparador);

	/**
	 * Metodo que indica si la lista tienen o no elementos
	 * @return true si no contiene elementos, false en caso contrario
	 */
	public abstract boolean noHayElementos();

	/**
	 * Metodo que busca un elemento 
	 * pre: La lista tiene elementos
	 * @param buscado el elemento a buscar
	 * @return el elemento buscado 
	 */
	public abstract T buscarElemento(T buscado, Comparator<T> comparador);
	
	
	
	/**
	 * Metodo que elimina un elemento de la lista
	 * @param elemento el elemento a eliminar
	 * @throws Exception Si no existen elementos
	 * post: Se elimino el elemento de la lista si esta lo tenia
	 */
	public abstract void eliminar(T elemento, Comparator<T> comparador) throws Exception;
	
	/**
	 * Retorna el primer elemento de la lista
	 * @return el primer elemento de la lista o null si no existe
	 */
	public abstract T volverActualPrimero();
	
	/**
	 * Se adelanta desde el elemento actual y retorna este nuevo elemento
	 * @return el siguiente elemento del anterior acutal
	 */
	public abstract T adelantarse() ;
	
	/**
	  * Se devuelve desde el elemento actual y retorna este nuevo elemento
	 * @return el anterior elemento del anterior acutal
	 */
	public abstract T devolverse();
	
	/**
	 * metodo que da el tamano de la lista
	 * @return el tamano de la lista
	 */
	public abstract int darTamano();
	
	/**
	 * Metodo que da el elemento actual de la lista
	 * @return el elemento actual de la lista
	 */
	public abstract T darActual();
	

}
