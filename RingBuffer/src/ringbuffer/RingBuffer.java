package ringbuffer;

import ringbuffer.RingBufferItem.TYPE;

public class RingBuffer {

	private RingBufferItem[] buffer;
	private int pointerPublisher;
	private int pointerModifier;
	private int pointerConsumer;
	
	private int counter;
	private int max;
	private volatile boolean ended;
	
	// control and response
	private final int minimumSize = 3;
	// private boolean pub;
	// private boolean mod;
	private RingBufferItem rbi;

	public RingBuffer(int bufferSize, int totalItems) {
		this.buffer = new RingBufferItem[bufferSize > minimumSize ? bufferSize : minimumSize];
		//this.buffer = new RingBufferItem[3];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = new RingBufferItem();
		}
		pointerPublisher = 0;
		pointerModifier = 0;
		pointerConsumer = 0;
		this.max = totalItems;
		this.counter = 0;
		this.ended = false;
	}

	public synchronized RingBufferItem publish() {
		rbi = buffer[pointerPublisher];
		if (rbi.getType() == TYPE.EMPTY) {
			pointerPublisher = addToPointer(pointerPublisher);
			return rbi;
		} else {
			return null;
		}
	}

	public synchronized RingBufferItem acess() {
		rbi = buffer[pointerModifier];
		if (rbi.getType() == TYPE.DATA) {
			pointerModifier = addToPointer(pointerModifier);
			return rbi;
		} else {
			return null;
		}
	}

	public synchronized RingBufferItem consume() {
		rbi = buffer[pointerConsumer];
		if (rbi.getType() == TYPE.DRAWING) {
			pointerConsumer = addToPointerCount(pointerConsumer);
			return rbi;
		} else {
			return null;
		}
	}
	
	private synchronized int addToPointerCount(int pointer) {
		addToTotal();
		return pointer == buffer.length - 1 ? 0 : pointer + 1;
	}
	
	private synchronized int addToPointer(int pointer) {
		return pointer == buffer.length - 1 ? 0 : pointer + 1;
	}
	
	private synchronized void addToTotal() {
		counter++;
		//System.out.println(counter+"\t"+max);
		if (counter>=max) {
			ended = true;
			//System.out.println(ended);
		}
	}
	
	public synchronized boolean isEnded() {
		return ended;
	}
	
	@Override
	public String toString() {
		return (super.toString() + ": Size: " + buffer.length
				+ "; pPublisher: " + pointerPublisher + "; pModifier: "
				+ pointerModifier + "; pConsusmer: " + pointerConsumer + ";");
	}
	
}