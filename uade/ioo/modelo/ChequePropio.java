package uade.ioo.modelo;

import java.time.LocalDate;

public class ChequePropio extends Cheque {
	
	public ChequePropio(int numero, double monto) {
		super(monto);
		this.numero = numero;
		this.tipo = "Propio";
		this.fechaEmision = LocalDate.now();
		this.estado = "Entregado";
	}
}
