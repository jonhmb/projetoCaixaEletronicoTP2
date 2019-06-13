/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visão;

import SingletonPattern.Sessao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonhm
 */
public class TelaLogin extends javax.swing.JFrame {
  
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAcessar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jButtonSair1 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabelAutor1 = new javax.swing.JLabel();
        jLabelAutor2 = new javax.swing.JLabel();
        jLabelFundoTelaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonAcessar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAcessar.setText("Acessar");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(40, 290, 120, 50);

        jButtonCadastrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(40, 40, 150, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 120, 100, 50);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(40, 180, 100, 50);

        jButtonSair1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSair1.setText("Sair");
        jButtonSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSair1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair1);
        jButtonSair1.setBounds(180, 290, 120, 50);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(140, 130, 160, 30);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(140, 190, 160, 30);

        jLabelAutor1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAutor1.setText("Jonathan Marchetti");
        getContentPane().add(jLabelAutor1);
        jLabelAutor1.setBounds(640, 370, 180, 14);

        jLabelAutor2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAutor2.setText("Tainah Carrion  v8.0");
        getContentPane().add(jLabelAutor2);
        jLabelAutor2.setBounds(640, 390, 150, 14);

        jLabelFundoTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FundoLogin.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoTelaLogin);
        jLabelFundoTelaLogin.setBounds(0, 0, 750, 407);

        setSize(new java.awt.Dimension(766, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
        
        
       
        
        
        try {
            
                      Class.forName("com.mysql.jdbc.Driver");
                       Connection con = null; 
                            PreparedStatement pstmt = null; 
                      
                      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcaixaeletronico", "root", "");
                      
                      Statement stm = con.createStatement(); 
                      
                      //Aqui fica a consulta
                      String sql = "select * from conta where login = '"+txtUsuario.getText()+"' and senha like '"+txtSenha.getText()+"'";
                      
                      //Aqui fica a execução da consulta
                      ResultSet rs = stm.executeQuery(sql);
                      
     
                      //Esse NEXT quer dizer que a consulta é verdadeira, então se houver um NEXT, dá para entrar    
                      if (rs.next()) {
                          String nomeUsuario = rs.getString("nome");
                          Float saldoUsuario = rs.getFloat("saldo");
                          int idUsuario = rs.getInt("id_conta");
                          
                          Sessao sessao = Sessao.getSessao();
                          
                          sessao.setNome(String.valueOf(nomeUsuario));
                          sessao.setSaldo(saldoUsuario);
                          sessao.setId(idUsuario);
                          
                          TelaPrincipal tela = new TelaPrincipal();
                          //JOptionPane.showMessageDialog(null, "Sucesso");
                          tela.setVisible(true);        
                          dispose();
                          
     
                      } else {
                      JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");                       
                      }

                  } 
                  catch (ClassNotFoundException | SQLException | HeadlessException e) {
                      JOptionPane.showConfirmDialog(null, e);
                  }
        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed

        TelaCadastrar tela = new TelaCadastrar();
        tela.setVisible(true);
        dispose(); 
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSair1ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSair1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonSair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAutor1;
    private javax.swing.JLabel jLabelAutor2;
    private javax.swing.JLabel jLabelFundoTelaLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
