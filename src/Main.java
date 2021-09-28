import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Processo;

public class Main {

	

	public static void main(String[] args) throws InterruptedException {
		int qtProcessos;
		//Armazena o tempo de espera de cada processo
		int aux =0;
		
		List< Processo> processoList = new ArrayList<Processo>() ;
		Scanner leitor = new Scanner(System.in);
		Random gerador = new Random();
		
		System.out.println("Deseja criar quanto processos?");
		qtProcessos = leitor.nextInt();
		
		for ( int index = 0; index < qtProcessos; index++) {
			
			if( index == 0){
				processoList.add( new Processo("Processo " + index, 0 ,gerador.nextInt(25 ) + 1, null) );
			}else{
				processoList.add( new Processo("Processo " + index, gerador.nextInt(25 ) + 1 ,
				gerador.nextInt(25 ) + 1, null) );
			}
			
			
			
		}
		
		Processo.ordenar(processoList);
        Processo.updateTempoEspera(processoList);

		System.out.println("Os processos forma criados.");
		System.out.println("-----------------------------");
		System.out.println("INICIANDO A EXECUÇÃO.....");
		System.out.println("-----------------------------");
		
		for ( int index  = 0; index < processoList.size(); index++) {
			System.out.println("-----------------------------");
		    System.out.println("PROCESSANDO: ");
		    Processo atual = processoList.get(index);
		    
		   
		    
		    processoList.get(index).imprimir();
		    for ( int i =1; i <= processoList.get(index).getBt(); i++) {
		    	Thread.sleep(150);
		    	System.out.println("-" +i);
		    	
		    }
		    System.out.println(  processoList.get(index).getNome() + " foi concluído.");
		    System.out.println("-----------------------------");
		    
		    
		    
		   
		}
		
		// mediaEspera =  somatoriaEspera / processoList.size();
		System.out.println("-----------------------------");
		System.out.println("  PROCESSAMENTO CONCLUÌDO");
		System.out.println("   -O Tempo médio de espera foi de " + Processo.calcularMediaEspera(processoList) );
		System.out.println("-----------------------------");
		
        leitor.close();
	}

}
