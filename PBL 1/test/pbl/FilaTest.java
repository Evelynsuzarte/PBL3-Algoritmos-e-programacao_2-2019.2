/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evelyn Suzarte
 */
public class FilaTest {
    /*
    Fila instance;
    Paciente paciente1;
    Paciente paciente2;
    Paciente paciente3;
    
    @Before
    public static void setUp() throws Exception {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
    }
    */
    /**
     * Teste do tamanho da Fila.
     */
    @Test
    public void testSize() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("size");
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Teste do primeiro da fila.
     */
    @Test
    public void testGetFirst() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("getFirst");
        LinkFila expResult = new LinkFila(paciente1);
        LinkFila result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Teste para mudar o primeiro.
     */
    @Test
    public void testSetFirst() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("setFirst");
        Paciente paciente0 = new Paciente("Carlos Pires",11112);
        LinkFila paciente = new LinkFila(paciente0);
        instance.setFirst(paciente);
        assertEquals(paciente0, instance.getFirst());
    }

    /**
     * Teste para ver ultimo item da lista.
     */
    @Test
    public void testGetLast() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("getLast");
        LinkFila expResult = new LinkFila(paciente3);
        LinkFila result = instance.getLast();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLast method, of class Fila.
     */
    @Test
    public void testSetLast() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("setLast");
        Paciente pacientex = new Paciente("Camila Mendes",11133);
        LinkFila paciente = new LinkFila(pacientex);
        instance.setLast(paciente);
        assertEquals(pacientex, instance.getLast());
    }

    /**
     * Teste para ver se ta vazia.
     */
    @Test
    public void testIsEmpty() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("isEmpty");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Teste para inserir item .
     */
    @Test
    public void testInsert() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("insert");
        Paciente novo = new Paciente("Luiza Souza",23200);
        instance.insert(novo);
        assertEquals(novo,instance.getLast());
    }

    /**
     * Teste para apagar o primeiro item.
     */
    @Test
    public void testDeleteFirst() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("deleteFirst");
        Paciente expResult = new Paciente("Maria Luiza",34343);
        Paciente result = instance.deleteFirst();
        assertEquals(expResult, result);
    }

    /**
     * Teste para encontrar um item 
     */
    @Test
    public void testGet() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("get");
        int indice = 0;
        Paciente expResult = new Paciente("Maria Luiza",34343);
        Paciente result = instance.get(indice);
        assertEquals(expResult, result);
    }

    /**
     * Teste para inserir na frente
     */
    @Test
    public void testInsertFirst() {
        Paciente paciente1 = new Paciente("Maria Luiza",34343);
        Paciente paciente2 = new Paciente("Ricardo Souza",22220);
        Paciente paciente3 = new Paciente("Eliza Pinheiro",55564);
        
        Fila instance = new Fila();
        
        instance.insert(paciente1);
        instance.insert(paciente2);
        instance.insert(paciente3);
        
        System.out.println("insertFirst");
        Paciente elemento = new Paciente("Maria Pedrosa",44461);
        instance.insertFirst(elemento);
        assertEquals(elemento,instance.getFirst());
    }
    
}
