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
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Os testes abaixo funcionam no melhor caso, onde tudo solicitado
 * realmente existe e pode fazer alguma ação.
 * 
 * @author Evelyn Suzarte
 */
public class ArvoreBinariaMelhorCaso {
   
   
    public static ArvoreBinaria instance = new ArvoreBinaria();
    public static ArrayList<String> autores = new ArrayList<String>();
    
    @BeforeClass
    public static void inicializar() {
        
        Livro livro1 = new Livro(1111,"Minha vida fora de série 1","Paula Pimenta","Mai",+
                2011,"www.paulapimenta.com.br/m_vida_fora_de_s");
        Livro livro2 = new Livro(2222,"Tudo por um pop star","Thalita Rebouças","Dez",+
                2003,"www.thalitareboucas.com/tpups_2003");
        Livro livro3 = new Livro(3333,"Fala sério, professor!","Thalita Rebouças","Ago",+
                2007,"www.thalitareboucas.com/fala_serio_professor");
        Livro livro4 = new Livro(1102,"Diário de uma paixão","Nickolas Sparks","Out",+
                1996,"www.nickolasparks.com/-diario+de+uma+paixao-");
        
        ///////////////////////////////
        instance.inserir(livro1, 1111);
        instance.inserir(livro2, 2222);
        instance.inserir(livro3, 3333);
        instance.inserir(livro4, 1102);
        
        autores.add("Paula Pimenta");
        autores.add("Thalita Rebouças");
        autores.add("Nickolas Sparks");
        //////////////////////////////
        
    }


    /**
     * Teste para verificar o tamanho da arvore
     */
    @Test
    public void testGetTamanho() {
        System.out.println("getTamanho");
        int expResult = 4;
        int result = instance.getTamanho();
        assertEquals(expResult, result);
    }

    /**
     * Teste para verificar a inserção na arvore
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Livro livro5 = new Livro(2322,"Teste","Teste autor","Fev",2000,"www.teste.com");
        int n_ebook = 2322;
        instance.inserir(livro5, n_ebook);
        assertNotNull(livro5);
    }

    /**
     * Teste o para verificar o maior numero e gerar um numero de ebook da arvore
     */
    @Test
    public void testGeradorEbook() {
        System.out.println("geradorEbook");
        int expResult = 3334;
        int result = instance.geradorEbook();
        assertEquals(expResult, result);
    }

    /**
     * Teste para buscar o numero de ebook na arvore
     */
    @Test
    public void testBuscarN_Ebook() {
        System.out.println("buscarN_Ebook");
        int chave_Nebook = 1111;  
        assertEquals(true,instance.buscarN_Ebook(chave_Nebook));      
    }

    /**
     * Teste para buscar ano na arvore
     * @throws java.io.IOException
     */
    @Test
    public void testBuscarAno() throws IOException {
        System.out.println("buscarAno");
        int ano_buscar = 2007;  
        assertEquals(true,instance.buscarAno(ano_buscar));
    }

   
    /**
     * Testar visualização de todos os livros do autor
     * @throws java.lang.Exception
     */
    @Test
    public void testListarAutoresLivro() throws Exception {
        System.out.println("listarAutoresLivro");
        String autor_buscar = "Thalita Rebouças";
        assertEquals(true,instance.listarAutoresLivro(autor_buscar));     
    }

    /**
     * Teste para remover livro
     */
    @Test
    public void testRemover() {
        System.out.println("remover");
        int n_ebook = 1111;  
        assertEquals(true,instance.remover(n_ebook));
    }
       
}
