package Trabajos;
import java.util.*;

public class MetodoTrapecios {

	private Scanner sc = new Scanner(System.in);
	private double vri,error,errorC,A,b;
	private int nTrap, totC;

	private MetodoTrapecios() {

		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nMETODO DE LOS TRAPECIOS\nHORA: 10-11\n");

		System.out.println("PROBLEMA\nEn una juguetería la producción de un empleado está dada y definida por " +
				"cada día del mes \nque trabaja por la integral definida en f(x) = x^3 - sen (x+1) " +
				"\n¿Cuál será la producción del empleado del día 2 al día 6 del mes?");
		ingresoDatos();
		MetTrapecios();

	}

	private void MetTrapecios(){
		double a = A,h,ah;
		int c = 0;
		double fa,fah,Area = 0;
		do{
			if(c>totC){
				System.out.println("\n\nEl total de calculos ha sido superado");
				return;
			}
			h = (b-A) / nTrap;
			System.out.printf("\n%s \t%s \t\t%s \t\t%s \t\t%s", "No", "a","a+h","f(a)","f(a+h)");
			for (int i = 1; i<=nTrap;i++){
				ah = a + h;
				fa = funcion(a);
				fah = funcion(ah);
				Area += (h*(fa+fah))/2;
				System.out.printf("\n%d \t%.6f \t%.6f \t%.6f \t%.6f", i, a, ah, fa, fah );
				a = ah;
			}
			System.out.printf("\nNo Trapecios: %d \nArea: %.6f\n", nTrap, Area);
			errorC = Math.abs(vri-Area);
			a = A;
			Area = 0;
			nTrap++;
			c++;
		}while(error<errorC);
	}

	private double funcion (double x){
		return (Math.pow(x,3) - (Math.sin(x)+1));
	}

	private void ingresoDatos(){
		System.out.println("Ingrese el valor real de la integral: ");
		vri = sc.nextDouble();
		System.out.println("Ingrese el número inicial de trapecios: ");
		nTrap = sc.nextInt();
		System.out.println("Ingrese el error de aproximación: ");
		error = sc.nextDouble();
		System.out.println("Ingrese el total de calculos: ");
		totC = sc.nextInt();
		System.out.println("Ingrese A: ");
		A = sc.nextInt();
		System.out.println("Ingrese B: ");
		b = sc.nextInt();
		sc.close();
	}

	public static void main(String[] args) {
		new MetodoTrapecios();
	}
}
