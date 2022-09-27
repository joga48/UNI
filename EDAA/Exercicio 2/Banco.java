/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author 1221116977
 */
import java.util.Scanner;

class TContaBancaria{
    private int numero;
    private int agencia;
    private String nome;
    private String CPF;
    private double saldo;
    private static int count = 0;
    
    TContaBancaria(){
        count++;
        this.numero = count;
        this.agencia = 0;
        this.nome = "";
        this.CPF = "";
        this.saldo = 0.0;
    }
    
    TContaBancaria(String nome, String CPF, int agencia){
        count++;
        this.numero = count;
        this.agencia = agencia;
        this.nome = nome;
        this.CPF = CPF;
        this.saldo = 0.0;
    }
    
    public void getNome(){
        System.out.println(this.nome);
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public double sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return valor;
        }else{
            System.out.println("Valor insuficiente");
            return 0;
        }
    }
    
    public void receber(double valor){
        this.saldo += valor;
    }
    
    public static boolean transferencia(TContaBancaria from, TContaBancaria to, double valor){
        if(from.getSaldo() >= valor){
            from.sacar(valor);
            to.receber(valor);
            return true;
        } else {
            return false;
        }
    }
}
public class Banco {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        System.out.println("Quantas contas, ao maximo, deseja criar? ");
        int cont = leia.nextInt();
        int agencia = 0001;
        String nome;
        String CPF;
        int x;
        int i = 0;
        int numCont;
        double valor;
        int aux;
        TContaBancaria[] contas = new TContaBancaria[cont];
        do{
            System.out.println("selecione uma operacao:"
                    + "\n1- Criar nova conta"
                    + "\n2- checar saldo"
                    + "\n3- adicionar saldo"
                    + "\n4- sacar"
                    + "\n5- transferencia entre contas"
                    + "\n0- sair");
            x = leia.nextInt();
            switch (x) {
                case 1:
                    if(i < cont){
                        System.out.print("Digite nome da conta " + (i+1) + ": ");
                        nome = leia.nextLine();
                        nome = leia.nextLine(); //1 entrada só estava bugando... por que?
                        
                        System.out.print("\nDigite CPF da conta: ");
                        CPF = leia.nextLine();
                        contas[i] = new TContaBancaria(nome, CPF, agencia);
                        contas[i].getNome();
                        System.out.println("\nObrigado, conta de numero " + (i+1) + " Criada");
                        i++;
                    }else{
                        System.out.println("Limite de contas atingido!\n");
                    }   break;
                case 2:
                    System.out.println("Digite qual numero da conta deseja ver o saldo: ");
                    numCont = leia.nextInt()-1;
                    System.out.println("Saldo: " + contas[numCont].getSaldo());
                    break;
                case 3:
                    System.out.println("Digite qual numero da conta deseja adicionar saldo: ");
                    numCont = leia.nextInt()-1;
                    System.out.println("Quando deseja adicionar? ");
                    valor = leia.nextDouble();
                    contas[numCont].setSaldo(valor);
                    break;
                case 4:
                    System.out.println("Digite qual numero da conta deseja sacar: ");
                    numCont = leia.nextInt()-1;
                    System.out.println("Digite o valor que deseja sacar: ");
                    valor = leia.nextDouble();
                    System.out.println(contas[numCont].sacar(valor));
                    break;
                case 5:
                    System.out.println("Digite qual numero da conta deseja transferir DE: ");
                    numCont = leia.nextInt()-1;
                    System.out.println("Digite qual numero da conta deseja tarnsfarir PARA: ");
                    aux = leia.nextInt()-1;
                    System.out.println("Digite qual valor deseja transferir: ");
                    valor = leia.nextDouble();
                    if(TContaBancaria.transferencia(contas[numCont],contas[aux],valor)){
                        System.out.println("Transferencia bem sucedida!!!");
                    }else{
                        System.out.println("Valor insuficiente.");
                    }   break;
                default:
                    break;
            }
        }while(x != 0);
    }    
}
