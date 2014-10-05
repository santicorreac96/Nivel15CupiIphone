package EstructuraDatos;

import java.util.ArrayList;
import java.util.Comparator;

public class ArbolAVL <T> implements IArbolAVL<T>
{
	
	private NodoArbol<T> raiz;
	
	private Comparator<T> compa;

	private int peso;

	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	@Override
	public void agregarElemento(T elemento, Comparator<T> comparador) 
	{
		compa = comparador;
		NodoArbol<T> nuevo = new NodoArbol<T>(elemento, this);
		if(raiz ==null)
		{
			raiz = nuevo;
			peso++;
		}
		else
		{
			raiz.insertar(raiz, nuevo, comparador);
			peso++;
		}
		
	}

	@Override
	public void eliminarElemento(T elemento) 
	{
		NodoArbol<T> buscado = new NodoArbol<T>(elemento, this);
		if(raiz!= null)
		{
			raiz.eliminar(raiz, buscado , compa);
		}
		
	}
	
	public void reducirPeso()
	{
		peso--;
	}

	@Override
	public int darAltura() 
	{
		if(raiz !=null)
		{
			return raiz.altura(raiz);
		}
		return 0;
	}

	@Override
	public int darPeso() {
		// TODO Auto-generated method stub
		return peso;
	}

	@Override
	public T buscarElemento(T elemento) {
		NodoArbol<T> a = new NodoArbol<T>(elemento, this);
		T resp = null;
		if(raiz!=null)
		{
			resp =raiz.buscar(raiz, a,compa);
		}
		return resp;
	}
	
	public ArrayList inorder()
	{
		ArrayList test = new ArrayList();
		if(raiz!=null)
		{
			raiz.inorder(raiz, test);
		}
		return test;
	}
	

}
