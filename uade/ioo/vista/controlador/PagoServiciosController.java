package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequePropio;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.comportamiento.IVistaPagoServicios;

public class PagoServiciosController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaPagoServicios vista;
	private int row = 1;
	private Cheque cheque;
	
	public PagoServiciosController(AdministradorPagos modelo, IVistaPagoServicios vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (row = 1; row <= this.vista.getFilas(); row++){
			if (this.vista.getTipo(row, 3) == "Terceros") 
				cheque = new ChequeTerceros(this.vista.getNumero(row, 0), this.vista.getFechaEmision(row, 1), this.vista.getMonto(row, 2), "Entregado");
			if (this.vista.getTipo(row, 3) == "Propio") 
				cheque = new ChequePropio(this.vista.getNumero(row, 0), this.vista.getMonto(row, 2));
			this.modelo.pagarCheque(cheque);
		}
		this.modelo.borrarChequesParaPagar();
	}

}