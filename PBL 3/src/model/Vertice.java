/*****************************************************************************************
 * PROBLEMA 3
 * Autora: Evelyn Suzarte Fernandes
 * Componente Curricular: MI-Programação - 2019.2
 * Concluido em: 22/03/2020
 * Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 * trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 * apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 * de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 * do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ******************************************************************************************/

package model;

import java.util.ArrayList;


/**Classe que cria a vértice do Grafo
 *
 * @author Evelyn Suzarte
 * @version 1.0
 */

public class Vertice implements Comparable<Vertice> {
	private String nome;
	private int distancia = 0;
	private Vertice pai;
	private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	private ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
	private boolean visitado = false;
        private boolean terminal = true;

	
	/**
        * Contrutor para criar vértice
        * @param nome String - nome da vértice
        * @param terminal boolean - se é terminal ou não 
 
        */
	public Vertice(String nome,boolean terminal){
		this.nome = nome;
                this.terminal = terminal;

	}
        
	/**
        * Método para retornar nome do vértice
        * @return String
        */
	public String getNome() {
		return nome;
	}
	
        /**
        * Método para atualizar nome do vértice
        * @param nome String
        */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
        /**
        * Método para retornar distancia 
        * @return int
        */
	public int getDistancia() {
		return distancia;
	}
	
        /**
        * Método para atualizar distancia
        * @param distancia int
        */
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
        
        /**
        * Método para retornar o vértice pai
        * @return Vertice
        */
	public Vertice getPai() {
		return pai;
	}
	
        /**
        * Método para atualizar o vértice pai
        * @param pai Vertice
        */
	public void setPai(Vertice pai) {
		this.pai = pai;
	}
	
        
        /**
        * Método para retornar o status de visitado
        * @return boolean
        */
	public boolean isVisitado() {
		return visitado;
	}
	
        
        /**
        * Método para atualizar o status de visitado
        * @param visitado boolean
        */
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

        /**
        * Método para retornar lista de vértices incidentes
        * @return ArrayList
        */
	public ArrayList<Aresta> getIncidentes() {
		return incidentes;
	}

        /**
        * Método para retornar se é terminal ou não
        * @return boolean
        */
        public boolean isTerminal() {
            return terminal;
        }

        
        /**
        * Método para atualizar se é terminal ou não
        * @param terminal boolean
        */
        public void setTerminal(boolean terminal) {
            this.terminal = terminal;
        }

     
        /**
        * Método para adicionar os vertices incidentes
        * @param incide Aresta
        */
	public void addIncidentes(Aresta incide) {
            this.incidentes.add(incide);
            
            //se a origem e se o destino não é vizinho = o destino é vizinho 
            if ((incide.getOrigem().getNome().equals(this.getNome())) && (!this.isVizinho(incide.getDestino()))){
                this.addVizinhos(incide.getDestino());

            }//se o destino é
            else if ((incide.getDestino().getNome().equals(this.getNome())) && (!this.isVizinho(incide.getOrigem()))){
                this.addVizinhos(incide.getOrigem());
            }
	}
	
        /**
        * Método para atualizar vertices vizinhos
        * @param vizinho Vertice
        */
	public void addVizinhos(Vertice vizinho) {
		this.vizinhos.add(vizinho);
	}

        /**
        * Método para retornar lista dos vértices vizinhos
        * @return ArrayListe
        */
	public ArrayList<Vertice> getVizinhos() {
		return vizinhos;
	}
	
        /**
        * Método para verificar se é vizinho
        * @param vizinho Vertice
        * @return boolean
        */
	public boolean isVizinho(Vertice vizinho){
		int i;
		
		for (i = 0;i<this.vizinhos.size();i++)                         
                    if (this.vizinhos.get(i).getNome().equals(vizinho.getNome())) //busca para ver se é vizinho
                        return true;                                              //se sim
		
		return false;
	}

	@Override
	public int compareTo(Vertice vertice) {
	
        if (this.getNome().equals(vertice.getNome()) && this.getPai().getNome().equals(vertice.getPai().getNome()) 
                && this.getDistancia() == vertice.getDistancia() /*&& this.getIncidentes().containsAll(vertice.getIncidentes())
                && this.getVizinhos().containsAll(vertice.getVizinhos())*/) {
                return 1 ;
            }
        else
            return 0;

	}

	@Override
	public String toString() {
		String s = " ";
		s+= this.getNome();
		return s;
	}
	 
}
