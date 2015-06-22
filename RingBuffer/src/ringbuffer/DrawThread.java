package ringbuffer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ringbuffer.RingBufferItem.TYPE;

public class DrawThread implements Runnable {

	static JLabel view;
	static BufferedImage surface;
	static Graphics g;
	static RingBuffer rb;
	static RingBufferItem rbi;
	
	public DrawThread(RingBuffer rb) {
		surface = new BufferedImage(650, 650, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		g = surface.getGraphics();
		g.setColor(Color.WHITE);
		this.rb = rb;
		g.fillRect(0, 0, 650, 650);
		g.dispose();
	}
	
	public synchronized static void desenhar() {
		
		rbi = rb.consume();
		if ( rbi == null  || rbi.getType() == TYPE.DRAWING ) {
			System.out.println("Desenhando");
			g = surface.getGraphics();
			g.setColor(rbi.getColor());
			int[] x = rbi.getX();
			int[] y = rbi.getY();	
			g.drawPolygon(x, y, rbi.getNumberOfPoints());
			g.fillPolygon(x, y, rbi.getNumberOfPoints());
			g.dispose();
			rbi.setType(TYPE.EMPTY);
		}
	}
	
	@Override
	public void run() {	
		JFrame frame = new JFrame();
		int canvasSize = 600;
		frame.setSize(canvasSize, canvasSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(view);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		desenhar();
		view.repaint(); // MAGIC
	}
}
