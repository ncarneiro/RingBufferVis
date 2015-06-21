package ringbuffer;

import java.util.List;

public class CategoricalAttribute {
	
	private String column;
	private List<String> values;
	
	public CategoricalAttribute(String columnName, List<String> values) {
		this.column = columnName;
		this.values = values;
	}
	
	public double getValueOnInterval(double value) {
		return 0;
	}
	
}