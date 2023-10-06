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
public class ControleMedicoTest {
  
    /**
     * Teste para editar o médico existente.
     */
    @Test
    public void testEditarMedico_existindoMedico() {
        System.out.println("editarMedico");
        int buscar_crm = 2222;
        String novo_nome = "Simone Santos";
        Lista lista_medicos = new Lista();
        
        Medico medico1 = new Medico("Rosana Moura",1111);
        Medico medico2 = new Medico("Carla Santos",2222);
        lista_medicos.insert(medico1);
        lista_medicos.insert(medico2);
        
        
        ControleMedico instance = new ControleMedico();
        instance.editarMedico(buscar_crm, novo_nome, lista_medicos);

        Medico medico = (Medico) lista_medicos.get(1);
        String result = medico.getNome_medico();
        
        assertEquals(novo_nome,result);
    }
    
    /**
     * Teste para editar o médico não existente.
     */
    @Test       
    public void testEditarMedico_nãoExistindoMedico() {
        System.out.println("editarMedico");
        int buscar_crm = 2222;
        String novo_nome = "Simone Santos";
        Lista lista_medicos = new Lista();
        
        Medico medico1 = new Medico("Rosana Moura",1111);
        Medico medico2 = new Medico("Carla Santos",2322);
        lista_medicos.insert(medico1);
        lista_medicos.insert(medico2);
        
        
        ControleMedico instance = new ControleMedico();
        instance.editarMedico(buscar_crm, novo_nome, lista_medicos);

        Medico medico = (Medico) lista_medicos.get(1);
        String result = medico.getNome_medico();
        
        assertNotEquals(novo_nome,result);
    }
    

}
