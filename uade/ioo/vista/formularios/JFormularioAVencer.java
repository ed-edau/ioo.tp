package uade.ioo.vista.formularios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaDepositoCheque;
import uade.ioo.vista.controlador.DepositoChequesController;
import uade.ioo.vista.modeloVista.TablaChequesAVencer;

public class JFormularioAVencer extends JFormularioBase implements IVistaDepositoCheque {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnDepositar;
	private JButton btnCancelar;
	private JTable tabla;
	
	public JFormularioAVencer(AdministradorPagos modelo){
		super(modelo);
		this.setTitle("Cheques Próximos a Vencer (30 días)");
		this.setSize(345, 200);
		this.setLocation(720, 220);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 103, 17));
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		tabla = new JTable(new TablaChequesAVencer(modelo.obtenerChequesAVencer()));
		this.getContentPane().add(tabla);
		tabla.setBackground(new Color(255, 103, 17));
		btnDepositar = new JButton("Depositar");
		this.getContentPane().add(btnDepositar);
		btnCancelar = new JButton("Cancelar");
		this.getContentPane().add(btnCancelar);
		
		btnDepositar.addActionListener(
			new DepositoChequesController(this.getModelo(), this)
		);
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}

	@Override
	public void refresh() {
		this.tabla.updateUI();
	}
	
	@Override
	public int getNumero(int row, int col) {
		return (Integer)this.tabla.getValueAt(row, col);
	}

	@Override
	public double getMonto(int row, int col) {
		return (Double)this.tabla.getValueAt(row, col);
	}
	
	@Override
	public LocalDate getFechaEmision(int row, int col) {
		return (LocalDate)this.tabla.getValueAt(row, col);
	}

	@Override
	public int getFilas() {
		return this.tabla.getRowCount();
	}
}
