package ringbuffer;

import java.awt.Color;
import java.util.HashMap;

public class RingBufferItem {
	
	public static enum TYPE {EMPTY, DATA, DRAWING}
	
	private TYPE type;
	private final int limitOfPoints = 8;
	
	//recovering information
	private int id;
	
	//data information
	//private HashMap<String, String> details;
	private HashMap<String, String> mappingsCatgoricos;
	private HashMap<String, Double> mappingsContinuos;
	
	//drawing information
	private Color color;
	private int[] x;
	private int[] y;
	private int numberOfPoints;
	
	public RingBufferItem() {
		this.id = -1;
		//this.details = new HashMap<String, String>();
		this.setMappingsCatgoricos(new HashMap<String, String>());
		this.setMappingsContinuos(new HashMap<String, Double>());
		this.color = Color.WHITE;
		this.x = new int[limitOfPoints];
		this.y = new int[limitOfPoints];
		this.numberOfPoints = 0;
	}
	
	public TYPE getType() {
		return this.type;
	}
	
	public void setType(TYPE type) {
		this.type = type;
	}
	
	public boolean isEmpty() {
		if (this.type==TYPE.EMPTY) {
			return true;
		} else {
			return false;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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