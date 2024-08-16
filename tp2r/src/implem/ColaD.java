package implem;

import api.ColaTDA;
import api.ConjuntoTDA;

public class ColaD implements ColaTDA {
	
	Nodo primero;
	
	Nodo ultimo;
	
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}
	
	public void Acolar(int x) {
		
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		if (ultimo != null) {
			ultimo.sig = aux;
		}
		ultimo = aux;
		
		if (primero == null) {
			primero = ultimo;
		}
	}
	
	public void Desacolar() {
		primero = primero.sig;
		
		if (primero == null) {
			ultimo = null;
		}
	}
	
	public boolean ColaVacia() {
		return (ultimo == null);
	}
	
	public int Primero() {
		return primero.info;
	}
	
	public ColaTDA eliminarRepetidos(ColaTDA cola) {
		int elemento = 0;
		ColaTDA aux = new ColaD();
		aux.InicializarCola();
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		while (!cola.ColaVacia()) {
			elemento = cola.Primero();
			cola.Desacolar();
			if (!conjunto.Pertenece(elemento)) {
				aux.Acolar(elemento);
				conjunto.Agregar(elemento);
			} else {
				conjunto.Agregar(elemento);
			}
		}
		return aux;
	}
	
	public static void MostrarCola(ColaTDA cola) {
		while (!cola.ColaVacia()) {
			System.out.print(cola.Primero());
			cola.Desacolar();
		}
	}
	
	public void repartirMitades(ColaTDA cola) {
		int cant = 0;
		ColaTDA aux = new ColaD();
		aux.InicializarCola();
		ColaTDA M1 = new ColaD();
		M1.InicializarCola();
		ColaTDA M2 = new ColaD();
		M2.InicializarCola();
		
		while (!cola.ColaVacia()) {
			cant = cant + 1;
			aux.Acolar(cola.Primero());
			cola.Desacolar();
		}
		int mitad = cant/2;
		for (int i=0; i<mitad; i++) {
			M1.Acolar(aux.Primero());
			aux.Desacolar();
		}
		while (!aux.ColaVacia()) {
			M2.Acolar(aux.Primero());
			aux.Desacolar();
		}
		
		MostrarCola(M1);
		System.out.print("-");
		MostrarCola(M2);
	}
	
	public ColaTDA elementosRepetidos(ColaTDA cola) {
		int elemento = 0;
		ColaTDA aux = new ColaD();
		aux.InicializarCola();
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		while (!cola.ColaVacia()) {
			elemento = cola.Primero();
			cola.Desacolar();
			if (conjunto.Pertenece(elemento)) {
				aux.Acolar(elemento);
				conjunto.Agregar(elemento);
			} else {
				conjunto.Agregar(elemento);
			}
		}
		
		return aux;
	}
}
