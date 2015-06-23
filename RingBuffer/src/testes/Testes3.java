package testes;

import ringbuffer.Core;
import ringbuffer.Metadata;

public class Testes3 {

	public static void main(String[] args) {
		Core c = new Core();
		Metadata metadata = new Metadata();
		for (int i = 0; i < 3; i++) {
			c.runRingBuffer(1024, metadata.getNumberOfItems());
			esperar(200000);
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
