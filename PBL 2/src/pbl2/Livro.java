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
  * Classe para criar objeto livro
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */
public class Livro {
    private int n_ebook;
    private String titulo;
    private String autor; 
    private String mes;
    private int ano;
    private String link;
    
     /**
    * Método para contruir objeto Livro
    * 
    * @param n_ebook int
    * @param titulo String
    * @param autor String
    * @param mes String
    * @param ano int
    * @param link String
    */
    public Livro(int n_ebook, String titulo, String autor, String mes, int ano, String link){
        this.n_ebook = n_ebook;
        this.titulo = titulo;
        this.autor = autor;
        this.mes = mes;
        this.ano = ano;
        this.link = link;
    }

    Livro(int i, String fala_sério_professor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
    * Método para retornar código do livro
    * @return N_ebook int
    */
    public int getN_ebook() {
        return n_ebook;
    }

    
    /**
    * Método para atualizar código do livro
    * @param n_ebook int
    */
    public void setN_ebook(int n_ebook) {
        this.n_ebook = n_ebook;
    }

    
    /**
    * Método para retornar nome do livro
    * @return titulo String
    */
    public String getTitulo() {
        return titulo;
    }

    
    /**
    * Método para atualizar nome do livro
    * @param titulo String
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    /**
    * Método para retornar nome do autor
    * @return autor String
    */
    public String getAutor() {
        return autor;
    }

    
    /**
    * Método para atualizar nome do autor
    * @param autor String
    */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
    /**
    * Método para retornar mes do livro
    * @return mes int
    */

    public String getMes() {
        return mes;
    }

    
    /**
    * Método para atualizar mes do livro
    * @param mes String
    */
    public void setMes(String mes) {
        this.mes = mes;
    }

    
    /**
    * Método para retornar ano do livro
    * @return ano int
    */
    public int getAno() {
        return ano;
    }

    
    /**
    * Método para atualizar ano do livro
    * @param ano int
    */
    public void setAno(int ano) {
        this.ano = ano;
    }

    
    /**
    * Método para retornar link do livro
    * @return link String
    */
    public String getLink() {
        return link;
    }

    
    /**
    * Método para atualizar link do livro
    * @param link String
    */
    public void setLink(String link) {
        this.link = link;
    }
    
     public void displayLivro(){
        System.out.printf("\nNº EBOOK: %d\n",n_ebook);
        System.out.printf("TITULO: %s\n",titulo);
        System.out.printf("AUTOR: %s\n",autor);
        System.out.printf("MES/ANO: %s/%d\n",mes,ano);
        System.out.printf("LINK: %s\n",link);
    }
    
    
    
}
