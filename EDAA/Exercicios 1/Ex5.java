import java.util.Scanner;

class Item{
    
    private int valor;
    private boolean mudado;
    
    Item(){
        this.valor = 0;
        this.mudado = false;
    }//fim Item
    
    Item(int valor){
        this.valor = valor;
        this.mudado = false;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public boolean getMudado(){
        return this.mudado;
    }
    
    public void setValor(int valor){
        if(!this.mudado){this.valor = valor;}
        this.mudado = true;
    }
}
public class Ex5 {
    public static void main(String[] args){
        Item[] item = new Item[10];
        boolean run = true;
        int valor, indice, cont;
        Scanner leia = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            item[i] = new Item();
        }
        while(run){
            for(int i = 0; i < 10; i++){
                item[i].getValor();
                System.out.print(item[i].getValor() + " ");
            }
            System.out.println("\nDeseja alterar algum item? \n1- sim\n2- nao");
            cont  = leia.nextInt();
            if(cont == 1){
                System.out.println("Qual? [0-9]");
                indice = leia.nextInt();
                System.out.println("Qual novo valor?");
                valor = leia.nextInt();
                item[indice].setValor(valor);
            }else{
                run = false;
            }
        }
    }
}
