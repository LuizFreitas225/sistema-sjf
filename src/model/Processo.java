package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Processo  implements Comparable<Processo> {
    private String  nome ;
    private Integer at;
    private Integer bt;
    private Integer tempoEspera;
    
    
    
    
	
	
	
	public Processo(String nome, Integer at, Integer bt, Integer tempoEspera) {
		super();
		this.nome = nome;
		this.at = at;
		this.bt = bt;
		this.tempoEspera = tempoEspera;
	}


	public Processo() {
		super();
		
	}
    
	public void  imprimir() {
		System.out.println("*******************");
		System.out.println("NOME: "  + this.getNome());
		System.out.println("AT: "  + this.getAt());
		System.out.println("BT: "  + this.getBt());
		System.out.println("TE: "  + this.getTempoEspera());
		System.out.println("*******************");
	
	}
     

	public  static List< Processo> ordenar (List< Processo> lista){
		List<Processo> listaOrdenada = new ArrayList<Processo>();
		Collections.sort(lista); 
		Integer burstTimeTotal = lista.get(0).getBt();
		listaOrdenada.add(lista.get(0));
		Processo processoAux;
          for( int index = 1 ; index < lista.size(); index++){
			  processoAux = null;
			  for ( int i= 1; i <  lista.size(); i++){
                   if( index == i || listaOrdenada.contains(lista.get(i))){
					   continue;
				   }
				  
				   if ( lista.get(index).getBt() > lista.get(i).getBt() && lista.get(i).getAt() < burstTimeTotal  ){
                      processoAux = lista.get(i);
				   }

			  }
			 if( processoAux == null){
				listaOrdenada.add(lista.get(index));
				burstTimeTotal += lista.get(index).getBt();
			 }
			 else{
				listaOrdenada.add(processoAux); 
				burstTimeTotal += processoAux.getBt();
			 }
		  }

		  return  listaOrdenada;
	} 

	public static void updateTempoEspera(List< Processo> lista){

		Integer burstTimeTotal = lista.get(0).getBt();
        lista.get(0).setTempoEspera(0);

		for( int index = 1 ; index < lista.size(); index++){
			if ( lista.get(index).getAt() >= burstTimeTotal ){
				lista.get(index).setTempoEspera(0);
			}
			else{
				lista.get(index).setTempoEspera(burstTimeTotal - lista.get(index).getAt());
			}

			burstTimeTotal += lista.get(index).getBt();
		}
	}

	public static Double calcularMediaEspera(List< Processo> lista){
		Double somatoriaEspera = 0.0;
		for( int index = 0 ; index < lista.size(); index++){
           somatoriaEspera += lista.get(index).getTempoEspera();
		}
		return (Double) ( somatoriaEspera / lista.size() );
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((at == null) ? 0 : at.hashCode());
		result = prime * result + ((bt == null) ? 0 : bt.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tempoEspera == null) ? 0 : tempoEspera.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (at == null) {
			if (other.at != null)
				return false;
		} else if (!at.equals(other.at))
			return false;
		if (bt == null) {
			if (other.bt != null)
				return false;
		} else if (!bt.equals(other.bt))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tempoEspera == null) {
			if (other.tempoEspera != null)
				return false;
		} else if (!tempoEspera.equals(other.tempoEspera))
			return false;
		return true;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAt() {
		return at;
	}
	public void setAt(Integer at) {
		this.at = at;
	}
	public Integer getBt() {
		return bt;
	}
	public void setBt(Integer bt) {
		this.bt = bt;
	}


	public Integer getTempoEspera() {
		return tempoEspera;
	}


	public void setTempoEspera(Integer tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
    
    
	public int compareTo(Processo processo) {
		if(this.getAt() < processo.getAt()){
		return -1;
		}
		else if(this.getAt() > processo.getAt()){
		return 1;
		}
		return 0;
	}
		
}
