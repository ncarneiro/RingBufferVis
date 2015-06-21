package ringbuffer;
import java.io.FileInputStream;
import java.io.IOException;

public class Loader {

	static FileInputStream ler;
	static String dados = new String();
	static RingBufferItem item = new RingBufferItem();
	
	public static void carregarBase() throws IOException {

		// leitura do arquivo
		ler = new FileInputStream("C:\\Users\\TiagoDavi\\teste\\Dataset1.csv");
		int letra;
		int[] x = new int[8];
		int[] y = new int[8];
		
		int i = 0;
		String vet[] = new String[8];
		while ((letra = ler.read()) != -1){
			dados += (char)letra;
			if (letra == ((int) '\n') ) {
				i++;
				if ( i > 3) {
					vet = dados.split(";");
					x[0] = Integer.parseInt(vet[2]);
					y[0] = Integer.parseInt(vet[3]);
					
					item.setX(x);
					item.setY(y);
					DrawThread.addElemento(item);	
				}
				dados = "";
			}
		}
		
		System.out.println("Finalizar");
		if (ler != null)
			ler.close();
	}
}
