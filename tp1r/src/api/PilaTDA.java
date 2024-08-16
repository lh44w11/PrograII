package api;

public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
	PilaTDA PasarPilaInvertida(PilaTDA origen);
	PilaTDA CopiarPila(PilaTDA origen);
	int ContarElementosPila(PilaTDA pila);
	int SumarElementosPila(PilaTDA pila);
	int PromedioElementosPila(PilaTDA pila);
}
