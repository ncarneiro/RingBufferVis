package ringbuffer;

public class Main {
	
	public static void main(String[] args) {
		RingBuffer rb = new RingBuffer(1024);
		LoaderThread loader = new LoaderThread(rb);
		Metadata metadata = new Metadata();
		MapperThread mapper = new MapperThread(metadata, rb);
		DrawThread drawer = new DrawThread(rb);
		Runnable[] runs = {loader, mapper, drawer};
		while (true) {
			for (Runnable r : runs) {
				r.run();
			}
		}
	}
	
}