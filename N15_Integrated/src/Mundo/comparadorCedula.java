package Mundo;



import java.io.Serializable;
import java.util.Comparator;

public class comparadorCedula implements Comparator<Usuario>,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Usuario o1, Usuario o2) 
	{
		return o1.darCedula().compareTo(o2.darCedula());
	}

}
