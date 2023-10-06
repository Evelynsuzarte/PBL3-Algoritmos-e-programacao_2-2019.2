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
public class ControleAtendimentoTest {
    
    /**
     * Teste do registro do médico.
     */
    @Test
    public void testRegistrarMedico() {
        System.out.println("registrarMedico");
        String nome = "Mateus";
        int crm = 111;
        Lista lista_medicos = new Lista();
        
        Medico medico1 = new Medico("Rosana Moura",1111);
        Medico medico2 = new Medico("Carla Santos",2222);
        lista_medicos.insert(medico1);
        lista_medicos.insert(medico2);
        
 
        ControleAtendimento instance = new ControleAtendimento();
        Lista expResult = new Lista();
        Medico medico4 = new Medico("Rosana Moura",1111);
        Medico medico5 = new Medico("Carla Santos",2222);
        Medico medico6 = new Medico("Mateus",111);
        expResult.insert(medico4);
        expResult.insert(medico5);
        expResult.insert(medico6);
        
        
        Lista result = instance.registrarMedico(nome, crm, lista_medicos);
        
        assertEquals(expResult, result);

    }

    /**
     * Test of registrarPaciente method, of class ControleAtendimento.
     */
    @Test
    public void testRegistrarPaciente() {
        System.out.println("registrarPaciente");
        String nome = "Rodrigo";
        int matricula = 22221;
        int opcao = 1;
        
        
        Lista lista_pacientes = new Lista();          
        Paciente paciente1 = new Paciente("Rosana Moura",12345);
        Paciente paciente2 = new Paciente("Carla Santos",67890);
        lista_pacientes.insert(paciente1);
        lista_pacientes.insert(paciente2);
        
         
        
        Lista lista_medicos = new Lista();
        Medico medico1 = new Medico("Rosana Moura",1111);
        Medico medico2 = new Medico("Carla Santos",2222);
        lista_medicos.insert(medico1);
        lista_medicos.insert(medico2);
        
            
        ControleAtendimento instance = new ControleAtendimento();
        Lista expResult = new Lista();
        
        
        Lista result = instance.registrarPaciente(nome, matricula, opcao, lista_pacientes, lista_medicos);
        assertEquals(expResult, result);

        
    }

    /**
     * Test of buscarMedicoFilaMenor method, of class ControleAtendimento.
     */
    @Test
    public void testBuscarMedicoFilaMenor() {
        System.out.println("buscarMedicoFilaMenor");
        Paciente paciente = null;
        Lista lista_medicos = null;
        ControleAtendimento instance = new ControleAtendimento();
        int expResult = 0;
        int result = instance.buscarMedicoFilaMenor(paciente, lista_medicos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarFilaPacientes method, of class ControleAtendimento.
     */
    @Test
    public void testListarFilaPacientes() {
        System.out.println("listarFilaPacientes");
        Lista lista_medicos = null;
        int crm_buscar = 0;
        ControleAtendimento instance = new ControleAtendimento();
        instance.listarFilaPacientes(lista_medicos, crm_buscar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}
