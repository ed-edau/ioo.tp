package uade.ioo.modelo;

public class ChequeTest extends Cheque {

	public ChequeTest(int numero, String tipo, double monto) {
		super(monto);
		this.numero = numero;
		this.tipo = tipo;
		// agregar fechaEmision
	}

}
