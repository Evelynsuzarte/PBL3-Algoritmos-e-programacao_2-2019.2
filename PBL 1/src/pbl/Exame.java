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
  * Classe usada para criação de objetos do tipo Exame, acompanhada de seus atributos e métodos
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class Exame{
    private String tipo_exame;
    private int quantidade_pessoas;
    private Lista atendimentos;    
    
    
    /**
    * Método para construir objeto exame 
    * 
    * @param tipo_exame String - nome do exame
    */
    public Exame(String tipo_exame){ 
        this.tipo_exame = tipo_exame;
        this.quantidade_pessoas = 0;
        this.atendimentos = new Lista();
    }
    
    
    /**
    * Método para atualizar nome do exame 
    * 
    * @param tipo_exame String - nome do exame        
    */
    public void setTipo_exame(String tipo_exame){
        this.tipo_exame = tipo_exame;
    }
    
    
    /**
    * Método para atualizar quantidade de pessoas para fazer o exame 
    * 
    * @param quantidade_pessoas int - quantidade de pessoas para o exame       
    */
    public void setQuantidade_pessoas(int quantidade_pessoas){
        this.quantidade_pessoas = quantidade_pessoas;
    }
    
    
    /**
    * Método para atualizar lista espera para o exame
    * 
    * @param atendimentos_exame Lista - lista de atendimentos do exame        
    */
    public void setAtendimentos(Lista atendimentos_exame){
        this.atendimentos = atendimentos_exame;
    }
    
    
    /**
    * Método para retornar nome do exame
    * @return tipo_exame String;
    */
    public String getTipo_exame(){
        return tipo_exame;
    }
    
    
    /**
    * Método para retornar quantidade de pessoas para fazer o exame
    * @return quantidade_pessoas int
    */
    public int getQuantidade_pessoas(){
        return quantidade_pessoas;
    }
    
    
    /**
    * Método para retornar lista de atendimentos do exame
    * @return atendimentos Lista - lista de atendimento do exame       
    */
    public Lista getAtendimentos(){
        return atendimentos;
    }


 } 

