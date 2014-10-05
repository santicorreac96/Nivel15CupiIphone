package uniandes.cupi2.cupiphone.reloj.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.cupiphone.reloj.mundo.Reloj;

public class InterfazReloj extends JFrame implements Observer

{
	private JPanel contentPane;
	
	private ComponenteRelojPanel componenteRelojPanel;
	
	private Reloj reloj;
	
	/**
	 * Create the frame.
	 */
	public InterfazReloj() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		reloj = new Reloj();
		reloj.addObserver(this);
		
		componenteRelojPanel = new ComponenteRelojPanel();
		add(componenteRelojPanel, BorderLayout.CENTER);
		reloj.modificarEstado();
		
	}

	public void update(Observable arg0, Object arg1) 
	{
		System.out.println((String)arg1);
		componenteRelojPanel.actualizarLabelFecha(arg1);	       
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		InterfazReloj interfaz = new InterfazReloj();
        interfaz.setVisible( true );
	}

}
