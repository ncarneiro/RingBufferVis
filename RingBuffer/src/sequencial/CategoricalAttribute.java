package sequencial;

import java.util.List;

public class CategoricalAttribute extends Attribute {
	
	private List<String> values;
	
	public CategoricalAttribute(String columnName, List<String> values) {
		super(columnName);
		this.values = values;
	}
	
	public void addToValues(String value) {
		if (!values.contains(value)) {
			values.add(value);
		}
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
}