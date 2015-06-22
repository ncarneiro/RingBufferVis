package testes;

import java.io.IOException;

import javax.xml.crypto.MarshalException;

import ringbuffer.DrawThread;
import ringbuffer.LoaderThread;
import ringbuffer.MapperThread;
import ringbuffer.Metadata;
import ringbuffer.RingBuffer;

public class Testes3 {

	public static void main(String[] args) {

		RingBuffer rb = new RingBuffer(1024);
		LoaderThread loader = null;
		try {
			loader = new LoaderThread(rb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Metadata metadata = new Metadata();
		MapperThread mapper = new MapperThread(metadata, rb);
		DrawThread drawer = new DrawThread(rb);
		
		loader.run();
		mapper.run();
		drawer.run();
	}	
}
