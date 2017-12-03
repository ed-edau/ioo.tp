package uade.ioo.vista.formularios;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.modeloVista.TablaChequesLog;

public class JFormularioChequesLog extends JFormularioBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable tabla;
	
	public JFormularioChequesLog(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Log de cheques");
		this.setSize(345, 200);
		this.setLocation(10, 430);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tabla = new JTable(new TablaChequesLog(modelo.obtenerListaCheques()));
		this.getContentPane().add(tabla);
		tabla.setBackground(new Color(212, 208, 169));
		
	}

	@Override
	public void refresh() {
		this.tabla.repaint();
	}
}
