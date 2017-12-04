package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.comportamiento.IVistaDepositoCheque;

public class DepositoChequesController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaDepositoCheque vista; 
	private int row = 1;
	
	public DepositoChequesController(AdministradorPagos modelo, IVistaDepositoCheque vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (row = 1; row <= this.vista.getFilas()-1; row++){
			Cheque cheque = new ChequeTerceros(this.vista.getNumero(row, 0), this.vista.getFechaEmision(row, 1), this.vista.getMonto(row, 2), "Depositado");
			this.modelo.depositarChequeTercero(cheque);
		}
		this.modelo.borrarChequesDepositados();
	}

}
