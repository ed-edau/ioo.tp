package uade.ioo.vista.formularios;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.modeloVista.TablaChequesDepositados;

public class JFormularioChequesDepositados extends JFormularioBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable tabla;
	
	public JFormularioChequesDepositados(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Listado de cheques despositados");
		this.setSize(345, 200);
		this.setLocation(720, 430);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tabla = new JTable(new TablaChequesDepositados(modelo.obtenerChequesDepositados()));
		this.getContentPane().add(tabla);
		tabla.setBackground(new Color(212, 208, 169));
	}

	@Override
	public void refresh() {
		this.tabla.updateUI();
	}	
}