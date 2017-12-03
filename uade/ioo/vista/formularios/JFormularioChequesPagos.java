package uade.ioo.vista.formularios;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.modeloVista.TablaChequesDepositados;

public class JFormularioChequesPagos extends JFormularioBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable tabla;
	
	public JFormularioChequesPagos(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Listado de cheques usados para pagar");
		this.setSize(345, 200);
		this.setLocation(1075, 430);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tabla = new JTable(new TablaChequesDepositados(modelo.obtenerChequesPagos()));
		this.getContentPane().add(tabla);
		tabla.setBackground(new Color(212, 208, 169));
	}

	@Override
	public void refresh() {
		this.tabla.updateUI();
	}	
}