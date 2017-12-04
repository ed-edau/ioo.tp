package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.comportamiento.IVistaRegistroCheque;

public class RegistroChequeController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaRegistroCheque vista;
	private String estado = "Disponible";
	
	public RegistroChequeController(AdministradorPagos modelo, IVistaRegistroCheque vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LocalDate hoy = LocalDate.now();
		if (this.vista.getFechaEmision().plusDays(30).isBefore(hoy))
			estado = "Vencido";
		else estado = "Disponible";
		
		Cheque cheque = new ChequeTerceros(this.vista.getNumero(), this.vista.getFechaEmision(), this.vista.getMonto(), this.estado);
		this.modelo.registrarChequeTercero(cheque);
	}
}
