import java.io.*;
public class Rec1{
	public static void main(String[] args)throws Exception{
		System.out.println("Digite numero para somatorio ");
		int num = readInt();
		System.out.println(somatorio(num));
	}

	public static int somatorio(int x){
		if(x == 1){
			return 1;
		}	

		return x + somatorio(x - 1);
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