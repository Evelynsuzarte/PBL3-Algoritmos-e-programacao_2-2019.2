/** **************************************************************************************
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
 * Classe para criar árvore binária
 *
 * @author	Evelyn Suzarte Fernandes
 * @version	1.0
 * @since	1.0
 */
public class ArvoreBinaria {

    private Folha raiz;
    private int tamanho = 0;

    /**
     * Método para retornar tamanho da arvore
     *
     * @return tamanho int
     */
    public int getTamanho() {
        return tamanho;                                  //retorna o tamanho da árvore
    }

    /**
     * Método para inserir folha na arvore
     *
     * @param livro Livro
     * @param n_ebook int
     */
    public void inserir(Livro livro, int n_ebook) {
        Folha nova_folha = new Folha(livro, n_ebook);   //cria nova folha
        nova_folha.livro = livro;                       //insere elemento
        nova_folha.n_ebook = n_ebook;                   //insere chave

        if (raiz == null) {                             //se a arvore estiver vazia
            raiz = nova_folha;                          //nova folha é a raiz
            tamanho++;
        } else {                                        //se nao
            Folha atual = raiz;                         //é criado uma folha que é igual a raiz
            Folha pai;                                  //uma folha pai é criada
            while (true) {
                pai = atual;                            //folha pai é igual a atual
                if (n_ebook < atual.n_ebook) {          //se o numero do ebook chave for menor do que a do ebook atual
                    atual = atual.esquerda;             //atual vai ser igual ao elemento esquerdo dele
                    if (atual == null) {                //se atual(que é o esquerdo) estiver vazio
                        pai.esquerda = nova_folha;      //o elemento esquerdo é igual a nova folha
                        nova_folha.setPai(atual);
                        tamanho++;
                        return;
                    }
                } else {                                //se o numero do ebook chave for maior que o numero do ebook do atual
                    atual = atual.direita;              //atual é igual ao elemento da sua direita
                    if (atual == null) {                //se a direita do elemento estiver vazia
                        pai.direita = nova_folha;       //o elemento da direita é igual a nova folha
                        nova_folha.setPai(atual);
                        tamanho++;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Método gerar numero de ebook, buscando o maior numero e acrescentando
     * mais 1
     *
     * @return numero int
     */
    public int geradorEbook() {
        Folha atual = raiz;                             //folha atual é igual a raiz
        Folha anterior = null;                          //nova folha chamada de anterior é igual a null
        if (raiz == null) {                             //caso não tenha nenhum livro na estrutura
            return 00001;                               //gera um numero padrão
        } else {                                          //caso contrário
            while (atual != null) {                     //busca o maior número de ebook da árvore
                anterior = atual;
                atual = atual.getDireita();
            }
            return anterior.n_ebook + 1;                //retorna o maior numero somado a 1
        }

    }

    /**
     * Método para buscar livro pelo numero do ebook
     *
     * @param chave_Nebook int
     * @return boolean
     */
    public boolean buscarN_Ebook(int chave_Nebook) {
        if (buscar_elemento_N_Ebook(raiz,chave_Nebook).n_ebook == chave_Nebook) {           //se a folha retornada foi igual a null
            return true;
        }
        System.out.println("LIVRO NÃO ENCONTRADO!!");                       //se a folha retornada foi diferente de null
        return false;        
    }
    private Folha buscar_elemento_N_Ebook(Folha atual,int chave_Nebook) {
        if (atual != null) {                                                    //enquanto atual for nulo
            if(atual.n_ebook == chave_Nebook){                                  //se o numero de ebook foi igual ao desejad
                System.out.printf("LINK PARA ACESSO: %s\n", atual.getLink());   //mostra o link
                return atual;                                                   //retornar atual
            }   
            buscar_elemento_N_Ebook(atual.getEsquerda(),chave_Nebook);          //metodo recursivo para o lado esquerdo
            buscar_elemento_N_Ebook(atual.getDireita(),chave_Nebook);           //metodo recursivo para o lado direito          
        }
        return atual;
    }
    

    /**
     * Método para buscar livros pelo ano
     *
     * @param ano_buscar int
     * @return boolean
     * @throws java.io.IOException
     */
    public boolean buscarAno(int ano_buscar) throws IOException {
        ArrayList<Folha> livros = new ArrayList<>();
        livros = buscarAno(raiz, ano_buscar, livros);                                           //chama o método privado para buscar o ano
        if(!livros.isEmpty()) {
            for (int n = 0; n < livros.size(); n++) {
                livros.get(n).displayFolha();              
            }
            ManipularArquivos.escrever(String.valueOf(ano_buscar), livros);
            return true;
        }else {
            System.out.println("ANO NÃO EXISTENTE!!!");
            return false;
        }
    }
    private ArrayList<Folha> buscarAno(Folha atual, int ano_buscar, ArrayList<Folha> livros) {                      //realiza uma busca em pos ordem     
        if (atual != null) {
            buscarAno(atual.getEsquerda(), ano_buscar, livros);                        //chamada recursiva para o lado esquerdo do atual
            buscarAno(atual.getDireita(), ano_buscar, livros);                         //chamada recursiva para o lado direito do atual
            if (ano_buscar == atual.getAno()) {                                         //se for igual ao ano buscado
                livros.add(atual);                                                      //adiciona a lista de livros
            }
        }
        return livros;
    }

    
    /**
     * Método para listar todos os autores com a quantidade de livros
     *
     * @param autores ArrayList
     */
    public void listarAutoresQuantidade(ArrayList<String> autores) {
        for (int i = 0; i < autores.size(); i++) {
            int contador = listarAutoresQuantidade(autores.get(i), raiz);                        //armazena a quantidade de livros do autor
            System.out.printf("Nome: %s  Quantidade de livros: %d\n", autores.get(i), contador); //printa o nome do autor juntamente com a quantidade de livros
            System.out.println("----------------------------------");
        }
    }

    private int listarAutoresQuantidade(String autor, Folha atual) {                            //método privado para fazer a contagem de livros                  
        int contador = 0;
        if (atual != null) {
            if (atual.getAutor().equals(autor)) //se o autor que deseja buscar for igual ao atual
            {
                contador++;                                                                     //soma mais 1
            }
            if (atual.getEsquerda() != null) {
                contador += listarAutoresQuantidade(autor, atual.getEsquerda());                //chamada recursiva para o lado esquerdo do atual
            }
            if (atual.getDireita() != null) {
                contador += listarAutoresQuantidade(autor, atual.getDireita());                  //chamada recursiva para o lado direito do atual           
            }
        }

        return contador;                                                                        //retorna quantidade de livros
    }

    /**
     * Método para listar todos os livros de determinado autor
     *
     * @param autor_buscar ArrayList
     * @return 
     * @throws IOException
     */
    public boolean listarAutoresLivro(String autor_buscar) throws IOException {
        ArrayList<Folha> livros = new ArrayList();                                      //lista de livros do autor      
        listarAutoresLivro(raiz, autor_buscar, livros);                                  //chama o método privado para listar todos os livros do autor
        if (!livros.isEmpty()) {
            ManipularArquivos.escrever(autor_buscar, livros);                               //escreve todos os livros do autor no arquivo
            return true;
        }else{
            System.out.println("AUTOR NÃO ENCONTRADO!!");
            return false;
        }      
    }
    private void listarAutoresLivro(Folha atual, String autor_buscar, ArrayList<Folha> livros) {
        if (atual != null) {                                                            //busca os livros em ordem
            listarAutoresLivro(atual.getEsquerda(), autor_buscar, livros);
            if (atual.getAutor().equals(autor_buscar)) {                                //se o autor do livro for igual ao buscado
                atual.displayFolha();                                                   //mostra o livro
                livros.add(atual);                                                      //adiciona a lista de livros do autor
            }
            listarAutoresLivro(atual.getDireita(), autor_buscar, livros);if (atual.getAutor().equals(autor_buscar)) {                                //se o autor do livro for igual ao buscado
                atual.displayFolha();                                                   //mostra o livro
                livros.add(atual);                                                      //adiciona a lista de livros do autor
            }
        }
    }

    /**
     * Método para listar todos os livros da árvore
     */
    public void listarTodosLivros() {
        listaLivros(raiz);                                          //chama o método privado para buscar o ano
    }

    private void listaLivros(Folha atual) {
        if (atual != null) {                                        //exibe todos os livros em ordem
            listaLivros(atual.getEsquerda());
            atual.displayFolha();
            listaLivros(atual.getDireita());
        }
    }

    /**
     * Método carregar os livros na base de dados, na árvore
     *
     * @param autores int
     */
    public void carregarDados(ArrayList<String> autores) {
        ArrayList<Livro> livros = ManipularArquivos.ler();                 //chama metodo de ler arquivo

        for (int i = 0; i < livros.size(); i++) {
            this.inserir(livros.get(i), livros.get(i).getN_ebook());        //insere livro na árvore     
            if (!autores.contains(livros.get(i).getAutor())) {             //se o nome do autor não existir na lista de autores
                autores.add(livros.get(i).getAutor());                     //adiciona o autor a lista de autores
            }
        }
    }

    /**
     * Método carregar os livros na base de dados, na árvore
     *
     * @throws IOException
     */
    public void gravarDados() throws IOException {
        ArrayList<Folha> livros = new ArrayList();                                  //lista com todos os livros
        arvoreParaLista(raiz, livros);                                               //chamada do método privado para salvar todo os livros da arvore em uma lista
        ManipularArquivos.escrever("Arquivo de entrada do catálogo", livros);       //escreve os livros no arquivo
    }

    private void arvoreParaLista(Folha atual, ArrayList<Folha> livros) {
        if (atual != null) {                                                       //percorre toda a arvore em pós ordem
            arvoreParaLista(atual.getEsquerda(), livros);
            arvoreParaLista(atual.getDireita(), livros);
            livros.add(atual);                                                      //adiciona na lista
        }
    }

    
    /**
     * Método para apagar livro da árvore
     *
     * @param n_ebook int
     * @return 
     */
    public boolean remover(int n_ebook) {
        if (removerNebook(n_ebook) == false) {                                      //se nao encontrar o livro que quer remover
            System.out.println("LIVRO NÃO ENCONTRADO!!");
            return false;
        } else  {                                                                   //se encontrou
            System.out.println("LIVRO EXCLUIDO!!");
            return true;
        }
    }

    private boolean removerNebook(int n_ebook) {
        if (raiz == null) {                                              // se arvore vazia
            return false;
        }

        Folha atual = raiz;
        Folha pai = raiz;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.getN_ebook() != n_ebook) {                         // enquanto nao encontrou
            pai = atual;
            if (n_ebook < atual.getN_ebook()) {                         // caminha para esquerda
                atual = atual.getEsquerda();
                filho_esq = true;                                       // é filho a esquerda? sim
            } else {                                                    // caminha para direita
                atual = atual.getDireita();
                filho_esq = false;                                      // é filho a esquerda? NAO
            }
            if (atual == null) {
                return false;                                           // encontrou uma folha -> sai
            }
        } 
        
                                                                        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (atual.getDireita() == null && atual.getEsquerda() == null) {
            if (atual == raiz) {
                raiz = null;                                            // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(null);                                  // se for filho a esquerda do pai
            } else {
                pai.setDireita(null);                                   // se for filho a direita do pai
            }
        }                                                               // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.getDireita() == null) {
            if (atual == raiz) {
                raiz = atual.getEsquerda();                             // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(atual.getEsquerda());                   // se for filho a esquerda do pai
            } else {
                pai.setDireita(atual.getEsquerda());                    // se for filho a direita do pai
            }
        }                                                               // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if (atual.getEsquerda() == null) {
            if (atual == raiz) {
                raiz = atual.getDireita();                              // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(atual.getDireita());                    // se for filho a esquerda do pai
            } else {
                pai.setDireita(atual.getDireita());                     // se for  filho a direita do pai
            }
        }                                                               // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            Folha sucessor = sucessor(atual);
                                                                        // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do Folha que deseja-se remover
            if (atual == raiz) {
                raiz = sucessor;                                        // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(sucessor);                              // se for filho a esquerda do pai
            } else {
                pai.setDireita(sucessor);                               // se for filho a direita do pai
            }
            sucessor.setEsquerda(atual.getEsquerda());                  // acertando o ponteiro a esquerda do sucessor agora que ele assumiu 
                                                                        // a posição correta na arvore   
        }
        tamanho--;
        return true;
    }

    private Folha sucessor(Folha apagado) {
        Folha sucessorPai = apagado;                                            //sucessor pai é igual ao apagado
        Folha sucessor = apagado;                                               //sucessor é igual ao apagado
        Folha atual = apagado.direita;                                          //atual é igual ao elemento da direita do apagado

        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.esquerda;
        }
        if (sucessor != apagado.direita) {
            sucessorPai.esquerda = sucessor.direita;
            sucessor.direita = apagado.direita;
        }
        return sucessor;
    }

   
    

}
