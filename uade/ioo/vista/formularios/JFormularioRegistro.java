package uade.ioo.vista.formularios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaRegistroCheque;
import uade.ioo.vista.controlador.RegistroChequeController;

public class JFormularioRegistro extends JFormularioBase implements IVistaRegistroCheque {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private JTextField txtNroCheque = new JTextField();
	private JTextField txtFechaEmision = new JTextField();
	private JTextField txtMonto = new JTextField();
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	public JFormularioRegistro(AdministradorPagos modelo){
		super(modelo);
		this.setTitle("Registrar cheques de terceros");
		this.setSize(345, 200);
		this.setLocation(365, 220);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().setBackground(new Color(99, 205, 245));
		
		this.getContentPane().add(new JLabel("N° Cheque"));
		this.getContentPane().add(txtNroCheque);
		this.getContentPane().add(new JLabel("Fecha de Emisión (YYYY-MM-DD)"));
		this.getContentPane().add(txtFechaEmision);
		this.getContentPane().add(new JLabel("Monto"));
		this.getContentPane().add(txtMonto);
		this.getContentPane().add(btnRegistrar);
		this.getContentPane().add(btnCancelar);
		
		btnRegistrar.addActionListener(
			new RegistroChequeController(this.getModelo(), this) //recibe el modelo y la vista, que es esta misma "this"
		);
			
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});		
	}

	@Override
	public int getNumero() {
		return Integer.parseInt(this.txtNroCheque.getText());
	}

	@Override
	public double getMonto() {
		return Double.parseDouble(this.txtMonto.getText());
	}
	
	@Override
	public LocalDate getFechaEmision() {
		return LocalDate.parse(this.txtFechaEmision.getText());
	}
	
	@Override
	public void refresh() {
		
	}
}
