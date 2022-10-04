import java.io.*;
public class Rec3{
	public static void main(String[] args)throws Exception{
		System.out.println("Digite (na ordem): base e expoente: ");
		int base = readInt();
		int exp = readInt();
		System.out.println(potencia(base, exp));
	}

	public static int potencia(int x, int y){
		return potencia(x,y,0);
	}

	public static int potencia(int x, int y, int i){
		if(i >= y){
			return 1;
		}
		return x * potencia(x, y, i+1);
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