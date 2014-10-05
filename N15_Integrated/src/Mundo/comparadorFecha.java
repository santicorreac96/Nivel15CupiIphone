package Mundo;

import java.util.Comparator;

public class comparadorFecha implements Comparator<Reserva>
{

	@Override
	public int compare(Reserva o1, Reserva o2) {
		// TODO Auto-generated method stub
		return o1.getFechaIngreso().compareTo(o2.getFechaIngreso());
	}

}
