package api;

public interface DicSimTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	int Recuperar(int clave);
	ConjuntoTDA Claves();
	DicSimTDA MaS(DicMulTDA dm);
}