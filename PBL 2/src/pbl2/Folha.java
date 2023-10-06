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

/**
  * Classe para criar nó da árvore
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class Folha {
    Livro livro;                //elemento
    int n_ebook;                //chave da folha
    Folha pai;
    Folha esquerda;             //nó da esquerda
    Folha direita;              //nó da direita
    
    /**
    * Método para mostrar a folha
    */
    public void displayFolha(){
        System.out.printf("\nNº EBOOK: %d\n",livro.getN_ebook());
        System.out.printf("TITULO: %s\n",livro.getTitulo());
        System.out.printf("AUTOR: %s\n",livro.getAutor());
        System.out.printf("MES/ANO: %s/%d\n",livro.getMes(),livro.getAno());
        System.out.printf("LINK: %s\n",livro.getLink());
        System.out.println("-------------------------------------------------");
    }

    
    public Folha(Livro livro, int n_ebook) {
        this.livro = livro;
        this.n_ebook = n_ebook;
    }
    
    /**
    * Método para retornar o objeto Livro
    * @return livro Livro
    */
    public Livro getLivro() {
        return livro;
    }

    /**
    * Método para atualizar o objeto livro
    * @param livro Livro
    */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
    /**
    * Método para retornar chave do livro
    * @return n_ebook int
    */
    public int getN_ebook() {
        return n_ebook;
    }

    
    /**
    * Método para atualizar chave do livro
    * @param n_ebook int
    */
    public void setN_ebook(int n_ebook) {
        this.n_ebook = n_ebook;
    }

    
    /**
    * Método para retornar Folha esquerda
    * @return esquerda Folha
    */
    public Folha getEsquerda() {
        return esquerda;
    }

    /**
    * Método para retornar Folha direita
    * @return direita Folha
    */
    public Folha getDireita() {
        return direita;
    }
    
    
    /**
    * Método para atualizar nó esquerda
    * @param livro Folha
    */
    public void setEsquerda(Folha livro) {
        this.esquerda = livro;
    }

    /**
    * Método para atualizar nó direita
    * @param livro Folha
    */
    public void setDireita(Folha livro) {
        this.direita = livro;
    }

    /**
    * Método para retornar titulo do livro
    * @return titulo String
    */
    public String getTitulo(){
        return livro.getTitulo();
    }
    
    
    /**
    * Método para retornar nome do autor do livro
    * @return nome String
    */
    public String getAutor(){
        return livro.getAutor();
    }
    
    
    /**
    * Método para retornar link do livro
    * @return link String
    */
    public String getLink(){
        return livro.getLink();
    }
    
    
    /**
    * Método para retornar mes do liro
    * @return mes String
    */
    public String getMes(){
        return livro.getMes();
    }
    
    
    /**
    * Método para retornar ano do livro
    * @return ano int
    */
    public int getAno(){
        return livro.getAno();
    }

    /**
    * Método para retornar mes do liro
    * @return pai Folha
    */
    public Folha getPai() {
        return pai;
    }
 /**
    * Método para atualizar pai do nó
    * @param pai Folha
    */
    public void setPai(Folha pai) {
        this.pai = pai;
    }
    
  
    
}
