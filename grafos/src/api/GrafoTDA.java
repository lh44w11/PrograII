package api;

public interface GrafoTDA {
	void InicializarGrafo();
	void AgregarVertice(int v);
	void EliminarVertice(int v);
	void AgregarArista(int v1, int v2, int peso);
	void EliminarArista(int v1, int v2);
	int PesoArista(int v1, int v2);
	ConjuntoTDA Vertices();
	boolean ExisteArista(int v1, int v2);
	ConjuntoTDA AdyacentesDobles(GrafoTDA grafo, int vertice);
	ConjuntoTDA Predecesores(GrafoTDA grafo, int vertice);
	ConjuntoTDA Aislados(GrafoTDA grafo);
	ConjuntoTDA Puentes(GrafoTDA grafo, int vertice1, int vertice2);
	int Grado(GrafoTDA grafo, int vertice);
	ConjuntoTDA Vecinos(GrafoTDA grafo, int vertice1, int vertice2);
}
