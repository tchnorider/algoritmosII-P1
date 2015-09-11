package estructuraAB;

public class ArbolB {

	private Nodo raiz;
	private int cantNodos;
	private int cantHojas;
	private int peso;
	private int altura;

	public ArbolB() {
		this.raiz = null;
	}

	public ArbolB(int dato) {
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

	// Ejercicio 3 - a - insertar
	public void insertar(int x) {
		Nodo n = new Nodo(x);
		if (this.raiz == null) {
			this.raiz = n;
		} else {
			insertar(n, this.raiz);
		}
	}

	// Pre-condicion: n <> null
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

	public void imprimir() {
		imprimir(this.raiz);
	}

	private void imprimir(Nodo n) {
		if (n == null) {
			return;
		}
		System.out.println(n.getDato());
		imprimir(n.nodoIzq);
		imprimir(n.nodoDer);
	}

	public boolean existe(int d) {
		return existe(this.raiz, d);
	}

	// Use of the lazy operator ('||'): if the call with the left node returns
	// true then the right call never gets done because there's no need to
	// evaluate this return since either way the result will be true even if
	// this return is false.
	private boolean existe(Nodo n, int d) {
		if (n == null) {
			return false;
		}
		if (n.getDato() == d) {
			return true;
		}
		return existe(n.nodoIzq, d) || existe(n.nodoDer, d);
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

	// in order: evaluate right children first, then the father then the left children
	public void imprimirInOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		System.out.println(n.getDato());
		imprimirPostOrder(n.nodoIzq);
	}

	public String cantidadDeNodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
