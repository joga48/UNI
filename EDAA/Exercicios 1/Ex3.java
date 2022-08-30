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
public class Ex3 {
    public static void main(String[] args){
        String[] carros = {"Ka", "Onix", "Gol", "C3", "Mobi"};
        int[] kmpl = {14,12,17,9,16};
        int maior = 0;
        for(int i = 0; i < 5; i++){
            if(kmpl[i] > kmpl[maior]){
                maior = i;
            }
        }
        System.out.println("Mais economico: " + carros[maior] + ", com: " + kmpl[maior] + "km/h");
        for(int i = 0; i < 5; i++){
            System.out.println(carros[i] + " consome: " + ((double)1000/kmpl[i]) + " litros para 1000km");
        }
    }
}
