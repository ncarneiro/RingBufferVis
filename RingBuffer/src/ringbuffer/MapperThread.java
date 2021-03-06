package ringbuffer;

import java.awt.Color;

import ringbuffer.RingBufferItem.TYPE;

public class MapperThread extends Thread {//implements Runnable {
	
	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.BLACK, Color.WHITE};
	private int[] sizes = {1,2,3};
	
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
		if (rbi!=null) {
			//categoricos
			rbi.setColor(colors[metadata.getColor().getValues().indexOf(rbi.getMappingsCatgoricos().get(metadata.getColorName()))]);
			rbi.setSize(sizes[metadata.getSize().getValues().indexOf(rbi.getMappingsCatgoricos().get(metadata.getSizeName()))]);
			//continuos
			rbi.setNumberOfPoints(currentPoints);
			//ERRO AQUI
			//
			x = (int)metadata.getAxisX().convertToInterval(0, metadata.getScreenWidth(), rbi.getMappingsContinuos().get(metadata.getAxisXName()));
			y = (int)metadata.getAxisY().convertToInterval(0, metadata.getScreenHeight(), rbi.getMappingsContinuos().get(metadata.getAxisYName()));
			//
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
			/*
			for (int i = 0; i < currentPoints; i++) {
				rbi.getX()[i] = x;
				rbi.getY()[i] = y;
			}
			*/
			rbi.setType(TYPE.DRAWING);
			//
			System.out.print("X:"+x+",Y:"+y+"\t");
			for (int i = 0; i < rbi.getX().length; i++) {
				if (rbi.getX()[i]<0)
				System.out.print(rbi.getX()[i]+","+rbi.getY()[i]+"; ");
			}
			System.out.println();
			System.out.println();
			//
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void run() {
		modify();
		/*
		while (!ringBuffer.isEnded()) {
			modify();
		}
		*/
	}
	
}