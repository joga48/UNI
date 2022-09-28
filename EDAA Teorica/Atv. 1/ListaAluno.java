import java.io.*;

class Aluno{

	private String nome;

	private int idade;


	Aluno(){
		this.nome = "";
		this.idade = 0;
	}

	Aluno(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public int getIdade(){
		return this.idade;
	}
}//fim aluno

class Lista{

	Aluno[] aluno;

	int length;

	int tam;

	Lista(int tam){
		aluno = new Aluno[tam];
		this.length = 0;
		this.tam = tam;
	}

	public void add(String nome, int idade){
		for(int i = 0; i  < this.length; i++){
			if(this.aluno[i] == null){
				this.aluno[i] = new Aluno(nome, idade);
				this.length++;
			}//fim if
		}//fim for
		if(this.length == 0){
			this.length++;
			this.aluno[0] = new Aluno(nome, idade);
		}
	}

	public void remove(int a){
		for(int i = 0; i  < this.length; i++){
			if(i == (a-1)){
				aluno[i] = null;
				for(int j = i; j < length-1; j++){
					aluno[i] = aluno[i+1];
				}
				aluno[length-1] = null;
				length--;
			}//fim if
		}//fim for

	}

	public boolean check(){
		if(length < tam-1){
			return false;
		}else{
			return true;
		}
	}

	public void mostrar(){
		for(int i = 0; i < length; i++){
			System.out.println(aluno[i].getNome());
		}
	}

}//fim lista

public class ListaAluno{
	public static void main(String[] args) throws Exception{
		Lista alunos = new Lista(10);
		int x, aux;
		String nome;
		int idade;
		do{
			System.out.println("\n\nO que deseja fazer?"
				+ "\n1- criar aluno novo"
				+ "\n2-deletar aluno"
				+ "\n3- ver lista de alunos");
			x = readInt();

			if(x == 1){
				if (alunos.check()){
					System.out.println("Lista cheia");
				}else{
					System.out.println("Digite nome do aluno: ");
					nome = readLine();
					System.out.println("Digite idade do aluno: ");
					idade = readInt();
					alunos.add(nome, idade);
				}
			}else if(x == 2){
				System.out.println("Digite numero do aluno: ");
				aux = readInt();
				alunos.remove(aux);
			}else if(x == 3){
				alunos.mostrar();
			}
		}while(x != 0);

	}

	public static int readInt() throws Exception{ 
		
		BufferedReader leia = new BufferedReader(new InputStreamReader(System.in));
		String aux = "";
		try{
			aux = leia.readLine();
		}catch (Exception e){
			System.out.println("Error!");
		}
		return Integer.parseInt(aux);
	}

	public static String readLine() throws Exception{ 
		BufferedReader leia = new BufferedReader(new InputStreamReader(System.in));
		String aux = leia.readLine();
		return aux;
	}
}