/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author Evelyn Suzarte
 */

public class MedicoTest {
 

    /**
     * Teste para armazenar nome do médico.
     */
    @Test
    public void testSetNome_medico() {
        Medico instance = new Medico("Milena Souza",1111);
        System.out.println("setNome_medico");
        String nome_medico = "Carlos Andrade";
        instance.setNome_medico(nome_medico);

        assertEquals("Carlos Andrade",instance.getNome_medico());
    }

    
    /**
     * Teste para armazenar crm do médico.
     */
    @Test
    public void testSetCrm() {
        Medico instance = new Medico("Pedro Nogueira",2222);
        System.out.println("setCrm");
        int crm = 5555;
        instance.setCrm(crm);

        assertEquals(5555,instance.getCrm());
    }

    
    /**
     * Teste para armazenar lista de atendidos pelo medico.
     */
    @Test
    public void testSetAtendidos_existindo_paciente() {
        System.out.println("setAtendidos_existindo_paciente");
        Lista lista_atendidos = new Lista();
        
        Paciente paciente1 = new Paciente("Rosana Moura",12345);
        Paciente paciente2 = new Paciente("Carla Santos",67890);
        lista_atendidos.insert(paciente1);
        lista_atendidos.insert(paciente2);
        
        Medico instance = new Medico("Fátima Lima",1111);
        instance.setAtendidos(lista_atendidos);

        assertEquals(paciente1, instance.lista_atendidos.get(0));
        assertEquals(paciente2, instance.lista_atendidos.get(1));
    }

    
    /**
     * Teste para armazenar lista de espera .
     */
    @Test
    public void testSetFilaEspera() {
        System.out.println("setFilaEspera");
        Fila fila_atendimento = new Fila();
        
        Paciente paciente1 = new Paciente("Celina Dias",12345);
        Paciente paciente2 = new Paciente("Ricardo Pires",67890);
        fila_atendimento.insert(paciente1);
        fila_atendimento.insert(paciente2);        
        fila_atendimento.deleteFirst();
                
        Medico instance = new Medico("Rodrigo Silva",1111);     
        instance.setFilaEspera(fila_atendimento);

        assertEquals(instance.getFilaEspera(), fila_atendimento);    
    }

    
    /**
     * Teste para ver se o nome do medico estar certo.
     */
    @Test
    public void testGetNome_medico() {
        System.out.println("getNome_medico");
        Medico instance = new Medico("Marcos Dias",4444);     
        String expResult = "Marcos Dias";
        String result = instance.getNome_medico();
        
        assertEquals(expResult, result);
    }

    
    /**
     * Teste para ver se o crm está correto.
     */
    @Test
    public void testGetCrm() {
        System.out.println("getCrm");
        Medico instance = new Medico("Rebeca Silva",3434);     
        int expResult = 3434;
        int result = instance.getCrm();
        assertEquals(expResult, result);
    }

    
    /**
     * Teste para verificar a fila de espera do médico.
     */
    @Test
    public void testGetListaEspera() {
        System.out.println("getListaEspera");
        Medico instance = new Medico("Rodrigo Silva",1111);     
               
        Fila expResult = new Fila();       
        Paciente paciente1 = new Paciente("Celina Dias",12345);
        Paciente paciente2 = new Paciente("Ricardo Pires",67890);
        expResult.insert(paciente1);
        expResult.insert(paciente2);
        
        instance.setFilaEspera(expResult);
        
        
        Fila result = instance.getFilaEspera();
        
        assertEquals(expResult, result);
    }

    
    /**
     * Teste para verificar a lista de atendidos.
     */
    @Test
    public void testGetAtendidos() {
        System.out.println("getAtendidos");
        Medico instance = new Medico("Talita Santana",0001);  
        
        Lista expResult = new Lista();
        Paciente paciente1 = new Paciente("Carla Rosa",12345);
        Paciente paciente2 = new Paciente("Italo Pires",67890);
 
        expResult.insert(paciente1);
        expResult.insert(paciente2);
        
        instance.setAtendidos(expResult);
        
        Lista result = instance.getAtendidos();
        assertEquals(expResult, result);
    }

    
    /**
     * Teste para verificar a quantidade de pessoas na lista de espera.
     */
    @Test
    public void testQuantidade_espera() {
        System.out.println("quantidade_espera");
        Medico instance = new Medico("Talita Santana",0001);  
        int expResult = 3;
        
        Fila espera = new Fila();
        Paciente paciente1 = new Paciente("Carla Rosa",12345);
        Paciente paciente2 = new Paciente("Italo Pires",67890);
        Paciente paciente3 = new Paciente("Teresa Menezes",24355);
        espera.insert(paciente1);
        espera.insert(paciente2);
        espera.insert(paciente3);
        
        instance.setFilaEspera(espera);
                
        int result = instance.quantidade_espera();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of quantidade_pacientes method, of class Medico.
     */
    @Test
    public void testQuantidade_pacientes() {
        System.out.println("quantidade_pacientes");
        Medico instance = new Medico("Thiago Santana",0001); 
        
        Lista atendidos = new Lista();
        Paciente paciente1 = new Paciente("Carla Rosa",12345);
        Paciente paciente2 = new Paciente("Italo Pires",67890);
        Paciente paciente3 = new Paciente("Teresa Menezes",24355);
        Paciente paciente4 = new Paciente("Evelyn Suzarte",32211);
        Paciente paciente5 = new Paciente("Mateus Rodrigues",78788);
        atendidos.insert(paciente1);
        atendidos.insert(paciente2);
        atendidos.insert(paciente3);
        atendidos.insert(paciente4);
        atendidos.insert(paciente5);
        
        instance.setAtendidos(atendidos);
        
        int expResult = 5;
        int result = instance.quantidade_pacientes();
        assertEquals(expResult, result);

    }

    
}
