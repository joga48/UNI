import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        ListaDuplamenteEncadeada ls = new ListaDuplamenteEncadeada();
        String nome;
        int idade, x, aux;
        Aluno a;
        do{
            System.out.println("\n\nO que deseja fazer?"
                + "\n1- criar aluno novo"
                + "\n2- deletar aluno"
                + "\n3- ver lista de alunos"
                + "\n0- sair");
            x = readInt();

            if(x == 1){
                System.out.println("Digite nome do aluno: ");
                nome = readLine();
                System.out.println("Digite idade do aluno: ");
                idade = readInt();
                ls.inserirFinal(new NoDuplo(new Aluno(nome, idade)));
            }else if(x == 2){
                System.out.println("Digite numero do aluno: ");
                aux = readInt();
                ls.excluirNoUsandoPosicao(aux-1);
            }else if(x == 3){
                NoDuplo tmp = ls.primeiro;
                for(int i = 0; tmp != null; i++, tmp = tmp.prox){
                    a = tmp.valor;
                    System.out.println((i+1) + "- " + a.getNome());
                }
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