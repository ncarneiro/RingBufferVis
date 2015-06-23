package sequencial;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;

public class Main {

	static List<HashMap<String,String>> dados;
	static List<Item> desenho;
	
	public static void main(String[] args) {
	
		Load loader = new Load();
		dados = loader.load();
		Metadata metadata = new Metadata();
		Mapper mapper = new Mapper(metadata, dados);
		desenho = mapper.map();
		Draw drawer = new Draw(desenho);
		drawer.draw();
	}
}
