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
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Os testes abaixo funcionam no pior caso, onde tudo solicitado
 * pode não existe e não podendo realizar alguma ação.
 * 
 * @author Evelyn Suzarte
 */
public class ArvoreBinariaPiorCaso {
      
    public static ArvoreBinaria instance = new ArvoreBinaria();
    
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
        
        
        instance.inserir(livro1, 1111);
        instance.inserir(livro2, 2222);
        instance.inserir(livro3, 3333);
        instance.inserir(livro4, 1102);
        
     
    }


    /**
     * Teste para buscar o numero de ebook na arvore
     */
    @Test
    public void testBuscarN_Ebook() {
        System.out.println("buscarN_Ebook");
        int chave_Nebook = 999;  
        assertEquals(false,instance.buscarN_Ebook(chave_Nebook));      
    }

    /**
     * Teste para buscar ano na arvore
     * @throws java.io.IOException
     */
    @Test
    public void testBuscarAno() throws IOException {
        System.out.println("buscarAno");
        int ano_buscar = 2000;  
        assertEquals(false,instance.buscarAno(ano_buscar));
    }

   
    /**
     * Testar visualização de todos os livros do autor
     * @throws java.lang.Exception
     */
    @Test
    public void testListarAutoresLivro() throws Exception {
        System.out.println("listarAutoresLivro");
        String autor_buscar = "Ana Lopes";
        assertEquals(false,instance.listarAutoresLivro(autor_buscar));     
    }

    /**
     * Teste para remover livro
     */
    @Test
    public void testRemover() {
        System.out.println("remover");
        int n_ebook = 90;  
        assertEquals(false,instance.remover(n_ebook));
    }
       
}
