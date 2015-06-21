package testes;

import ringbuffer.ContinuousAttribute;

public class Testes2 {
	
	public static void main(String[] args) {
		ContinuousAttribute continuo = new ContinuousAttribute(50, -50);
		System.out.println(continuo.convertToInterval(1, 3, 2.5));
	}
	
}