package implem;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;

public class ConjuntoD implements ConjuntoTDA {
	
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
	
	public boolean sonIguales(ConjuntoTDA c1, ConjuntoTDA c2) {
		int elemento = 0;
		while (!c1.ConjuntoVacio()) {
			elemento = c1.Elegir();
			if (!c2.Pertenece(elemento)) {
				return false;
			} else {
				c1.Sacar(elemento);
			}
		}
		return true;
	}
	
	public int cantidadElementos(ConjuntoTDA c) {
		int cant = 0;
		int elementoRandom = 0;
		while (!c.ConjuntoVacio()) {
			elementoRandom = c.Elegir();
			cant = cant + 1;
			c.Sacar(elementoRandom);
		}
		return cant;
	}
	
	public ConjuntoTDA generar(PilaTDA p, ColaTDA c) {
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		while (!p.PilaVacia()) {
			conjunto.Agregar(p.Tope());
			p.Desapilar();
		}
		while (!c.ColaVacia()) {
			conjunto.Agregar(c.Primero());
			c.Desacolar();
		}
		return conjunto;
	}
	
	public boolean PenC(PilaTDA p, ColaTDA c) {
		int elemento = 0;
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		while (!p.PilaVacia()) {
			elemento = p.Tope();
			conjunto.Agregar(elemento);
			p.Desapilar();
		}
		while (!c.ColaVacia()) {
			elemento = c.Primero();
			c.Desacolar();
			if (!conjunto.Pertenece(elemento)) {
				return false;
			}
		}
		return true;
	}
}
