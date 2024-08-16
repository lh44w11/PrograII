package prin;

import api.ColaTDA;
import implem.Cola;

public class Prin2 {
	
	public static void MostrarCola(ColaTDA cola) {
		while (!cola.ColaVacia()) {
			System.out.print(cola.Primero());
			cola.Desacolar();
		}
	}

	public static void main(String[] args) {
		ColaTDA c1 = new Cola();
		c1.InicializarCola();
		c1.Acolar(1);
		c1.Acolar(2);
		c1.Acolar(3);
		ColaTDA c2 = new Cola();
		c2.InicializarCola();
		c2.Acolar(1);
		c2.Acolar(2);
		c2.Acolar(1);
		boolean c = c1.esInversa(c1, c2);
		System.out.print(c);
	}

}
