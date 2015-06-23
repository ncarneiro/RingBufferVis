package sequencial;

import java.awt.Color;
import java.util.HashMap;

public class Main {

	static String dados[];
	static Item desenho[];
	
	public static void main(String[] args) {
	
		Load loader = new Load();
		dados = loader.load();
		Metadata metadata = new Metadata();
		Mapper mapper = new Mapper(metadata, dados);
		Draw drawer = new Draw(desenho);
		drawer.draw();
	}
	
	public static void carregarBase() {
		
	}
	
	public static void	mapear() {
		
	}
	
}
