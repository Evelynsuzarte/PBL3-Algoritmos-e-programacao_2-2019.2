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

import java.util.Scanner;

 /**
  * Classe para fazer manipulação dos objetos.
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */

public class ControleAtendimento {
    
     /**
    * Método para realizar atendimento
    * 
    * @param lista_pacientes Lista - lista de pacientes
    * @param crm int - crm do médico
    * @param lista_medicos Lista - lista de médicos
    * @param lista_exames Lista - lista de exames
    * @param lista_geral Lista - lista de atendimento geral
    *	          
    */
    public void realizarAtendimento(Lista lista_pacientes,Lista lista_medicos, int crm, Lista lista_exames, Lista lista_geral){
        Scanner ler = new Scanner(System.in);
    
        int opcao = 0;
        if (!lista_pacientes.isEmpty()){ 
                boolean continuar_atendimento = true;  
                Medico medico_buscado = null;
                
                int id = 0;                                             //busca pelo medico  e guarda a posição do médico
                for(int i=0;i<lista_medicos.size();i++){                //loop do tamanho da lista
                    medico_buscado = (Medico) lista_medicos.get(i);          //se for igual ao crm que quero buscar. armazena o médico
                    if(medico_buscado.getCrm() == crm){
                        id = i;
                        break;
                    }
                }

                Fila pacientes_esperando = (Fila)medico_buscado.getFilaEspera();            //fila de espera do médico

                while(continuar_atendimento == true){       //loop para manter se repetindo o menu de atendimento

                    LinkFila atendendo_paciente = pacientes_esperando.getFirst();
                    System.out.printf("ATENDENDO %s - %d\n",atendendo_paciente.elemento.getNome(),atendendo_paciente.elemento.getMatricula());
                    System.out.println("PASSAR EXAME:\n1 - SIM\n2 - NÃO\n");
                    System.out.println("*-----------*");
                    System.out.println("Selecione: ");
                    opcao = ler.nextInt();

                if(opcao == 1){    
                        int add_exames = 0;                                         //variavel para manter loop de exames rodando
                        while(add_exames == 0){ 
                            for (int i = 0; i<lista_exames.size(); i++){            //loop para print dos exames
                                Exame exame = (Exame) lista_exames.get(i);          
                                String nome_exame = exame.getTipo_exame();
                                System.out.printf("%d - %s\n",i,nome_exame);
                            }

                            System.out.println("*-----------*");
                            System.out.print("Selecione: ");                        //seleção dos exames
                            opcao = ler.nextInt();

                            Exame exame = (Exame) lista_exames.get(opcao);          //exame escolhido

                            int quantidade = exame.getQuantidade_pessoas();         //adiciona 1 na quantidade de pessoas para o exame
                            quantidade++;
                            exame.setQuantidade_pessoas(quantidade);

                            Lista exame_paciente = exame.getAtendimentos();         //adiciona o paciente a lista do exame
                            exame_paciente.insert(atendendo_paciente);

                            Lista exames_passados = atendendo_paciente.elemento.getExames_passados();     //adiciona o exame a lista de exames do paciente
                            exames_passados.insert(exame);


                            medico_buscado = (Medico) lista_medicos.get(id);                //adiciona o paciente a lista de atendidos de médico
                            Lista atendimentos_medico = medico_buscado.getAtendidos();
                            atendimentos_medico.insert(atendendo_paciente);

                            lista_geral.insert(atendendo_paciente);                         //insere o paciente na lista geral de atendimento

                            System.out.println("ADICIONAR MAIS EXAMES?\n1 - SIM\n2 - NÃO");
                            System.out.println("*--------------------*");
                            System.out.print("Selecione: ");
                            opcao = ler.nextInt();
                            switch(opcao){
                                case 1:
                                    add_exames = 0;                                         //exibe o menu de exames novamente
                                    break;
                           
                                case 2:{
                                        System.out.print("ATENDER PRÓXIMO?\n1 - SIM\n2 - NÃO \n");
                                        System.out.println("*--------------------*");
                                        System.out.print("Selecione: ");
                                        opcao = ler.nextInt();
                                        if(opcao == 1){
                                            continuar_atendimento = true;                       //vai para o proximo paciente da fila do mesmo médico

                                            LinkFila pac_esperando = pacientes_esperando.getFirst();
                                            System.out.println(pac_esperando.elemento.getNome());
                                            pacientes_esperando.deleteFirst();                          //deleta o paciente do inicio da fila da lista de espera
                                    }
                                        else if(opcao == 2){
                                            add_exames = 1;             //sai do loop de adicionar mais exames
                                            continuar_atendimento = false;  //sai do loop do menu de atendimento
                                            pacientes_esperando.deleteFirst();                          //deleta o paciente do inicio da fila da lista de espera

                                        }
                                    }
                                        break;
                            } // switch
                        }   //loop add exame
                }
                else{                                       //caso nao passe exame
                        System.out.print("ATENDER PRÓXIMO?\n1 - SIM\n2 - NÃO \n");
                        System.out.println("*--------------------*");
                        System.out.print("Selecione: ");
                        opcao = ler.nextInt();
                        if(opcao == 1){
                            continuar_atendimento = true;                       //vai para o proximo paciente da fila do mesmo médico

                            LinkFila pac_esperando = pacientes_esperando.getFirst();
                            System.out.println(pac_esperando.elemento.getNome());
                            pacientes_esperando.deleteFirst();                          //deleta o paciente do inicio da fila da lista de espera
                    }   
                        else if(opcao == 2){
                            continuar_atendimento = false;  //sai do loop do menu de atendimento
                            pacientes_esperando.deleteFirst();                          //deleta o paciente do inicio da fila da lista de espera

                        }
                }
            }
           
        }else
            System.out.println("NENHUM PACIENTE NA FILA DE ESPERA!!\n");
    }
    
    
    /**
    * Método para exibir menu principal
    */
    public void exibirMenu(){
        System.out.println("*-------* MENU DE ATENDIMENTOS *-------* ");
        System.out.println("1 - MÉDICOS");
        System.out.println("2 - REGISTRO DO PACIENTE");
        System.out.println("3 - ATENDIMENTO DO PACIENTE");
        System.out.println("4 - REALIZAR EXAME");
        System.out.println("5 - LISTAS DE ATENDIMENTO");
        System.out.println("*--------------------------------------* ");
        System.out.print("Selecione: ");
    }
    
    
     /**
    * Método para registrar médico
    * 
    * @param nome String - nome do médico para registrar
    * @param crm int - crm do médico
    * @param lista_medicos Lista - lista de médicos
    *	
    * @return lista_medicos Lista          
    */
    public Lista registrarMedico(String nome,int crm, Lista lista_medicos){
        Medico elemento;
        int crm_buscar = 0, i = 0;
        while(crm_buscar != crm){
            elemento = (Medico) lista_medicos.get(i);
            crm_buscar = elemento.getCrm();
            i++;
            System.out.println("MÉDICO JÁ REGISTRADO!!");
            return lista_medicos;
        }     
        Medico medico = new Medico(nome,crm);                   //cria objeto
        lista_medicos.insert(medico);                           //insere o médico
        return lista_medicos;             
    } 
    
    
     /**
    * Método para registrar pacientes
    * 
    * @param nome String - nome do paciente
    * @param matricula int - matricula do paciente
    * @param opcao int - opcao de menu
    * @param lista_pacientes Lista - lista de pacientes
    * @param lista_medicos Lista - lista de médicos
    *	
    * @return lista_pacientes Lista
    */
    public Lista registrarPaciente(String nome, int matricula, int opcao, Lista lista_pacientes, Lista lista_medicos){  
        Paciente paciente = new Paciente(nome,matricula);       //cria o objeto paciente
        lista_pacientes.insert(paciente);                       //adiciona o paciente numa lista geral de pacientes
        
        Fila fila_espera = null;
        if(opcao == 1){                                         //se for prioritário
            paciente.alterar_prioridade();                      //altera a prioridade para true

            int posicao = buscarMedicoFilaMenor(paciente, lista_medicos);           //posicao do medico com menor fila
            
            Medico medico = (Medico) lista_medicos.get(posicao);            //medico da posicao
            fila_espera = medico.getFilaEspera();                     //fila de espera do medico
                     
            this.inserirPrioritario(paciente, fila_espera);
           
           
        }else if(opcao == 2){                                       //inserir paciente sem prioridade
                
            int posicao = buscarMedicoFilaMenor(paciente, lista_medicos);           //posicao do medico com menor fila
            
            Medico medico = (Medico) lista_medicos.get(posicao);            //medico da posicao
            fila_espera = medico.getFilaEspera();                     //fila de espera do medico
            
            fila_espera.insert(paciente);                    //adiciona normalmente
               medico.setFilaEspera(fila_espera);               //atualiza a fila do medico
        }
        
        return lista_pacientes;
} 
   
    
    /**
    * Método para inserir prioritário
    * 
    * @param paciente Paciente - objeto paciente
    * @param lista_paciente Lista - lista de médicos         
    */
    public void inserirPrioritario(Paciente paciente, Fila lista_paciente){
        if(lista_paciente.size()>0){
            for(int i = 0; i<lista_paciente.size(); i++){
                LinkFila paciente_aux =  lista_paciente.getLink(i);       //atual
                LinkFila paciente_aux_prox = lista_paciente.getLink(i+1);        //proximo 
                if(paciente_aux.getElemento().getPrioridade() == true){               
                    if(paciente_aux.getElemento().getPrioridade() == true && paciente_aux_prox.getElemento().getPrioridade() == false ){
                        LinkFila no_paciente = new LinkFila(paciente);

                        no_paciente.setProximo(paciente_aux_prox);
                        paciente_aux.setProximo(no_paciente);
                }
                } 
                else if (i == 0 && paciente_aux.getElemento().getPrioridade() == false){   //
                    LinkFila aux = lista_paciente.getFirst();
                    LinkFila no_paciente = new LinkFila(paciente);
                    
                    no_paciente.setProximo(aux);
                    lista_paciente.setFirst(no_paciente);                   
                }
                
        }
    }
        else{
            lista_paciente.insert(paciente);
        }
    
    }
    
    
    
    
     /**
    * Método para buscar fila de espera menor
    * 
    * @param paciente Paciente - objeto paciente
    * @param lista_medicos Lista - lista de médicos
    *	
    * @return posição int          
    */
    public int buscarMedicoFilaMenor(Paciente paciente, Lista lista_medicos){
        int menor = 0;
        int posicao = 0;
        
        Medico medico0 = (Medico) lista_medicos.get(0);
        Fila fila_medico0 = medico0.getFilaEspera();
        int menor_first = fila_medico0.size();                    //tamanho do primeiro médico 
        
        for(int i=0;i<lista_medicos.size();i++){
            Medico medico_buscar = (Medico) lista_medicos.get(i);
            Fila fila_medico_buscar = medico_buscar.getFilaEspera();
            int tamanho_fila_buscar = fila_medico_buscar.size();
            if (tamanho_fila_buscar > menor_first){
                menor = menor_first;
                posicao = 0;
            }
            else{
                menor = tamanho_fila_buscar;
                posicao = i;
            }
        }
        return posicao;        
    }      
    

     /**
    * Método para lista fila de pacientes por médicos
    * 
    * @param lista_medicos Lista - lista de médicos
    * @param crm_buscar int - crm para buscar         
    */
    public void listarFilaPacientes(Lista lista_medicos, int crm_buscar){
        Medico elemento;                                                   //elemento auxiliar
        Medico medico_encontrado;                                          //medico encontrado ao fazer a busca
        Paciente paciente_encontrado;
        int posicao = 0;

        for(int i = 0; i<lista_medicos.size(); i++){
            elemento = (Medico) lista_medicos.get(i);
            if (elemento.getCrm() == crm_buscar){                       //encontrado o médico pelo crm
                posicao = i;                                            //guardando o indice da lista de medicos
                break;
            }     
            else
                return;
        }
        medico_encontrado = (Medico) lista_medicos.get(posicao);        //medico encontrado
        for(int j = 0; j< medico_encontrado.quantidade_pacientes(); j++){
            paciente_encontrado = (Paciente) medico_encontrado.lista_atendidos.get(j);      //armazena a lista de atendidos
            System.out.printf("Nome: %s", paciente_encontrado.getNome());
            System.out.printf("Matricula: %d",paciente_encontrado.getMatricula());
        }
    }
    
    
     /**
    * Método para listar nome de exames
    * 
    * @param lista_exames Lista - lista de exames          
    */
    public void listarExames(Lista lista_exames){               //listagem do nome dos exames
         for(int i = 0; i<lista_exames.size(); i++){
            Exame aux = (Exame) lista_exames.get(i);            //armazena o indice do exame
            String nomeExame = aux.getTipo_exame();             //guarda o nome do exame do indice

            System.out.printf("%d - %s\n",i,nomeExame);         //printa os nomes dos exames
        }
        System.out.println("*----------------------------*"); 
    }
    
    
     /**
    * Método para listar os pacientes de cada exame
    * 
    * @param lista_exames Lista - lista de exames
    * @param opcao int - opcao do menu         
    */
    public void listarPacientesExame (Lista lista_exames, int opcao){       //pacientes por exame
        Exame aux = (Exame) lista_exames.get(opcao);            //seleciona o exame por indice
        Lista atendidos = aux.getAtendimentos();                //armazena a lista de atendimento de pacientes
        if(lista_exames.isEmpty()){
            System.out.println("SEM PACIENTES!!!\n");
        } 
        else{
            System.out.printf("Quantidade de pessoas: %d\n",aux.getQuantidade_pessoas());

            for(int i = 0; i<aux.getQuantidade_pessoas();i++){
                Paciente lista_atendidos =  (Paciente) atendidos.get(i);        //buscar os pacientes por indice
                String nome = lista_atendidos.getNome();
                int matricula = lista_atendidos.getMatricula();
                System.out.printf("PACIENTE %d = %s - %d\n",i,nome,matricula);                  //printa o nome do paciente
            }
        }
    }
    
    
     /**
    * Método para listar os pacientes do médico  
    * 
    * @param lista_medicos Lista - lista de médicos
    * @param crm_buscar int - crm do médico para buscar          
    */
    public void listarPacientesMedicos(Lista lista_medicos, int crm_buscar){               //listagem de pacientes por medicos
        int id = 0;
                                
        for(int i = 0; i<lista_medicos.size(); i++){
            Medico temp = (Medico) lista_medicos.get(i);            //buscar o medico pelo indice
            if(temp.getCrm() == crm_buscar){                        //caso o crm buscado seja igual ao da lista
                id = i;                                             //id salva o indice do médico
                break;
            }
        }

        Lista lista_atendidos_medico = (Lista) lista_medicos.get(id);       //acesa o médico pelo id
        
        if(!lista_atendidos_medico.isEmpty()){
        for (int i = 0; i<lista_atendidos_medico.size(); i++){
            Paciente paciente_atendido = (Paciente) lista_atendidos_medico.get(i);              //acessa o paciente da lista de atendidos
            System.out.println(paciente_atendido.getNome()); 
        }

        }else{
            System.out.println("SEM PACIENTES!!!\n");
        }
                                
    }
    
    
    /**
    * Método para listar exame de cada paciente
    * 
    * @param lista_pacientes Lista - lista de pacientes
    * @param matricula int - matricula para buscar        
    */
    public void listarExamePaciente(Lista lista_pacientes, int matricula){                  //exame por paciente
        int indice = 0;

        if(!lista_pacientes.isEmpty()){
            for (int i = 0; i<lista_pacientes.size(); i++){
                Paciente paciente_buscar = (Paciente) lista_pacientes.get(i);        //busca por indice do paciente na lista
                int matricula_buscar = paciente_buscar.getMatricula();               
                if (matricula_buscar == matricula){                                  //se a matricula que quer buscar é igual a matricula da lista 
                    indice = i;                                                      //indice do paciente;
                    break;
                }
            }

            Paciente paciente_buscado = (Paciente) lista_pacientes.get(indice);     //armazena o paciente
            Lista paciente_exames = paciente_buscado.getExames_passados();          //busca o exame do paciente

            if(paciente_exames.isEmpty()){
                System.out.printf("EXAMES DO PACIENTE %d:\n",matricula);    
                for(int i = 0;i<paciente_exames.size();i++){
                    Exame exame_passado = (Exame) paciente_exames.get(i);                 //percorre a lista de exames do paciente
                    String nome_exame = exame_passado.getTipo_exame();                    //procura o nome do exame 
                    System.out.printf("%s\n",nome_exame);   
                }

                }else{
                 System.out.println("SEM EXAMES PARA ESSE PACIENTE!!!\n");
                }
    }else{
         System.out.println("LISTA DE PACIENTES VAZIA!!\n");   
        }
     
    }    
    
    
    /**
    * Método para listar fila de pacientes esperando por atendimento
    * 
    * @param lista_medicos Lista - lista de médicos
    * @param crm int - crm do médico para buscar          
    */
    public void listarPacientesEsperando(Lista lista_medicos, int crm){               //pacientes esperando de determinado médico
        int id = 0;                                                 //guarda a posição do médico
        Medico medico_buscado = null;
       
        for(int i=0;i<lista_medicos.size();i++){
            medico_buscado = (Medico) lista_medicos.get(i);          //armazena o médico
            if(medico_buscado.getCrm() == crm){                      //buscar o médico por crm
                id = i;                                             //guarda a posição do médico na lista geral
                break;
            }
        }
        
        Fila pacientes_esperando = (Fila)medico_buscado.getFilaEspera();        //fila do médico
        
        if(!pacientes_esperando.isEmpty()){
            System.out.println("\nPACIENTES NA FILA DE ESPERA: ");
            for(int j = 0; j<pacientes_esperando.size();j++){
                Paciente paciente = pacientes_esperando.get(j);
                System.out.printf("PACIENTE: %d\n",j+1);
                System.out.printf("Nome:%s \n",paciente.getNome());
                System.out.printf("Matricula: %d\n\n",paciente.getMatricula());
            }    
        }
        else{
            System.out.println("SEM PACIENTES NA LISTA DE ESPERA!!!");
        }
    }
   
}