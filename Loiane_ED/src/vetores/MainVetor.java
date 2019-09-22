package vetores;

public class MainVetor {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		
		vetor.adiciona("Atualmente");
		vetor.adiciona("a tua mente");
		vetor.adiciona("atua ou mente?");
		
		System.out.println(vetor.tamanho());
		
		System.out.println(vetor); //exibe vetor
		
		System.out.println(vetor.busca(2)); //exibe a terceira posi��o da busca
	
		System.out.println(vetor.busca("Atualmente")); //faz a busca da String no vetor
		
		System.out.println(vetor.busca("Atual")); // n�o existe no vetor, ent�o retorna -1
	}

}
