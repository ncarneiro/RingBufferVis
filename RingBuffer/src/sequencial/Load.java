package sequencial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import ringbuffer.RingBuffer;
import ringbuffer.RingBufferItem;
import ringbuffer.RingBufferItem.TYPE;

public class Load {

	static FileInputStream ler;
	static String strLinha;
	
	static BufferedReader br;
	
	static String[] load() {
		String[] linhas = new String[5000];

		try {
			br = new BufferedReader(new FileReader("Datasets/Dataset1.csv"));
			br.readLine();
			br.readLine();
		
			int i = 0;
			strLinha = br.readLine();
			while (strLinha != null) {
				linhas[i] = new String(strLinha);
	
				strLinha = br.readLine();
				i++;
			}
			br.close();
		} catch (IOException e ) {}
		
		return linhas;
	}
}
