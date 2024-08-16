package implem;

import api.ColaTDA;
import api.PilaTDA;

public class Cola implements ColaTDA {
	int [] a;
	int indice;
	
	public void InicializarCola() {
		a = new int [100];
		indice = 0;
	}
	
	public void Acolar(int x) {
		for (int i = indice-1; i>=0; i--) {
			a[i+1] = a[i];
		}
		a[0] = x;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public boolean ColaVacia() {
		return (indice == 0);
	}
	
	public int Primero() {
		return a[indice-1];
	}
	
	public ColaTDA PasarCola(ColaTDA origen) {
		ColaTDA destino = new Cola();
		destino.InicializarCola();
		while (!origen.ColaVacia()) {
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
		return destino;
	}
	
	public ColaTDA InvertirCola(ColaTDA cola) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		while (!cola.ColaVacia()) {
			aux.Apilar(cola.Primero());
			cola.Desacolar();
		}
		while (!aux.PilaVacia()) {
			cola.Acolar(aux.Tope());
			aux.Desapilar();
		}
		return cola;
	}
	
	//
	
	public boolean CoincideFinal(ColaTDA c1, ColaTDA c2) {
		int c1ult = 0;
		int c2ult = 0;
		while (!c1.ColaVacia()) {
			c1ult = c1.Primero();
			c1.Desacolar();
		}
		while (!c2.ColaVacia()) {
			c2ult = c2.Primero();
			c2.Desacolar();
		}
		return c1ult == c2ult;
	}
	
	public boolean esCapicua(ColaTDA cola) {
		int elemento = 0;
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		ColaTDA c = new Cola();
		c.InicializarCola();
		while (!cola.ColaVacia()) {
			elemento = cola.Primero();
			aux.Apilar(elemento);
			c.Acolar(elemento);
			cola.Desacolar();
		}
		while (!aux.PilaVacia() && !c.ColaVacia()) {
			if (aux.Tope() != c.Primero()) {
				return false;
			}
			aux.Desapilar();
			c.Desacolar();
		}
		return aux.PilaVacia() && c.ColaVacia();
	}
	
	public boolean esInversa(ColaTDA c1, ColaTDA c2) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		while (!c2.ColaVacia()) {
			aux.Apilar(c2.Primero());
			c2.Desacolar();
		}
		while (!aux.PilaVacia()) {
			c2.Acolar(aux.Tope());
			aux.Desapilar();
		}
		while (!c1.ColaVacia() && !c2.ColaVacia()) {
			if (c1.Primero() != c2.Primero()) {
				return false;
			}
			c1.Desacolar();
			c2.Desacolar();
		}
		return c1.ColaVacia() && c2.ColaVacia();
	}
}
