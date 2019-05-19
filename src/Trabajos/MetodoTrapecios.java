package Trabajos;

import java.text.DecimalFormat;
import java.util.*;

public class MetodoTrapecios {

	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.######");
	double vri,error;
	int nTrap, totC;

	public MetodoTrapecios() {

		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nMETODO DE LOS TRAPECIOS\nHORA: 10-11\n");

		System.out.println("PROBLEMA\nEn una juguetería la producción de un empleado está dada y definida \npor " +
				"cada día del mes que trabaja por la integral definida en f(x) = x^3 - sen (x+1) " +
				"\n ¿Cuál será la producción del empleado del día 2 al día 6 del mes?");



	}

	public void ingresoDatos(){
		System.out.println("Ingrese el valor real de la integral: ");
		vri = sc.nextDouble();
		System.out.println("Ingrese el número inicial de trapecios: ");
		nTrap = sc.nextInt();
		System.out.println("Ingrese el error de aproximación: ");
		error = sc.nextDouble();
		System.out.println("Ingrese el total de calculos: ");
		totC = sc.nextInt();
	}

	public static void main(String[] args) {
		new MetodoTrapecios();
	}
}
