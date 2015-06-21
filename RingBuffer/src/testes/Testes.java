package testes;

public class Testes {
	
	public static void main(String[] args) {
		int tamanho = 99999999;
		String[] vSimples = new String[tamanho];
		String[] vComplexo = new String[tamanho];
		long begin;
		long end;
		
		begin = System.nanoTime();
		for (int i = 0; i < vSimples.length; i++) {
			vSimples[i] = "a";
		}
		end = System.nanoTime();
		System.out.println("end part one");
		System.out.println(end-begin);
		
		begin = System.nanoTime();
		for (int i = 0; i < vComplexo.length; i++) {
			vComplexo[i] = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?";
		}
		end = System.nanoTime();
		System.out.println("end part two");
		System.out.println(end-begin);
	}
	
}