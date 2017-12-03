package uade.ioo.vista.formularios;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioReporte extends JFormularioBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblMontoDispCh = new JLabel("0");
	private JLabel lblMontoPagado = new JLabel("0");
	private JLabel lblMontoDepositado= new JLabel("0");
	private JLabel lblDineroEmitidoCh = new JLabel("0");
	private JLabel lblChequesAVencer= new JLabel("0");
	
	public JFormularioReporte(AdministradorPagos modelo){
		super(modelo);
		this.setTitle("Reporte");
		this.setSize(345, 200);
		this.setLocation(10, 220);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.getContentPane().add(new JLabel("Monto disponible en cheques de 3eros:"));
		this.getContentPane().add(lblMontoDispCh);
		this.getContentPane().add(new JLabel("Monto pagado:"));
		this.getContentPane().add(lblMontoPagado);
		this.getContentPane().add(new JLabel("Monto depositado en Banco:"));
		this.getContentPane().add(lblMontoDepositado);
		this.getContentPane().add(new JLabel("Dinero emitido en cheques:"));
		this.getContentPane().add(lblDineroEmitidoCh);
		this.getContentPane().add(new JLabel("Cheques prox. a vencer:"));
		this.getContentPane().add(lblChequesAVencer);
		this.getContentPane().setBackground(new Color(255, 198, 57));
		
		//this.refresh();
	}

	@Override
	public void refresh() {
		this.lblMontoDispCh.setText(
			Double.toString(
				this.getModelo().getMontoDispCh())
			);
		this.lblMontoPagado.setText(
			Double.toString(
				this.getModelo().getMontoPagado())
			);
		this.lblMontoDepositado.setText(
			Double.toString(
				this.getModelo().getMontoDepositado())
			);
		this.lblDineroEmitidoCh.setText(
			Double.toString(
				this.getModelo().getMontoEmitido())
			);
		this.lblChequesAVencer.setText(
			Double.toString(
				this.getModelo().getChequesAVencer())
			);
	}

}