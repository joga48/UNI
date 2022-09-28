public class JoaoOtavioEx5{
	public static void main(String[] args){
		int[] vet = {1,5,6,80,43,30,100,2,7};
		System.out.println(maiorElemento(vet, vet[0], 1));
	}

	public static int maiorElemento(int[] vet, int maior, int i){
		if(i >= vet.length){
			return maior;
		}
		if(vet[i] > maior){
			maior = vet[i];
		}
		return maiorElemento(vet, maior, i+1);
	}
}