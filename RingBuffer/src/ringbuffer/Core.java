package ringbuffer;

public class Core {
	
	public static void main(String[] args) {
		Core m = new Core();
	}
	
	public void runRingBuffer(int ringbufferSize, int numberOfItems) {
		RingBuffer rb = new RingBuffer(1024, 5000);
		LoaderThread loader = new LoaderThread(rb);
		Metadata metadata = new Metadata();
		MapperThread mapper = new MapperThread(metadata, rb);
		DrawThread drawer = new DrawThread(rb);
		Runnable[] runs = {loader, mapper, drawer};
		//while (rb.isEnded()) {
		while (true) {
			if (rb.isEnded()) {
				break;
			} else {
				for (Runnable r : runs) {
					r.run();
				}
			}
		}
	}
	
}