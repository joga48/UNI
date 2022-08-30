/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author 1221116977
*/
import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int[] bolsos = new int[10];
        System.out.println("Preencha 10 valores separados por ENTER!");
        for(int i = 0; i < 10; i++){
            bolsos[i] = leia.nextInt();
        }
        System.out.println("Agora diga qual desses valores é o menor roubado pelo ladrão!");
        int menor = leia.nextInt();
        int soma = 0;
        System.out.print("Bandidos nas posicoes: ");
        for(int i = 0; i < 10; i++){
            if(bolsos[i] >= menor && bolsos[i]%10 == 0){
                soma+=bolsos[i];
                System.out.print(bolsos[i] + " ");
            }
        }
        System.out.print("\nA soma roubada: " + soma + "\n");
        
    }
}
