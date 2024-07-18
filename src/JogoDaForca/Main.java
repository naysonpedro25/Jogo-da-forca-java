package JogoDaForca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Scanner input = new Scanner(System.in);
	private ArrayList<String> palavras = new ArrayList<String>();

	private void menu() {
		int ident;
		while (true) {
			System.out.println("(1)addpalavra");
			System.out.println("(2) jogar");
			System.out.println("(0) sair");
			ident = input.nextInt();
			if (ident == 1) {
				addPalavra();
			} else if (ident == 2) {
				if(palavras.isEmpty()) {
					System.out.println("Adicione uma ou mais palavras\n");
				}else {
					
					novoJogo();
				}
			}else if(ident ==0) {
				System.out.println("Saindo");
				break;
			}else {
				System.out.println("Digite algo que preste");
			}
		}
	}

	public void imprimir(char palavras[]) {
		for (int i = 0; i < palavras.length; i++) {
			System.out.print(palavras[i] + " ");
		}
		System.out.println();
	}

	public void jogar(String palavraSort) {
		char palavraSortArr[] = palavraSort.toCharArray();
		char palavra[] = new char[palavraSort.length()];
		for (int i = 0; i < palavra.length; i++) {
			palavra[i] = '_';
		}
		String letra ;
		int cont = 0;
		while (true) {
			imprimir(palavra);
			letra = input.next();
			char l[]= letra.toCharArray();
			if(palavraSort.contains(letra)) {
				for(int i = 0; i < palavraSortArr.length; i++) {
					if(l[0] == palavraSortArr[i]) {
						palavra[i] = l[0];
					}
				}
			}else {
				System.out.println("Erro");
				cont++;
			}
			int aux = 0;
			for (int i = 0; i < palavraSortArr.length; i++) {
				if(palavra[i] == palavraSortArr[i]) {
					aux++;
				}
			}
			if(aux == palavra.length) {
				System.out.println("\nGanhou\n");
				imprimir(palavraSortArr);
				System.out.println();
				break;
			}else if(cont == 5) {
				System.out.println("Vc perdeu\n");
				break;
			}
			
		}
	}

	public void novoJogo() {
		int num = (int) Math.floor(Math.random() * palavras.size());
		String palavrasort = palavras.get(num);
		this.jogar(palavrasort);

	}

	private void addPalavra() {
		String p;
		System.out.println("Adicione uma palavra");
		p = input.next();
		palavras.add(p);
	}

	public static void main(String[] args) {
		Main jogo = new Main();
		jogo.menu();
	}
}
