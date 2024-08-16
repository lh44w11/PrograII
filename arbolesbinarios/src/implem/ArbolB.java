package implem;

import api.ArbolbTDA;

public class ArbolB implements ArbolbTDA {
	NodoABB raiz;
	
	public int Raiz() {
		return raiz.info;
	}
	
	public boolean ArbolVacio() {
		return (raiz == null);
	}
	
	public void InicializarArbol() {
		raiz = null;
	}
	
	public ArbolbTDA HijoDer() {
		return raiz.hijoDer;
	}

	public ArbolbTDA HijoIzq() {
		return raiz.hijoIzq;
	}
	
	public void AgregarElemento(int x) {
		if (raiz == null) {
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ArbolB();
			raiz.hijoIzq.InicializarArbol();
			raiz.hijoDer = new ArbolB();
			raiz.hijoDer.InicializarArbol();
		}
		else if (raiz.info > x) {
			raiz.hijoIzq.AgregarElemento(x);
		}
		else if (raiz.info < x) {
			raiz.hijoDer.AgregarElemento(x);
		}
	}
	
	public void EliminarElemento(int x) {
		if (raiz != null) {
			if (raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
				raiz = null;
			}
			else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.info = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.EliminarElemento(raiz.info);
			}
			else if (raiz.info == x && raiz.hijoIzq.ArbolVacio()) {
				raiz.info = this.menor(raiz.hijoDer);
				raiz.hijoDer.EliminarElemento(raiz.info);
			}
			else if (raiz.info < x) {
				raiz.hijoDer.EliminarElemento(x);
			}
			else {
				raiz.hijoIzq.EliminarElemento(x);
			}
		}
	}
	
	private int mayor(ArbolbTDA a) {
		if (a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		}
		else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor(ArbolbTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		}
		else {
			return menor(a.HijoIzq());
		}
	}
	
	public void preOrder(ArbolbTDA a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
	
	public void inOrder(ArbolbTDA a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	public void postOrder(ArbolbTDA a) {
		if (!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}
	
	public boolean ExisteElemento(ArbolbTDA a, int x) {
		if (a.ArbolVacio()) {
			return false;
		}
		if (x==a.Raiz()) {
			return true;
		}
		if (x<a.Raiz()) {
			return ExisteElemento(a.HijoIzq(), x);
		}
		else {
			return ExisteElemento(a.HijoDer(), x);
		}
	}
	
	public boolean EsHoja(ArbolbTDA a, int x) {
		if (a.ArbolVacio()) {
			return false;
		}
		if (x==a.Raiz()) {
			if (a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio()) {
				return true;
			}
			else {
				return false;
			}
		}
		if (x<a.Raiz()) {
			return EsHoja(a.HijoIzq(), x);
		}
		else {
			return EsHoja(a.HijoDer(), x);
		}
	}
	
	public int CalcularProfundidadSegunElemento(ArbolbTDA a, int x) {
		if (x==a.Raiz()) {
			return 0;
		}
		if (x<a.Raiz()) {
			return 1 + CalcularProfundidadSegunElemento(a.HijoIzq(), x);
		}
		else {
			return 1 + CalcularProfundidadSegunElemento(a.HijoDer(), x);
		}
	}
	
	public int MenorElemento(ArbolbTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		}
		else {
			return MenorElemento(a.HijoIzq());
		}
	}
	
	public int CantidadElementos(ArbolbTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		}
		return 1 + CantidadElementos(a.HijoIzq()) + CantidadElementos(a.HijoDer());
	}
	
	public int SumaElementos(ArbolbTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		}
		return a.Raiz() + SumaElementos(a.HijoIzq()) + SumaElementos(a.HijoDer());
	}
	
	public int CantidadHojas(ArbolbTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		}
		if (a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio()) {
			return 1;
		}
		return CantidadHojas(a.HijoIzq()) + CantidadHojas(a.HijoDer());
	}
	
	public int Altura(ArbolbTDA a) {
		if (a.ArbolVacio()) {
			return -1;
		}
		if (a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio()) {
			return 0;
		}
		int alturaIzq = Altura(a.HijoIzq());
		int alturaDer = Altura(a.HijoDer());
		
		return 1 + Math.max(alturaIzq, alturaDer);
	}
	
	public boolean TienenMismaForma(ArbolbTDA a, ArbolbTDA b) {
		if (a.ArbolVacio() && b.ArbolVacio()) {
			return true;
		}
		if (a.ArbolVacio() || b.ArbolVacio()) {
			return false;
		}
		return TienenMismaForma(a.HijoIzq(), b.HijoIzq()) && TienenMismaForma(a.HijoDer(), b.HijoDer());
	}
	
	public boolean SonIguales(ArbolbTDA a, ArbolbTDA b) {
		if (a.ArbolVacio() && b.ArbolVacio()) {
			return true;
		}
		if (a.ArbolVacio() || b.ArbolVacio()) {
			return false;
		}
		if (a.Raiz()!=b.Raiz()) {
			return false;
		}
		return SonIguales(a.HijoIzq(), b.HijoIzq()) && SonIguales(a.HijoDer(), b.HijoDer());
	}
	
	public int ContarElementosSegunNivel(ArbolbTDA a, int nivObj, int nivAct) {
		if (a.ArbolVacio()) {
			return 0;
		}
		if (nivAct==nivObj) {
			return 1;
		}
		return ContarElementosSegunNivel(a.HijoIzq(), nivObj, nivAct + 1) + ContarElementosSegunNivel(a.HijoDer(), nivObj, nivAct + 1);
	}
	
	public void MostrarElementosInOrden(ArbolbTDA a) {
		if (!a.ArbolVacio()) {
			System.out.print(a.Raiz() + " ");
			MostrarElementosInOrden(a.HijoIzq());
			MostrarElementosInOrden(a.HijoDer());
		}
	}
	
	public void MostrarElementosMayoresQueK(ArbolbTDA a, int k) {
		if (!a.ArbolVacio()) {
			if (a.Raiz()>k) {
				System.out.print(a.Raiz() + " ");
				MostrarElementosMayoresQueK(a.HijoIzq(), k);
			}
			MostrarElementosMayoresQueK(a.HijoDer(), k);
		}
	}
	
	public int ModeloParcial(ArbolbTDA a, ArbolbTDA b) {
		int menorA = menor(a);
		int mayorA = mayor(a);
		int resultadoA = mayorA - menorA;
		
		int menorB = menor(b);
		int mayorB = mayor(b);
		int resultadoB = mayorB - menorB;
		
		return resultadoA - resultadoB;
	}
}