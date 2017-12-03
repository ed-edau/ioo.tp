package uade.ioo.modelo;

import java.time.LocalDate;

public abstract class Cheque {
	protected int numero;
	protected String tipo;
	private double monto;
	protected LocalDate fechaEmision;
	protected String estado;
	
	public Cheque(double monto) {
		super();
		this.numero = 0;
		this.fechaEmision = null;
		this.tipo = null;
		this.monto = monto;
		this.estado = "Disponible";
	}
	
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public String getEstado() {
		return estado;
	}
}
