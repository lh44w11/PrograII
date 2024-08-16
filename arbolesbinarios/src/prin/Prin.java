package prin;

import api.ArbolbTDA;
import api.ConjuntoTDA;
import implem.ArbolB;
import implem.Conjunto;

public class Prin {
	
	public ConjuntoTDA NodosPares(ArbolbTDA a) {
		ConjuntoTDA c = new Conjunto();
		c.InicializarConjunto();
		
		if (!a.ArbolVacio()) {
			if (a.Raiz() % 2 == 0) {
				c.Agregar(a.Raiz());
			}
		}
		ConjuntoTDA rI = NodosPares(a.HijoDer());
		ConjuntoTDA rD = NodosPares(a.HijoIzq());
		while (!rI.ConjuntoVacio()) {
			int x = rI.Elegir();
			c.Agregar(x);
			rI.Sacar(x);
		}
		while (!rD.ConjuntoVacio()) {
			int x = rD.Elegir();
			c.Agregar(x);
			rD.Sacar(x);
		}
		return c;
	}
	
	public static void main(String[] args) {
		ArbolbTDA a = new ArbolB();
        a.InicializarArbol();
        a.AgregarElemento(20);
        a.AgregarElemento(10);
        a.AgregarElemento(30);
        a.AgregarElemento(5);
        a.AgregarElemento(15);
        a.AgregarElemento(25);
        a.AgregarElemento(35);
        ArbolbTDA b = new ArbolB();
        b.InicializarArbol();
        b.AgregarElemento(20);
        b.AgregarElemento(10);
        b.AgregarElemento(30);
        b.AgregarElemento(5);
        b.AgregarElemento(15);
        b.AgregarElemento(25);
        int resultado = a.ModeloParcial(a, b);
        System.out.print(resultado);
	}
}
