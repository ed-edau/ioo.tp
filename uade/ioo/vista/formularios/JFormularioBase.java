package uade.ioo.vista.formularios;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.observer.IObservador;

public abstract class JFormularioBase extends JFrame implements IObservador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdministradorPagos modelo;
	
	public JFormularioBase(AdministradorPagos modelo){
		this.modelo = modelo;
		this.modelo.registrarObservador(this); // así los formularios serán todos observadores por herencia
	}
	
	protected AdministradorPagos getModelo(){
		return modelo;
	}
	
	public abstract void refresh();
	
}
