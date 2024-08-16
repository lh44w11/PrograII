package implem;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class Grafo implements GrafoTDA {

	static int n = 100;
	int [][] MAdy; 
	int [] Etiqs; 
	int cantNodos;
	
	public void InicializarGrafo() {
		MAdy = new int[n] [n];
		Etiqs = new int [n];
		cantNodos = 0;
	}

	public void AgregarVertice(int v) {
		Etiqs[cantNodos] = v;
		for (int i=0; i<=cantNodos; i++) {
			MAdy[cantNodos][i] = 0;
			MAdy[i][cantNodos] = 0;
		}
		cantNodos++;
	}

	public void EliminarVertice(int v) {
		int ind = Vert2Indice(v);
		Etiqs[ind] = Etiqs[cantNodos-1];
		for(int k = 0; k<cantNodos; k++) {
			MAdy[ind][k] = MAdy[cantNodos-1][k];
		}
		for (int k=0; k<cantNodos; k++) {
			MAdy[k][ind] = MAdy[k][cantNodos - 1];
		}
		cantNodos--;
	}
	 
	public ConjuntoTDA Vertices() {
		ConjuntoTDA Vert = new Conjunto();
		Vert.InicializarConjunto();
		for (int i =0; i<cantNodos; i++) {
			Vert.Agregar(Etiqs[i]);
		}
		return Vert;
	}

	private int Vert2Indice(int v) {
		int i= cantNodos -1;
		while(i >=0 && Etiqs[i]!= v)
			i--;
		return i;
	}
	
	public void AgregarArista(int v1, int v2, int peso) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = peso;
	}

	public void EliminarArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = 0;
	}

	public boolean ExisteArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return MAdy[o][d]!=0;
	}

	public int PesoArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return MAdy[o][d];
	}
	
	public ConjuntoTDA AdyacentesDobles(GrafoTDA grafo, int vertice) {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while(!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			if (grafo.ExisteArista(vertice, a)) {
				
				ConjuntoTDA vertices2 = grafo.Vertices();
				
				while (!vertices2.ConjuntoVacio()) {
					int b = vertices2.Elegir();
					vertices2.Sacar(b);
					
					if (grafo.ExisteArista(a, b)) {
						resultado.Agregar(b);
					}
				}
			}
		}
		return resultado;
	}
	
	public ConjuntoTDA Predecesores(GrafoTDA grafo, int vertice) {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while (!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			if (grafo.ExisteArista(a, vertice)) {
				resultado.Agregar(a);
			}
		}
		return resultado;
	}
	
	public ConjuntoTDA Aislados(GrafoTDA grafo) {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while (!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			boolean aislado = true;
			
			ConjuntoTDA vertices2 = grafo.Vertices();
			
			while (!vertices2.ConjuntoVacio()) {
				int b = vertices2.Elegir();
				vertices2.Sacar(b);
				
				if (grafo.ExisteArista(a, b) || grafo.ExisteArista(b, a)) {
					aislado = false;
				}
			}
			if (aislado==true) {
				resultado.Agregar(a);
			}
		}
		return resultado;
	}
	
	public ConjuntoTDA Puentes(GrafoTDA grafo, int vertice1, int vertice2) {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while (!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			if (grafo.ExisteArista(vertice1, a) && grafo.ExisteArista(a, vertice2)) {
				resultado.Agregar(a);
			}
		}
		return resultado;
	}
	
	public int Grado(GrafoTDA grafo, int vertice) {
		int grado1 = 0;
		int grado2 = 0;
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while (!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			if (grafo.ExisteArista(vertice, a)) {
				grado1++;
			}
			
			if (grafo.ExisteArista(a, vertice)) {
				grado2++;
			}
		}
		return grado2-grado1;
	}
	
	public ConjuntoTDA Vecinos(GrafoTDA grafo, int vertice1, int vertice2) {
		ConjuntoTDA resultado = new Conjunto();
		resultado.InicializarConjunto();
		
		ConjuntoTDA vertices = grafo.Vertices();
		
		while (!vertices.ConjuntoVacio()) {
			int a = vertices.Elegir();
			vertices.Sacar(a);
			
			if (grafo.ExisteArista(vertice1, a) && grafo.ExisteArista(vertice2, a)) {
				resultado.Agregar(a);
			}
		}
		return resultado;
	}
}

