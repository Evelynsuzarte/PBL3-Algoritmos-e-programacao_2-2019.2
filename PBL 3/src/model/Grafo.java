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
import java.util.Arrays;
import java.util.Collections;

/**Classe que cria a estrutura de dados Grafo
 *
 * @author Evelyn Suzarte
 * @version 1.0
 */

public class Grafo implements Comparable {

    private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    private boolean ciclo = false;

    
    /**
    * Método para retornar vértices
    * @return ArrayList
    */
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    /**
    * Método para retornar arestas
    * @return ArrayList
    */
    public ArrayList<Aresta> getArestas() {
        return arestas;
    }
    
    /**
    * Método para limpar todo o grafo
    */
    public void limparGrafo() {
        arestas.clear();
        vertices.clear();
        setCiclo(false);
    }

  
    


    /**
    * Método para adicionar aresta
    * @param peso int 
    * @param origem String
    * @param destino String 
    * @param terminal boolean
    */
    public void addAresta(int peso, String origem, String destino, boolean terminal) {
        int i = 0, j = 0, k;

        
        //adiciona vertices e retorna posicao
        i = addVertice(origem,terminal);
        j = addVertice(destino,terminal);
        
        //adiciona aresta na lista
        Aresta a = new Aresta(peso,vertices.get(i),vertices.get(j),terminal);

        temCiclo(a);
        arestas.add(a);
        k = arestas.size();

        //adiciona aresta na lista de arestas incidentes em cada vertice
        vertices.get(i).addIncidentes(arestas.get(k - 1));
        vertices.get(j).addIncidentes(arestas.get(k - 1));
    }

    

    /**
    * Método para adicionar vértices
    * @param nome String
    * @param terminal boolean
    * @return int
    */
    public int addVertice(String nome,boolean terminal) {
        int i = posicaoVertice(nome);

        if (i == vertices.size()) {
            vertices.add(new Vertice(nome,terminal));
            return (vertices.size() - 1);                  //retorna posicao da vertice
        }

        return i;
    }
    
    

    
    /**
    * Método para retornar posição
    * @param nome int
    * @return int 
    */
    public int posicaoVertice(String nome) {
        int i;

        for (i = 0; i < vertices.size(); i++) {                                 //percorre o vetor de vertics
            if (vertices.get(i).getNome().equals(nome)) {                       //se o nome for dela for igual ao do nome pra buscar
                return i;                                                       //retorna posição
            }
        }

        return vertices.size();                                                 //se nao encontrar retorna o tamanho da lista vertices
        
    }

    /**
    * Método para buscar vertice
    * @param nome String
    * @return Vertice
    */
    public Vertice buscarVertice(String nome) {
        return vertices.get(posicaoVertice(nome));              //busca a vertice no ArrayList a partir do metodo
                                                                // que busca a posição
    }

    /**
    * Método para buscar aresta
    * @param vet1 Vertice
    * @param vet2 Vertice
    * @return Aresta
    */
    public Aresta buscarAresta(Vertice vet1, Vertice vet2) {
        int i;
        for (i = 0; i < arestas.size(); i++) {                                             //loop a partir da quantidade de arestas
            if (((arestas.get(i).getOrigem().getNome().equals(vet1.getNome()))             //se a origem da aresta for igual ao nome da vertice 1 que se quer buscar
                    && (arestas.get(i).getDestino().getNome().equals(vet2.getNome())))     //se o destino da aresta for igual ao nome da vertice 1  que se quer buscar
                    || ((arestas.get(i).getOrigem().getNome().equals(vet2.getNome()))      //ou se a origem da aresta for igual ao nome da vertice 2 que se quer buscar
                    && (arestas.get(i).getDestino().getNome().equals(vet1.getNome())))) {  //se o destino da aresta for igual ao nome da vertice 2  que se quer buscar
                return arestas.get(i);
            }
        }
        return null;
    }

    
    /**
    * Método para apagar a vértice escolhida e suas arestas
    * @param v_apagar String
    * @return boolean
    */
     public boolean removerVertice(String v_apagar) {
        int id = 0;
        boolean encontrado = false;
         
        for (int i = 0; i < vertices.size(); i++) {                                        //a partir da lista de vértices
             if (vertices.get(i).getNome().equals(v_apagar)) {
                 vertices.get(i).getIncidentes().clear();                                   //limpa lista de incidentes
                 vertices.get(i).getVizinhos().clear();                                     //limpa lista de vizinhos
                 id = i;                                                                    //guarda posição da vertice 
                 encontrado = true;                                                         //marca que encontrou vertice  
                 break;                                                                     //sai do loop
             }
             else 
                 encontrado = false;                                                        //não encontrou em nenhum momento
         }
        
        if(encontrado){         
             for (int j = 0; j < arestas.size(); j++) {
                 if (arestas.get(j).getOrigem().getNome().equals(v_apagar) || arestas.get(j).getDestino().getNome().equals(v_apagar))                 
                     arestas.remove(j);                
            }
      
            vertices.get(id).getIncidentes().clear();
            vertices.get(id).getVizinhos().clear();
            vertices.remove(id);
        
        }
    
        return encontrado;
}
        
    
    
    
    
    /**
    * Método para retornar o caminho menos custoso entre duas vértices utilizando o algoritmo de Dijkstra
    * @param v1 Vertice
    * @param v2 Vertice
    * @return ArrayList
    */
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(Vertice v1,Vertice v2) {
        
    	ArrayList<Vertice> menorCaminho = new ArrayList<Vertice>();                         // Lista que guarda os vertices pertencentes ao menor caminho encontrado
        Vertice verticeCaminho;                                                             // Variavel que recebe os vertices pertencentes ao menor caminho      
        Vertice atual;                                                                      // Variavel que guarda o vertice que esta sendo visitado      
        Vertice vizinho;                                                                    // Variavel que marca o vizinho do vertice atualmente visitado       
        Aresta ligacao;                                                                     // Aresta que liga o atual ao seu vizinho;       
        ArrayList<Vertice> naoVisitados = new ArrayList<Vertice>();                         // Lista dos vertices que ainda nao foram visitados

 	
        menorCaminho.add(v1);                                                               // Adiciona a origem na lista do menor caminho
     
        for (int i = 0; i < this.getVertices().size(); i++) {                               // Colocando a distancias iniciais 
            if (this.getVertices().get(i).getNome().equals(v1.getNome()))                   // Vertice atual tem distancia zero, e todos os outros, é 9999
                this.getVertices().get(i).setDistancia(0);
            else
                this.getVertices().get(i).setDistancia(9999);           
            naoVisitados.add(this.getVertices().get(i));                                    // Insere o vertice na lista de vertices nao visitados
        }

        Collections.sort(naoVisitados);
        
       
        while (!naoVisitados.isEmpty()) {                                                   // O algoritmo continua ate que todos os vertices sejam visitados
            atual = naoVisitados.get(0);                                                    // Toma-se sempre o vertice com menor distancia, que eh o primeiro da lista

            for (int i = 0; i < atual.getVizinhos().size(); i++) {                          // De acordo com a quantidade de vizinhos do elemento
                vizinho = atual.getVizinhos().get(i);               
                if (!vizinho.isVisitado()) {
                    ligacao = this.buscarAresta(atual,vizinho);                         
                    if (vizinho.getDistancia() > (atual.getDistancia() + ligacao.getPeso())) {          //soma a vertice atual com a da aresta correspondente
                        vizinho.setDistancia(atual.getDistancia() + ligacao.getPeso());                 //se for menor do que da do vizinho, ela é atualizada
                                        
                        vizinho.setPai(atual);
                   
                        if (vizinho == v2) {                                                //se o vizinho for igual ao destino
                            menorCaminho.clear();                                           //limpa a lista de menor caminho
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);                                      //adiciona ele a lista de menor caminho
                            while (verticeCaminho.getPai() != null) {  
                                menorCaminho.add(verticeCaminho.getPai());                  //adiciona seu pai a lista
                                verticeCaminho = verticeCaminho.getPai();                   
                            }
                            
                            Collections.sort(menorCaminho);
                            

                        }
                    }
                }

            }

            atual.setVisitado(true);                                                        // Marca o vertice atual como visitado e o retira da lista de nao visitados
            naoVisitados.remove(atual); 
            Collections.sort(naoVisitados);                                                 //ordena a lista de não visitados
            
            
        }
        
        for (int i = 0; i < this.getVertices().size(); i++) {                               //torna a variavel visitado falso  para que possa ser feita próximas verificações
            this.getVertices().get(i).setVisitado(false);
        }
        
        limparVerticesPai();
        return menorCaminho;
    }
    
    

    /**
    * Método para retornar o caminho menos custoso de uma vértice para todas as outras
    * @param x1 int
    * @param y1 int
    * @param x2 int
    * @param y2 int
    * @return int 
    */
    public int distanciaEuclidiana(int x1, int y1, int x2, int y2){
       int sub1 = x2 - x1;
       int sub2 = y2 - y1;
       int pot1 = (int) Math.pow(sub1, 2);
       int pot2 = (int) Math.pow(sub2, 2);
      
       int raiz = (int) Math.sqrt(pot1+pot2);
       
       return raiz;
   }
    
   
    /**
    * Método para retornar o caminho menos custoso de uma vértice para todas as outras
    * @param vert String
    * @return ArrayList
    */
     public ArrayList<ArrayList<Vertice>> menorCaminhoTodos(String vert){
         int ind = 0;                                                                               
         ArrayList<Vertice> menor = new ArrayList<Vertice>();
         ArrayList<ArrayList<Vertice>> lista = new ArrayList<ArrayList<Vertice>>();
         
         for (int i = 0; i < this.vertices.size(); i++) {
             if (this.vertices.get(i).getNome().equals(vert)) {
                 ind = i;                                                                       //guarda indice do vertice na lista de vertices
                 break;
             }
         }
         
         for (int j = 0; j < this.vertices.size(); j++) {
             menor = this.encontrarMenorCaminhoDijkstra(vertices.get(ind),vertices.get(j));     //calcula menor caminho do vertice para todos os outros
             lista.add(menor);                                                                  //adiciona lista em uma lista de vetores de vertices
         }
         
         return lista;                                                                          //retorna lista
                 
     }

 
    private void limparVerticesPai() {
        int i;
        for (i = 0; i < getVertices().size(); i++) {       //loop a partir da quantidade de vértices
            getVertices().get(i).setPai(null);             //torna o pai nulo
        }
    }

    private void limparArestaVisitada() {    
        int i = 0;                                              
        for (i = 0; i < getArestas().size(); i++) {        //loop a partir da quantidade de arestas
            getArestas().get(i).setVisitado(false);        //torna falso o status de visitado
        }
    }
     
     private boolean temCiclo(Aresta aresta) {
        Vertice anterior = aresta.getDestino();                                                                 //aresta anterior
        for (int j = 0; j < getArestas().size(); j++) {                                                         //loop a partir da quantidade de arestas        
            for (int i = 0; i < getArestas().size(); i++) {                                                     
                if ((aresta == getArestas().get(i)) && (getArestas().get(i).isVisitado() == false)) {           //se a aresta adicionada for igual a aresta q ja existe e o status de visita for falsa
                    getArestas().get(i).setVisitado(true);                                                      //atualiza o status para visitado   
                } else if (aresta != getArestas().get(i)) {                                                     //se a aresta adicionar for diferente a aresta do loop

                    if (anterior.getNome().equals(getArestas().get(i).getOrigem().getNome())) {                 //se o vertice anterior é igual ao nome da origem de alguma aresta existente

                        if (aresta.getOrigem().getNome().equals(getArestas().get(i).getDestino().getNome())) {  //se a origem da aresta buscada é igual ao destino de alguma aresta
                            limparArestaVisitada();                                                             //limpa aresta visitada
                            ciclo = true;                                                                       //ciclo é igual a true
                            return true;                                                                        //return true
                        } else {                                                                                //se não
                            anterior = getArestas().get(i).getDestino();                                        //anterior é igual ao destino da aresta do loop
                            getArestas().get(i).setVisitado(true);                                              //torna o status de visitado para true
                        }

                    } else if (anterior.getNome().equals(getArestas().get(i).getDestino().getNome())) {         //se nome da anterior for diferente da vertice destino

                        if (aresta.getOrigem().getNome().equals(getArestas().get(i).getOrigem().getNome())) { // se origem da aresta buscada for igual a alguma aresta do loop
                            limparArestaVisitada();                                                             //limpa aresta visitada
                            ciclo = true;                                                                       //ciclo é igual a true
                            return true;                                                                        //retorna verdadeiro
                        } else {                                                                                //se não
                            anterior = getArestas().get(i).getOrigem();                                         //torna o status de visitado para true
                            getArestas().get(i).setVisitado(true);
                        }
                    }
                }
            }
        }
        limparArestaVisitada();                                                                                 //limpa aresta visitada
        ciclo = false;                                                                                          //ciclo é falso
        return false;                                                                                           //return false;
    }

    private boolean temCiclo() {
        return ciclo;
    }
    
    /**
    * Método para atualizar se tem ciclo
    * @param ciclo boolean
    */
    private void setCiclo(boolean ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public int compareTo(Object o) {
        ArrayList<Aresta> a = (ArrayList<Aresta>)o;
        boolean igual = false;
    
        int i = 0;
        while(igual == true){
            if ((((arestas.get(i).getOrigem().getNome().equals(a.get(i).getOrigem().getNome()))             //se a origem da aresta for igual ao nome da vertice 1 que se quer buscar
                    && (arestas.get(i).getDestino().getNome().equals(a.get(i).getDestino().getNome()))))) {
                igual = true;
            }
            i++;
        }
        
        if (igual == true)
            return 1;
       
        return 0;
                
}
    
    
    
}

