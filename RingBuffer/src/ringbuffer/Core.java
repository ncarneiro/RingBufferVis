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
	//private String dataset = "Datasets/Dataset1000000D.csv";
	private String dataset = "Datasets/Dataset1000000D.csv";
	
	public Core(int ringbufferSize, int numberOfItems) {
		metadata = new Metadata(dataset);
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
		loader = new LoaderThread(dataset, rb);
		mapper = new MapperThread(metadata, rb);
		drawer = new DrawThread(rb);
		//
		while (!rb.isEnded()) {
			loader.run();
			mapper.run();
			drawer.run();
		}
		drawer.exit();
		//
		/*
		Thread[] threads = {loader, mapper, drawer};
		for (Thread t : threads) {
				t.start();
		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	
	private void clear() {
		drawer.exit();
		rb = null;
		loader = null;
		mapper = null;
		drawer = null;
		System.gc();
	}
	
}