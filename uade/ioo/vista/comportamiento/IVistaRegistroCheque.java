package uade.ioo.vista.comportamiento;

import java.time.LocalDate;

public interface IVistaRegistroCheque {
	int getNumero();
	LocalDate getFechaEmision();
	double getMonto();
}
