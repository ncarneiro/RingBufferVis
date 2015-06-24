package testes;

import ringbuffer.Core;
import ringbuffer.Metadata;

public class Testes3 {

	public static void main(String[] args) {
		int tamanhoDoRingbuffer = 1024;
		int espera = 12;//em segundos
		
		Metadata metadata = new Metadata();
		Core c = new Core(tamanhoDoRingbuffer, metadata.getNumberOfItems());
		
		try {
		    Thread.sleep(espera*1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		c.start();
	}
	
}
