package api;

public interface ColaTDA {
	void InicializarCola();
	void Acolar(int x);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	ColaTDA eliminarRepetidos(ColaTDA cola);
	void repartirMitades(ColaTDA cola);
	ColaTDA elementosRepetidos(ColaTDA cola);
}
