package ringbuffer;

public class ContinuousAttribute extends Attribute {
	
	private double min;
	private double max;
	
	public ContinuousAttribute(String columnName, double min, double max) {
		super(columnName);
		this.min = min;
		this.max = max;
	}
	
	private void adjustValues(double value) {
		if (value<min) {
			min = value;
		}
		if (value>max) {
			max = value;
		}
	}
	
	public double convertToInterval(double min, double max, double value) {
		return r3(min, max, this.min, this.max, value);
	}
	
	private double r3(double minA, double maxA, double minB, double maxB, double valB) {
		double ajusteA = minA*-1;
		double ajusteB = minB*-1;
		double result = (valB+ajusteB)*(maxA+ajusteA)/(maxB+ajusteB);
		result-=ajusteA;
		return result;
	}
	
	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		adjustValues(min);
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		adjustValues(max);
	}

}