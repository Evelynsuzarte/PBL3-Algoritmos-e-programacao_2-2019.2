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
  * Classe usada para criação de objetos do tipo LinkFila, acompanhada de seus atributos e métodos para serem
  *         usadas na classe Fila
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */


class LinkFila {
    public Paciente elemento;                               //primeiro item
    public LinkFila proximo;                                //proximo item
    
    
    /**
    * Método para criar objeto LinkFila
    * 
    * @param item Paciente - objeto tipo Paciente           
    */
    public LinkFila(Paciente item){
        elemento = item;
    }
    
    
    /**
    * Método para retornar elemento
    * @return elemento LinkFila         
    */
    public Paciente getElemento(){                          //elemento atual_elemento
        return elemento;
    }
    
    
    /**
    * Método para retornar proximo elemento
    * @return proximo LinkFila      
    */
    public LinkFila getProximo(){                           //elemento proximo
        return proximo;                 
    }
    
    
    /**
    * Método para atualizar elemento
    * @param elemento Paciente - paciente      
    */
    public void setElemento(Paciente elemento){             //receber elemento
        this.elemento = elemento;
    }    
    

    /**
    * Método para atualizar proximo elemento
    * @param proximo LinkFila - proximo paciente
    */
    public void setProximo(LinkFila proximo){
        this.proximo = proximo;
}
 }

 /**
  * Classe usada para criação de objetos do tipo Fila, acompanhada de seus atributos e métodos
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */
    
class Fila{
    private LinkFila first;                     //primeiro item da lista
    private LinkFila last;                      //ultimo item da lista
    private int size;
    
    
    /**
    * Método para criar objeto tipo Fila         
    */
    public Fila(){                              //construtor
        this.first = null;
        this.last = null; 
        this.size = 0;
    }  
    
    /**
    * Método para retornar tamanho da fila
    * @return size int          
    */
    public int size(){                          //tamanho da fila
        return size;
    }
    
    /**
    * Método para retornar primeiro elemento
    * @return first LinkFila          
    */
    public LinkFila getFirst(){                 //retorna primeiro
        return first;
    } 

    /**
    * Método para atualizar primeiro elemento        
    */
    public void setFirst(LinkFila paciente){                 //retorna primeiro
        this.first = paciente;
    }    
    
    /**
    * Método para retornar ultimo elemento
    * @return last LinkFila          
    */
    public LinkFila getLast(){                  //retorna ultimo
       return last;
    }
    

    /**
    * Método para atualizar ultimo elemento        
    */
    public void setLast(LinkFila paciente){                 //retorna primeiro
        this.last = paciente;
    }     
    
    
    /**
    * Método para retornar se lista ta vazia
    * @return boolean          
    */
    public boolean isEmpty(){                   //se a lista cheia 
        return (first == null);
    }
    
    
    /**
    * Método para inserir novo elemento
    * @param novo Paciente - novo paciente para ser inserido          
    */
    public void insert(Paciente novo){                    //metodo para inserir 
        if(isEmpty()){            
            LinkFila newLink = new LinkFila (novo);       // novo nó        
            first = newLink;                                
            last = newLink;                                                                        
        }
        else{
            LinkFila newLink = new LinkFila(novo);
            LinkFila aux = last;
            aux.setProximo(newLink);
            last = newLink;
        }
        size++;
   }
    
    
    /**
    * Método para deletar primeiro elemento
    * @return temp Paciente          
    */
    public Paciente deleteFirst(){                  //apaga o primeiro
        if(!isEmpty()){
            Paciente temp = first.elemento;
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
    
    
    /**
    * Método para retornar posição na Fila
    * @param indice int - posição que deseja buscar
    * @return item - Paciente      
    */
    public Paciente get(int indice){                //posições da lista
        if (indice >= 0 && indice < size()) {
            LinkFila item = first;
            for (int i = 0; i < indice; i++) {
                item = item.getProximo();
            }
            return item.getElemento();
        }
        return null;
    }

    
    /**
    * Método para retornar posição na Fila
    * @param indice int - posição que deseja buscar
    * @return item LinkFila        
    */
    public LinkFila getLink(int indice){                //posições da lista
        if (indice >= 0 && indice < size()) {
            LinkFila item = first;
            for (int i = 0; i < indice; i++) {
                item = item.getProximo();
            }
            return item;
        }
        return null;
    }
    
    
    /**
    * Método para adicionar na primeira posição na fila
    * @param elemento Paciente - paciente que deseja adicionar
    * @return item          
    */       
    public void insertFirst(Paciente elemento){
        LinkFila novoLink = new LinkFila(elemento);                 //novo elemento é igual ao primeiro
        first = novoLink; 
    }
    
    
    /**
    * Método para adicionar no meio da fila
    * @param atual LinkFila - item atual
    * @param anterior LinkFila - item anterior        
    */       
    public void insertPosition(LinkFila atual, LinkFila anterior, Paciente paciente){
        LinkFila newLink = new LinkFila(paciente);       
        newLink.proximo = atual;
        anterior.proximo = newLink;
    }
    
    public void insertFirst2(Paciente paciente){
        LinkFila newLink = new LinkFila(paciente);
        newLink.setProximo(first);
        first = newLink;       
    }
    
    
    
    

}
    