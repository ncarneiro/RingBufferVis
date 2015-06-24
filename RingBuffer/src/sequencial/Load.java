package sequencial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Load {

	static FileInputStream ler;
	static String strLinha;
	
	BufferedReader br;
	List<HashMap<String, String>> map = new ArrayList<HashMap<String,String>>();
	
	List<HashMap<String, String>> load() {
		try {
			br = new BufferedReader(new FileReader("Datasets/Dataset3_500000.csv"));
			br.readLine();
			br.readLine();
		
			strLinha = br.readLine();
			while (strLinha != null) {
				HashMap<String, String> aux = new HashMap<String, String>();
				String[] vetor = strLinha.split(";");	
				aux.put("ID", vetor[0]);
				aux.put("NOTA1", vetor[1]);
				aux.put("NOTA2", vetor[2]);
				aux.put("NOTA3", vetor[3]);
				aux.put("NOTA4", vetor[4]);
				aux.put("MEDIA", vetor[5]);
				aux.put("SITUACAO", vetor[6]);
				aux.put("CONCEITO", vetor[7]);
				map.add(aux);
				
				strLinha = br.readLine();
			}
			br.close();
		} catch (IOException e ) {}
		
		return map;
	}
}
