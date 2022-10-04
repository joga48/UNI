import java.io.*;

class Fila{
    char[] arr;
    
    int fim;
    
    Fila(){
        arr = new char[10];
        fim = 0;
    }
    
    Fila(int x){
        arr = new char[x];
        fim = 0;
    }
    
    public void push(char x){
        if(fim >= arr.length){
            extend();
        }
        this.arr[fim] = x;
        fim++;
    }
    
    public char pop(){
        char x = this.arr[0];
        for(int i = 0; i < arr.length; i++){
            if(i == (arr.length - 1)){break;}
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = ' ';
        fim--;
        return x;
    }
    
    public void mostrar(){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    
    public void extend(){
        char[] aux = new char[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            aux[i] = arr[i];
        }
        arr = aux;
    }
}


public class TesteFila {
    public static void main(String args[]) throws Exception{
      Fila arr = new Fila();
      System.out.println("Digite as letras separando por espaco ");
      String str = readLine();
      String[] aux = str.split(" ");
      Fila x = new Fila(1);
      Fila y = new Fila(1);
      int tam = aux.length;
      
      for(int i = 0; i < tam; i++){
          if((int)aux[i].charAt(0) >= 65 && (int)aux[i].charAt(0) <= 90){
              x.push(aux[i].charAt(0));
          }else if((int)aux[i].charAt(0) >= 97 && (int)aux[i].charAt(0) <= 122){
              y.push(aux[i].charAt(0));
          }//fim else if
      }//fim for
      
      for(int i = 0; i < tam; i++){
          if(x.fim > 0){
            System.out.println(x.pop());
          }else{ 
            System.out.println(y.pop());
          }
      }//fim for
    }
    
    public static int readInt() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = br.read();
        return (int) x;
    }
    
    public static String readLine() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        return x;
    }
}