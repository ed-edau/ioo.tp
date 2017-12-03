package uade.ioo.vista.modeloVista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.Cheque;

public class TablaChequesDisponibles extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Cheque> listaCheques;
	
	public TablaChequesDisponibles(List<Cheque> lista){
		this.listaCheques = lista;
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return this.listaCheques.size()+1;
	}

	@Override
	public Object getValueAt(int fila, int col) {
		if(fila == 0){
			if(col == 0)
				return "<html><b>N° Cheque</b></html>";
			if(col == 1)
				return "<html><b>Fecha Emisión</b></html>";
			if(col == 2)
				return "<html><b>Monto ▽</b></html>";
			if(col == 3)
				return "<html><b>Tipo</b></html>";
		}
		if(col == 0)
			return this.listaCheques.get(fila-1).getNumero();
		if(col == 1)
			return this.listaCheques.get(fila-1).getFechaEmision();
		if(col == 2)
			return this.listaCheques.get(fila-1).getMonto();
		if(col == 3)
			return this.listaCheques.get(fila-1).getTipo();
		return "";
	}

}
