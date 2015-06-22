package ringbuffer;

import ringbuffer.RingBufferItem.TYPE;

public class RingBuffer {
	
	private RingBufferItem[] buffer;
	private int pointerPublisher;
	private int pointerModifier;
	private int pointerConsumer;
	
	//control and response
	private final int minimumSize = 3;
	private boolean pub;
	private boolean mod;
	private RingBufferItem rbi;
	
	public RingBuffer(int bufferSize) {
		this.buffer = new RingBufferItem[bufferSize>minimumSize?bufferSize:minimumSize];
	}
	
	public synchronized boolean publish(RingBufferItem o) {
		pub = true;
		rbi = buffer[pointerPublisher];
		if (rbi==null) {
			buffer[pointerPublisher] = o;
			pointerPublisher = addToPointer(pointerPublisher);
			} else {
			pub = false;
		}
		return pub;
	}
	
	public synchronized RingBufferItem acess() {
		rbi = buffer[pointerModifier];
		if (rbi.getType()==TYPE.DATA) {
			return rbi;
		} else {
			return null;
		}
	}
	
	public synchronized RingBufferItem consume() {
		rbi = buffer[pointerConsumer];
		buffer[pointerConsumer] = null;
		pointerConsumer = addToPointer(pointerConsumer);
		return rbi;
	}
	
	private synchronized int addToPointer(int pointer) {
		return pointer == buffer.length-1 ? 0 : pointer+1;
	}
	
}