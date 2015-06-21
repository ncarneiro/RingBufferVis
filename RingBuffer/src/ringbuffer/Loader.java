package ringbuffer;
import java.io.FileInputStream;
import java.io.IOException;

public class Loader {

	static FileInputStream ler;
	static StringBuffer dados = new StringBuffer();
	
	public static void carregarBase() throws IOException {

		// leitura do arquivo
		ler = new FileInputStream("C:\\Users\\TiagoDavi\\teste\\Dataset1.csv");
		int letra;
		while ((letra = ler.read()) != -1){
			dados.append((char)letra);
			if (letra == ((int) '\n') ) {
				System.out.print("Colocar no ringbuffer " + dados);
				dados.setLength(0);
			}
		}
		
		System.out.println("Finalizar");
		if (ler != null)
			ler.close();
	}
}
