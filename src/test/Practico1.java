package test;

import estructuraAB.ArbolBinario;

/*
 *  Algoritmos II - Practico 1
 */
public class Practico1 {

	public static void main(String[] args) {

		ArbolBinario arbol = crearArbol();

		arbol.getRaiz().insertarHijo(4);
		arbol.getRaiz().insertarHijo(3);
		if (arbol.existe(3)) {
			System.out.println(" Existe " + 3);
		}
		arbol.imprimir();
		arbol.cantidadDeHojas();
		System.out.println(" Cantidad de hojas: " + arbol.cantidadDeHojas());
	}

	private static ArbolBinario crearArbol() {
		ArbolBinario arbolBinario = new ArbolBinario(5);
		return arbolBinario;
	}

}
