package uniandes.cupi2.cupiphone.reloj.interfaz;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;

import uniandes.cupi2.cupIphone.core.ICore;
import uniandes.cupi2.cupiphone.reloj.mundo.Reloj;



import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel principal del componente.
 */
public class ComponenteRelojPanel extends JPanel
{	

	private JLabel lblHoraYFecha;

	/**
	 * Inicializa el panel que presenta el reloj
	 */
	public ComponenteRelojPanel() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{451, 0};
		gridBagLayout.rowHeights = new int[]{296, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblHoraYFecha = new JLabel("New label");
		lblHoraYFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		GridBagConstraints gbc_lblHoraYFecha = new GridBagConstraints();
		gbc_lblHoraYFecha.gridx = 0;
		gbc_lblHoraYFecha.gridy = 0;
		add(lblHoraYFecha, gbc_lblHoraYFecha);
		
	
	}
	
	public void actualizarLabelFecha(Object arg1)
	{
		System.out.println((String)arg1);
		lblHoraYFecha.setText((String)arg1);
	}

} 
