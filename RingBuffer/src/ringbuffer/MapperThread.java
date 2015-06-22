package ringbuffer;

import java.awt.Color;

import ringbuffer.RingBufferItem.TYPE;

public class MapperThread implements Runnable {
	
	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.BLACK, Color.WHITE};
	private int[] sizes = {1,2,3};
	private int largura = 600;
	private int altura = 600;
	
	private int x;
	private int y;
	private int currentPoints = 4;
	
	private Metadata metadata;
	private RingBuffer ringBuffer;
	private RingBufferItem rbi;
	
	public MapperThread(Metadata metadata, RingBuffer ringBuffer) {
		this.metadata = metadata;
		this.ringBuffer = ringBuffer;
		//this.xs = new int[RingBufferItem.limitOfPoints];
		//this.ys = new int[RingBufferItem.limitOfPoints];
	}
	
	private boolean modify() {
		rbi = ringBuffer.acess();
		if (rbi.getType()!=null) {
			//categoricos
			int sssss = rbi.getMappingsCatgoricos().size();
			sssss = 0 + sssss;
			String srbi = rbi.getMappingsCatgoricos().get(metadata.getColorName());
			int irbi = metadata.getColor().getValues().indexOf(srbi);
			rbi.setColor(colors[irbi]);
			rbi.setSize(sizes[metadata.getSize().getValues().indexOf(rbi.getMappingsCatgoricos().get(metadata.getSizeName()))]);
			//continuos
			rbi.setNumberOfPoints(currentPoints);
			x = (int)metadata.getAxisX().convertToInterval(0, largura, rbi.getMappingsContinuos().get(metadata.getAxisXName()));
			y = (int)metadata.getAxisX().convertToInterval(0, altura, rbi.getMappingsContinuos().get(metadata.getAxisYName()));
			for (int i = 0; i < currentPoints; i++) {
				if (i==0 || i==3) {
					rbi.getX()[i] = x-10;
				} else {
					rbi.getX()[i] = x+10;
				}
				if (i<2) {
					rbi.getY()[i] = y;
				} else {
					rbi.getY()[i] = y+20;
				}
			}
			rbi.setType(TYPE.DRAWING);
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