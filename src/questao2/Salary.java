package questao2;

import java.util.Arrays;
import java.util.Scanner;

public class Salary {
    public static void main (String[] args){
        int resto;
        double mediana;
        Scanner scanner = new Scanner(System.in);
        int tamanho = scanner.nextInt();/*Lê o tamanho da lista*/
        System.out.print("Digite o tamanho da lista: ");
        System.out.println("Digite o salario de " + tamanho + " trabalhadores");
        double[] numbers = new double[tamanho];
        for (int i = 0; i < tamanho; i++){/*Lê os elementos da lista*/
            System.out.print("Salario " + (i+1) + ": ");            
            numbers[i] = scanner.nextDouble();
        }
        scanner.close();
        Arrays.sort(numbers);/*Organiza os elementos da lista em ordem crescente*/
        resto = numbers.length;
        if (resto%2==1){/*Pega o elemento no meio da lista caso essa seja impar*/
            resto/=2;
            mediana = numbers[resto];
            if (numbers.length==1){
                mediana = numbers[0];
            }
        }
        else{/*Faz a media dos elementos no meio caso o tamanho da lista seja par*/
            resto/=2;
            mediana = (numbers[resto] + numbers[resto-1])/2;        
        }
        System.out.println(Arrays.toString(numbers));
        System.out.print("Esta e a mediana dos salarios: ");
        System.out.println(mediana);
    }
}
