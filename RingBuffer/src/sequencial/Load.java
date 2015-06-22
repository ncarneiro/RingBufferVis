package sequencial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import ringbuffer.RingBuffer;
import ringbuffer.RingBufferItem;
import ringbuffer.RingBufferItem.TYPE;

public class Load {

	static FileInputStream ler;
	static String dados = new String();
	
	static String[] load() {
		String[] dados = null;
		
			try {
				//ler = new FileInputStream("\\RingBuffer\\Datasets\\Dataset1.csv");
				ler = new FileInputStream("Datasets/Dataset1.csv");
			} catch (FileNotFoundException e) {}
			
			int letra;
			String vet[];// = new String[8];
			int i = 0;
			
			try {
				while ( ((letra = ler.read()) != -1) && (i < 2)) {
					dados += (char) letra;
					if (letra == ((int) '\n')) {
						i++;
						dados = "";
					}
				}
			} catch (IOException e) {}
			
			try {
				while ((letra = ler.read()) != -1) {
					dados += (char) letra;
					if (letra == ((int) '\n')) {
						vet = dados.split(";");
						dados = "";
						rbi = rb.publish();
						if (rbi.getType() == TYPE.EMPTY) {
							//continuos = rbi.getMappingsContinuos();
							//categoricos = rbi.getMappingsCatgoricos();
							rbi.setType(TYPE.DATA);
							/*
							continuos.put("ID", Double.parseDouble(vet[0]));
							continuos.put("NOTA1", Double.parseDouble(vet[1]));
							continuos.put("NOTA2", Double.parseDouble(vet[2]));
							continuos.put("NOTA3", Double.parseDouble(vet[3]));
							continuos.put("NOTA4", Double.parseDouble(vet[4]));
							continuos.put("MEDIA", Double.parseDouble(vet[5]));
							categoricos.put("SITUACAO", vet[6]);
							categoricos.put("CONCEITO", vet[7]);
							*/
							
							String id = "ID";
							double idV = Double.parseDouble(vet[0]);
							
							rbi.getMappingsContinuos().put(id, idV);
							
							//rbi.getMappingsContinuos().put("ID", Double.parseDouble(vet[0]));
							rbi.getMappingsContinuos().put("NOTA1", Double.parseDouble(vet[1]));
							rbi.getMappingsContinuos().put("NOTA2", Double.parseDouble(vet[2]));
							rbi.getMappingsContinuos().put("NOTA3", Double.parseDouble(vet[3]));
							rbi.getMappingsContinuos().put("NOTA4", Double.parseDouble(vet[4]));
							rbi.getMappingsContinuos().put("MEDIA", Double.parseDouble(vet[5]));
							rbi.getMappingsCatgoricos().put("SITUACAO", vet[6]);
							rbi.getMappingsCatgoricos().put("CONCEITO", vet[7]);
							
							System.out.println("Reading" + continuos.get("ID"));
							//rbi.setMappingsCatgoricos(categoricos);
							//rbi.setMappingsContinuos(continuos);
							//rbi.setType(TYPE.DATA);
						}
					}
				}
			} catch (NumberFormatException | IOException e) {}

			if (ler != null)
				try {
					ler.close();
				} catch (IOException e) {}
		
		return dados;
	}
}
