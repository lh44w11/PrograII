package prin;

import api.ColaTDA;
import implem.ColaD;

public class Prin2 {

	public static void MostrarCola(ColaTDA cola) {
		while (!cola.ColaVacia()) {
			System.out.print(cola.Primero());
			cola.Desacolar();
		}
	}
	
	public static void main(String[] args) {
		ColaTDA cola = new ColaD();
		cola.InicializarCola();
		cola.Acolar(6);
		cola.Acolar(8);
		cola.Acolar(2);
		cola.Acolar(8);
		cola.Acolar(8);
		cola.Acolar(7);
		cola.Acolar(7);
		ColaTDA c = cola.elementosRepetidos(cola);
		MostrarCola(c);
		
	}

}
