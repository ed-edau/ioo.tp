package uade.ioo.modelo;

public class Chequera {
	
	private int ultimoNumero = 1000;

	public int getUltimoNumero() {
		return ultimoNumero;
	}

	public void setUltimoNumero() {
		this.ultimoNumero = this.ultimoNumero+1;
	}
}
