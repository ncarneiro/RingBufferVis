package sequencial;

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
		double ajusteGlobal = this.min*-1;
		double ajusteLocal = min*-1;
		//double result = ((this.max+ajusteGlobal)*(value+ajusteLocal))/(max+ajusteLocal);
		double result = ((max+ajusteLocal) * (value+ajusteLocal)) / (this.max+ajusteGlobal);
		result+=this.min;
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