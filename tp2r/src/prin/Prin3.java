package prin;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;
import implem.ColaD;
import implem.ConjuntoD;
import implem.PilaD;

public class Prin3 {
	
	public static void MostrarConjunto(ConjuntoTDA c) {
		int elemento = 0;
		while (!c.ConjuntoVacio()) {
			elemento = c.Elegir();
			System.out.print(elemento);
			c.Sacar(elemento);
		}
	}

	public static void main(String[] args) {
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		PilaTDA pila = new PilaD();
		pila.InicializarPila();
		ColaTDA cola = new ColaD();
		cola.InicializarCola();
		pila.Apilar(1);
		pila.Apilar(2);
		cola.Acolar(2);
		cola.Acolar(1);
		boolean c = conjunto.PenC(pila, cola);
		System.out.print(c);
		
		
	}

}
