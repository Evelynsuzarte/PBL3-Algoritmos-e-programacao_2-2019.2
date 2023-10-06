/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evelyn Suzarte
 */
public class ExameTest {
    

    /**
     * Teste para definir nome do exame.
     */
    @Test
    public void testSetTipo_exame() {
        System.out.println("setTipo_exame");
        String tipo_exame = "Ultrassonografia";
        Exame instance = new Exame("Hemograma");
        instance.setTipo_exame(tipo_exame);

        assertEquals(tipo_exame,instance.getTipo_exame());
    }

    /**
     * Teste para verificar quantidade de pessoas.
     */
    @Test
    public void testSetQuantidade_pessoas_int() {
        System.out.println("setQuantidade_pessoas");
        int quantidade_pessoas = 5;
        Exame instance = new Exame("Hemograma");
               
        instance.setQuantidade_pessoas(quantidade_pessoas);

        assertEquals(quantidade_pessoas,instance.getQuantidade_pessoas());
    }

    /**
     * Test of setAtendimentos method, of class Exame.
     */
    @Test
    public void testSetAtendimentos() {
        System.out.println("setAtendimentos");
        Lista atendimentos_exame = new Lista();
        
        Paciente paciente1 = new Paciente("Isabel Mendes",12121);
        Paciente paciente2 = new Paciente("Rodrigo Fereira",77778);
        atendimentos_exame.insert(paciente1);
        atendimentos_exame.insert(paciente2);
        
        
        Exame instance = new Exame("Hemograma");
        instance.setAtendimentos(atendimentos_exame);

        assertEquals(atendimentos_exame,instance.getAtendimentos());
    }

    /**
     * Teste para retorno do nome do exames.
     */
    @Test
    public void testGetTipo_exame() {
        System.out.println("getTipo_exame");
        Exame instance = new Exame("Hemograma");
        String expResult = "Hemograma";
        String result = instance.getTipo_exame();
        
        assertEquals(expResult, result);

    }

    /**
     * Teste para retorno de quantidade de pessoas.
     */
    @Test
    public void testGetQuantidade_pessoas() {
        System.out.println("getQuantidade_pessoas");
        Exame instance = new Exame("Hemograma");
        int expResult = 0;
        int result = instance.getQuantidade_pessoas();
        assertEquals(expResult, result);
    }

    /**
     * Teste para retorno de lista de atendimentos.
     */
    @Test
    public void testGetAtendimentos() {
        System.out.println("getAtendimentos");
        Exame instance = new Exame("Hemograma");
        
        Lista expResult = new Lista();
        Paciente paciente1 = new Paciente("Isabel Mendes",12121);
        Paciente paciente2 = new Paciente("Rodrigo Fereira",77778);
        expResult.insert(paciente1);
        expResult.insert(paciente2);
        
        instance.setAtendimentos(expResult);
        
        Lista result = instance.getAtendimentos();
        assertEquals(expResult, result);

    }

    /**
     * Teste para mudar quantidade de pessoas.
     */
    @Test
    public void testSetQuantidade_pessoas() {
        System.out.println("setQuantidade_pessoas");
        Exame instance = new Exame("Beta HCG");
        int expResult = 2;
        
        instance.setQuantidade_pessoas(expResult);
        
        int result = instance.getQuantidade_pessoas();
        
        assertEquals(expResult, result);
    }
   
}
