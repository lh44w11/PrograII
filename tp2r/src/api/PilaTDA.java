package api;

public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
	boolean esCapicua(PilaTDA pila);
	PilaTDA eliminarRepetidos(PilaTDA pila);
	void repartirMitades(PilaTDA pila);
	PilaTDA elementosRepetidos(PilaTDA pila);
}
