/*******************************************************************************
PROBLEMA 2
Autora: Evelyn Suzarte Fernandes 
Componente Curricular: MI-Programação - 2019.2
Concluido em: 04/01/2020
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package pbl2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe usada para manipular arquivos
 *
 * @author Evelyn Suzarte
 */
public class ManipularArquivos {

    /**
     * Método estático para escrever em arquivo de texto
     *
     * @param nome_arquivo - String
     * @param livro - ArrayList
     * @return 
     * @throws IOException
     */
    public static boolean escrever(String nome_arquivo, ArrayList<Folha> livro) throws IOException {
        String nomeArquivo = nome_arquivo + ".txt";                         //nome do arquivo

        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {            //abertura de arquivo de escrita
            PrintWriter escrever = new PrintWriter(arquivo);                //print de escrita em arquivo
            escrever.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");          
            for (int i = 0; i < livro.size(); i++) {                        //escrita dos livros no arquivo de texto
                escrever.printf("%d;%s;%s;%s;%d;%s\n", livro.get(i).getN_ebook(), livro.get(i).getTitulo(), livro.get(i).getAutor(), livro.get(i).getMes(), livro.get(i).getAno(), livro.get(i).getLink());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("ARQUIVO NÃO ENCONTRADO!!");
            return false;
        }
    }

    /**
     * Método estático para ler arquivo de texto
     *
     * @return listaLivros - ArrayList
     */
    public static ArrayList<Livro> ler() {
        File arquivoCSV = new File("Arquivo de entrada do catálogo.txt");

        ArrayList<Livro> listaLivros = new ArrayList();
        int n_ebook, ano;
        String titulo, link, mes, autor, n_ebookAux, anoAux;

        try {
            Scanner leitor = new Scanner(arquivoCSV);                       //scanner para o arquivo
            String linhasDoArquivo = new String();                          //armazena cada linha do arquivo
            leitor.nextLine();                                              //pula primeira linha do arquivo
            while (leitor.hasNext()) {
                linhasDoArquivo = leitor.nextLine();                        //recebe cada linha do arquivo
                String[] valoresEntreVirgulas = linhasDoArquivo.split(";"); //separa os campos entre as virgulas de cada linha

                n_ebookAux = valoresEntreVirgulas[0];
                titulo = valoresEntreVirgulas[1];
                autor = valoresEntreVirgulas[2];
                mes = valoresEntreVirgulas[3];
                anoAux = valoresEntreVirgulas[4];
                link = valoresEntreVirgulas[5];

                n_ebook = Integer.parseInt(n_ebookAux);                     //transforma a string em numero
                ano = Integer.parseInt(anoAux);

                Livro livro = new Livro(n_ebook, titulo, autor, mes, ano, link);    //cria o objeto livro

                listaLivros.add(livro);                                     //adiciona em uma lista de livros
            }

        } catch (FileNotFoundException e) {
            System.out.println("ARQUIVO NÃO ENCONTRADO!!!");
        }

        return listaLivros;                                                //retorna os livros lidos
    }

}
