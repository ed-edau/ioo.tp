package uade.ioo.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado {
	
	private List<Cheque> cheques = new ArrayList<Cheque>();
	private List<Cheque> disponibles = new ArrayList<Cheque>();
	private List<Cheque> avencer = new ArrayList<Cheque>();
	private List<Cheque> depositos = new ArrayList<Cheque>();
	private List<Cheque> paraPagar = new ArrayList<Cheque>();
	private List<Cheque> pagos = new ArrayList<Cheque>();
	private Chequera numero = new Chequera();
	
	/*
	 * 
	 * Funciones core
	 * 
	 */
	
	public void registrarChequeTercero(ChequeTerceros cheque){
		
		int i = 0;
		
		// inserto los cheques ordenados por su monto descendente en la tabla "disponibles"
		if (this.disponibles.size() > 0)
			while (this.disponibles.size() > i && this.disponibles.get(i).getMonto() >= cheque.getMonto())
				i++;
		if (this.disponibles.size() <= i)
			this.disponibles.add(cheque);
		else this.disponibles.add(i, cheque);
		
		// si están por vencer, los inserto en la tabla "avencer"
		LocalDate hoy = LocalDate.now();
		if(cheque.getFechaEmision().isBefore(hoy.minusDays(30)))
			this.avencer.add(cheque);
		
		// todos los cheques van al log
		this.cheques.add(cheque);
		
		this.notificarObservadores();
	}
	
	public void depositarChequeTercero(ChequeTerceros cheque){
		this.depositos.add(cheque);
		this.notificarObservadores();
	}
	
	public void borrarChequesDepositados(){
		this.cheques.removeAll(this.avencer);
		this.cheques.addAll(this.depositos);
		this.disponibles.removeAll(this.avencer);
		this.paraPagar.clear();
		this.avencer.clear();
		this.notificarObservadores();
	}
	
	public void consultarChequesPagar(double monto){
		double suma = 0;
		this.paraPagar.clear();
		for (Cheque c : this.disponibles)
			if ((suma + c.getMonto()) <= monto){
				suma = suma + c.getMonto();
				this.paraPagar.add(c);
			}
		
		if (suma < monto){
			Cheque propio = new ChequePropio(this.numero.getUltimoNumero(), monto-suma);
			this.paraPagar.add(propio);
		}
		
		this.notificarObservadores();
	}
	
	public void pagarCheque(Cheque cheque){
		this.pagos.add(cheque);
		if (cheque.getTipo() == "Propio")
			this.numero.setUltimoNumero();
		this.notificarObservadores();
	}
	
	public void borrarChequesParaPagar(){
		this.cheques.removeAll(this.paraPagar);
		this.cheques.addAll(this.pagos);
		this.disponibles.removeAll(this.paraPagar);
		this.avencer.removeAll(this.paraPagar);
		this.paraPagar.clear();
		this.notificarObservadores();
	}
	
	/*
	 * 
	 * Auxiliar - Chequera
	 * 
	 */
	
	public Cheque generarChequeNuevo(double monto){
		Cheque nuevo = new ChequePropio(this.numero.getUltimoNumero(), monto);
		return nuevo;
	}
	
	/*
	 * 
	 * Actualizar formulario Reporte
	 * 
	 */
	
	public double getMontoDispCh(){
		double total = 0;
		for (Cheque c : this.disponibles){
			total += c.getMonto();
		}
		return total;
	}
	
	public double getMontoPagado(){
		double total = 0;
		for (Cheque p : this.pagos){
			total += p.getMonto();
		}
		return total;
	}
	
	public double getMontoEmitido(){
		double total = 0;
		for (Cheque c : this.pagos){
			if (c.getTipo() == "Propio")
				total += c.getMonto();
		}
		return total;
	}
	
	public double getMontoDepositado(){
		double total = 0;
		for (Cheque c : this.depositos){
			total += c.getMonto();
		}
		return total;
	}
	
	public double getChequesAVencer(){
		double total = 0;
		for (Cheque c : this.avencer){
			total += c.getMonto();
		}
		return total;
	}
	
	/*
	 * 
	 * Recuperar listados de cheques para formularios 
	 * 
	 */
		
	public List<Cheque> obtenerListaCheques(){
		return this.cheques;
	}
	
	public List<Cheque> obtenerChequesParaPagar(){		
		return this.paraPagar;
	}
	
	public List<Cheque> obtenerChequesAVencer(){
		return this.avencer;
	}
	
	public List<Cheque> obtenerChequesDepositados(){
		return this.depositos;
	}

	public List<Cheque> obtenerChequesDisponibles(){
		return this.disponibles;
	}
	
	public List<Cheque> obtenerChequesPagos(){
		return this.pagos;
	}
	
}
