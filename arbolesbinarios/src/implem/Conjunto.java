package implem;

import api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	
	Nodo c;
	
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}
	}
	
	public boolean ConjuntoVacio() {
		return (c == null);
	}
	
	public int Elegir() {
		return c.info;
	}
	
	public void InicializarConjunto() {
		c = null;
	}
	
	public boolean Pertenece(int x) {
		Nodo aux = c;
		while ((aux != null) && (aux.info != x)) {
			aux = aux.sig;
		}
		return (aux != null);
	}
	
	public void Sacar(int x) {
		if (c!=null) {
			if (c.info == x) {
				c = c.sig;
			} else {
				Nodo aux = c;
				while (aux.sig!=null && aux.sig.info!=x) {
					aux = aux.sig;
				}
				if (aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}
}
