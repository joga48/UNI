import java.io.*;

class Agenda{
    public String nome;
    public long tel;
    
    public Agenda(String nm, long t){
        this.nome = nm;
        this.tel = t;
    }
}
class PilhaAgenda {
    Agenda[] elemento;
    int tam;
    int topo;
    
    PilhaAgenda(){
        elemento = new Agenda[10];
        topo = 0;
        this.tam = 10; 
    }
    
    PilhaAgenda(int tam){
        elemento = new Agenda[tam];
        topo = 0;
        this.tam = tam;
    }
    
    public int getTam(){
        return this.tam;
    }
    
    public int getTopo(){
        return this.topo-1;
    }
    
    public void push(String nm, long t){
        if(topo >= tam){
            System.out.println("Limite ja atingido, aumentando a pilha");
            this.aumentar();
        }//fim if
        
        elemento[topo] = new Agenda(nm, t);
        topo++;
    }
    
    public Agenda pop(){
        if(topo == 0){
            System.out.println("Pilha vazia");
            return null;
        }
        topo--;
        return elemento[topo];
    }
    
    public Agenda top(){
        if(topo > 0){
            return elemento[topo - 1];
        }else{
            return null;
        }
    }
    
    public void aumentar(){
        this.tam = this.tam*2;
        Agenda[] aux = new Agenda[tam];
        for(int i = topo - 1; i >= 0; i--){
            aux[i] = this.elemento[i];
        }
        this.elemento = aux;
        aux = null;
    }
    
    public void swap(){
        Agenda aux = this.elemento[topo-1];
        this.elemento[topo - 1] = this.elemento[0];
        this.elemento[0] = aux;
        aux = null;
    }
}

class Pilha{
    int[] elemento;
    int tam;
    int topo;
    
    Pilha(){
        elemento = new int[10];
        topo = 0;
        this.tam = 10; 
    }
    
    Pilha(int tam){
        elemento = new int[tam];
        topo = 0;
        this.tam = tam;
    }
    
    public int getTam(){
        return this.tam;
    }
    
    public int getTopo(){
        return this.topo-1;
    }
    
    public void push(int i){
        if(topo >= tam){
            System.out.println("Limite ja atingido, aumentando a pilha");
            this.aumentar();
        }//fim if
        
        elemento[topo] = i;
        topo++;
    }
    
    public int pop(){
        if(topo == 0){
            System.out.println("Pilha vazia");
            return 0;
        }
        topo--;
        return elemento[topo];
    }
    
    public int top(){
        if(topo > 0){
            return elemento[topo - 1];
        }else{
            return 0;
        }
    }
    
    public void aumentar(){
        this.tam = this.tam*2;
        int[] aux = new int[tam];
        for(int i = topo - 1; i >= 0; i--){
            aux[i] = this.elemento[i];
        }
        this.elemento = aux;
    }
    
    public void swap(){
        int aux = this.elemento[topo-1];
        this.elemento[topo - 1] = this.elemento[0];
        this.elemento[0] = aux;
    }
    
    public void down(){
        for(int i = topo - 1; i <= 0; i--){
            System.out.println(elemento[i]);
        }
        topo = 0;
    }
}

public class Test{
    public static void main(String[] args) throws Exception{
       int x;
       do{
            System.out.println("PROGRAMA PILHA\n"
                   +"0- sair\n"
                   +"1- Agenda\n"
                   +"2- Testes de pilha\n"
                   +"3- Pilha par/impar\n"
            );
            x = readInt();
            if(x == 1){
                pilhaAgendaTeste();
            }else if(x == 2){
                pilhaTeste();             
            }else if(x == 3){
                pilhaParImpar();
            }
       }while(x != 0);
    }
    
    public static void pilhaParImpar() throws Exception{
        Pilha p1 = new Pilha(10);
        Pilha p2 = new Pilha(10);
        int x;
        for(int i = 0; i < 10; i++){
            System.out.println("Digite numero: ");
            x = readInt();
            if(x %2 == 0){
                p1.push(x);
            }else{
                p2.push(x);
            }
        }
        p1.down();
        p2.down();
    }
    
    public static void pilhaAgendaTeste() throws Exception{
       int x;
       PilhaAgenda pa = new PilhaAgenda();
       int tam = pa.getTam();
       String nm;
       long t;
       do{
            System.out.println("PROGRAMA PILHA\n"
                   +"0- sair\n"
                   +"1- Inserir itens\n"
                   +"2- Remover itens\n"
                   +"3- imprimir tamanho\n"
                   +"4- Imprimir topo"
            );
            x = readInt();
            if(x == 1){
                if(pa.getTopo() >= tam){
                    System.out.println("Pilha muito pequena, tamanho será aumentado");
                }
                System.out.println("Digite nome do novo contato");
                nm = readLine();
                System.out.println("Digite numero do contato");
                t = readLong();
                pa.push(nm, t);
            }else if(x == 2){
               if(pa.getTopo() >= 0){
                   System.out.println(pa.pop().nome);
               }else{
                   System.out.println("Pilha vazia");
               }
            }else if(x == 3){
               if(pa.getTopo() >= 0){
                   System.out.println(pa.getTam());
               }else{
                   System.out.println("Pilha vazia");
               } 
            }else if(x == 4){
                if(pa.getTopo() >= 0){
                   System.out.println(pa.top().nome + " tel: " + pa.top().tel);
               }else{
                   System.out.println("Pilha vazia");
               }
            }
           
       }while(x != 0);
    }
    
    public static void pilhaTeste() throws Exception{
        int x, t;
        Pilha p = new Pilha(10);
        do{
            System.out.println("PROGRAMA PILHA\n"
                   +"0- sair\n"
                   +"1- Inserir itens\n"
                   +"2- Remover itens\n"
                   +"3- imprimir tamanho\n"
                   +"4- Imprimir topo\n"
                   +"5- Swap"
            );
            x = readInt();
            if(x == 1){
                if(p.getTopo() >= p.getTam()){
                    System.out.println("Pilha muito pequena, tamanho será aumentado");
                }
                System.out.println("Digite numero");
                t = readInt();
                p.push(t);
            }else if(x == 2){
               if(p.getTopo() >= 0){
                   System.out.println(p.pop());
               }else{
                   System.out.println("Pilha vazia");
               }
            }else if(x == 3){
               if(p.getTopo() >= 0){
                   System.out.println(p.getTam());
               }else{
                   System.out.println("Pilha vazia");
               } 
            }else if(x == 4){
                if(p.getTopo() >= 0){
                   System.out.println(p.top());
               }else{
                   System.out.println("Pilha vazia");
               }
            }else if(x == 5){
                p.swap();
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
    
    public static long readLong() throws Exception{ 
		
	BufferedReader leia = new BufferedReader(new InputStreamReader(System.in));
	String aux = "";
	try{
            aux = leia.readLine();
	}catch (Exception e){
            System.out.println("Error!");
	}
	return Long.parseLong(aux);
    }

    public static String readLine() throws Exception{ 
	BufferedReader leia = new BufferedReader(new InputStreamReader(System.in));
	String aux = leia.readLine();
	return aux;
    }
}
