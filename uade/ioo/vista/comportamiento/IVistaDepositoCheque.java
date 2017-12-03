package uade.ioo.vista.comportamiento;

import java.time.LocalDate;

public interface IVistaDepositoCheque {
	int getNumero(int r, int c);
	LocalDate getFechaEmision(int r, int c);
	double getMonto(int r, int c);
	int getFilas();
}
