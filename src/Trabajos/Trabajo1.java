package Trabajos;

import java.text.DecimalFormat;

public class Trabajo1 {

	public static void main(String[]a) {

		DecimalFormat df = new DecimalFormat("#.000000");

		double A = -14,B = 0,C = -5;
		double fa,fb = 0,fc;
		double error = 0.001;
		int tc = 50, nc = 0;


		System.out.println("f(x) = xcos(x^2)-4 \tIntervalo: ["+A+","+C+"]");

		while( nc <= tc) {

			fa = A * (Math.cos((A*A)*(Math.PI/180)))-4;
			fc = C * (Math.cos((C*C)*(Math.PI/180)))-4;

			if(fa * fc < 0) {
				B = (A+C)/2;
				fb = B * (Math.cos((B*B)*(Math.PI/180)))-4;
			}else {
				System.out.println("No hay solucion");
				break;
			}

			nc++;
			if(nc==50) {
				System.out.println("Total de calculos superado");
				break;
			}

			System.out.println("NC " + nc + "\t| A " + df.format(A)+"\t| B "
					+df.format(B)+"\t| C " +df.format(C)+"\t| f(a) "
					+df.format(fa)+"\t| f(b) "+df.format(fb)+"\t| f(c) "+df.format(fc));

			if(Math.abs(fb) <= error) {
				System.out.println("La raiz de la ecuacion es " + df.format(B));
				break;
			}

			if(fb * fc < 0) {	//Intervalo B C
				A = B;	
			}
			else { //Intervalo A B
				C = B;
			}
		}
	}


}
