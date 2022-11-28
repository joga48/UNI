class Aluno {

     String nome;

     int matricula;

     String curso;

     Aluno prox;

     Aluno ante;

     Aluno(){}

     Aluno(int n){
          this.matricula = n;
     }

}

class ListaAluno{         
     Aluno a;

     ListaAluno(){
          a = new Aluno();
     }

     public void inserir(Aluno novo, int pos){
          if(i == 1){
               inserirInicio(novo);
               return;
          }
          Aluno aux = a;

          for(int i = 1; i < pos; aux = aux.prox);

          novo.prox = aux;
          novo.ante = aux.ante;
          aux.ante.prox = novo;
          aux.ante = novo;
          aux = null;
          novo = null;

     }

     public void remover(int n){
          for(Aluno aux = a; aux != null; aux = aux.prox){
               if(aux.matricula == n){
                    aux.prox.ante = aux.ante;
                    aux.ante.prox = aux.prox;
                    aux.ante = null;
                    aux.prox = null;
                    break;
               }
          }
     }

     public void inserirFim(Aluno novo){
          Aluno aux = a;
          for(aux = a;aux.prox != null; aux = aux.prox);

          aux.prox = novo;

          novo.ante = prox;

     }//fim inserir

     public void inserirInicio(Aluno novo){
          novo.prox = a;
          a.ante = novo;
          a = novo;
          novo = null;
     }//fim inserir


     public int quant(){
          Alluno aux = a;
          int i;
          for(i = 0; aux != null; i++, aux = aux.prox);
          return i;
     }//fim mostrar
}//fim class

public class TesteAlunoDinamico{
     public static void main(String[] args){
          ListaAluno la = new ListaAluno();
          Aluno novo;
          for(int i = 0; i < 10; i++){
               novo = new Aluno();
               novo.matricula = i;
               la.inserirFim(novo);
          }
          la.remover(5);
          la.inserirInicio(new Aluno(11));
          System.out.println(la.quant());
     }
}