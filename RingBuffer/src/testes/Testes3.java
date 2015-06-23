package testes;

import ringbuffer.Core;
import ringbuffer.Metadata;

public class Testes3 {

	public static void main(String[] args) {
		Core c = new Core();
		Metadata metadata = new Metadata();
		esperar(10000);
		for (int i = 0; i < 5; i++) {
			c.runRingBuffer(1024, metadata.getNumberOfItems());
			c.clear();
			esperar(50000);
			//esperar(10000);
		}
		
	}
	
	public static void esperar(long segundos) {
		long ti = System.currentTimeMillis();
		long tf = segundos+ti;
		while (tf>ti) {
			ti = System.currentTimeMillis();
		}
	}
	
}
