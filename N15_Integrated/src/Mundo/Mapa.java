package Mundo;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

import javax.swing.border.TitledBorder;

import com.sun.javafx.application.PlatformImpl;

public class Mapa 
{
	private JFXPanel panel;
	private String nombre;

	public  Mapa(JFXPanel pane, String nombreMapa) 
	{
		panel = pane;
		nombre = nombreMapa;
	}

	public void start()
	{
		PlatformImpl.startup(
	            new Runnable() 
	            {
	                public void run() 
	                {
		panel.setBorder(new TitledBorder(nombre));
		panel.setSize(300, 300);
		HBox nueva = new HBox();
		Buscador vistaWeb = new Buscador(nueva);
		Group root = new Group();
		Scene  escena = new Scene(root,800,800);
		root.getChildren().add(nueva);
		panel.setScene(escena);
		panel.show();
		}
	                });
	} 


}
