package ringbuffer;

public class Core {

	private RingBuffer rb;
	private Metadata metadata;

	private LoaderThread loader;
	private MapperThread mapper;
	private DrawThread drawer;

	public Core() {
		metadata = new Metadata();
	}

	public void runRingBuffer(int ringbufferSize, int numberOfItems) {
		rb = new RingBuffer(ringbufferSize, numberOfItems);
		loader = new LoaderThread(rb);
		mapper = new MapperThread(metadata, rb);
		drawer = new DrawThread(rb);
		while (!rb.isEnded()) {
			loader.run();
			mapper.run();
			drawer.run();
		}
	}
	
}