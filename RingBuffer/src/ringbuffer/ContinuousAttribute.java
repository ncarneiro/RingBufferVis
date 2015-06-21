package ringbuffer;

public class ContinuousAttribute {
	
	private double min;
	private double max;
	private double ajuste;
	
	public ContinuousAttribute(double min, double max) {
		if (min>max) {
			this.min = max;
			this.max = min;
		} else {
			this.min = min;
			this.max = max;
		}
		this.ajuste = this.min*-1;
	}
	
	public double convertToInterval(double min, double max, double value) {
		double aux = min*-1;
		double result = ((this.max+this.ajuste)*(value+aux))/(max+aux);
		result+=this.min;
		return result;
	}
	
}