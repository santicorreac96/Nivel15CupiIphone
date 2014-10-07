package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Mundo.Aplicacion;
import Mundo.Mapa;
import javafx.embed.swing.JFXPanel;

public class ComponenteAplicacionPanel extends JPanel implements ActionListener
{
	private JFXPanel pane;
	private Aplicacion mundo;
	private JTextField texto;
	private JButton boton;
	
	public ComponenteAplicacionPanel(Aplicacion aplicacion)
	{
		mundo = aplicacion;
		pane = new JFXPanel();
		JPanel busqueda = new JPanel(new GridLayout(1,2));
		boton = new JButton("Definir Actual");
		boton.setActionCommand("boton");
		boton.addActionListener(this);
		texto = new JTextField();
		busqueda.add(texto);
		busqueda.add(boton);
		setLayout(new BorderLayout());
		add(pane,BorderLayout.CENTER);
		add(busqueda,BorderLayout.SOUTH);
		revalidate();
		repaint();
	}
	
	public void crearMapa() throws Exception
	{
		mundo.construirMapaPosActual();
		new Mapa(pane, "mapa").start();
	}
	
	public void definirPosActual() throws Exception
	{
		if(texto.getText().equals("")==false)
		{
			mundo.definirUbicacion(texto.getText());
			crearMapa();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equals(boton.getActionCommand()))
		{
			try {
				definirPosActual();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error en el mapa");
			}
		}
		
	}
	
	public void terminar()
	{
		
	}
	

}
