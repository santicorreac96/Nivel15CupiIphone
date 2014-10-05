package EstructuraDatos;

import java.util.ArrayList;
import java.util.Comparator;

public class NodoArbol<T>
{
	
	private T elemento;
	
	private NodoArbol<T> nodoDerecha;
	
	private NodoArbol<T> nodoIzquierda;
	
	private NodoArbol<T> padre;
	
	private int estado;
	
	private ArbolAVL arbol;
	
	public NodoArbol(T nElemento, ArbolAVL arb)
	{
		elemento = nElemento;
		nodoDerecha = null;
		padre = null;
		nodoIzquierda = null;
		estado = 0;
		arbol =arb;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NodoArbol<T> getNodoDerecha() {
		return nodoDerecha;
	}

	public void setNodoDerecha(NodoArbol<T> nodoDerecha) {
		this.nodoDerecha = nodoDerecha;
	}

	public NodoArbol<T> getNodoIzquierda() {
		return nodoIzquierda;
	}

	public void setNodoIzquierda(NodoArbol<T> nodoIzquierda) {
		this.nodoIzquierda = nodoIzquierda;
	}

	public NodoArbol<T> getPadre() {
		return padre;
	}

	public void setPadre(NodoArbol<T> padre) {
		this.padre = padre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void insertar(NodoArbol<T> p, NodoArbol<T> q, Comparator<T> comparador) 
	{

		if(comparador.compare(p.getElemento(), q.getElemento())>0)
		{
			if(p.nodoIzquierda==null) 
			{
				p.setNodoIzquierda(q); 
				q.setPadre(p);

				balance(p);
			} 
			else 
			{
				insertar(p.getNodoIzquierda(),q, comparador);
			}

		} 

		else if(comparador.compare(p.getElemento(), q.getElemento())<0)
		{
			if(p.nodoDerecha==null) 
			{
				p.setNodoDerecha(q);
				q.setPadre(p);

				
				balance(p);
			} 
			else 
			{
				insertar(p.getNodoDerecha(),q,comparador);
			}
		} 
		else 
		{
	
		}
	}
	
	public void balance(NodoArbol<T> actual) {
		
		  calcularBalance(actual);
		  int balance = actual.getEstado();

		  
		  if(balance==-2) 
		  {

			  if(altura(actual.getNodoIzquierda().getNodoIzquierda())>=altura(actual.getNodoIzquierda().getNodoDerecha()))
			  {
				  actual = rotDerecha(actual);
			  }
			  else 
			  {
				  actual = rotIzqDer(actual);
			  }
		  } 
		  else if(balance==2)
		  {
			  if(altura(actual.getNodoDerecha().getNodoDerecha())>=altura(actual.getNodoDerecha().getNodoIzquierda()))
			  {
				  actual = rotIzquierda(actual);
			  } 
			  else
			  {
				  actual = rotDerIzq(actual);
			  }
		  }

		  if(actual.getPadre()!=null) 
		  {
			 balance(actual.getPadre());
		  }
		  else
		  {
			  arbol.setRaiz(actual);
			  System.out.println("------------Balance----------------");
		  }
	}

	private NodoArbol<T> rotIzqDer(NodoArbol<T> actual) 
	{
		actual.setNodoIzquierda(rotIzquierda(actual.getNodoIzquierda()));
		return rotDerecha(actual);
	}

	private NodoArbol<T> rotDerIzq(NodoArbol<T> actual) {
		actual.setNodoDerecha(rotDerecha(actual.getNodoDerecha()));
		return rotIzquierda(actual);
	}

	private NodoArbol<T> rotIzquierda(NodoArbol<T> actual) {
		NodoArbol<T> v = actual.getNodoDerecha();
		v.setPadre(actual.getPadre());

		actual.setNodoDerecha(v.getNodoIzquierda()); 

		if(actual.getNodoDerecha()!=null) {
			actual.getNodoDerecha().setPadre(actual);
		}

		v.setNodoIzquierda(actual);
		actual.setPadre(v);


		if(v.getPadre()!=null) {
			if(v.getPadre().getNodoDerecha()==actual) {
				v.getPadre().setNodoDerecha(v);
			} else if(v.getPadre().getNodoIzquierda()==actual) {
				v.getPadre().setNodoIzquierda(v);
			}
		}

		calcularBalance(actual);
		calcularBalance(v);

		return v;
	}

	private NodoArbol<T> rotDerecha(NodoArbol<T> actual) {
		NodoArbol<T> v = actual.getNodoIzquierda();
		v.setPadre(actual.getPadre());

		actual.setNodoIzquierda(v.getNodoDerecha()); 

		if(actual.getNodoIzquierda()!=null) {
			actual.getNodoIzquierda().setPadre(actual);
		}

		v.setNodoDerecha(actual);
		actual.setPadre(v);


		if(v.getPadre()!=null) {
			if(v.getPadre().getNodoDerecha()==actual) {
				v.getPadre().setNodoDerecha(v);
			} else if(v.getPadre().getNodoIzquierda()==actual) {
				v.getPadre().setNodoIzquierda(v);
			}
		}

		calcularBalance(actual);
		calcularBalance(v);

		return v;
	}

	public int altura(NodoArbol<T> nodo) {
		 if(nodo==null) {
			   return -1;
			  }
			  if(nodo.getNodoIzquierda()==null && nodo.getNodoDerecha()==null)
			  {
			   return 0;
			  } else if(nodo.getNodoIzquierda()==null) {
			   return 1+altura(nodo.getNodoDerecha());
			  } else if(nodo.getNodoDerecha()==null) {
			   return 1+altura(nodo.getNodoIzquierda());
			  } else {
			   return 1+Math.max(altura(nodo.getNodoIzquierda()),altura(nodo.getNodoDerecha()));
			  }
	}

	private void calcularBalance(NodoArbol<T> actual) 
	{
		actual.setEstado(altura(actual.getNodoDerecha())-altura(actual.getNodoIzquierda()));
		
	}
	
	public void eliminar(NodoArbol<T> buscador,NodoArbol<T> buscado,Comparator<T> comparadorEliminacion) 
	{
		if(buscador.getNodoIzquierda()!=null && comparadorEliminacion.compare(buscado.getElemento(),buscador.getElemento())<0)  
		{
			eliminar(buscador.getNodoIzquierda(),buscado,comparadorEliminacion);
		} 
		else if(buscador.getNodoDerecha()!=null && comparadorEliminacion.compare(buscado.getElemento(),buscador.getElemento())>0) 
		{
			eliminar(buscador.getNodoDerecha(),buscado,comparadorEliminacion);
		}
		else if(buscador!=null && comparadorEliminacion.compare(buscado.getElemento(),buscador.getElemento())==0)
		{
			eliminarNodo(buscador);
		}
	}
	
	public T buscar(NodoArbol<T> buscador,NodoArbol<T> buscado,Comparator<T> comparadorbuscar) 
	{
		T resp = null;
		if(buscador.getNodoIzquierda()!=null && comparadorbuscar.compare(buscado.getElemento(),buscador.getElemento())<0)  
		{
			resp = buscar(buscador.getNodoIzquierda(),buscado,comparadorbuscar);
		} 
		else if(buscador.getNodoDerecha()!=null && comparadorbuscar.compare(buscado.getElemento(),buscador.getElemento())>0) 
		{
			resp = buscar(buscador.getNodoDerecha(),buscado,comparadorbuscar);
		}
		else if(comparadorbuscar.compare(buscado.getElemento(),buscador.getElemento())==0)
		{
			if(buscador!=null)
			{
				return buscador.getElemento();
			}
		}
		return resp;
	}

	private void eliminarNodo(NodoArbol<T> buscador) 
	{
		NodoArbol<T> referencia = null;
		// at least one child of q, q will be removed directly
		if(buscador.getNodoDerecha()==null || buscador.getNodoIzquierda()==null) 
		{
			// the root is deleted
			if(buscador.getPadre()==null)
			{
				arbol.setRaiz(null);
				buscador=null;
			}
			referencia = buscador;
		} 
		else 
		{
			// q has two children --> will be replaced by successor
			referencia = siguienteNodo(buscador);
			buscador.setElemento(referencia.getElemento());
		}


		NodoArbol<T> aux = null;
		if (referencia.getNodoIzquierda() != null) {
			aux = referencia.getNodoIzquierda();
		} else {
			aux = referencia.getNodoDerecha();
		}
		if (aux != null) {
			aux.setPadre(referencia.getPadre());
		}
		if (referencia.getPadre() == null) {
			arbol.setRaiz(aux);
		} else {
			if (referencia == referencia.getPadre().getNodoIzquierda()) {
				referencia.getPadre().setNodoIzquierda(aux);
			} else {
				referencia.getPadre().setNodoDerecha(aux);
			}
			// balancing must be done until the root is reached.
			balance(referencia.getPadre());
		}
		referencia = null;
		arbol.reducirPeso();

	}

	private NodoArbol<T> siguienteNodo(NodoArbol<T> buscador)
	{
		if(buscador.getNodoDerecha()!=null) {
			NodoArbol<T> ref = buscador.getNodoDerecha();
			while(ref.getNodoIzquierda()!=null) {
				ref = ref.nodoIzquierda;
			}
			return ref;
		} else {
			NodoArbol<T> aux = buscador.getPadre();
			while(aux!=null && buscador==aux.getNodoDerecha()) {
				buscador = aux;
				aux = buscador.getPadre();
			}
			return aux;
		}
	}
	
	public void inorder(NodoArbol<T> act,ArrayList lista)
	{
		if(act ==null)
		{
			return;
		}
		inorder(act.getNodoIzquierda(), lista);
		lista.add(act.getElemento());
		inorder(act.getNodoDerecha(), lista);	

	}
}
