package api;

public interface ColaTDA {
	void InicializarCola();
	void Acolar(int x);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	ColaTDA PasarCola(ColaTDA origen);
	ColaTDA InvertirCola(ColaTDA cola);
	//
	boolean CoincideFinal(ColaTDA c1, ColaTDA c2);
	boolean esCapicua(ColaTDA cola);
	boolean esInversa(ColaTDA c1, ColaTDA c2);
}
