import java.io.*;
public class JoaoOtavioEx1{
	public static void main(String[] args)throws Exception{
		System.out.println("Digite numero: ");
		int x = readInt();
		System.out.println(somaN(x));
	}

	public static int somaN(int x){
		if(x == 0){
			return 0;
		}
		return x + somaN(x-1);
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