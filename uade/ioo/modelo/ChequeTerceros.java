package uade.ioo.modelo;

import java.time.LocalDate;

public class ChequeTerceros extends Cheque {
	
	//EstadoCheque estado = new EstadoCheque();
	
	public ChequeTerceros(int numero, LocalDate fechaEmision, double monto, String estado) {
		super(monto);
		this.numero = numero;
		this.tipo = "Terceros";
		this.fechaEmision = fechaEmision;
		this.estado = estado;
	}

}
