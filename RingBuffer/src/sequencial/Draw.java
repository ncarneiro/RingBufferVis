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
	static HashMap<String, String> desenho = new HashMap<String, String>();
	
	public Draw(HashMap<String, String> desenho) {
		this.desenho = desenho;
		surface = new BufferedImage(650, 650, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		g = surface.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 650, 650);
		g.dispose();
	}
	
	public static void desenhar() {

		g = surface.getGraphics();
		String strCor = desenho.get("Cor");
		Color cor = Color.red;
		
		
		g.setColor(cor);
//		int[] x = rbi.getX();
//		int[] y = rbi.getY();	
//		g.drawPolygon(x, y, rbi.getNumberOfPoints());
//		g.fillPolygon(x, y, rbi.getNumberOfPoints());
		g.dispose();
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