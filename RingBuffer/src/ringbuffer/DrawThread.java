package ringbuffer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DrawThread implements Runnable {

	static JLabel view;
	static BufferedImage surface;
	static Graphics g;

	public static void setView() {
		surface = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		g = surface.getGraphics();
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 600, 400);
		g.dispose();

		view.repaint(); // MAGIC
	}
	
	public static void addElemento(RingBufferItem item) {
		g = surface.getGraphics();
		g.setColor(Color.BLACK);
		// desenhar
		int x = item.getX()[0];
		int y = item.getY()[0];
		
		int[] xv = { x - 10, x + 10, x + 10, x - 10 };
		int[] yv = {    y  ,   y   , y + 20, y + 20 };

		g.drawPolygon(xv, yv, 4);
		
		g.dispose();
	}
	
	@Override
	public void run() {	
		JFrame frame = new JFrame();
		int vertexes = 0;
		// Tamanho
		vertexes = 15;
		int canvasSize = vertexes * vertexes;
		frame.setSize(canvasSize, canvasSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(view);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}
