package uade.ioo.vista.formularios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagoServicios;
import uade.ioo.vista.controlador.PagoServiciosController;
import uade.ioo.vista.modeloVista.TablaChequesParaPagar;

public class JFormularioPagosServicios extends JFormularioBase implements IVistaPagoServicios{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtMontoAPagar = new JTextField();
	private JButton btnConsultar = new JButton("Consultar cheques");
	private JButton btnPagar = new JButton("Pagar servicios");
	private JButton btnCancelar = new JButton("Cancelar");
	private JTable tabla;	
	
	public JFormularioPagosServicios(AdministradorPagos modelo){
		super(modelo);
		this.setTitle("Pago de Servicios");
		this.setSize(345, 200);
		this.setLocation(1075, 220);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().setBackground(new Color(172, 209, 0));
		tabla = new JTable(new TablaChequesParaPagar(modelo.obtenerChequesParaPagar()));
		tabla.setBackground(new Color(172, 209, 0));
		
		this.getContentPane().add(new JLabel("Ingrese el monto a pagar"));
		this.getContentPane().add(txtMontoAPagar);
		this.getContentPane().add(btnConsultar);
		this.getContentPane().add(tabla);
		this.getContentPane().add(btnPagar);
		this.getContentPane().add(btnCancelar);
		
		btnConsultar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				modelo.consultarChequesPagar(Double.parseDouble(txtMontoAPagar.getText()));
			}
		});

		btnPagar.addActionListener(
			new PagoServiciosController(this.getModelo(), this)
		);
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}

	@Override
	public void refresh() {
		tabla.updateUI();
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
	public String getTipo(int row, int col) {
		return (String)this.tabla.getValueAt(row, col);
	}

	@Override
	public int getFilas() {
		return this.tabla.getRowCount()-1;
	}

}
