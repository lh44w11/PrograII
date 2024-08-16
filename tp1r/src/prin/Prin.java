package prin;

import api.PilaTDA;
import implem.Pila;

public class Prin {
	
	public static void MostrarPila(PilaTDA pila) {
		while (!pila.PilaVacia()) {
			System.out.print(pila.Tope());
			pila.Desapilar();
		}
	}

	public static void main(String[] args) {
		PilaTDA pila = new Pila();
		pila.InicializarPila();
		pila.Apilar(6);
		pila.Apilar(8);
		MostrarPila(pila);
	}

}
