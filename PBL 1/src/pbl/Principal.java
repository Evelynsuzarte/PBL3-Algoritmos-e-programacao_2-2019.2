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
  * Classe principal onde o usuário insere os dados
  * 
  * @author	Evelyn Suzarte Fernandes
  * @version	1.0 
  * @since	1.0  
  */


public class Principal {
   
    public static void main (String args []){
    
    
    //criação de lista encadeada
    Lista lista_medicos = new Lista();
    Lista lista_pacientes = new Lista();
    Lista lista_exames = new Lista();
    Lista lista_geral = new Lista();
    
    //variaveis básicas
    int crm,matricula,opcao;
    String nome;
    
    
    //variavel para entrada de dados
    Scanner ler = new Scanner(System.in);               //entrada de dados
 
    //variaveis de controle
    ControlePaciente menus_paciente = new ControlePaciente() ;
    ControleMedico menus_medico = new ControleMedico();
    ControleAtendimento menus_atendimento = new ControleAtendimento();
    
 
    //opcões de exame
    Exame exame1 = new Exame("Hemograma");              
    Exame exame2 = new Exame("Raio X");
    Exame exame3 = new Exame("Ultrassonografia");
    Exame exame4 = new Exame("Beta HCG");
    //inserção de exames na lista de exames
    lista_exames.insert(exame1);
    lista_exames.insert(exame2);
    lista_exames.insert(exame3);
    lista_exames.insert(exame4);
    
    
    //médicos pré cadastrados
    Medico medico1 = new Medico("Mirela Costa",11111);
    Medico medico2 = new Medico("Carlos Lima",22222);
    //inserção de médicos na lista de médicos
    lista_medicos.insert(medico1);
    lista_medicos.insert(medico2);    
    
    
    boolean repeat = true;
    while(repeat == true){   
           menus_atendimento.exibirMenu();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:                                                 //menu para registrar ou editar o médico
                    menus_medico.menuMedicos();
                    opcao = ler.nextInt();  
                    
                    if (opcao == 1){                                    //menu para registrar médico
                       
                        boolean repetir = true;
                        while (repetir == true){
                                ler.nextLine();
                                System.out.println("\n");
                                System.out.println("*------ REGISTRAR MÉDICO(A) ------* ");
                                System.out.print("Nome do médico(a): ");       
                                nome = ler.nextLine();
                                
                                System.out.print("CRM: ");
                                crm = ler.nextInt();

                                
                                lista_medicos = menus_atendimento.registrarMedico(nome, crm, lista_medicos);
                                menus_medico.perguntaRegistrarMedicos();

                                opcao = ler.nextInt();
                                
                                if (opcao == 1){                        // se sim, registra mais medicos
                                    repetir = true;                     // a opcao  é repetida
                                }
                                else if (opcao == 2){                   //se nao,vai ao menu principal
                                   repeat = true;
                                   repetir = false;
                                }
                        }                  
                    }
                    else if (opcao == 2){                               //menu para alterar medico
                        boolean repetir = true;
                        while (repetir == true){   
                                ler.nextLine();
                                System.out.println("\n");
                                System.out.println("*------ EDITAR MÉDICO(A) ------* ");
                                System.out.print("CRM que deseja buscar: ");
                                crm = ler.nextInt();
                                System.out.printf("Novo nome para o CRM %d: ",crm);       
                                nome = ler.nextLine();

                                menus_medico.editarMedico(crm, nome, lista_medicos);
                                                               
                                menus_medico.perguntaAlterarmedico();
                                opcao = ler.nextInt();

                                if (opcao == 1){                        // editar outro médico
                                   repetir = true;
                                }   
                                else if (opcao == 2){                   //retornar ao menu principal
                                   repeat = true;
                                   repetir = false;
                                }     
                        }
                    }
                    else if (opcao == 3){                               //opção para listar nome dos médicos
                        ler.nextLine();
                        System.out.println("\n");
                        System.out.println("*------ LISTAR MÉDICOS(A) ------* ");
                        menus_medico.listarMedicos(lista_medicos);
                        
                        System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                        opcao = ler.nextInt();
                        if (opcao == 0)
                            repeat = true;  
                        
                    }
                    break;
                case 2:                                             //opção para registrar paciente
                    boolean repetir = true;
                    while (repetir == true){     
                        ler.nextLine();
                        System.out.println("\n");
                        System.out.println("*------ REGISTRO DO PACIENTE ------* ");
                        System.out.print("Nome: ");
                        nome = ler.nextLine();
                        System.out.print("Matricula:");       
                        matricula = ler.nextInt();
                        System.out.print("Paciente de prioridade:\n1 - Sim\n2 - Não\n*---------------------*\nSelecione: ");
                        opcao = ler.nextInt();

                        lista_pacientes = menus_atendimento.registrarPaciente(nome, matricula, opcao, lista_pacientes, lista_medicos);
                                                      
                        menus_paciente.perguntaRegistrarpacientes();
                                              
                        opcao = ler.nextInt();
                       if (opcao == 1){
                           repetir = true;
                        }
                        else if (opcao == 2){
                           repeat = true;
                           repetir = false;
                        }       
                    }
                    break;
                case 3:                           
                        ler.nextLine();                                     //opção de atendimento ao paciente
                        System.out.println("\n");
                        System.out.println("*----- ATENDIMENTO DO PACIENTE ------*");
                        System.out.println("Medico CRM: ");
                        crm = ler.nextInt();                

                        menus_atendimento.realizarAtendimento(lista_pacientes, lista_medicos, crm, lista_exames, lista_geral);

                        System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                        opcao = ler.nextInt();
                        if (opcao == 0)
                            repeat = true;        
                    break;
                case 4:
                        System.out.println("\n");
                        System.out.println("*----- REALIZAR EXAMES ------*");
                        
                        System.out.println("ESTA OPÇÃO NÃO ESTÁ FUNCIONANDO NO MOMENTO...");
                        
                        System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                        opcao = ler.nextInt();
                        if (opcao == 0)
                            repeat = true;                      
                    break;
                case 5:
                        System.out.println("\n");
                        System.out.println("*----- LISTAS DE ATENDIMENTO ------*");
                        System.out.println("1 - POR EXAME");
                        System.out.println("2 - POR MÉDICO");
                        System.out.println("3 - POR PACIENTE");
                        System.out.println("4 - POR MEDICO - LISTA DE ESPERA");
                        System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
                        System.out.println("*----------------------------------*");
                        System.out.print("Selecione:");
                        opcao = ler.nextInt();
                        
                        switch(opcao){
                            case 1:
                                System.out.println("\n");
                                System.out.println("*----- LISTA POR EXAME ------*"); 
                               
                                System.out.println("SELECIONE O EXAME:");
                                menus_atendimento.listarExames(lista_exames);
                                        
                                System.out.println("\nSelecione: ");
                                opcao = ler.nextInt();                                  //seleção do exame 
                                
                                menus_atendimento.listarPacientesExame(lista_exames, opcao);
                                
                                System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                                opcao = ler.nextInt();
                                if (opcao == 0)
                                    repeat = true;
                        
                             break;
                            case 2:
                                System.out.println("\n");
                                System.out.println("*----- LISTA POR MÉDICO ------*");      
                               
                                System.out.println("DIGITE O CRM; ");
                                int crm_buscar = ler.nextInt();
                                
                                menus_atendimento.listarPacientesMedicos(lista_medicos, crm_buscar);
                                
                                System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                                opcao = ler.nextInt();
                                if (opcao == 0)
                                    repeat = true;                                
                                
                                
                                break;
                            case 3:
                                System.out.println("\n");
                                System.out.println("*----- LISTA POR PACIENTE ------*");  
                                System.out.println("DIGITE A MATRÍCULA DO PACIENTE: ");  
                                matricula = ler.nextInt();                              //paciente para ser buscado
                                
                                menus_atendimento.listarExamePaciente(lista_pacientes, matricula);
                                
                                System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                                opcao = ler.nextInt();
                                if (opcao == 0)
                                    repeat = true;  
                                
                                break;   
                                
                            case 4:
                                System.out.println("\n");
                                System.out.println("*----- LISTA POR MÉDICO = LISTA DE ESPERA ------*"); 
                                System.out.println("Medico CRM: ");
                                crm = ler.nextInt(); 
                                menus_atendimento.listarPacientesEsperando(lista_medicos,crm);
                                
                                System.out.println("VOLTAR AO MENU PRINCIPAL\nDIGITE 0: "); 
                                opcao = ler.nextInt();
                                if (opcao == 0)
                                    repeat = true;  
                             }
                                                         
                    break;
                }
    } 
    }
            
} //model

