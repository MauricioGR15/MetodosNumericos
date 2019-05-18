package Trabajos;

import java.util.Scanner;

public class MetodoMontante {

	Scanner sc=new Scanner(System.in);
	int orden;
	double matriz[][];
	
	public MetodoMontante(){
		
		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nSOLUCION DE SISTEMAS DE "
				+ "ECUACIONES POR METODO DE LA MONTANTE\nHORA: 10-11\n");
		
		inputMatriz();
		System.out.println("\nMatriz de datos");
		printMatriz();
		int i,j;
		double pivAnt=1;
		for(j=0;j<orden;j++){
			double piv=matriz[j][j];
			for(i=0;i<orden;i++)
				for(int k=0;k<orden+1;k++){
					if(i!=j && k!=j)
						matriz[i][k]=((piv*matriz[i][k])-(matriz[i][j]*matriz[j][k]))/pivAnt;
				}
			for(i=0;i<orden;i++){
				if(i!=j)
					matriz[i][j]=0;			
			}
			pivAnt=piv;
		}
		System.out.println("Matriz transformada");
		printMatriz();
		System.out.println("Matriz unitaria");
		hacerMatrizUnitaria();
		printMatriz();
		hacerVariables();
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

	public void printMatriz() {
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(j == matriz[i].length-1) {
					System.out.print("= " + matriz[i][j] +"\n");
					continue;
				}
				System.out.print(matriz[i][j]+"\t");
			}
		}
		System.out.println();
	}

	public void hacerMatrizUnitaria(){
		for(int i=0;i<matriz.length;i++){
			matriz[i][matriz[i].length-1]=matriz[i][matriz[i].length-1]/matriz[i][i];
			matriz[i][i]=matriz[i][i]/matriz[i][i];
		}
	}

	public void hacerVariables(){
		for(int i=0;i<matriz.length;i++) 
			System.out.println("X"+(i+1)+" = "+matriz[i][matriz[i].length-1]);
	}

	public static void main(String[] args) {
		new MetodoMontante();
	}
}
