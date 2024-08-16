package prin;

import api.ColacpTDA;
import implem.ColaCP;

public class Prin3 {
	
	public static void MostrarColaCP(ColacpTDA cp) {
		while (!cp.ColaVacia()) {
			System.out.print(cp.Primero());
			cp.Desacolar();
		}
	}

	public static void main(String[] args) {
		ColacpTDA cp1 = new ColaCP();
		cp1.InicializarCola();
		ColacpTDA cp2 = new ColaCP();
		cp2.InicializarCola();
		cp1.AcolarPrioridad(1, 2);
		cp1.AcolarPrioridad(3, 4);
		cp2.AcolarPrioridad(1, 2);
		cp2.AcolarPrioridad(3, 4);
		boolean cp = cp1.sonIdenticas(cp1, cp2);
		System.out.print(cp);

	}

}
