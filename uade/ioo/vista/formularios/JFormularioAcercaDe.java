package uade.ioo.vista.formularios;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFormularioAcercaDe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel acercaDe = new JLabel("<html><p align='center', color='white'><b>IOO.TP</b><br>Trabajo Práctico<br>Introducción a la Orientación a Objetos<br><br><b>Emilio Delgado</b><br><b>LU 1015008</b><br><br>Turno Lunes/Noche</p></html>");

	public JFormularioAcercaDe() {
		this.setTitle("Acerca de IOO.TP");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		acercaDe.setHorizontalAlignment(JLabel.CENTER);		
		this.getContentPane().add(acercaDe);
		acercaDe.setBackground(new Color(53, 78, 78));
		this.getContentPane().setBackground(new Color(53, 78, 78));
		
	}
	
	
	
}
