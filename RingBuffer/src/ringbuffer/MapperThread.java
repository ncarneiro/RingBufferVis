package ringbuffer;

import java.awt.Color;

public class MapperThread implements Runnable {
	
	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.BLACK, Color.WHITE};
	
	private Metadata metadata;
	private RingBuffer ringBuffer;
	private RingBufferItem rbi;
	
	public MapperThread(Metadata metadata, RingBuffer ringBuffer) {
		this.metadata = metadata;
		this.ringBuffer = ringBuffer;
	}
	
	private boolean modify() {
		rbi = ringBuffer.acess();
		if (rbi!=null) {
			//
			
			//TODO
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void run() {
		modify();
	}
	
}