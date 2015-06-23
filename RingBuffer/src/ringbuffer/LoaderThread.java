package ringbuffer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ringbuffer.RingBufferItem.TYPE;

public class LoaderThread implements Runnable {

	static RingBuffer rb;
	static RingBufferItem rbi;
	static HashMap<String, String> categoricos;
	static HashMap<String, Double> continuos;

	static BufferedReader br;
	static String[] linha;
	static String strLinha;

	public LoaderThread(RingBuffer rb) {
		this.rb = rb;
		try {
			br = new BufferedReader(new FileReader("Datasets/Dataset2_50000.csv"));
			//br = new BufferedReader(new FileReader("Datasets/Dataset1.csv"));
			br.readLine();
			br.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void load() {
		rbi = rb.publish();
		try {
			strLinha = br.readLine();
			if (strLinha != null) {
				linha = strLinha.split(";");
				if (rbi != null) {
					System.out.println("Entrou");

					String id = "ID";
					double idV = Double.parseDouble(linha[0]);

					rbi.getMappingsContinuos().put(id, idV);
					rbi.getMappingsContinuos().put("NOTA1",
							Double.parseDouble(linha[1]));
					rbi.getMappingsContinuos().put("NOTA2",
							Double.parseDouble(linha[2]));
					rbi.getMappingsContinuos().put("NOTA3",
							Double.parseDouble(linha[3]));
					rbi.getMappingsContinuos().put("NOTA4",
							Double.parseDouble(linha[4]));
					rbi.getMappingsContinuos().put("MEDIA",
							Double.parseDouble(linha[5]));
					rbi.getMappingsCatgoricos().put("SITUACAO", linha[6]);
					rbi.getMappingsCatgoricos().put("CONCEITO", linha[7]);
					
					rbi.setType(TYPE.DATA);
				}
			}
			else {
				// Fim do arquivo
			}
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		load();
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
					if (sair < 3) {
						if (sair == 1) {
							nomes = dados.toString().trim().split(";");
						} else if (sair == 2) {
							tipos = dados.toString().trim().split(";");
							// criar tipos
							for (int i = 0; i < tipos.length; i++) {
								if (tipos[i].equals("NUMERO")) {
									continuous.put(nomes[i],
											new ContinuousAttribute(nomes[i],
													Double.MAX_VALUE,
													Double.MIN_VALUE));
								} else {
									categoricals.put(nomes[i],
											new CategoricalAttribute(nomes[i],
													new ArrayList<String>()));
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
					System.out.print(s + ",");
				}
				System.out.print("}\n");
			}
			System.out.println("Continuous:");
			for (String string : continuous.keySet()) {
				System.out.println(string);
				System.out.println("Maior:" + continuous.get(string).getMax()
						+ "; Menor: " + continuous.get(string).getMin());
			}
			if (ler != null)
				ler.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
