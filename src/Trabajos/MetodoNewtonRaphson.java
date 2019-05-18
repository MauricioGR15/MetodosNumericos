package Trabajos;

import java.text.DecimalFormat;
import java.util.*;

public class MetodoNewtonRaphson {
	
	public MetodoNewtonRaphson() {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.####");
		
		ArrayList<Double> soluciones = new ArrayList<Double>();
		double fx,fxI,fxII,fx2;
		double x1,x2,error;
		int tc,nc;		
		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nSOLUCION POR METODO NEWTON RAPHSON");
		System.out.println("f(x) = x^2 + cos(x^2) - 2");
		System.out.print("Ingrese a del intervalo [a,b]: ");
		double a = sc.nextDouble();
		System.out.print("Ingrese b del intervalo [" +a+",b]: ");
		double b = sc.nextDouble();
		System.out.print("Ingrese el error: ");
		error = sc.nextDouble();
		System.out.print("Ingrese el total de calculos: ");
		tc = sc.nextInt();
		
		
		
		while(a<=b) {
			nc=1;
			x1=a;
			System.out.println("\nValor de x1 = " +a);
			System.out.println("nc \t\tx1 \t\tf(x1) \t\tf'(x1) \t\tf''(x1) \tx2 \t\tf(x2)");
			while(nc<=tc){
				
				fx = funcion(x1);
				fxI = derivada(x1);
				fxII = segundaDerivada(x1);
				
				x2 = x1 - (fx/(fxI-((fx*fxII)/(2*fxI))));
				fx2 = funcion(x2);
				
				System.out.println(df.format(nc)+"\t\t"+ df.format(x1)+"\t\t"+ df.format(fx )+"\t\t" + df.format(fxI)+"\t\t" 
									+ df.format(fxII)+ "\t\t" + df.format(x2 )+ "\t\t" + df.format(fx2));
				
				if(Math.abs(fx2)<=error) {
					System.out.println("\nLa raiz solucion es >>> " + x2);
					soluciones.add(x2);
					break;
				}
				
				nc++;
				
				if(nc>tc) {
					System.out.println("\nTotal de calculos superado: No hay solucion");
					break;
				}
				
				x1=x2;
				fx=fx2;
			}
			a++;
			
		}
		
		Set<Double> hs = new HashSet<>();
		hs.addAll(soluciones);
		soluciones.clear();
		soluciones.addAll(hs);
		
		
		System.out.println("Las raices encontradas son: ");
		System.out.println(soluciones);
		
		sc.close();
	}
	
	
	
	public static void main(String[]a) {
		new MetodoNewtonRaphson();
	}
	
	
	public double funcion(double x) {
		return (x*x)+(Math.cos(x*x))-2;
	}
	
	public double derivada(double x) {
		return (2*x) - ((2*x)*(Math.sin(x*x)));
	}
	
	public double segundaDerivada(double x) {
		return 2 - (4*(x*x) * Math.cos(x*x)) - (2*Math.sin(x*x));
	}
	

}
