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
	
	public void registrarChequeTercero(Cheque cheque){
		
		int i = 0;
		LocalDate hoy = LocalDate.now();
		
		// inserto los cheques no vencidos ordenados por su monto descendente en la tabla "disponibles"
		
		if (cheque.getFechaEmision().plusDays(30).isAfter(hoy.minusDays(1))){			
			if (this.disponibles.size() > 0)
				while (this.disponibles.size() > i && this.disponibles.get(i).getMonto() >= cheque.getMonto())
					i++;
			if (this.disponibles.size() <= i)
				this.disponibles.add(cheque);
			else this.disponibles.add(i, cheque);
		}
		
		/*
		 *  si están por vencer, los inserto en la tabla "avencer"
		 *  deben estar en los últimos 10 días antes de vencer >
		 *  (fechaHoy - 10) < (fechaEmision + 30) < (fechaHoy)
		 */
		
		if(cheque.getFechaEmision().plusDays(30).isAfter(hoy.minusDays(1)) && cheque.getFechaEmision().plusDays(30).isBefore(hoy.plusDays(10)))
			this.avencer.add(cheque);
		
		// todos los cheques van al log
		
		this.cheques.add(cheque);
		
		this.notificarObservadores();
	}
	
	public void depositarChequeTercero(Cheque cheque){
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
		this.cheques.add(cheque);
		if (cheque.getTipo() == "Propio")
			this.numero.setUltimoNumero();
		this.notificarObservadores();
	}
	
	public void borrarChequesParaPagar(){
		this.cheques.removeAll(this.paraPagar);
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
