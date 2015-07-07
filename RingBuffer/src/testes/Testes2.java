package testes;

import ringbuffer.LoaderThread;

public class Testes2 {
	
	public static void main(String[] args) {
		//String dataset = "Datasets/Dataset1000000D.csv";
		String dataset = "Datasets/Dataset20000D.csv";
		LoaderThread.getMetadata(dataset);
	}
	
}