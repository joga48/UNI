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
public class Ex2 {
    public static void main(String[] args){
        int[] arr = {7,8,9,10,11,12,13,14,15,16};
        boolean flag = true;
        for(int i = 0; i < 10; i++){
            for(int j = 2; j < arr[i]; j++){
                if(arr[i]%j == 0){
                    flag = false;
                }
            }//fim for
            if(flag && arr[i] > 2){
                System.out.println(arr[i] + " está na posição: " + i);
            }
            flag = true;
        }//fim for
    }//fim main
}
