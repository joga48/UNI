import java.io.*;

public class JoaoOtavioEx3{
	public static void main(String[] args)throws Exception{
		int i;
		int x;
		long inicio;
		long fim;
		while(1 == 1){
			System.out.println("1- Recursivo\n2- iterativo\n0- sair");
			i = readInt();
			System.out.println("Digite numero do termo que deseja ver: ");
			x = readInt();
			
			if(x != 0){
				inicio = System.nanoTime();
				if(i == 1){
					System.out.println(fibonacciR(x));
				}else if(i == 2){
					System.out.println(fibonacci(x));
				}
				fim = System.nanoTime() - inicio;
				System.out.println("tempo decorrido de exec(microsgundos) para " + x + "termos = " + fim/1000);
			}else{
				break;
			}
		}
	}

	public static int fibonacciR(int x){
		if(x <= 2){
			return 1;
		}
		return (fibonacciR(x-1) + fibonacciR(x-2));
	}

	public static int fibonacci(int x){
		int t = 1;
		int aux = 0;
		int aux2 = 0;
		for(int i = 1; i < x; i++){
			aux2 = aux;
			aux = t;
			t = aux2 + aux;
		}
		return t;
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
}