package sequencial;

import java.awt.Color;
import java.util.HashMap;

public class Item {

	private Color cor;

	private HashMap<String, String> mappingsCatgoricos;
	private HashMap<String, Double> mappingsContinuos;

	public void setColor(Color color) {
		this.cor = color;
	}

	public void setSize(int i) {
		
	}

	public void setNumberOfPoints(int currentPoints) {
		// TODO Auto-generated method stub
		
	}

	public int[] getX() {
		return null;
	}

	public int[] getY() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumberOfPoints() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public HashMap<String, String> getMappingsCatgoricos() {
		return mappingsCatgoricos;
	}

	public void setMappingsCatgoricos(HashMap<String, String> mappingsCatgoricos) {
		this.mappingsCatgoricos = mappingsCatgoricos;
	}

	public HashMap<String, Double> getMappingsContinuos() {
		return mappingsContinuos;
	}

	public void setMappingsContinuos(HashMap<String, Double> mappingsContinuos) {
		this.mappingsContinuos = mappingsContinuos;
	}

}
