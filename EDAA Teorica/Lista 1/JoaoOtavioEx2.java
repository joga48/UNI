import java.io.*;

public class JoaoOtavioEx2{
	public static void main(String[] args)throws Exception{
		System.out.println("1- Recursivo\n2- iterativo");
		int i = readInt();
		System.out.println("Digite numero do termo que deseja ver: ");
		int x = readInt();

		if(i == 1){
			System.out.println(fibonacciR(x));
		}else if(i == 2){
			System.out.println(fibonacci(x));
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