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
  * Classe usada para criação de objetos do tipo Medico, acompanhada de seus atributos e métodos
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class Medico{
    private String nome_medico;
    private int crm;   
    Fila fila_espera;
    Lista lista_atendidos;
    
    
    /**
    * Método para construir objetos do tipo médico 
    * 
    * @param nome_medico String - nome do médico
    * @param crm int - crm do médico        
    */
    public Medico(String nome_medico,int crm){  //construtor
        this.nome_medico = nome_medico;
        this.crm = crm;
        this.fila_espera = new Fila();
        this.lista_atendidos = new Lista();
    }
    
    
    /**
    * Método para atualizar nome do médico
    * 
    * @param nome_medico String - nome do médico          
    */
    public void setNome_medico(String nome_medico){
        this.nome_medico = nome_medico;
    }
    
    
    /**
    * Método para atualizar crm do médico 
    * 
    * @param crm int - crm do médico          
    */
    public void setCrm(int crm){
        this.crm = crm;
    }
    
    
    /**
    * Método para atualizar lista de atendidos pelo médico
    * 
    * @param lista_atendidos Lista - lista de atendidos pelo médico           
    */
    public void setAtendidos(Lista lista_atendidos){
        this.lista_atendidos = lista_atendidos;
    }
    
    
    /**
    * Método para atualizar fila de espera de atendimento do médico
    * 
    * @param fila_atendimento Fila - fila de espera          
    */
    public void setFilaEspera(Fila fila_atendimento){
        this.fila_espera = fila_atendimento;
    }
    
    
    /**
    * Método para retorna nome do médico	
    * @return nome_medico String          
    */
    public String getNome_medico(){
        return nome_medico;
    }
    
    
    /**
    * Método para retornar crm do médico
    * @return crm int         
    */
    public int getCrm(){
        return crm;
    }
    
    
    /**
    * Método para retornar fila de espera do médico	
    * @return fila_espera Fila          
    */
    public Fila getFilaEspera(){
        return fila_espera;
    }
    
    
    /**
    * Método para retornar lista de atendidos pelo médico
    * @return lista_atendidos Lista           
    */
    public Lista getAtendidos(){
        return lista_atendidos;
    }
    
    
    /**
    * Método para retornar quantidade de pessoas na lista de espera	
    * @return quantidade_espera int       
    */
    public int quantidade_espera(){
        return fila_espera.size();
    }
    
    /**
    * Método para retornar quantidade de pessoas da lista de atendidos	
    * @return  quantidade_pacientes int         
    */
    public int quantidade_pacientes(){
        return lista_atendidos.size();
    }
}
