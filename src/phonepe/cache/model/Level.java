package phonepe.cache.model;

import java.util.LinkedHashMap;

public class Level {

	private LinkedHashMap<String, String> data;
	
	public Level() {
		this.data = new LinkedHashMap<>();
	}
	
	public LinkedHashMap<String, String> getData() {
		return data;
	}
	public void setData(LinkedHashMap<String, String> data) {
		this.data = data;
	}
}
