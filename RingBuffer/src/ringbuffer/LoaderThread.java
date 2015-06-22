package ringbuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ringbuffer.RingBufferItem.TYPE;

public class LoaderThread implements Runnable {

	static FileInputStream ler;
	static String dados = new String();
	static RingBuffer rb;
	static RingBufferItem rbi;
	static HashMap<String, String> categoricos;
	static HashMap<String, Double> continuos;
	
	public LoaderThread(RingBuffer rb) throws IOException {
		this.rb = rb;
	}
	
	@Override
	public void run() {

		// leitura do arquivo
		try {
			//ler = new FileInputStream("\\RingBuffer\\Datasets\\Dataset1.csv");
			ler = new FileInputStream("C:\\Users\\TiagoDavi\\git\\RingBufferVis\\RingBuffer\\Datasets\\Dataset1.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int letra;
		String vet[] = new String[8];
		int i = 0;
		try {
			while ((letra = ler.read()) != -1 || i < 2) {
				dados += (char) letra;
				if (letra == ((int) '\n')) {
					i++;
					dados = "";
				}
			}
		} catch (IOException e) { }
		
		try {
			while ((letra = ler.read()) != -1) {
				dados += (char) letra;
				if (letra == ((int) '\n')) {
					vet = dados.split(";");
					dados = "";
					rbi = rb.publish();

					if (rbi.getType() == TYPE.EMPTY) {
						System.out.println("Reading");
						rbi.setType(TYPE.DATA);
						continuos.put("ID", Double.parseDouble(vet[0]));
						continuos.put("NOTA1", Double.parseDouble(vet[1]));
						continuos.put("NOTA2", Double.parseDouble(vet[2]));
						continuos.put("NOTA3", Double.parseDouble(vet[3]));
						continuos.put("NOTA4", Double.parseDouble(vet[4]));
						continuos.put("MEDIA", Double.parseDouble(vet[5]));
						categoricos.put("SITUACAO", vet[6]);
						categoricos.put("CONCEITO", vet[7]);
						
						rbi.setMappingsCatgoricos(categoricos);
						rbi.setMappingsContinuos(continuos);
					}
				}
			}
		} catch (NumberFormatException | IOException e) {}

		if (ler != null)
			try {
				ler.close();
			} catch (IOException e) {}		
	}

	public static void getMetadata() {
		FileInputStream ler;
		StringBuffer dados = new StringBuffer();
		try {
			// leitura do arquivo
			ler = new FileInputStream("Datasets/Dataset1.csv");
			int letra;
			//
			int sair = 0;
			String[] nomes = new String[1];
			String[] tipos = new String[1];
			HashMap<String, CategoricalAttribute> categoricals = new HashMap<String, CategoricalAttribute>();
			HashMap<String, ContinuousAttribute> continuous = new HashMap<String, ContinuousAttribute>();
			//
			while ((letra = ler.read()) != -1) {
				dados.append((char) letra);
				if (letra == ((int) '\n')) {
					sair++;
					//
					if (sair<3) {
						if (sair==1) {
							nomes = dados.toString().trim().split(";");
						} else if (sair==2) {
							tipos = dados.toString().trim().split(";");
							//criar tipos
							for (int i = 0; i < tipos.length; i++) {
								if (tipos[i].equals("NUMERO")) {
									continuous.put(nomes[i], new ContinuousAttribute(nomes[i], Double.MAX_VALUE, Double.MIN_VALUE));
								} else {
									categoricals.put(nomes[i], new CategoricalAttribute(nomes[i], new ArrayList<String>()));
								}
							}
						}
					} else {
						String[] s = dados.toString().split(";");
						for (int i = 0; i < s.length; i++) {
							if (tipos[i].equals("NUMERO")) {
								double d = Double.parseDouble(s[i]);
								continuous.get(nomes[i]).setMin(d);
							} else {
								categoricals.get(nomes[i]).addToValues(s[i]);
							}
						}
					}
					//
					dados.setLength(0);
				}
			}
			System.out.println("Finalizar");
			System.out.println("Categoricos:");
			for (String string : categoricals.keySet()) {
				System.out.println(string);
				System.out.print("{");
				for (String s : categoricals.get(string).getValues()) {
					System.out.print(s+",");
				}
				System.out.print("}\n");
			}
			System.out.println("Continuous:");
			for (String string : continuous.keySet()) {
				System.out.println(string);
				System.out.println("Maior:"+continuous.get(string).getMax()+"; Menor: "+continuous.get(string).getMin());
			}
			if (ler != null)
				ler.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
