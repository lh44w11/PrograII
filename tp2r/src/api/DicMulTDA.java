package api;

public interface DicMulTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	ConjuntoTDA Recuperar(int clave);
	ConjuntoTDA Claves();
	DicMulTDA combinar(DicMulTDA dm1, DicMulTDA dm2);
//	DicMulTDA combinarMismasClaves(DicMulTDA dm1, DicMulTDA dm2);
}
