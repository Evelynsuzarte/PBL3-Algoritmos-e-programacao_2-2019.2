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

/**Classe que cria a aresta do Grafo
 *
 * @author Evelyn Suzarte
 * @version 1.0
 */
public class Aresta {

	private int peso;
	private Vertice origem;
	private Vertice destino;
	private boolean visitado = false;
	
	/**
        * Contrutor para criar aresta
        * @param peso int - peso das arestas
        * @param origem Vertice - ponto inicial
        * @param destino Vertice - ponto destino
        * @param terminal boolean - indica se é o destino é terminal
        */
	public Aresta(int peso, Vertice origem, Vertice destino, Boolean terminal) {
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
                this.destino.setTerminal(terminal);
                
	}
	
        /**
        * Método para retornar se ja foi visitado
        * @return boolean
        */
	public boolean isVisitado() {
		return visitado;
	}

        /**
        * Método para atualizar se ja foi atualizado
        * @param visitado boolean
        */
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

        /**
        * Método para retornar o peso da aresta
        * @return int
        */
	public int getPeso() {
		return peso;
	}

        /**
        * Método para atualizar o peso
        * @param peso int
        */
	public void setPeso(int peso) {
		this.peso = peso;
	}

        /**
        * Método para retornar a origem da vertice
        * @return Vertice
        */
	public Vertice getOrigem() {
		return origem;
	}

        /**
        * Método para atualizar origem da aresta
        * @param origem Vertice
        */
	public void setOrigem(Vertice origem) {
        	this.origem = origem;
	}

        /**
        * Método para retornar o destino da aresta
        * @return Vertice
        */
	public Vertice getDestino() {
		return destino;
	}

        /**
        * Método para atualizar destino da aresta
        * @param destino Vertice
        */
	public void setDestino(Vertice destino) {
            this.destino = destino;
	}
        
	
	@Override
	public String toString() {
		String s = " ";
		s+= this.getOrigem().getNome() + this.getDestino().getNome();
		return s;
	}
        
       
  

}
