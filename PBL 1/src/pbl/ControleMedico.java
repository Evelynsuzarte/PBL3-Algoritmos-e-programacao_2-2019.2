/*******************************************************************************
Autora: Evelyn Suzarte Fernandes 
Componente Curricular: MI-Programação - 2019.2
Concluido em: 23/11/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package pbl;

 /**
  * Classe contendo métodos relacionados ao médico 
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */


public class ControleMedico {
    
     /**
     * Metodo para exibir menu do case de médicos	
     */
    public void menuMedicos(){
        System.out.println("\n");
        System.out.println("*----- MÉDICOS ------*");
        System.out.println("1 - REGISTRAR MÉDICO(A)");
        System.out.println("2 - EDITAR MÉDICO(A)");
        System.out.println("3 - LISTA DE MÉDICOS(A)"); 
        System.out.println("*---------------------*");
        System.out.print("Selecione: ");
     }
    
    
     /**
     * Metodo para exibir menu de perguntas para alterar médico
     */
    public void perguntaAlterarmedico(){
        System.out.println("\n*--- ALTERAR MAIS MÉDICOS? ---*\n1 - SIM\t\t2 - NÃO\n*---------------------*\nSelecione:");
    }
    
    
    /**
     * Metodo para exibir menu de perguntas para registrar médicos
     */
    public void perguntaRegistrarMedicos(){
        System.out.println("\n*--- REGISTRAR MAIS MÉDICOS? ---*\n1 - SIM\t\t2 - NÃO\n*---------------------*\nSelecione:");
    }
    
    
     /**
    * Metodo para editar médico
    * 
    * @param buscar_crm int - crm para ser buscado
    * @param novo_nome String - novo nome para o médico
    * @param lista_medicos Lista - lista de médicos
    *	
    */
    public void editarMedico (int buscar_crm, String novo_nome, Lista lista_medicos){      
       Medico item;  
       int medico_buscar;
       
       if(!lista_medicos.isEmpty()){     
        for(int i=0; i<lista_medicos.size();i++){
            item = (Medico) lista_medicos.get(i);
            medico_buscar = item.getCrm();            
            if(buscar_crm == medico_buscar){
               item.setNome_medico(novo_nome);
               return;
            }
        } 
        System.out.println("CRM não encontrado");
       }else{
          System.out.println("Lista de médicos vazia!!!");
        
       }
    }
    
   
    /**
    * Metodo para listar médicos
    * 
    * @param lista_medicos Lista - lista de médicos
    *	
    */     
    public void listarMedicos(Lista lista_medicos){
        for(int i = 0;i < lista_medicos.size(); i++){
            Medico aux  = (Medico) lista_medicos.get(i);            //percorre a lista encadeada
            System.out.printf("Nome: %s\n",aux.getNome_medico());     //printa o nome do médico
            System.out.printf("CRM: %d\n\n",aux.getCrm());          //printa o crm do médico
            
        }
    }
   

    
    
    
    
    
    
    
    
    
}