package Trabajos;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MetodoSecante {
	
	double x1,x2,x3,fx1,fx2,fx3;
	double error = 0.0001;
	int cont = 1;
	DecimalFormat df = new DecimalFormat("#.000000");
	
	MetodoSecante(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Metodo de la secante \nf(x) = x^3+2x^2+7x-20");
		System.out.print("Ingrese intervalo abierto a: ");
		double a = sc.nextDouble();
		System.out.print("Ingrese intervalo abierto b: ");
		double b = sc.nextDouble();
		System.out.print("Ingrese total de calculos: ");
		int tc = sc.nextInt();
		MetodoSec(tc,a,b);
		
		sc.close();
	}
	
	public void MetodoSec(int tc, double x1, double x2) {
		while(cont<tc) {
			fx1 = (x1*x1*x1)+(2*(x1*x1))+(7*x1)-20;
			fx2 = (x2*x2*x2)+(2*(x2*x2))+(7*x2)-20;
			
			x3 = x1-(((x1-x2)*fx1)/(fx1-fx2));
			fx3 = (float) (Math.pow(x3, 3) + (2*Math.pow(x3, 2)) + (7*x3) -20);
			
			System.out.println("NC " + cont + "\t| x1 " + df.format(x1)+"\t| x2 "
					+df.format(x2)+"\t| x3 " +df.format(x3)+"\t| f(x1) "
					+df.format(fx1)+"\t| f(x2) "+df.format(fx2)+"\t| f(x3) "+df.format(fx3));
			
			if(Math.abs(fx3)<=error) {
				System.out.println("La raiz es >>> "+ x3);
				break;
			}
			
			cont++;
			
			if(cont>tc) {
				System.out.println("No hay solucion ");
				break;
			}
			x1=x2;
			x2=x3;
			fx1=fx2;
			fx2=fx3;	
		}
	}
	
	public static void main(String [] args) {
		new MetodoSecante();
	}
}
