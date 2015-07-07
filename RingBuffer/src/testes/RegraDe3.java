package testes;

public class RegraDe3 {
	
	public static void main(String[] args) {
		double minA = 0;
		double maxA = 500;
		double valB = 9.1;
		double minB = 0.36074108369511776;
		double maxB = 9.759113984698196;
		
		double d = r3(minA, minB, maxA, maxB, valB);
		System.out.println(d);
	}
	
	public static double r3(double minA, double minB, double maxA, double maxB, double valB) {
		double ajusteA = minA*-1;
		double ajusteB = minB*-1;
		double result = (valB+ajusteB)*(maxA+ajusteA)/(maxB+ajusteB);
		result-=ajusteA;
		return result;
	}
	
}