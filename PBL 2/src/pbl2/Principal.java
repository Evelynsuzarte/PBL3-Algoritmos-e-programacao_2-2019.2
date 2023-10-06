/****************************************************************************************
 * PROBLEMA 2
 * Autora: Evelyn Suzarte Fernandes
 * Componente Curricular: MI-Programação - 2019.2
 * Concluido em: 04/01/2020
 * Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 * trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 * apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 * de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 * do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ***************************************************************************************** */

package pbl2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal do sistema
 *
 * @author	Evelyn Suzarte Fernandes
 * @version	1.0
 * @since	1.0
 */

public class Principal {
    public static void main(String[] args) throws IOException {

        boolean repete = true;                          //variavel para repetir bloco
        Scanner entrada = new Scanner(System.in);       //scanner
        int selecione, n_ebook, ano;                    //variaveis auxiliares
        String titulo, autor, mes = null, link;
        Livro livro;
        
        //o arquivo principal é lido assim que o programa abre
        System.out.println("CARREGANDO...");
        Dao.carregarDados();
        System.out.println("BASE DE DADOS CARREGADA!");
        

        while (repete == true) {                    
            System.out.println("\n>>>>>>> CATÁLOGO DE LIVROS <<<<<<<");         //menu principal
            System.out.println("1 - CADASTRAR LIVRO");
            System.out.println("2 - BUSCAR LIVRO");
            System.out.println("3 - LISTAS");
            System.out.println("4 - EXCLUIR LIVRO");
            System.out.println("5 - ENCERRAR E SALVAR PROGRAMA");
            System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
            System.out.print("Selecione: ");
            selecione = entrada.nextInt();                                      

            switch (selecione) {
                case 1:
                    System.out.println("\n>>>>>>> CADASTRAR LIVRO <<<<<<<");                  
                    n_ebook = Dao.geradorNEbook();
                    entrada.nextLine();
                    System.out.println("TÍTULO:");
                    titulo = entrada.nextLine();
                    System.out.println("AUTOR:");
                    autor = entrada.nextLine();

                    System.out.println("MES (nº de 1 a 12):");
                    selecione = entrada.nextInt();
                    if (selecione == 1) {
                        mes = "Jan";
                    } else if (selecione == 2) {
                        mes = "Fev";
                    } else if (selecione == 3) {
                        mes = "Mar";
                    } else if (selecione == 4) {
                        mes = "Abr";
                    } else if (selecione == 5) {
                        mes = "Mai";
                    } else if (selecione == 6) {
                        mes = "Jun";
                    } else if (selecione == 7) {
                        mes = "Jul";
                    } else if (selecione == 8) {
                        mes = "Ago";
                    } else if (selecione == 9) {
                        mes = "Set";
                    } else if (selecione == 10) {
                        mes = "Out";
                    } else if (selecione == 11) {
                        mes = "Nov";
                    } else if (selecione == 12) {
                        mes = "Dez";
                    }
                    System.out.println("ANO:");
                    ano = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("LINK:");
                    link = entrada.nextLine();
                    System.out.println("SALVANDO...");

                    livro = new Livro(n_ebook, titulo, autor, mes, ano, link);
                    Dao.inserir(livro, n_ebook);

                    System.out.println("LIVRO SALVO COM SUCESSO!!\n\n");
                    repete = true;
                    break;
                case 2:
                    System.out.println("\n>>>>>>> BUSCAR LIVRO <<<<<<<");
                    System.out.println("1 - BUSCAR LIVRO");
                    System.out.println("2 - BUSCAR LIVRO / ANO ");
                    System.out.println("3 - MENU PRINCIPAL ");
                    System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<");
                    System.out.print("Selecione: ");

                    selecione = entrada.nextInt();
                    switch (selecione) {
                        case 1:
                            System.out.println("\n>>>>>>> BUSCAR LIVRO <<<<<<<");
                            System.out.println("Nº DO EBOOK:");
                            n_ebook = entrada.nextInt();

                            Dao.buscarLivro_nEbook(n_ebook);
                            entrada.nextLine();
                            repete = true;
                            break;
                        case 2:
                            System.out.println("\n>>>>>>> BUSCAR LIVRO / ANO <<<<<<<");
                            System.out.println("ANO:");
                            ano = entrada.nextInt();

                            Dao.buscarLivro_ano(ano);
                            repete = true;
                            break;
                        case 3:
                            repete = true;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\n>>>>>>>>>>> LISTAS <<<<<<<<<<");
                    System.out.println("1 - LISTAR AUTORES / QUANTIDADE");
                    System.out.println("2 - LISTAR AUTOR / LIVROS");
                    System.out.println("3 - LISTAR LIVROS");
                    System.out.println("4 - MENU PRINCIPAL");
                    System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<");
                    System.out.print("Selecione: ");
                    selecione = entrada.nextInt();
                    switch (selecione) {
                        case 1:
                            System.out.println("\n>>>>>>> LISTAR AUTORES / QUANTIDADE <<<<<<<");

                            Dao.listarAutoresQuantidade();
                            repete = true;
                            break;
                        case 2:
                            System.out.println("\n>>>>>>> LISTAR AUTOR / LIVROS <<<<<<<");
                            entrada.nextLine();
                            System.out.println("AUTOR: ");
                            autor = entrada.nextLine();
                            Dao.listarAutoresLivro(autor);
                            repete = true;
                            break;
                        case 3:
                            System.out.println("\n>>>>>>> LISTAR LIVROS <<<<<<<");
                            Dao.listarTodosLivros();
                            repete = true;
                            break;
                        case 4:
                            repete = true;
                            break;
                    }
                    break;
                case 4:
                    System.out.println("\n>>>>>>> EXCLUIR LIVRO <<<<<<");
                    System.out.println("Nº EBOOK:");
                    n_ebook = entrada.nextInt();
                    Dao.excluirLivro(n_ebook);
                    repete = true;
                    break;
                case 5:
                    System.out.println("\nDESEJA SAIR E GRAVAR ALTERAÇÕES?");
                    System.out.println("1 - SIM\n2 - NÃO");
                    System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<");
                    System.out.print("Selecione: ");
                    selecione = entrada.nextInt();
                    
                    if (selecione == 1) {
                        System.out.println("SALVANDO ALTERAÇÕES...");
                        Dao.gravarDados();
                        System.out.println("ENCERRADO!!");
                        System.exit(0);
                    }
                    else
                        repete = true;                
                    break;
               
            }
        }
    }

}
