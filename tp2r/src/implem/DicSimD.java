package implem;

import api.ConjuntoTDA;
import api.DicMulTDA;
import api.DicSimTDA;

public class DicSimD implements DicSimTDA {
	
	class NodoClave {
		int clave;
		int valor;
		NodoClave sigClave;
	}
	
	NodoClave origen;
	 
	public void InicializarDiccionario() {
		origen = null;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if (nc==null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;
	}
	
	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux!=null && aux.clave!=clave) {
			aux = aux.sigClave;
		}
		return aux;
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
				} if (aux.sigClave!=null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}
	
	public int Recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);
		return n.valor;
	}
	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c=new ConjuntoD();
		c.InicializarConjunto();
		
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}
	
	//
	
	public DicSimTDA MaS(DicMulTDA dm) {
		DicSimTDA resultado = new DicSimD();
		resultado.InicializarDiccionario();
		ConjuntoTDA claves = dm.Claves();
		while (!claves.ConjuntoVacio()) {
			int clave = claves.Elegir();
			ConjuntoTDA valores = dm.Recuperar(clave);
			int suma = 0;
			while (!valores.ConjuntoVacio()) {
				int valor = valores.Elegir();
				suma = suma + valor;
				valores.Sacar(valor);
			}
			resultado.Agregar(clave, suma);
			claves.Sacar(clave);
		}
		return resultado;
	}	
}
