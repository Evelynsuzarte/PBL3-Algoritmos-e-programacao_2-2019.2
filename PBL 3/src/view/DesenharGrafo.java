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

package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import model.Aresta;
import model.Grafo;
import model.Vertice;


/**Classe que cria o desenho do Grafo na tela
 *
 * @author Evelyn Suzarte
 * @version 1.0
 */
public class DesenharGrafo extends javax.swing.JPanel {

        private Grafo grafo = controller.Controller.getGrafo();
        private int raio = 200;
        private int xBase = 500;
        private int yBase = 400;
        private boolean menorCaminho = false;
        private int tamanhoPonto = 12;

        ArrayList<Vertice> vertices = grafo.getVertices();                  //lista de vértices
        ArrayList<Aresta> arestas = grafo.getArestas();                     //lista de arestas
        ArrayList<Integer> posicaoX = new ArrayList();                      //lista posições de x
        ArrayList<Integer> posicaoY = new ArrayList();                      //lista posições de y
        ArrayList<String> nomes = new ArrayList();                          //lista de nomes
        Vertice vertice;                                                    //vértice
        ArrayList<Vertice> caminho;
        
        /**
        * Contrutor para desenhar grafo simples
        */
        public DesenharGrafo(){
        }
        
        /**
        * Contrutor para desenhar grafo com menor caminho destacado
        * @param c ArrayList - Lista de menor caminho
        */
        public DesenharGrafo(ArrayList<Vertice> c){
            menorCaminho = true;
            caminho = c;
        }
      
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
              
            this.setBackground(Color.pink);
            int contador = 0;                                                   //contador para percorrer
            int x, y;                                                           //x e y
                                                                                //imprimir vertices
            if(menorCaminho == false){
                do {                                                               
                                                                                //formula baseada no raio para gerar x e y
                x = xBase + (int) Math.round(raio * Math.cos(Math.PI * 2 / vertices.size() * contador));            
                y = yBase + (int) Math.round(raio * Math.sin(Math.PI * 2 / vertices.size() * contador));
                posicaoX.add(x);                                                //adiciona x na lista
                posicaoY.add(y);                                                //adiciona y na lista
                vertice = vertices.get(contador);                               //vertice Ã© igual ao elemento da posição do contador na lista de vértices
                nomes.add(vertice.getNome());                                   //adiciona seu nome na lista de nome
                g.drawOval(x, y, tamanhoPonto, tamanhoPonto);               //desenha um circulo
                g.fillOval(x, y, tamanhoPonto, tamanhoPonto);               //pinta um circulo
                g.drawString(vertice.getNome(), x + 3, y - 5);                  //escreve no nome da vértice ao lado 
                contador++;
            } while (contador != vertices.size());                              //enquanto houve vértices
            
                                                                                // imprimir arestas
            contador = 0;                                                       //contador para percorrer
            
            
            int i = 0, j;                                                       //auxiliares        
            for (Aresta a : arestas) {                                          //para cada elemento da lista de arestas
                for (i = 0; i < nomes.size(); i++) {                            //loop de acordo com quantidade de nomes
                    for (j = 0; j < nomes.size(); j++) {                        //loop de acordo com quantidade de nomes
                                                                                //se nome de origem e de destino for iguais ao da lista de nomes
                        if (a.getOrigem().getNome().equals(nomes.get(i)) && a.getDestino().getNome().equals(nomes.get(j))) {
                                                                                //desenha a linha para ligar as vértices
                            g.drawLine(posicaoX.get(i) + 5, posicaoY.get(i) + 5, posicaoX.get(j) + 5, posicaoY.get(j) + 5);
                                                                                //escreve o peso da aresta ao lado da aresta
                            g.drawString(String.valueOf(a.getPeso()), (posicaoX.get(i) + posicaoX.get(j)) / 2,
                                    (((posicaoY.get(i) - posicaoY.get(j)) / 2) + posicaoY.get(j)));
                        }
                    }
                }
                contador++;                                                     
            }
            
            }                   
           if(menorCaminho == true){ 
               
               do {                                                               
                                                                                //formula baseada no raio para gerar x e y
                x = xBase + (int) Math.round(raio * Math.cos(Math.PI * 2 / vertices.size() * contador));            
                y = yBase + (int) Math.round(raio * Math.sin(Math.PI * 2 / vertices.size() * contador));
                posicaoX.add(x);                                                //adiciona x na lista
                posicaoY.add(y);                                                //adiciona y na lista
                vertice = vertices.get(contador);                               //vertice Ã© igual ao elemento da posição do contador na lista de vértices
                nomes.add(vertice.getNome());                                   //adiciona seu nome na lista de nome
                g.drawOval(x, y, tamanhoPonto, tamanhoPonto);               //desenha um circulo
                g.fillOval(x, y, tamanhoPonto, tamanhoPonto);               //pinta um circulo               
                g.drawString(vertice.getNome(), x + 3, y - 5);                  //escreve no nome da vértice ao lado 
                contador++;
            } while (contador != vertices.size());                              //enquanto houve vértices
               
               
               ArrayList<String> nomes2 = new ArrayList();
               for (int i = 0; i < caminho.size(); i++) {
                   nomes2.add(caminho.get(i).getNome());
               }
               
               int i,j;
                g.setColor(Color.red);

                for(int c = 0; c<caminho.size();c++){
                    arestas = caminho.get(c).getIncidentes();
                    for (Aresta a : arestas) {                                              //para cada elemento da lista de arestas
                            for (i = 0; i < nomes2.size(); i++) {                            //loop de acordo com quantidade de nomes
                                for (j = 0; j < nomes2.size(); j++) {                        //loop de acordo com quantidade de nomes
                                                                                            //se nome de origem e de destino for iguais ao da lista de nomes
                                    if (a.getOrigem().getNome().equals(nomes2.get(i)) && a.getDestino().getNome().equals(nomes2.get(j))) {
                                                                                            //desenha a linha para ligar as vértices
                                        g.drawLine(posicaoX.get(i) + 5, posicaoY.get(i) + 5, posicaoX.get(j) + 5, posicaoY.get(j) + 5);
                                                                                            //escreve o peso da aresta ao lado da aresta
                                        g.drawString(String.valueOf(a.getPeso()), (posicaoX.get(i) + posicaoX.get(j)) / 2,
                                                (((posicaoY.get(i) - posicaoY.get(j)) / 2) + posicaoY.get(j)));
                                    }
                                }
                            }
                            contador++;                                                     
                        }
                    }                                                                 
                }
            }  
           
        }


        
        

    