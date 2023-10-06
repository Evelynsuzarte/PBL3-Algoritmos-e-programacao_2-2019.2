/****************************************************************************************
 * PROBLEMA 2
 * Autora: Evelyn Suzarte Fernandes
 * Componente Curricular: MI-Programação - 2019.2
 * Concluido em: 04/01/2020
 * Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 * trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 * apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 * de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 * do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ***************************************************************************************** */

package pbl2;

import java.io.IOException;
import java.util.ArrayList;

/**
  * Classe para fazer conexão com a classe principal
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class Dao {
    
    private static ArvoreBinaria arvore_livros = new ArvoreBinaria();
    private static ArrayList<String> autores = new ArrayList();
    
    public static void inserir(Livro livros, int n_ebook){                  //requisito 1
        arvore_livros.inserir(livros, n_ebook);
    }
    
    public static void carregarDados(){                                     //requisito 2
        arvore_livros.carregarDados(autores);
    }
    
    public static void gravarDados() throws IOException{                    //requisito 3
        arvore_livros.gravarDados();
    }
    
    public static void listarAutoresQuantidade(){                           //requisito 4
        arvore_livros.listarAutoresQuantidade(autores);
    }
    
    public static void listarAutoresLivro(String autor_buscar) throws IOException{  //requisito 5
        arvore_livros.listarAutoresLivro(autor_buscar);
    }
    
    public static void listarTodosLivros(){                                 //requisito 6
        arvore_livros.listarTodosLivros();
    }
    
    public static void buscarLivro_nEbook(int chave_Nebook){                //requisito 7
        arvore_livros.buscarN_Ebook(chave_Nebook);
    }
    
    public static void buscarLivro_ano(int chave_Ano) throws IOException{           //requisito 8
        arvore_livros. buscarAno(chave_Ano);
    }
    
    public static void excluirLivro(int n_ebook){                           //requisito 9
        arvore_livros.remover(n_ebook);
    }
     
    public static int geradorNEbook(){
        return arvore_livros.geradorEbook();
    }
    
    
}


