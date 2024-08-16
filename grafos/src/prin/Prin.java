package prin;

import api.ConjuntoTDA;
import api.GrafoTDA;
import implem.Grafo;
  
public class Prin {
	
	public static void MostrarConjunto(ConjuntoTDA c) {
		while (!c.ConjuntoVacio()) {
			int a = c.Elegir();
			c.Sacar(a);
			System.out.println(a);
		}
	}
	

	public static void main(String[] args) {
		GrafoTDA a = new Grafo();
		a.InicializarGrafo();
		a.AgregarVertice(1);
		a.AgregarVertice(2);
		a.AgregarVertice(3);
		a.AgregarVertice(4);
		a.AgregarVertice(5);
		a.AgregarArista(1, 2, 3);
		a.AgregarArista(2, 3, 4);
		a.AgregarArista(3, 4, 5);
		a.AgregarArista(4, 2, 6);
		ConjuntoTDA resultado = a.Vecinos(a, 1, 4);
		MostrarConjunto(resultado);
	}

}
