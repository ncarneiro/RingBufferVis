package sequencial;

import java.util.HashMap;

public class Main {

	static String dados[];
	static HashMap<String, String> desenho = new HashMap<String, String>();
	
	public static void main(String[] args) {
	
		Load loader = new Load();
		dados = loader.load();
		
		Draw drawer = new Draw(desenho);
		drawer.draw();
	}
	
	public static void carregarBase() {
		
	}
	
	public static void	mapear() {
		
	}
	
}
