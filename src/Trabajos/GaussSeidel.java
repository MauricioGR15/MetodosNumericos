package Trabajos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GaussSeidel {

	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#.000000");
	int orden;
	double[][] matriz;
	double[] vIni,vFin;

	public GaussSeidel() {
		
		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nSOLUCION DE SISTEMAS DE "
				+ "ECUACIONES POR GAUSS SEIDEL\nHORA: 10-11");
		System.out.println("PROBLEMA: UNA GRANJA AVICOLA INCLUYE UNA DIETA DE SUS AVES VITAMINAS B, C, D Y E,\n"
				+ "PARA EVITAR ENFERMEDADES, ASI COMO UN DESARROLLO MAS RAPIDO. LOS PRECIOS HAN INCREMENTADO\n"
				+ "EN UN 7.5% DEL AÑO ANTERIOR AL ACTUAL. UTILICE EL METODO DE GAUSS SEILDEL PARA SABER CUAL ES\n"
				+ "EL PRECIO DE CADA CAJA DE VITAMINAS CONSIDERANDO QUE EL PRECIO NO HAYA VARIADO EN EL PERIODO\n"
				+ "DE COMPRAS\n");
	
		
		inputMatriz();
		vFin = new double[orden];
		vIni = new double[orden];
		
		System.out.print("Unidad de medida: ");
		String unidad = sc.next();
		for(int i=0 ; i<orden ; i++) {
			System.out.print("Valor inicial de x"+(i+1)+": ");
			vIni[i]=sc.nextDouble();
		}
		
		System.out.println("\nMatriz de datos");
		printMatriz(matriz);
		
		System.out.println("Proceso de Gauss-Seidel\n");
		System.out.print("   n   ");
		for(int i=0; i<orden; i++) 
			System.out.print(" x"+(i+1)+"\t\t");
		System.out.println(" Error\t\t");
		double error=0, suma, coef;
		int n=0;
		System.out.print("   "+n+"   ");
		for(int i=0; i<orden; i++) 
			System.out.print(" "+vIni[i]+"\t\t");
		System.out.println(" "+error+"\t\t");
		
		while(error>0.001 || n==0) {
			n++;
			for(int i=0; i<orden; i++) {
				coef=matriz[i][i];
				suma=matriz[i][orden];
				for(int j=0; j<orden ;j++) {
					if(i==j)
						continue;
					if(j<i) 
						suma-=(matriz[i][j]*vFin[j]);
					else
						suma-=(matriz[i][j]*vIni[j]);
				}
				suma/=coef;
				vFin[i]=suma;
			}
			System.out.print("   "+n+"   ");
			error=0;
			for(int i=0; i<orden; i++) {
				System.out.print(" "+df.format(vFin[i])+"\t");
				error+=Math.abs(vFin[i]-vIni[i]);
				vIni[i]=vFin[i];
			}
			System.out.println(" "+df.format(error)+"\t");			
		}
		
		System.out.println("Resultados:");
		for(int i=0 ; i<orden; i++) 
			System.out.println(df.format(vFin[i]) + " " + unidad);
		
	}
	
	public void printMatriz(double aux[][]) {
		for(int i=0; i<aux.length; i++) {
			for(int j=0; j<aux[i].length; j++) {
				if(j == aux[i].length-1) {
					System.out.print("= " + df.format(matriz[i][j]) +"\n");
					continue;
				}
				System.out.print(aux[i][j]+"\t");
			}
		}
		System.out.println();
	}
	
	public void inputMatriz(){
		System.out.println("Teclee el orden de la matriz");
		orden=sc.nextInt();
		matriz=new double[orden][orden+1];
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz[i].length;j++){
				if(j==matriz[i].length-1){
					System.out.println("Teclee el resultado de la fila "+(i+1));
					matriz[i][j]=sc.nextDouble();
					continue;
				}	
				System.out.println("Ingrese el valor en ["+i+"]"+"["+j+"]");
				matriz[i][j]=sc.nextDouble();
			}
	}
	
	public static void main(String []a) {
		new GaussSeidel();

	}
}
