package sequencial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Creator {

	public Creator(int size) {
		String strFile = "Datasets/Dataset" + size + "D.csv";
		File file = new File(strFile);
		try {
			file.createNewFile();
		} catch (IOException e) {
		}

		String content = "ID;NOTA1;NOTA2;NOTA3;NOTA4;MEDIA;SITUACAO;CONCEITO\n"
				+ "NUMERO;NUMERO;NUMERO;NUMERO;NUMERO;NUMERO;TEXTO;TEXTO\n";
		System.out.println("Start");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
		}
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for (int i = 1; i <= size; i++) {
			Random r = new Random();
			content += i + ";";
			double soma = 0;
			for (int j = 1; j <= 4; j++) {
				double num = r.nextDouble()*10;
				soma += num;
				content += num + ";";
			}
			content += (soma / 4) + ";";

			if (r.nextBoolean())
				content += "AP" + ";";
			else
				content += "RE" + ";";

			int conc = r.nextInt(4);
			switch (conc) {
			case 0: {
				content += "INS" + ";";
				break;
			}
			case 1: {
				content += "REG" + ";";
				break;
			}
			case 2: {
				content += "BOM" + ";";
				break;
			}
			case 3: {
				content += "EXC" + ";";
				break;
			}
			default: {
				// FUDEU
				break;
			}
			}

			try {
				bw.write(content);
				bw.newLine();
			}catch(Exception e) {}
			content = "";
			if (i%1000000==0)
				System.out.println(i);
		}
		System.out.println("Terminado");
		try {
			bw.close();
		} catch (IOException e) {
		}
	
	}
}
