package estructuraABB;

import estructuraAB.ArbolB;
import estructuraAB.NodoAB;
import estructuraAG.ArbolG;
import estructuraAG.NodoG;

public class ArbolBB {

	private Nodo raiz;
	private int cantNodos;
	private int cantHojas;
	private int peso;
	private int altura;

	public ArbolBB() {
		this.raiz = null;
	}

	public ArbolBB(int dato) {
		this.raiz = new Nodo();
		raiz.setDato(dato);
		this.cantHojas = 0;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantHojas() {
		return cantHojas;
	}

	public void setCantHojas(int cantHojas) {
		this.cantHojas = cantHojas;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Nodo getRaiz() {
		return this.raiz;
	}

	// E.3 |A| Insert
	public void insertar(int x) {
		Nodo n = new Nodo(x);
		if (this.raiz == null) {
			this.raiz = n;
		} else {
			insertar(n, this.raiz);
		}
	}

	// Precondition: n <> null
	private void insertar(Nodo n, Nodo raiz) {
		if (raiz.getDato() > n.getDato()) {
			if (n.nodoIzq == null) {
				n.nodoIzq = n;
			} else {
				insertar(n, n.nodoIzq);
			}
		} else {
			if (n.nodoDer == null) {
				n.nodoDer = n;
			} else {
				insertar(n, n.nodoDer);
			}
		}
	}

	// E.3 |B| TODO: TEST
	public void borrarMinimo() {
		if (this.raiz == null) {
			return;
		}
		borrarMin(this.raiz);
	}

	private void borrarMin(Nodo nodo) {
		if (nodo.nodoIzq == null) {
			nodo.nodoIzq = null;
		} else {
			borrarMin(nodo.nodoIzq);
		}
	}

	// E.3 |D| Belongs(x)
	public boolean pertenece(int x) {
		return pertenece(x, this.raiz);
	}

	private boolean pertenece(int x, Nodo n) {
		if (n == null) {
			return false;
		}
		if (n.getDato() == x) {
			return true;
		} else {
			return x > n.getDato() ? pertenece(x, n.nodoDer) : pertenece(x, n.nodoIzq);
		}
	}

	public void imprimirAsc() {
		imprimirAsc(this.raiz);
	}

	private void imprimirAsc(Nodo n) {
		if (n == null) {
			return;
		}
		System.out.println(n.getDato());
		imprimirAsc(n.nodoIzq);
		imprimirAsc(n.nodoDer);
	}

	public void imprimirDesc() {
		imprimirDesc(this.raiz);
	}

	private void imprimirDesc(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirAsc(n.nodoIzq);
		imprimirAsc(n.nodoDer);
		System.out.println(n.getDato());
	}

	public Nodo buscar(int d) {
		return buscar(this.raiz, d);
	}

	private Nodo buscar(Nodo n, int d) {
		if (n == null) {
			return null;
		}
		if (n.getDato() == d) {
			return n;
		}

		Nodo nodoAux = buscar(n.nodoIzq, d);
		if (nodoAux == null) {
			return buscar(n.nodoDer, d);
		} else {
			return nodoAux;
		}
	}

	public int cantidadDeHojas() {
		return cantidadDeHojas(this.raiz);
	}

	private int cantidadDeHojas(Nodo n) {
		if (n == null) {
			return cantHojas;
		}
		if (n.nodoIzq == null) {
			this.cantHojas++;
		} else if (n.nodoDer == null) {
			this.cantHojas++;
		}
		cantidadDeHojas(n.nodoIzq);
		cantidadDeHojas(n.nodoDer);
		return this.cantHojas;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(Nodo n) {
		if (n == null) {
			return -1;
		}
		int altIzq = altura(n.nodoIzq);
		int altDer = altura(n.nodoDer);
		return 1 + (altIzq > altDer ? altIzq : altDer);
	}

	// Pre order: the father gets evaluated first
	public void imprimirPreOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPreOrder(n.nodoDer);
		imprimirPreOrder(n.nodoIzq);
	}

	// Post order: the children gets evaluated first
	public void imprimirPostOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		imprimirPostOrder(n.nodoIzq);
		System.out.println(n.getDato());
	}

	// in order: evaluate right children first, then the father then the left
	// children
	public void imprimirInOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		System.out.println(n.getDato());
		imprimirPostOrder(n.nodoIzq);
	}

	// Mover el transformar al Arbol Binario: clase ArbolB
	public ArbolG transformar() {
		ArbolG arbolG = new ArbolG();
		if (this.raiz != null) {
			arbolG.raiz = new NodoG(this.getRaiz().getDato());
			return transformar(this.raiz, arbolG.raiz);
		}
		return null;
	}
	
	private ArbolG transformar(Nodo raizBin, NodoG raizG) {
		if (raizBin == null) {
			return null;
		}
		if(raizBin.nodoIzq!=null){
			NodoG nG = new NodoG(raizBin.nodoIzq.getDato());
			raizG.primerHijo = nG;
		}else{
			raizG.primerHijo = null;
		}
		if(raizBin.nodoDer!=null){
			NodoG nG = new NodoG(raizBin.nodoDer.getDato());
			raizG.sigHermano = nG;
		}else{
			raizG.sigHermano = null;
		}
		return transformar(raizBin.nodoIzq,raizG.primerHijo);		
	}
	
	// Mover el transformar al Arbol Binario: clase ArbolB
	public ArbolG transformarClase(ArbolB a) {
		ArbolG arbolG = new ArbolG();
		if (a.getRaiz() != null) {
			arbolG.raiz = new NodoG(a.getRaiz().getDato());
			transformarClase(a.getRaiz(), arbolG.raiz);
		}
		return arbolG;
	}

	private void transformarClase(NodoAB a, NodoG n) {
		if (a == null) {
			return;
		}
		if(a.nodoIzq!=null){
			NodoG nG = new NodoG(a.nodoIzq.getDato());
			n.primerHijo = nG;
			transformarClase(a.nodoIzq,n.primerHijo);
		}
		if(a.nodoDer!=null){
			if(n.primerHijo!=null){
				NodoG nG = new NodoG(a.nodoDer.getDato());
				n.primerHijo.sigHermano = nG;
				transformarClase(a.nodoDer,n.sigHermano);	
			}else{
				NodoG nG = new NodoG(a.nodoDer.getDato());
				n.primerHijo=nG;
				transformarClase(a.nodoDer, nG.primerHijo);
			}
		}
	}

	public void borrarElemento(Integer hijo) {
		// TODO Auto-generated method stub

	}

	public void insertarOrdenado(Integer entero) {
		// TODO Auto-generated method stub

	}

}
