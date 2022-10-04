import java.io.*;
public class Rec2{
	public static void main(String[] args)throws Exception{
		System.out.println("Digite numero a ser mostrado em ordem: ");
		int num = readInt();
		printElementos(num);
	}

	public static void printElementos(int i){
		if(i < 0){
			return;
		}
		printElementos(i - 1);
		System.out.println(i);
		
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