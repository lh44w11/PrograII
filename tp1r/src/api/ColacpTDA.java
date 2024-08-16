package api;

public interface ColacpTDA {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	int Primero();
	boolean ColaVacia();
	int Prioridad();
	ColacpTDA CombinarColasCP(ColacpTDA cp1, ColacpTDA cp2);
	boolean sonIdenticas(ColacpTDA cp1, ColacpTDA cp2);
}
