package uade.ioo.modelo.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado { // el observado es el modelo
	
	private List<IObservador> observadores = new ArrayList<IObservador>(); // tiene una lista de observadores
	
	public void registrarObservador(IObservador obs){
		this.observadores.add(obs);
	}
	
	public void quitarObservador(IObservador obs){
		this.observadores.remove(obs);
	}
	
	public void notificarObservadores(){
		for(IObservador obs : this.observadores){
			obs.refresh();
		}
	}
}
