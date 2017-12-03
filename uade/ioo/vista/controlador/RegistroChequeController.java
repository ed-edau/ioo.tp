package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.comportamiento.IVistaRegistroCheque;

public class RegistroChequeController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaRegistroCheque vista; 
	
	public RegistroChequeController(AdministradorPagos modelo, IVistaRegistroCheque vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ChequeTerceros cheque = new ChequeTerceros(this.vista.getNumero(), this.vista.getFechaEmision(), this.vista.getMonto(), "Disponible");
		this.modelo.registrarChequeTercero(cheque);
	}
}
