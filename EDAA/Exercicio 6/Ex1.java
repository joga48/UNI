import java.util.Random;

public class Ex1{
	public static void main(String[] args){
        int[] a = new int[500];
        Random r = new Random();
        int val = 0;
        for(int i = 0; i < a.length; i++){
            while(val == 0){
                val = r.nextInt(10001);
            }
            a[i] = val;
        }

        long inicio1 = System.nanoTime(); // vai calcular tempo total de execução do exercicio
//Exercicio 1 : Array ordenado e armazenado em outro array
        int[] newA = insertion(a);

//Exercicio 2 : uma posição do array original é gerada pelo random, e ela referencia a um valor que será buscado no novo array ordenado
        long inicioBinario = System.nanoTime();
        val = r.nextInt(500);
        int loc = binario(newA, a[val]);
        long tBinario = System.nanoTime() - inicioBinario;

//Exercicio 3 : mesmo principio do exercicio acima, porem realizando uma busca por quantos dele existem no array.
        long inicioSeq = System.nanoTime();
        val = r.nextInt(500);
        int quant = 0;
        for(int i = 0; i < newA.length; i++){
            if(newA[i] == a[val]){
                quant++;
            }
        }
        long tSeq = System.nanoTime() - inicioSeq;

//Exercicio 4: Vai calcular as % das buscas
        Long tTotal = System.nanoTime() - inicio1;
        double bin = tBinario / tTotal;
        double seq = tSeq / tTotal;
        //busca binária = 4% da execução
        //busca sequencial = 37% da execução

	}

	public static int[] insertion(int[] a){
        int tmp;
        int j;
        for(int i = 1; i < a.length; i++){
            tmp = a[i];
            j = i-1;
            while(j >= 0 && tmp < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
        return a;
    }
    
    public static int binario(int[] a, int x){
        int inicio = 0;
        int fim = a.length;
        int mid;
        while(inicio <= fim){
            mid = (inicio + fim) /2;
            if(a[mid] == x){
                return mid;
            }else if(x > a[mid]){
                inicio = mid;
    
            }else if(x < a[mid]){
                fim = mid;
            }
        }
        return 0;
    }
}