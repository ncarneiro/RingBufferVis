package sequencial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Draw {

	JLabel view;
	BufferedImage surface;
	Graphics g;
	List<Item> desenho = new ArrayList<Item>();
	
	public Draw(List<Item> desenho) {
		this.desenho = desenho;
		surface = new BufferedImage(650, 650, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		g = surface.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 650, 650);
		g.dispose();
	}
	
	public void desenhar() {

		for (int i = 0; i < desenho.size(); i++) {
			g = surface.getGraphics();
			Color cor = desenho.get(i).getColor();
			g.setColor(cor);
			int[] x = desenho.get(i).getX();
			int[] y = desenho.get(i).getY();	
			g.drawPolygon(x, y, desenho.get(i).getNumberOfPoints());
			g.fillPolygon(x, y, desenho.get(i).getNumberOfPoints());
			g.dispose();
		}
	}
	
	public void draw() {	
		JFrame frame = new JFrame();
		int canvasSize = 600;
		frame.setSize(canvasSize, canvasSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(view);
		
		BaseCanvas bc = new BaseCanvas();
		frame.getContentPane().add(bc);
		
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		desenhar();
		view.repaint();
	}
}