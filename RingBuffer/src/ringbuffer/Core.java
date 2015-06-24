package ringbuffer;

import java.time.LocalDateTime;

public class Core extends Thread {

	private RingBuffer rb;
	private Metadata metadata;

	private LoaderThread loader;
	private MapperThread mapper;
	private DrawThread drawer;
	
	private int ringbufferSize;
	private int numberOfItems;
	
	public Core(int ringbufferSize, int numberOfItems) {
		metadata = new Metadata();
		this.ringbufferSize = ringbufferSize;
		this.numberOfItems = numberOfItems;
	}
	
	@Override
	public synchronized void start() {
		long i = System.currentTimeMillis();
		String inicio = LocalDateTime.now().toString();
		runRingBuffer();
		String fim = LocalDateTime.now().toString();
		long f = System.currentTimeMillis();
		clear();
		System.out.println("Duração: "+((f-i)/1000.0)+" segundos.");
		System.out.println("Inicio:\t"+inicio);
		System.out.println("Fim:\t"+fim);
	}
	
	private void runRingBuffer() {
		rb = new RingBuffer(ringbufferSize, numberOfItems);
		loader = new LoaderThread(rb);
		mapper = new MapperThread(metadata, rb);
		drawer = new DrawThread(rb);
		//
		while (!rb.isEnded()) {
			loader.run();
			mapper.run();
			drawer.run();
		}
		//
		/*
		try {
			loader.start();
			loader.join();
			mapper.start();
			mapper.join();
			drawer.start();
			drawer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		/*
		loader.start();
		mapper.start();
		drawer.start();
		*/
	}
	
	private void clear() {
		rb = null;
		loader = null;
		mapper = null;
		drawer = null;
		System.gc();
	}
	
}