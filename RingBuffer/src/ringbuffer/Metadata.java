package ringbuffer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Metadata {
	
	//categorical
	private CategoricalAttribute color;
	private CategoricalAttribute size;
	
	//continuous
	private ContinuousAttribute axisX;
	private ContinuousAttribute axisY;
	
	//column names
	private String colorName;
	private String sizeName;
	private String axisXName;
	private String axisYName;
	
	public Metadata() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("INS");aux.add("REG");aux.add("BOM");aux.add("EXC");
		color = new CategoricalAttribute("CONCEITO", aux);
		aux = new ArrayList<String>();
		aux.add("RE");aux.add("AP");
		size = new CategoricalAttribute("SITUACAO", aux);
		axisX = new ContinuousAttribute("ID", 1, 5000);
		axisY = new ContinuousAttribute("MEDIA", 0, 9);
	}

	public CategoricalAttribute getColor() {
		return color;
	}

	public void setColor(CategoricalAttribute color) {
		this.color = color;
	}

	public CategoricalAttribute getSize() {
		return size;
	}

	public void setSize(CategoricalAttribute size) {
		this.size = size;
	}

	public ContinuousAttribute getAxisX() {
		return axisX;
	}

	public void setAxisX(ContinuousAttribute axisX) {
		this.axisX = axisX;
	}

	public ContinuousAttribute getAxisY() {
		return axisY;
	}

	public void setAxisY(ContinuousAttribute axisY) {
		this.axisY = axisY;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getAxisXName() {
		return axisXName;
	}

	public void setAxisXName(String axisXName) {
		this.axisXName = axisXName;
	}

	public String getAxisYName() {
		return axisYName;
	}

	public void setAxisYName(String axisYName) {
		this.axisYName = axisYName;
	}
	
}