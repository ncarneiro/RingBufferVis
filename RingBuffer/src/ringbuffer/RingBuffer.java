package ringbuffer;

import ringbuffer.RingBufferItem.TYPE;

public class RingBuffer {
	
	private RingBufferItem[] buffer;
	private int pointerPublisher;
	private int pointerModifier;
	private int pointerConsumer;
	
	//control and response
	private final int minimumSize = 3;
	//private boolean pub;
	//private boolean mod;
	private RingBufferItem rbi;
	
	public RingBuffer(int bufferSize) {
		this.buffer = new RingBufferItem[bufferSize>minimumSize?bufferSize:minimumSize];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = new RingBufferItem();
		}
		pointerPublisher = 0;
		pointerModifier = 0;
		pointerConsumer = 0;
	}
	
	public synchronized RingBufferItem publish() {
		rbi = buffer[pointerPublisher];
		if (rbi.getType()==TYPE.EMPTY) {
			pointerPublisher = addToPointer(pointerPublisher);
			return rbi;
		} else {
			return null;
		}
	}
	
	public synchronized RingBufferItem acess() {
		rbi = buffer[pointerModifier];
		if (rbi.getType()==TYPE.DATA) {
			pointerModifier = addToPointer(pointerModifier);
			return rbi;
		} else {
			return null;
		}
	}
	
	public synchronized RingBufferItem consume() {
		rbi = buffer[pointerConsumer];
		if (rbi.getType()==TYPE.DRAWING) {
			pointerConsumer = addToPointer(pointerConsumer);
			return rbi;
		} else {
			return null;
		}
	}
	
	private synchronized int addToPointer(int pointer) {
		return pointer == buffer.length-1 ? 0 : pointer+1;
	}
	
}