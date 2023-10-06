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

package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.Grafo;
import model.ManipularArquivos;
import model.Vertice;


public class Controller {
    
    private  static Grafo grafo = new Grafo();
    
    public static void importar_arquivo(File caminho){
        ManipularArquivos.carregar(caminho);
    }
    
    public static void exportar_arquivo(String caminho) throws IOException{
        ManipularArquivos.salvar(caminho, grafo);
    }
    
    public static void add_conexao(String inicio, boolean terminal, String destino, int peso){
        grafo.addAresta(peso, inicio, destino, terminal);
    }
    
    public static void remover_conexao(String vertice){
        grafo.removerVertice(vertice);
    }
    
    public static int distanciaEucliana(int x1, int y1, int x2, int y2){
        return grafo.distanciaEuclidiana(x1, y1, x2, y2);
    }
    
    public static ArrayList<ArrayList<Vertice>> menorCaminhoTodos(String vertice){
        return grafo.menorCaminhoTodos(vertice);
    }
    
    public static ArrayList<Vertice> menorCaminho(Vertice v1, Vertice v2){
        return grafo.encontrarMenorCaminhoDijkstra(v1, v2);
    }
         
    public static Grafo getGrafo(){
        return grafo;
    }    
    
    public static Vertice buscarVertice(String v){
        return grafo.buscarVertice(v);
    }
  
}
