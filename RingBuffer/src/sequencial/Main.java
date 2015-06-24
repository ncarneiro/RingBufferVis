package sequencial;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Main {

	static List<HashMap<String,String>> dados;
	static List<Item> desenho;
	
	public static void main(String[] args) {
	
		esperar(7000);
		
		long i = System.currentTimeMillis();
		String inicio = LocalDateTime.now().toString();
	
		Load loader = new Load();
		dados = loader.load();
		Metadata metadata = new Metadata();
		Mapper mapper = new Mapper(metadata, dados);
		desenho = mapper.map();
		Draw drawer = new Draw(desenho);
		drawer.draw();
		
		String fim = LocalDateTime.now().toString();
		long f = System.currentTimeMillis();
		
		System.out.println("Duração: "+((f-i)/1000.0)+" segundos.");
		System.out.println("Inicio:\t"+inicio);
		System.out.println("Fim:\t"+fim);
		
		
	}
	
	public static void esperar(long segundos) {
		long ti = System.currentTimeMillis();
		long tf = segundos+ti;
		while (tf>ti) {
			ti = System.currentTimeMillis();
		}
	}
}
