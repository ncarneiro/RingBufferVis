package testes;

import ringbuffer.Core;
import ringbuffer.Metadata;

public class Testes3 {

	public static void main(String[] args) {
		Core c = new Core();
		Metadata metadata = new Metadata();
		c.runRingBuffer(1024, metadata.getNumberOfItems());
	}

}
