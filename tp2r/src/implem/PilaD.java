package implem;

import api.PilaTDA;
import api.ColaTDA;
import api.ConjuntoTDA;

public class PilaD implements PilaTDA {
	
	Nodo primero;
	
	public void InicializarPila() {
		primero = null;
	}
	
	public void Apilar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = primero;
		primero = aux;
	}
	
	public void Desapilar() {
		primero = primero.sig;
	}
	
	public boolean PilaVacia() {
		return (primero == null);
	}
	
	public int Tope() {
		return primero.info;
	}
	
	public boolean esCapicua(PilaTDA pila) {
		int elemento = 0;
		PilaTDA aux = new PilaD();
		aux.InicializarPila();
		ColaTDA prim = new ColaD();
		prim.InicializarCola();
		while (!pila.PilaVacia()) {
			elemento = pila.Tope();
			aux.Apilar(elemento);
			prim.Acolar(elemento);
			pila.Desapilar();
		}
		while (!prim.ColaVacia()) {
			if (aux.Tope() != prim.Primero()) {
				return false;
			} else {
				aux.Desapilar();
				prim.Desacolar();
			}
		}
		return aux.PilaVacia() && prim.ColaVacia();
	}
	
	public PilaTDA eliminarRepetidos(PilaTDA pila) {
		int elemento = 0;
		PilaTDA aux = new PilaD();
		aux.InicializarPila();
		ColaTDA cola = new ColaD();
		cola.InicializarCola();
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		
		while (!pila.PilaVacia()) {
			elemento = pila.Tope();
			pila.Desapilar();
			if (!conjunto.Pertenece(elemento)) {
				cola.Acolar(elemento);
				conjunto.Agregar(elemento);
			}
		}
		while (!cola.ColaVacia()) {
			aux.Apilar(cola.Primero());
			cola.Desacolar();
		}
		while (!aux.PilaVacia()) {
			pila.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return pila;
	}
	
	public static void MostrarCola(ColaTDA cola) {
		while (!cola.ColaVacia()) {
			System.out.print(cola.Primero());
			cola.Desacolar();
		}
	}
	
	public void repartirMitades(PilaTDA pila) {
		int cant = 0;
		PilaTDA aux = new PilaD();
		aux.InicializarPila();
		ColaTDA M1 = new ColaD();
		M1.InicializarCola();
		ColaTDA M2 = new ColaD();
		M2.InicializarCola();
		while (!pila.PilaVacia()) {
			cant = cant + 1;
			aux.Apilar(pila.Tope());
			pila.Desapilar();
		}
		int mitad = cant/2;
		for (int i=0; i<mitad; i++) {
			M1.Acolar(aux.Tope());
			aux.Desapilar();
		}
		while (!aux.PilaVacia()) {
			M2.Acolar(aux.Tope());
			aux.Desapilar();
		}
		
		MostrarCola(M1);
		System.out.print("-");
		MostrarCola(M2);
		
	}
	 
	public PilaTDA elementosRepetidos(PilaTDA pila) {
		int elemento = 0;
		PilaTDA aux = new PilaD();
		aux.InicializarPila();
		ColaTDA cola = new ColaD();
		cola.InicializarCola();
		ConjuntoTDA conjunto = new ConjuntoD();
		conjunto.InicializarConjunto();
		while (!pila.PilaVacia()) {
			elemento = pila.Tope();
			pila.Desapilar();
			if (conjunto.Pertenece(elemento)) {
				cola.Acolar(elemento);
			} else {
				conjunto.Agregar(elemento);
			}
		}
		while (!cola.ColaVacia()) {
			aux.Apilar(cola.Primero());
			cola.Desacolar();
		}
		while (!aux.PilaVacia()) {
			pila.Apilar(aux.Tope());
			aux.Desapilar();;
		}
		return pila;
	}
} 
