package ringbuffer;

import java.util.ArrayList;

public class Metadata {

	private int screenWidth = 500;
	private int screenHeight = 500;
	private int numberOfItems;

	// categorical
	private CategoricalAttribute color;
	private CategoricalAttribute size;

	// continuous
	private ContinuousAttribute axisX;
	private ContinuousAttribute axisY;

	public Metadata(String dataset) {
		switch (dataset) {
		case ("Datasets/Dataset1000000D.csv"):
			preload2();
			break;
		default:
			preload1();
			break;
		}
	}

	private void preload1() {//20k
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("INS");
		aux.add("REG");
		aux.add("BOM");
		aux.add("EXC");
		color = new CategoricalAttribute("CONCEITO", aux);
		aux = new ArrayList<String>();
		aux.add("RE");
		aux.add("AP");
		size = new CategoricalAttribute("SITUACAO", aux);
		axisX = new ContinuousAttribute("ID", 1, 20000);
		axisY = new ContinuousAttribute("MEDIA", 0.646004953184473, 9.525669583318937);
		this.numberOfItems = 20000;
	}

	private void preload2() {//1m
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("INS");
		aux.add("REG");
		aux.add("BOM");
		aux.add("EXC");
		color = new CategoricalAttribute("CONCEITO", aux);
		aux = new ArrayList<String>();
		aux.add("RE");
		aux.add("AP");
		size = new CategoricalAttribute("SITUACAO", aux);
		axisX = new ContinuousAttribute("ID", 1, 1000000);
		axisY = new ContinuousAttribute("MEDIA", 0.13693470162697674,
				9.843291469691156);
		this.numberOfItems = 1000000;
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
		return color.getColumnName();
	}

	public String getSizeName() {
		return size.getColumnName();
	}

	public String getAxisXName() {
		return axisX.getColumnName();
	}

	public String getAxisYName() {
		return axisY.getColumnName();
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

}