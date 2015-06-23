package sequencial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ringbuffer.RingBuffer;
import ringbuffer.RingBufferItem;
import ringbuffer.RingBufferItem.TYPE;

public class Draw {

	static JLabel view;
	static BufferedImage surface;
	static Graphics g;
	static Item[] desenho;
	
	public Draw(Item[] desenho) {
		this.desenho = desenho;
		surface = new BufferedImage(650, 650, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		g = surface.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 650, 650);
		g.dispose();
	}
	
	public static void desenhar() {

		for (int i = 0; i < desenho.length; i++) {
			g = surface.getGraphics();
			Color cor = desenho[i].getColor();
			g.setColor(cor);
			int[] x = desenho[i].getX();
			int[] y = desenho[i].getY();	
			g.drawPolygon(x, y, desenho[i].getNumberOfPoints());
			g.fillPolygon(x, y, desenho[i].getNumberOfPoints());
			g.dispose();
		}
		
	}
	
	public void draw() {	
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