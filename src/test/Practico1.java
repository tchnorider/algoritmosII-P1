package test;

import estructuraAB.ArbolB;
import estructuraABB.ArbolBB;

/*
 *  Algoritmos II - Practico 1
 */
public class Practico1 {

	public static void main(String[] args) {

		ejercicio1();

		ejercicio2();

		ejercicio3();

	}

	private static void ejercicio1() {
		// getting the binary tree ready for the first exercise
		// arbol.getRaiz().insertarHijo(4);
		ArbolB arbolBin = new ArbolB();
		Integer hijo1 = 1, hijo2 = 2, hijo3 = 3;

		arbolBin.getRaiz().insertarHijo(hijo1);
		arbolBin.getRaiz().insertarHijo(hijo2);
		arbolBin.getRaiz().insertarHijo(hijo3);

		// a - quantity of nodes
		arbolBin.cantidadDeHojas();
		System.out.println(" Cantidad de nodos: " + arbolBin.cantidadDeNodos());

		// b - quantity of leaves
		arbolBin.cantidadDeHojas();
		System.out.println(" Cantidad de hojas: " + arbolBin.cantidadDeHojas());

	}

	private static void ejercicio2() {
		// TODO Auto-generated method stub

	}

	private static void ejercicio3() {

		ArbolBB arbolBinBusqueda = new ArbolBB();
		Integer hijo1 = 1, hijo2 = 2, hijo3 = 3;

		arbolBinBusqueda.insertar(hijo1);
		arbolBinBusqueda.insertar(hijo2);
		arbolBinBusqueda.insertar(hijo3);

		if (arbolBinBusqueda.existe(hijo2)) {
			System.out.println(" Existe " + hijo2);
		}
		arbolBinBusqueda.imprimir();
	}
}
