package ringbuffer;

public class Attribute {
	
	private String columnName;
	
	public Attribute(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
}