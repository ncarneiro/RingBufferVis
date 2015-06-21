package testes;

import java.io.IOException;

import ringbuffer.DrawThread;
import ringbuffer.Loader;

public class Testes3 {

	public static void main(String[] args) {
		try {
			Loader.carregarBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
