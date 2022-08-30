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
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        for(int i = 0; i  < 10; i++){
            for(int j = 0; j < 10; j++){
                arr[i][j] = i+j;
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("\n");
        }
    }
    
}
