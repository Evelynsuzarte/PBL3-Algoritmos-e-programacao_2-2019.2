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
  * Classe usada para criação de objetos do tipo Paciente, acompanhada de seus atributos e métodos
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class Paciente{
    private String nome;
    private int matricula;   
    private boolean prioridade;
    private Lista exames_passados;
    
    
    /**
    * Método para construir objeto paciente 
    * 
    * @param nome String - nome do paciente
    * @param matricula int - numero de matricula do paciente          
    */
    public Paciente(String nome,int matricula){ //construtor
        this.nome = nome;
        this.matricula = matricula;
        this.prioridade = false;
        this.exames_passados = new Lista();
        }
    
    
    /**
    * Método para atualizar nome do paciente 
    * 
    * @param nome String - nome do paciente        
    */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
    * Método para atualizar matricula do paciente
    * 
    * @param matricula int - matrícula do paciente          
    */
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    
    /**
    * Método para atualizar a prioridade do paciente
    * 
    * @param prioridade boolean - prioridade do paciente          
    */
    public void setPrioridade(boolean prioridade){
        this.prioridade = prioridade;
    }
    
    
    /**
    * Método para atualizar lista de exames passados
    * 
    * @param exames_passados Lista - lista de exames do paciente          
    */
    public void setExames_passados(Lista exames_passados){
        this.exames_passados = exames_passados;
    }       
    
    
    /**
    * Método para retornar nome do paciente
    * @return nome String      
    */
    public String getNome(){
        return nome;
    }
    
    
    /**
    * Método para retornar matricula do paciente
    * @return matricula int      
    */
    public int getMatricula(){
        return matricula;
    }
    
    
    /**
    * Método para retornar prioridade do paciente
    * @return prioridade boolean      
    */
    public boolean getPrioridade(){
        return prioridade;
    }
    
    
    /**
    * Método para retornar lista de exames do paciente
    * @return exames_passados Lista      
    */
    public Lista getExames_passados(){
        return exames_passados;
    }
    
    
    /**
    * Método para alterar a prioridade do paciente para verdadeiro    
    */
    public void alterar_prioridade(){
        this.prioridade = true;
    }
    
    
} 