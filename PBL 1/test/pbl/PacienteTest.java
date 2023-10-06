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
public class PacienteTest {

    /**
     * Teste para alterar nome do paciente.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Pedro Silva";
        Paciente instance = new Paciente("Rebeca Morais",11143);
        instance.setNome(nome);
        
        assertEquals(nome,instance.getNome());
    }

    /**
     * Teste para alterar a matrícula do paciente.
     */
    @Test
    public void testSetMatricula() {
        System.out.println("setMatricula");
        int matricula = 00001;
        Paciente instance = new Paciente("Rebeca Morais",11143);
        instance.setMatricula(matricula);
        
        assertEquals(matricula,instance.getMatricula());
    }

    /**
     * Teste para definir prioridade do paciente.
     */
    @Test
    public void testSetPrioridade() {
        System.out.println("setPrioridade");
        boolean prioridade = true;
        Paciente instance = new Paciente("Rebeca Morais",11143);
        instance.setPrioridade(prioridade);
        
        assertEquals(true, instance.getPrioridade());
    }

    /**
     * Teste para ver exames passados do paciente.
     */
    @Test
    public void testSetExames_passados() {
        System.out.println("setExames_passados");
        Lista exames_passados = new Lista();
        
        Exame exame1 = new Exame("Hemograma");
        Exame exame2 = new Exame("Beta HCG");
        Exame exame3 = new Exame("Ultrassonografia");
        exames_passados.insert(exame1);
        exames_passados.insert(exame2);
        exames_passados.insert(exame3);
        
     
        Paciente instance = new Paciente("Rebeca Morais",11143);
        instance.setExames_passados(exames_passados);
        
        assertEquals(exames_passados,instance.getExames_passados());
    }

    /**
     * Teste para retornar nome do paciente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Paciente instance = new Paciente("Rebeca Morais",11143);
        String expResult = "Rebeca Morais";
        String result = instance.getNome();
        
        assertEquals(expResult, result);
    }

    /**
     * Testa o retorno da matricula do paciente.
     */
    @Test
    public void testGetMatricula() {
        System.out.println("getMatricula");
        Paciente instance = new Paciente("Jorge Gomes",32991);
        int expResult = 32991;
        int result = instance.getMatricula();
        
        assertEquals(expResult, result);

    }

    /**
     * Teste do retorno da prioridade do paciente.
     */
    @Test
    public void testGetPrioridade() {
        System.out.println("getPrioridade");
        Paciente instance = new Paciente("Jorge Gomes",11143);
        boolean expResult = false;
        boolean result = instance.getPrioridade();
        
        assertEquals(expResult, result);

    }

    /**
     * Teste do retorno da lista de paciente.
     */
    @Test
    public void testGetExames_passados() {
        System.out.println("getExames_passados");
        Paciente instance = new Paciente("Milena Gomes",11143);
        Lista expResult = new Lista();
        
        Exame exame1 = new Exame("Hemograma");
        Exame exame2 = new Exame("Beta HCG");
        expResult.insert(exame1);
        expResult.insert(exame2);
        
        instance.setExames_passados(expResult);
        
        
        Lista result = instance.getExames_passados();
        
        assertEquals(expResult, result);
 
    }

    /**
     * Test of alterar_prioridade method, of class Paciente.
     */
    @Test
    public void testAlterar_prioridade() {
        System.out.println("alterar_prioridade");
        Paciente instance = new Paciente("Jorge Gomes",11143);
        instance.alterar_prioridade();
        
        assertEquals(true,instance.getPrioridade());
    }
    
}
