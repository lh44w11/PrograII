package implem;

import api.PilaTDA;

public class Pila implements PilaTDA {
	int [] a;
	int indice;
	
	public void InicializarPila() {
		a = new int [100];
		indice = 0;
	}
	
	public void Apilar(int x) {
		a[indice] = x;
		indice++;
	}
	
	public void Desapilar() {
		indice--;
	}
	
	public boolean PilaVacia() {
		return (indice == 0);
	}
	
	public int Tope() {
		return a[indice-1];
	}
	
	public PilaTDA PasarPilaInvertida(PilaTDA origen) {
		PilaTDA destino = new Pila();
		destino.InicializarPila();
		while (!origen.PilaVacia()) {
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
		return destino;
	}
	
	public PilaTDA CopiarPila(PilaTDA origen) {
		PilaTDA aux = new Pila();
		aux.InicializarPila();
		PilaTDA destino = new Pila();
		destino.InicializarPila();
		while (!origen.PilaVacia()) {
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		while (!aux.PilaVacia()) {
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return destino;
	}
	
	public int ContarElementosPila(PilaTDA pila) {
		int cant = 0;
		while (!pila.PilaVacia()) {
			cant = cant + 1;
			pila.Desapilar();
		}
		return cant;
	}
	
	public int SumarElementosPila(PilaTDA pila) {
		int suma = 0;
		while (!pila.PilaVacia()) {
			suma = suma + pila.Tope();
			pila.Desapilar();
		}
		return suma;
	}
	
	public int PromedioElementosPila(PilaTDA pila) {
		int cant = 0;
		int suma = 0;
		int promedio = 0;
		while (!pila.PilaVacia()) {
			cant = cant + 1;
			suma = suma + pila.Tope();
			pila.Desapilar();
		}
		promedio = suma/cant;
		
		return promedio;
	}
}
