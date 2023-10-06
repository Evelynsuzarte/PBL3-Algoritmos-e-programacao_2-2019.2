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
  * Classe usada para criação de objetos do tipo Link, acompanhada de seus atributos e métodos, para serem
  *         usadas na classe Lista
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

class Link{
    public Object elemento;                                     //item
    public Link proximo;                                        // proximo
    
    /**
    * Método para criar Link
    * @param elemento Object
    * @param proximo Link      
    */
    public Link(Object elemento,Link proximo){                  //construtor
        this.elemento = elemento;
        this.proximo = proximo;
    }
    
    
    /**
    * Método para retornar elemento
    * @return elemento          
    */
    public Object getElemento(){                                //elemento atual_elemento
        return elemento;
    }
    
    
    /**
    * Método para retornar proximo elemento
    * @return proximo          
    */
    public Link getProximo(){                                   //elemento proximo
        return proximo;                 
    }
    
    
    /**
    * Método para atualizar elemento         
    */
    public void setElemento(Object elemento){                    //receber elemento
        this.elemento = elemento;
    }    
    

    /**
    * Método para atualizar próximo elemento         
    */    
    public void setProximo(Link proximo){                       //atualizar proximo elemento
        this.proximo = proximo;
}
 }


 /**
  * Classe usada para criação de objetos do tipo Lista, acompanhada de seus atributos e métodos
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */
public class Lista {
    
    private Link first;                                         // referencia do primeiro nó
    private Link last;                                          //referencia do ultimo nó   
    private int size;                                           //tamanho da lista
    
    
    /**
    * Método para construir Lista        
    */
    public Lista(){                                             //construtor
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    
    /**
    * Método para retornar tamanho da lista
    * @return size int
    */
    public int size(){                                          //retorna o tamanho da lista
        return this.size;
    }
    
    /**
    * Método para retornar se lista está cheia
    * @return size int           
    */    
    public boolean isEmpty(){                       
        return (size == 0);                                     //return true caso esteja vazia
    }
    
    
    /**
    * Método para retornar o primeiro elemento
    * @return first Object          
    */
    public Object getFirst(){                                   //retorna primeiro nó
        return first;
    }
    
    
    /**
    * Método para retornar ultimo elemento
    * @return last Object          
    */
    public Object getLast(){                                    //retorna ultimo nó
        return last;
    }
    
    
    /**
    * Método para atualizar tamanho da Lista
    * @param size int         
    */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
    * Método para inserir elemento na lista
    * @param novo Object - novo elemento          
    */
    public void insert(Object novo){                            //inserir 
        if(isEmpty()){                                          //caso esteja vazia
            Link newLink = new Link (novo,last);                          
            first = newLink;                                    //o primeiro e o ultimo nó é o novo nó
            last = newLink;                                                                              
        }
        else{
            Link newLink = new Link(novo,null);
            Link aux = last;                                    //o ultimo nó fica numa variavel auxiliar
            aux.setProximo(newLink);                            //o proximo nó do auxiliar é o novo nó
            last = newLink;                                     //o novo nó se torna ultimo
        }
        size++;
   }
    
    
    /**
    * Método para deletar ultimo elemento
    * @return atual Link          
    */
    public Object delete(){                                     //apaga o ultimo
        if(!isEmpty()){                                         //se nao tiver vazia
            Link atual = first;                                 //atual é igual ao primeiro
            Link prox = first.getProximo();                     //proximo é igual ao proximo do primeiro
            first = prox;                                       //primeiro é igual ao proximo
            size --;                                    
            return atual.getElemento();
        }
        return null;                                            //se tiver vazia retorna null
        }
    
    
    /**
    * Método para inserir no inicio da fila
    * @param elemento Object          
    */
    public void inserirFirst(Object elemento){
        Link novoNo = new Link(elemento,first);                 //novo elemento é igual ao primeiro
        first = novoNo;
    }
    
    
    /**
    * Método para retornar posicao do elemento desejado
    * @param posicao int
    * @return elemento          
    */
    public Object get(int posicao){                            //retorna o elemento de dada posição
        if (posicao >= 0 && posicao < size()) {                //a entrada tem que ser maior que ou igual a zero e menor que o tamanho da lista
            Link elemento = first;
            for (int i = 0; i < posicao; i++) {
                elemento = elemento.getProximo();
            }
            return elemento.getElemento();
        }
        return null;
    }
   
    
    /**
    * Método para deletar primeiro elemento
    * @return temp Object          
    */
    public Object deleteFirst(){                                //apaga o primeiro
        if(!isEmpty()){
            Object temp = first.elemento;
            if(first.proximo == null){
                last = null;
                size--;
            }
            first = first.proximo;
            size --;
            return temp;
            
            }   
        return null;
    }

    LinkFila getLink(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    }
    
    
 

 