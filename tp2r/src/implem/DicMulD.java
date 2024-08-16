package implem;

import api.DicMulTDA;
import api.ConjuntoTDA;

public class DicMulD implements DicMulTDA { 
	class NodoClave {
		int clave;
		NodoValor valores;
		NodoClave sigClave;
	}
	
	class NodoValor {
		int valor;
		NodoValor sigValor;
	}
	
	NodoClave origen;
	
	public void InicializarDiccionario() {
		origen = null;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if (nc==null) {
			nc = new NodoClave();
			nc.clave=clave;
			nc.sigClave=origen;
			origen = nc;
		}
		NodoValor aux = nc.valores;
			while (aux!=null && aux.valor!=valor) {
				aux = aux.sigValor;
			}
			if (aux==null) {
				NodoValor nv = new NodoValor ();
				nv.valor = valor;
				nv.sigValor = nc.valores;
				nc.valores = nv;
			}
		}
			
	private NodoClave Clave2NodoClave (int clave) {
		NodoClave aux = origen;
		while (aux!=null && aux.clave!=clave) {
			aux = aux. sigClave;
		}
		return aux;
			
	}
		
	public void EliminarValor(int clave, int valor) {
		if (origen!=null) {
			if (origen.clave == clave) {
				EliminarValorEnNodo(origen, valor);
			}
			if (origen.valores==null) {
				origen = origen.sigClave;
			} 
			else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave!=clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave.valores!=null) {
					EliminarValorEnNodo(aux.sigClave, valor);
					if (aux.sigClave.valores==null) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}	
	}
		

	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if (nodo.valores!=null) {
			if (nodo.valores.valor == valor) {
				nodo.valores = nodo.valores.sigValor;
			}
			else {
				NodoValor aux = nodo.valores;
				while (aux.sigValor != null && aux.sigValor.valor !=valor) {
					aux = aux.sigValor;
				}
				if (aux.sigValor!=null) {
					aux.sigValor = aux.sigValor.sigValor;
				}
			} 
		}
	}
			
	public void Eliminar(int clave) {
		if (origen!=null) {
			if (origen.clave == clave) {
				origen = origen.sigClave;
			}
			else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave!=clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave!=null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}
	
	public ConjuntoTDA Recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);
		
		ConjuntoTDA c = new ConjuntoD();
		c.InicializarConjunto();
		if (n!=null) {
			NodoValor aux = n.valores;
			while (aux != null) {
				c.Agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		return c;
	}
	
	public ConjuntoTDA Claves() {
		
		ConjuntoTDA c = new ConjuntoD();
		c.InicializarConjunto();
		
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}
	
	public DicMulTDA combinar(DicMulTDA dm1, DicMulTDA dm2) {
		DicMulTDA resultado = new DicMulD();
		resultado.InicializarDiccionario();
		ConjuntoTDA claves1 = dm1.Claves();
		ConjuntoTDA claves2 = dm2.Claves();
		while (!claves1.ConjuntoVacio() || !claves2.ConjuntoVacio()) {
			if (!claves1.ConjuntoVacio()) {
				int num1 = claves1.Elegir();
				ConjuntoTDA valores1 = dm1.Recuperar(num1);
				while (!valores1.ConjuntoVacio()) {
					int num2 = valores1.Elegir();
					resultado.Agregar(num1, num2);
					valores1.Sacar(num2);
				}
				claves1.Sacar(num1);
			}
			if (!claves2.ConjuntoVacio()) {
				int num3 = claves2.Elegir();
				ConjuntoTDA valores2 = dm2.Recuperar(num3);
				while (!valores2.ConjuntoVacio()) {
					int num4 = valores2.Elegir();
					resultado.Agregar(num3, num4);
					valores2.Sacar(num4);
				}
				claves2.Sacar(num3);
			}
		}
		return resultado;
	}
	
	// CombinarMismasClaves;
}