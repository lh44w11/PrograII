package api;

public interface ConjuntoTDA {
	void InicializarConjunto();
	boolean ConjuntoVacio();
	void Agregar(int x);
	int Elegir();
	void Sacar(int x);
	boolean Pertenece(int x);
	boolean sonIguales(ConjuntoTDA c1, ConjuntoTDA c2);
	int cantidadElementos(ConjuntoTDA c);
	ConjuntoTDA generar(PilaTDA p, ColaTDA c);
	boolean PenC(PilaTDA p, ColaTDA c);
}
