class Aluno {

     String nome;

     int matricula;

     String curso;

     Aluno(){}

     Aluno(int n){
          this.matricula = n;
     }

}

class ListaAluno{
     Aluno[] a;

     boolean cheio = false;

     ListaAluno(){
          a = new Aluno[10];
     }

     public void inserir(Aluno novo){
          if(cheio){
               aumentar();
          }
          for(int i = 0; i < a.length; i++){
               if(a[i] == null){
                    a[i] = novo;
                    i = a.length;
               }
          }
          lotacao();
     }

     public void remover(int n){
          for(int i = 0; i < a.length; i++){
               if(a[i].matricula == n){
                    a[i] = null;
               }
          }
          lotacao();
     }

     public int vazios(){
          int sum = 0;
          for(int i = 0; i < a.length; i++){
               if(a[i] == null){
                    sum++;
               }
          }
          
          return sum;
     }

     public void aumentar(){
          Aluno[] aux = new Aluno[a.length + 5];
          for(int i = 0; i < a.length; i++){
               aux[i] = a[i];
          }
          a = aux;
     }

     public void inserirFim(Aluno novo){
          if(a[a.length - 1] != null){
               aumentar();
          }//fim if
          for(int j = a.length -1; j >= 0; j--){
               if( a[j] == null){
                    if( j > 0){
                         if(a[j - 1] != null){
                              a[j] = novo;
                              j = -1;
                         }//fim if
                    }else{
                         a[j] = novo;
                    }//fim elif
               }//fim if
          }//fim for
          lotacao();
     }//fim inserir

     public void inserirInicio(Aluno novo){
          if(a[a.length - 1] != null){
               aumentar();
          }//fim if
          for(int j = a.length - 2; j >= 0; j--){
               if(j == 0){
                    a[j+1] = a[j]; 
                    a[j] = novo;
               }else{
                    a[j+1] = a[j];
               }//fim elif
          }//fim for
          lotacao();
     }//fim inserir

     public void lotacao(){
          this.cheio = true;
          for(int i = 0; i < a.length; i++){
               if(a[i] == null){
                    this.cheio = false;
               }//fim if
          }//fim for
     }//fim lotaca

     public void mostrar(){
          for(int i = 0; i < a.length; i++){
               if(a[i] == null){
                    System.out.println("vazio");
               }else{
                    System.out.println(a[i].matricula);
               }//fim elif
          }//fim for
     }//fim mostrar
}//fim class

public class TesteAluno{
     public static void main(String[] args){
          ListaAluno la = new ListaAluno();
          Aluno novo;
          for(int i = 0; i < 10; i++){
               novo = new Aluno();
               novo.matricula = i;
               la.inserir(novo);
          }
          la.remover(5);
          la.inserirInicio(new Aluno(11));
          la.mostrar();
     }
}