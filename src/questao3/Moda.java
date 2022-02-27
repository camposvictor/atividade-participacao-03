package questao3;

import java.util.Scanner;

public class Moda {

	private static Scanner sc;
	
	public static void main(String[] args) {
		int quant; //quantidade de numeros a serem digitados
		boolean para = true; //condição do while para caso a quantidade seja menor que dois numeros
		sc = new Scanner(System.in);
		System.out.println("Quantos numeros deseja digitar? (OBS.: Digite um numero maior que 1)");
		quant=sc.nextInt();
		if(quant<=1){ //condicao para iniciar a repeticao a releitura do quant
			while(para){
				System.out.println("Numero invalido! (OBS.: Digite um numero maior que 1)");
				quant=sc.nextInt();
				if(quant>1){ //condicao para finalizar a releitura de quant
					para=false; 
				}
			}
		}
		
		int[] numeros = new int[quant]; //array para armazenar os "n" numeros
		int contador=0; //contador que armazenara a quantidade de vezes que a moda foi repetida
		int modaPri=0; //variavel para armazenar a primeira (e/ou unica) moda
		int cont=1; //contador dinâmico de vezes que cada numero é repetido durante o ciclio do [for j]
		
		atribuir(quant,numeros); // atribui os valores dos "n" numeros
		ordenar(quant,numeros); // ordena os numeros em ordem crescente para a facilitação da divisão para encontrar o moda
		
		int contarRepeticoes; //variavel que ira aumentar em 1 sempre que o [for j] encontrar a condição do if, fazendo com que não tenha uma redundancia de contagem
		for(int i=0;i<quant;i++){
			contarRepeticoes=0; //igualado a 0 sempre que o [for i] reiniciar, para não somar no [for j] um valor que não faz parte da nova repetição
	        for(int j=(i+1+contarRepeticoes);j<quant;j++){
				if(numeros[i]==numeros[j]){
					cont++; 
					contarRepeticoes++;
				}
	        }
	        if(cont>=2 && contador<cont){ //quando encontrado uma ou mais repetições
				modaPri=numeros[i];
				contador=cont;
	        }
	        cont=1;
	    }
		if(contador==0){ //caso não encontre nenhum moda
			System.out.println("Nenhum numero de repetiu!");
		}
		else{ //caso encontre um ou mais modas
			System.out.println("Repetido "+contador+" vezes.");
			System.out.print("Moda(s): "+modaPri+" " );
			for(int i=0;i<quant;i++){
				contarRepeticoes=0;
			    for(int j=(i+1+contarRepeticoes);j<quant;j++){
			    	if(numeros[i]!=modaPri){
						if(numeros[i]==numeros[j]){
							cont++;
							contarRepeticoes++;
						}
			    	}
			    }
			    if(cont==contador){ //caso exista mais de um moda
			    	if(i>0 && numeros[i]!=numeros[i-1]){ //para não existir chances de imprimir o mesmo numero mais de uma vez
			    		System.out.print(numeros[i]+" ");
			    	}
			    }
			    cont=1;
			}
		}
		System.out.printf("\n");
	}
	
	public static void atribuir(int quant, int numeros[]){ //funcao que atruibui o valor aos "n" numeros
		System.out.printf("\n");
		System.out.printf("--> Digite os %d numeros <--\n", quant);
		for(int i=0;i<quant;i++){
			System.out.printf("%dº numero: ", i+1);
			numeros[i]=sc.nextInt();
		}
		System.out.printf("\n");
	}
	
	public static void ordenar(int quant, int numeros[]){ //funcao que ordena em ordem crescente
		for(int i=0;i<quant;i++) {
			for(int j=0;j<quant;j++){
				if(numeros[i]<numeros[j]){
					int aux=numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=aux;
				}
			}
		}
		/*System.out.println("Sequencia: "); //parte impressa dos numeros em sequencia, onde cada linha é composta por um numero e suas repeticoes 
		for(int i=0;i<quant;i++){
			if(i>0 && numeros[i]!=numeros[i-1]){
				System.out.printf("\n");
			}
			System.out.printf("%d ", numeros[i]);
		}
		System.out.printf("\n\n");*/
	}

}