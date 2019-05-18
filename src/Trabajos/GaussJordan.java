package Trabajos;

import java.util.Scanner;
import java.text.*;

public class GaussJordan {
	
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.##"); 
	double matriz [][],mC[][];
	int orden;
	
	public GaussJordan() {
		
		System.out.println("INSTITUTO TECNOLOGICO DE CULIACAN \nINGENIERA EN SISTEMAS COMPUTACIONALES"
				+ "\nMAURICIO GARCIA RUBIO \nMETODOS NUMERICOS \nSOLUCION DE SISTEMAS DE "
				+ "ECUACIONES POR GAUSS JORDAN\nHORA: 10-11\n");
		
		inputMatriz();
		System.out.println("Matriz de datos");
		printMatriz(matriz);
		System.out.println("Eliminacion con Gauss");
		printMatriz(eliminacionGauss(matriz));
		System.out.println("Eliminacion con Gauss-Jordan");
		printMatriz(eliminacionGaussJordan(matriz));
		calcularVariables(matriz);
	}
	
	public void calcularVariables(double[][]mat) {
		for(int i=0;i<mat.length;i++) 
				System.out.println("X"+(i+1)+" = " + df.format(mat[i][mat[i].length-1]/mat[i][i]));
	}
	
	public double[][] eliminacionGauss(double mat[][]) {
		double pivote;
		int aux;
		for(int i=0; i<mC.length-1; i++) {
			pivote = mC[i][i];
			aux = i;
			int j=i;
			while(aux<mC.length-1) {
				mC[aux+1][j] = (pivote*mat[aux+1][j])-(mat[aux+1][i]*mat[i][j]);
				if(j==mC[i].length-1) {
					j=i;
					aux++;
					continue;
				}
				j++;
			}
			mat = copiarMatriz(mat,mC);
		}
		return mat;
	}
	
	public double[][] eliminacionGaussJordan(double [][] mat) {
		double factor,pivote;
		for(int i=mat.length-1; i>0;i--) {
			int j = i;
			int aux = 0;
			pivote = mat[i][i];
			factor = mat[aux][i] / pivote;
			while(aux<i) {
				mC[aux][j]= mat[aux][j] - (factor*mat[i][j]);
				if(j==mC[i].length-1) {
					j=i;
					aux++;
					factor = mat[aux][i]/ pivote;
					continue;
				}
				j++;
			}
			mat = copiarMatriz(mat,mC);
		}
		return mat;
	}
	
	public void inputMatriz() {
		System.out.println("Teclee el orden de la Matriz");
		orden = sc.nextInt();
		matriz = new double [orden][orden+1];
		mC = new double [orden][orden+1];
		
		for(int i=0; i<orden;i++) {
			for(int j=0;j<orden+1;j++) {
				if(j==matriz[i].length-1) {
					System.out.println("Ingrese el valor de resultado de fila " + (i+1));
					double x = sc.nextDouble();
					matriz[i][j] = x;
					mC[i][j] = x;
					continue;
				}
				System.out.println("Ingrese un valor en [" +i+"]["+j+"]");
				double x = sc.nextDouble();
				matriz[i][j] = x;
				mC[i][j] = x;
			}
		}
	}
	
	public double[][] copiarMatriz(double mat[][],double mat2[][]) {
		for(int i=0; i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				double x = mat2[i][j];
				mat[i][j] = x;
			}
		}
		return mat;
	}
	
	public void printMatriz(double aux[][]) {
		for(int i=0;i<aux.length;i++) {
			for(int j=0;j<aux[i].length;j++) {
				if(j == aux[i].length-1) {
					System.out.print("= " + df.format(matriz[i][j]) +"\n");
					continue;
				}
				System.out.print(aux[i][j]+"\t");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new GaussJordan();
	}

}
