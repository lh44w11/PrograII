package implem;

import api.ColacpTDA;

public class ColaCP implements ColacpTDA {
	int [] elementos;
	int [] prioridades;
	int indice;
	
	public void InicializarCola() {
		indice = 0;
		elementos = new int[100];
		prioridades = new int [100];
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		for ( ; j>0 && prioridades[j-1] >= prioridad; j--) {
			elementos[j] = elementos[j-1];
			prioridades[j] = prioridades[j-1];
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;	
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public int Primero() {
		return elementos[indice-1];
	}
	
	public boolean ColaVacia() {
		return (indice == 0);
	}
	
	public int Prioridad() {
		return prioridades[indice-1];
	}
	
	public ColacpTDA CombinarColasCP(ColacpTDA cp1, ColacpTDA cp2) {
		ColacpTDA resul = new ColaCP();
		resul.InicializarCola();
		while (!cp1.ColaVacia() && !cp2.ColaVacia()) {
			if (cp1.Prioridad() > cp2.Prioridad()) {
				resul.AcolarPrioridad(cp1.Primero(), cp1.Prioridad());
				cp1.Desacolar();
			} 
			else if (cp1.Prioridad() == cp2.Prioridad()){
				resul.AcolarPrioridad(cp1.Primero(), cp1.Prioridad());
				cp1.Desacolar();
			}
			else {
				resul.AcolarPrioridad(cp2.Primero(), cp2.Prioridad());
				cp2.Desacolar();
			}
		}
		while (!cp1.ColaVacia()) {
			resul.AcolarPrioridad(cp1.Primero(), cp1.Prioridad());
			cp1.Desacolar();
		}
		while (!cp2.ColaVacia()) {
			resul.AcolarPrioridad(cp2.Primero(), cp2.Prioridad());
			cp2.Desacolar();
		}
		return resul;
	}
	
	public boolean sonIdenticas(ColacpTDA cp1, ColacpTDA cp2) {
		while (!cp1.ColaVacia() && !cp2.ColaVacia()) {
			if ((cp1.Primero() != cp2.Primero()) || (cp1.Prioridad() != cp2.Prioridad())) {
				return false;
			}
			cp1.Desacolar();
			cp2.Desacolar();
		}
		return cp1.ColaVacia() && cp2.ColaVacia();
	}
}

