package prin;

import api.PilaTDA;
import implem.PilaD;

public class Prin {
	
	public static void MostrarPila(PilaTDA pila) {
		PilaTDA aux = new PilaD();
		aux.InicializarPila();;
		while (!pila.PilaVacia()) {
			aux.Apilar(pila.Tope());
			pila.Desapilar();
		}
		while (!aux.PilaVacia()) {
			System.out.print(aux.Tope());
			aux.Desapilar();
		}
	}

	public static void main(String[] args) {
		PilaTDA pila = new PilaD();
		pila.InicializarPila();
		pila.Apilar(6);
		pila.Apilar(8);
		pila.Apilar(2);
		pila.Apilar(8);
		pila.Apilar(8);
		pila.Apilar(7);
		pila.Apilar(7);
		//pila.repartirMitades(pila);
		PilaTDA p = pila.elementosRepetidos(pila);
		MostrarPila(p);
	}

}
