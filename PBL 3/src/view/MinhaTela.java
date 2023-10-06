/*****************************************************************************************
 * PROBLEMA 3
 * Autora: Evelyn Suzarte Fernandes
 * Componente Curricular: MI-Programação - 2019.2
 * Concluido em: 22/03/2020
 * Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 * trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 * apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 * de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 * do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ******************************************************************************************/

package view;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import model.Grafo;
import model.Vertice;

/** Classe que cria a tela de interface 
 *
 * @author Evelyn Suzarte
 */
public class MinhaTela extends javax.swing.JFrame {

    
    public MinhaTela() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        calcularDistancia = new javax.swing.JButton();
        apreConexoes = new javax.swing.JButton();
        menorCaminho = new javax.swing.JButton();
        expConfig = new javax.swing.JButton();
        impConfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menorCaminhoEntreDois = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexões de terminais");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(350, 50));
        setMaximumSize(new java.awt.Dimension(650, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 500));

        menu.setBackground(new java.awt.Color(102, 0, 51));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setText("CONEXÃO DE TERMINAIS");

        adicionar.setBackground(new java.awt.Color(204, 0, 51));
        adicionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adicionar.setText("ADICIONAR");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        remover.setBackground(new java.awt.Color(204, 0, 51));
        remover.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        remover.setText("REMOVER");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        calcularDistancia.setBackground(new java.awt.Color(204, 0, 51));
        calcularDistancia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        calcularDistancia.setText("CALCULAR DISTANCIA");
        calcularDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularDistanciaActionPerformed(evt);
            }
        });

        apreConexoes.setBackground(new java.awt.Color(204, 0, 51));
        apreConexoes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        apreConexoes.setText("APRESENTAR CONEXÕES");
        apreConexoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apreConexoesActionPerformed(evt);
            }
        });

        menorCaminho.setBackground(new java.awt.Color(204, 0, 51));
        menorCaminho.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menorCaminho.setText("MENOR CAMINHO");
        menorCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menorCaminhoActionPerformed(evt);
            }
        });

        expConfig.setBackground(new java.awt.Color(204, 0, 51));
        expConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        expConfig.setText("EXPORTAR CONFIGURAÇÕES");
        expConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expConfigActionPerformed(evt);
            }
        });

        impConfig.setBackground(new java.awt.Color(204, 0, 51));
        impConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        impConfig.setText("IMPORTAR CONFIGURAÇÕES");
        impConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impConfigActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Evelyn Suzarte\\Documents\\NetBeansProjects\\PBL 3\\icon roteador.png")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Evelyn Suzarte\\Documents\\NetBeansProjects\\PBL 3\\icon terminal.png")); // NOI18N

        menorCaminhoEntreDois.setBackground(new java.awt.Color(204, 0, 51));
        menorCaminhoEntreDois.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menorCaminhoEntreDois.setText("MENOR CAMINHO ENTRE DOIS");
        menorCaminhoEntreDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menorCaminhoEntreDoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(expConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menorCaminho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calcularDistancia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(59, 59, 59)
                            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(menorCaminhoEntreDois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(impConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(apreConexoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(47, 47, 47))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(92, 92, 92)))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(remover))
                .addGap(18, 18, 18)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcularDistancia)
                    .addComponent(apreConexoes))
                .addGap(18, 18, 18)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menorCaminho)
                    .addComponent(menorCaminhoEntreDois))
                .addGap(18, 18, 18)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expConfig)
                    .addComponent(impConfig))
                .addGap(40, 40, 40)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        // BOTÃO ADICIONAR
        
        int resp = JOptionPane.showConfirmDialog(null, "O DESTINO É TERMINAL? ");                       //variável para armazenar opção
        switch(resp){
            case JOptionPane.YES_OPTION:
            terminal_conex = true;
            break;
            case JOptionPane.NO_OPTION:
            terminal_conex = false;
            break;

        }
    
        inicio_conex = JOptionPane.showInputDialog("INÍCIO:");                                         
        destino_conex = JOptionPane.showInputDialog("DESTINO:");
        String peso_aux = JOptionPane.showInputDialog("PESO:"); 
        
        peso_conex = Integer.parseInt(peso_aux);        
        controller.Controller.add_conexao(inicio_conex, terminal_conex, destino_conex, peso_conex);       
        JOptionPane.showMessageDialog(null,"CONEXÃO ADICIONADA COM SUCESSO!!");
        
    
    }//GEN-LAST:event_adicionarActionPerformed

    private void apreConexoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apreConexoesActionPerformed
        // BOTÃO APRESENTAR CONEXÕES
       
        DesenharGrafo d = new DesenharGrafo();                                 
        JFrame conexoes = new JFrame("Apresentar conexões");
        conexoes.setSize(1200,900);
        conexoes.setLocationRelativeTo(null);
        conexoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        conexoes.setVisible(true);
        conexoes.add(d);  
    }//GEN-LAST:event_apreConexoesActionPerformed

    private void expConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expConfigActionPerformed
        // BOTÃO EXPORTAR CONFIGURAÇÕES
        
        try {           
            JFileChooser file = new JFileChooser();
            JTextField texto = new JTextField();
            File arquivo;
            
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int i=file.showSaveDialog(null);
            
            if (i==1){
                texto.setText("");
            } else {
                arquivo = file.getSelectedFile();
                texto.setText(arquivo.getPath());
            }
         
            controller.Controller.exportar_arquivo(texto.getText());
        } catch (IOException ex) {
            Logger.getLogger(MinhaTela.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_expConfigActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        // BOTÃO REMOVER
        
        ponto_remover = JOptionPane.showInputDialog("PONTO PARA REMOVER:");
        
        if (controller.Controller.buscarVertice(ponto_remover) != null || 
                controller.Controller.buscarVertice(ponto_remover).getNome().equals(ponto_remover)) {
            controller.Controller.remover_conexao(this.ponto_remover);
            JOptionPane.showMessageDialog(null,"PONTO REMOVIDO COM SUCESSO!!");
        }else if(controller.Controller.buscarVertice(ponto_remover) == null|| 
                !controller.Controller.buscarVertice(ponto_remover).getNome().equals(ponto_remover)) 
            JOptionPane.showMessageDialog(null,"NÃO FOI POSSÍVEL REMOVER PONTO!!");    
     
    }//GEN-LAST:event_removerActionPerformed

    
    private void impConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impConfigActionPerformed
        //BOTÃO IMPORTAR CONFIGURAÇÕES
        
        JFileChooser janela = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        File caminho;
        int verificacao = janela.showOpenDialog(null);		
        if (verificacao == JFileChooser.APPROVE_OPTION) {
                caminho = janela.getSelectedFile();
                controller.Controller.importar_arquivo(caminho);
                  
        }      
    }//GEN-LAST:event_impConfigActionPerformed

    private void calcularDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularDistanciaActionPerformed
        // BOTÃO CALCULAR DISTANCIA
       JOptionPane.showMessageDialog(null,"FUNÇÃO NÃO DISPONÍVEL NO MOMENTO!");
   
    }//GEN-LAST:event_calcularDistanciaActionPerformed

    private void menorCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menorCaminhoActionPerformed
        // MENOR CAMINHO

        DesenharGrafo d = new DesenharGrafo();   
        JFrame menor2 = new JFrame("Menor caminho entre dois");
        menor2.setSize(1200,900);
        menor2.setBackground(Color.pink);
        menor2.setLocationRelativeTo(null);
        menor2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menor2.setVisible(true);      
        menor2.add(d);
       
        String ponto = JOptionPane.showInputDialog("DIGITE O NOME DE UM PONTO:");
        
        ArrayList<ArrayList<Vertice>> menoresCaminhos = controller.Controller.menorCaminhoTodos(ponto);
        Grafo g = controller.Controller.getGrafo();
        
        String r = "Caminho de " + ponto + " para: \n";                     //concatena titulo
        String x = "";                                                      //variavel auxiliar
        for (int i = 0; i < menoresCaminhos.size(); i++) {                  //loop de acordo com a quantidade de itens da lista 
            for (int j = 0; j < menoresCaminhos.get(i).size(); j++) {       //loop de acordo com a quantidade de itens da lista da lista
                x = x + menoresCaminhos.get(i).get(j).getNome()+ " ";       //concatenação do nome do vértice que formam o menor caminho
                
            }
            r = r + g.getVertices().get(i).getNome() + " - " + x +"\n" ;    //concatenação da msg título + nome da vertice + menor camino
            x = "";                                                         //limpa variável x
        }
        
        JOptionPane.showMessageDialog(null, r); 
    }//GEN-LAST:event_menorCaminhoActionPerformed

    private void menorCaminhoEntreDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menorCaminhoEntreDoisActionPerformed
        //MENOR CAMINHO ENTRE DOIS PONTOS
        
        DesenharGrafo d = new DesenharGrafo();   
        JFrame menor2 = new JFrame("Menor caminho entre dois");
        menor2.setSize(1200,900);
        menor2.setBackground(Color.pink);
        menor2.setLocationRelativeTo(null);
        menor2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menor2.setVisible(true);      
        menor2.add(d);
        
        
        String ponto = JOptionPane.showInputDialog("DIGITE O NOME DA ORIGEM");
        String ponto2 = JOptionPane.showInputDialog("DIGITE O NOME DO DESTINO");
        
        ArrayList<Vertice> menorC = controller.Controller.menorCaminho(controller.Controller.buscarVertice(ponto), 
                                                                controller.Controller.buscarVertice(ponto2));
        
        menor2.setVisible(false);
        DesenharGrafo d2 = new DesenharGrafo(menorC);
        JFrame menorExibir = new JFrame("Menor caminho entre dois");
        menorExibir.setSize(1200,900);
        menorExibir.setBackground(Color.pink);
        menorExibir.setLocationRelativeTo(null);
        menorExibir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menorExibir.setVisible(true);      
        menorExibir.add(d2);
 
    }//GEN-LAST:event_menorCaminhoEntreDoisActionPerformed

    

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MinhaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton apreConexoes;
    private javax.swing.JButton calcularDistancia;
    private javax.swing.JButton expConfig;
    private javax.swing.JButton impConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton menorCaminho;
    private javax.swing.JButton menorCaminhoEntreDois;
    private javax.swing.JPanel menu;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables

    public boolean terminal_conex;
    public int peso_conex;
    public String inicio_conex;
    public String destino_conex;
    public String ponto_remover;
 
    
   
}


