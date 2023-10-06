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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 * Classe usada para manipular arquivos
 *
 * @author Evelyn Suzarte
 * @version 2.0
 */

public class ManipularArquivos {

    /**
     * Método estático para escrever em arquivo de texto
     *
     * @param caminho - String
     * @param grafo - Grafo
     * @throws java.io.IOException
     */
    public static void salvar(String caminho, Grafo grafo)  throws IOException {

        try (FileWriter arquivo = new FileWriter(caminho)) {                                                //abertura de arquivo de escrita
            PrintWriter escrever = new PrintWriter(arquivo);                                //print de escrita em arquivo
            escrever.println("Inicio,Terminal,Destino,Peso");          
            String t = "";
            for (int i = 0; i < grafo.getArestas().size(); i++) {                           //escrita das arestas no arquivo de texto
                
                boolean terminal = grafo.getArestas().get(i).getOrigem().isTerminal();      //verifica se é terminal
                if (terminal == true)                                                       //transforma na palavra 'sim' ou 'não'
                    t = "sim";
                else if (terminal == false) 
                    t = "não";
          
                escrever.printf("%s,%s,%s,%d\n", grafo.getArestas().get(i).getOrigem().getNome(), t,          //escreve no arquivo
                                grafo.getArestas().get(i).getDestino().getNome(), grafo.getArestas().get(i).getPeso());
            }
            
            JOptionPane.showMessageDialog(null, "ARQUIVO EXPORTADO COM SUCESSO!!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL SALVAR!!");
        }
    }

    /**
     * Método estático para ler arquivo de texto
     *
     * @param caminho File
     */
    public static void carregar (File caminho) {
        File arquivoCSV = caminho;
        controller.Controller.getGrafo().limparGrafo();
        
        String inicio, terminal_aux, destino, peso_aux;
        int peso;
        boolean terminal = false;
      
        try {
            Scanner leitor = new Scanner(arquivoCSV);                       //scanner para o arquivo
            String linhasDoArquivo = new String();                          //armazena cada linha do arquivo
            leitor.nextLine();                                              //pula primeira linha do arquivo
            
            while (leitor.hasNext()) {
                linhasDoArquivo = leitor.nextLine();                        //recebe cada linha do arquivo
                String[] valoresEntreVirgulas = linhasDoArquivo.split(","); //separa os campos entre as virgulas de cada linha

                inicio = valoresEntreVirgulas[0];
                terminal_aux = valoresEntreVirgulas[1];
                destino = valoresEntreVirgulas[2];
                peso_aux = valoresEntreVirgulas[3];
 
                
                peso = Integer.parseInt(peso_aux);                          //transforma a string em numero

                
                if (terminal_aux.equals("sim")) {
                    terminal = true;
                }
                else if(terminal_aux.equals("não")){
                    terminal = false;
                }
                      
                
                controller.Controller.getGrafo().addAresta(peso, inicio, destino, terminal);

            }
            JOptionPane.showMessageDialog(null, "ARQUIVO IMPORTADO COM SUCESSO!!");

        } catch (FileNotFoundException e) {
             JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL ABRIR ARQUIVO!!");

        }

    }

}
