
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Evelyn Suzarte
 */
public class GrafoTest {
    
    public static Grafo grafo ;
    public static ArrayList<Vertice> vert = new ArrayList<Vertice>();               //lista de vertices do grafo
    public static ArrayList<Vertice> vert2 = new ArrayList<Vertice>();              //vertice de apoio diferente do grafo
    public static ArrayList<Aresta> arestas = new ArrayList<Aresta>();              //lista de arestas do grafo
    public static ArrayList<Aresta> arestas2 = new ArrayList<Aresta>();             //arestas de apoio diferente do grafo

    @Before
    public void setUpClass() {          

        grafo = new Grafo();
       
        grafo.addVertice("A",false);
        grafo.addVertice("B",false);
        grafo.addVertice("C",false);
        grafo.addVertice("D",false);
        grafo.addVertice("E",false);
        
        grafo.addAresta(12, "A", "B",false);
        grafo.addAresta(5, "A", "C",false);
        grafo.addAresta(4, "B", "C",false);
        grafo.addAresta(8, "B", "E",false);
        grafo.addAresta(10, "D", "C",false);
        grafo.addAresta(6, "D", "E",false);
        
        //vertices e arestas do grafo
        Vertice a = new Vertice("A",false);
        Vertice b = new Vertice("B",false);
        Vertice c = new Vertice("C",false);
        Vertice d = new Vertice("D",false);
        Vertice e = new Vertice("E",false);
        
        Aresta ab = new Aresta(12,a,b,false);
        Aresta ac = new Aresta(5,a,c,false);
        Aresta bc = new Aresta(4,b,c,false);
        Aresta be = new Aresta(8,b,e,false);
        Aresta dc = new Aresta(10,d,c,false);
        Aresta de = new Aresta(6,d,e,false);
        
        
        vert.add(a);
        vert.add(b);
        vert.add(c);
        vert.add(d);
        vert.add(e);

        arestas.add(ab);
        arestas.add(ac);
        arestas.add(bc);
        arestas.add(be);
        arestas.add(dc);
        arestas.add(de);
        
        //vertices e arestas da lista auxiliar
        Vertice w = new Vertice("W",false);
        Vertice x = new Vertice("X",false);
        Vertice y = new Vertice("Y",false);
        Vertice z = new Vertice("Z",false);
        
        Aresta wx = new Aresta(6,w,x,false);
        Aresta xy = new Aresta(5,x,y,false);
        Aresta yz = new Aresta(4,y,z,false);
        Aresta zw = new Aresta(8,z,w,false);

        vert2.add(w);
        vert2.add(x);
        vert2.add(y);
        vert2.add(z);
        
        arestas2.add(wx);
        arestas2.add(xy);
        arestas2.add(yz);
        arestas2.add(zw);
        
        
        ArrayList<Vertice> mostra = grafo.getVertices();
        System.out.println("\nTodas vértices");
        for (int i = 0; i < mostra.size(); i++) {
            System.out.println(mostra.get(i).getNome());
        }
        
        
    }
    @After
    public  void tearDownClass() {          
        vert.clear();
        vert2.clear();
        arestas.clear();
        arestas2.clear();
        grafo.limparGrafo();
    }
    

    /**
     * Testar se o método limpa o grafo
     */
    @Test
    public void testLimparGrafo() {
        System.out.println("limparGrafo");
        grafo.limparGrafo();
        assertEquals(0,grafo.getVertices().size());
    }


    /**
     * Teste para verificar se está adicionando
     */
    @Test
    public void testAddAresta() {
        System.out.println("addAresta");
        
        //para dar certo
        grafo.addAresta(0,"w","y", false);      
        int esperado = arestas.size();                  
        esperado = esperado + 1;
        int resultado = grafo.getArestas().size();
        assertEquals(esperado,resultado);
        
        //para dar errado
        grafo.addAresta(0,"oi","ai", false);
        grafo.addAresta(0,"h","i", false);
        int esperado2 = arestas.size();
        int resultado2 = grafo.getArestas().size();
        assertNotEquals(esperado2,resultado2);          
     
    }


    /**
     * Teste para verificar se está adicionando vertice
     */
    @Test
    public void testAddVertice() {
        System.out.println("addVertice");
        String nome = "X";
        
        grafo.addVertice(nome,false);
        
        assertEquals(grafo.getVertices().get(5),grafo.buscarVertice("X"));
        
    }

    

    /**
     * Teste para verificar a lista de vertices
     */
    @Test
    public void testGetVertices() {
       System.out.println("getVertices");
               
        ArrayList<Vertice> atual = grafo.getVertices();
        ArrayList<Vertice> esperado = vert;
        
        assertEquals(esperado,atual);
 

    }

    /**
     * Teste para verificar a posição da vertice
     */
    @Test
    public void testPosicaoVertice() {
        System.out.println("posicaoVertice");
        ArrayList<Vertice> mostra = grafo.getVertices();
        System.out.println("\nTodas vértices");
        for (int i = 0; i < mostra.size(); i++) {
            System.out.println(mostra.get(i).getNome());
        }
        assertEquals(2, grafo.posicaoVertice("C"));
        assertNotEquals(4,grafo.posicaoVertice("C"));
        
    }

    /**
     * Teste para buscar vertice
     */
    @Test
    public void testBuscarVertice() {
        System.out.println("buscarVertice");
        Vertice buscar_a = new Vertice("A",false);
        
        
        
    }

    /**
     * Teste para verificar metodo de busca de arestas;
     */
    @Test
    public void testBuscarAresta() {
        System.out.println("buscarAresta");
    
        Vertice a = vert.get(0);
        Vertice b = vert.get(1);
        
        Aresta ab = arestas.get(0);
        
        assertEquals(ab,grafo.buscarAresta(a, b));
        
        
        
    }

    /**
     * Test of getArestas method, of class Grafo.
     */
    @Test
    public void testGetArestas() {
        System.out.println("getArestas");
        
        ArrayList<Aresta> atual = grafo.getArestas();
        ArrayList<Aresta> esperado = arestas;
        
        assertEquals(esperado,atual);
                
        
    }

    

    /**
     * Teste para verificar se o método ta removendo.
     */
    @Test
    public void testRemoverVertice2() {
        System.out.println("removerVertice2");
        String v_apagar = "A";
        
        assertTrue(grafo.removerVertice(v_apagar));

    }

    /**
     * Test of encontrarMenorCaminhoDijkstra method, of class Grafo.
     */
    @Test
    public void testEncontrarMenorCaminhoDijkstra() {
        System.out.println("encontrarMenorCaminhoDijkstra");
        Vertice v1 = vert.get(0);           //de a
        Vertice v2 = vert.get(1);           //até b

        ArrayList<Vertice> esperado = new ArrayList<Vertice>();
        esperado.add(v1);                   //a
        esperado.add(vert.get(2));          //c
        esperado.add(v2);                   //b
        
        ArrayList<Vertice> result = grafo.encontrarMenorCaminhoDijkstra(v1, v2);
        assertEquals(esperado,result);

        
    }

    /**
     * Test of removerVertice method, of class Grafo.
     */
    @Test
    public void testRemoverVertice() {
        System.out.println("removerVertice");
        
        boolean removido = grafo.removerVertice("A");
        assertEquals(true,removido);
        
        int size_atual = grafo.getVertices().size();      
        assertEquals(4,size_atual);
    }

    /**
     * Test of distanciaEuclidiana method, of class Grafo.
     */
    @Test
    public void testDistanciaEuclidiana() {
        System.out.println("distanciaEuclidiana");
        int x1 = 10;
        int y1 = 23;
        int x2 = 12;
        int y2 = 42;
        int expResult = 19;
        int result = grafo.distanciaEuclidiana(x1, y1, x2, y2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of menorCaminhoTodos method, of class Grafo.
     */
    @Test
    public void testMenorCaminhoTodos() {
        System.out.println("menorCaminhoTodos");
        String vert = "";
        Grafo instance = new Grafo();
        ArrayList<ArrayList<Vertice>> expResult = null;
        ArrayList<ArrayList<Vertice>> result = instance.menorCaminhoTodos(vert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
