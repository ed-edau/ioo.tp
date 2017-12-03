/*
 *  TP: Pantalla principal que abra las pantallas del reporte, cargar cheques de terceros, administrar pagos (monto y devuelve cheques), depositar cheques
 *  formulario principal + pantallas
 *  clases del modelo
*/

package uade.ioo.principal;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.JFormularioChequesDepositados;
import uade.ioo.vista.formularios.JFormularioChequesDisponibles;
import uade.ioo.vista.formularios.JFormularioChequesLog;
import uade.ioo.vista.formularios.JFormularioChequesPagos;
import uade.ioo.vista.formularios.JFormularioPrincipal;
import uade.ioo.vista.formularios.JFormularioReporte;

public class Principal {

	public static void main(String[] args) {
		
		AdministradorPagos modelo = new AdministradorPagos();
		
		JFrame formMenu = new JFormularioPrincipal(modelo);
		formMenu.setVisible(true);
		
		JFrame formReporte = new JFormularioReporte(modelo);
		formReporte.setVisible(true);
		
		JFrame formListaCheques = new JFormularioChequesLog(modelo);
		formListaCheques.setVisible(true);

		JFrame formListaChequesDisp = new JFormularioChequesDisponibles(modelo);
		formListaChequesDisp.setVisible(true);
		
		JFrame formListaChequesDepo = new JFormularioChequesDepositados(modelo);
		formListaChequesDepo.setVisible(true);
		
		JFrame formListaChequesPago = new JFormularioChequesPagos(modelo);
		formListaChequesPago.setVisible(true);
	}

}