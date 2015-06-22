package sequencial;

import java.util.HashMap;

public class Mapper {

	static HashMap<String, String>[] categoricos;
	static HashMap<String, Double>[] continuos;
	
	public Mapper(String[] dados) {
		
		for (int i = 0; i < dados.length; i++) {
			String[] vetor = dados[i].split(";");	
			continuos[i].put("ID", Double.parseDouble(vetor[0]));
			continuos[i].put("NOTA1", Double.parseDouble(vetor[1]));
			continuos[i].put("NOTA2", Double.parseDouble(vetor[2]));
			continuos[i].put("NOTA3", Double.parseDouble(vetor[3]));
			continuos[i].put("NOTA4", Double.parseDouble(vetor[4]));
			continuos[i].put("MEDIA", Double.parseDouble(vetor[5]));
			categoricos[i].put("SITUACAO", vetor[6]);
			categoricos[i].put("CONCEITO", vetor[7]);
		}
	}
	
	public void map() {
	
		
		
	}
 }
