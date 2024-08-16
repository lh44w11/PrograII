package api;

public interface ArbolbTDA {
	int Raiz();
	ArbolbTDA HijoIzq();
	ArbolbTDA HijoDer();
	boolean ArbolVacio();
	void InicializarArbol();
	void AgregarElemento(int x);
	void EliminarElemento(int x);
	void preOrder(ArbolbTDA a);
	void inOrder(ArbolbTDA a);
	void postOrder(ArbolbTDA a);
	boolean ExisteElemento(ArbolbTDA a, int x);
	boolean EsHoja(ArbolbTDA a, int x);
	int CalcularProfundidadSegunElemento(ArbolbTDA a, int x);
	int MenorElemento(ArbolbTDA a);
	int CantidadElementos(ArbolbTDA a);
	int SumaElementos(ArbolbTDA a);
	int CantidadHojas(ArbolbTDA a);
	int Altura(ArbolbTDA a);
	boolean TienenMismaForma(ArbolbTDA a, ArbolbTDA b);
	boolean SonIguales(ArbolbTDA a, ArbolbTDA b);
	int ContarElementosSegunNivel(ArbolbTDA a, int nivObj, int nivAct);
	void MostrarElementosInOrden(ArbolbTDA a);
	void MostrarElementosMayoresQueK(ArbolbTDA a, int k);
	int ModeloParcial(ArbolbTDA a, ArbolbTDA b);
}
