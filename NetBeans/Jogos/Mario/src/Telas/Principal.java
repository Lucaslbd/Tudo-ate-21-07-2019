package Telas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {
    
    private Random cor =  new Random();
    private JPanel[] quadrados = new JPanel[26];   
    private JPanel tiro = new JPanel();

    public Principal() {
        initComponents();
        teclado();
        criaQuadrado();
    }

    private void teclado() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //JOptionPane.showMessageDialog(rootPane, e.getKeyCode());
                if (e.getKeyCode() == 39 && personagem.getBounds().getX() < jPanel1.getWidth() - personagem.getWidth()) {//Direita
                    personagem.setBounds(personagem.getBounds().x + 5, personagem.getBounds().y, personagem.getBounds().width, personagem.getBounds().height);
                } else if (e.getKeyCode() == 37 && personagem.getBounds().getX() > 0) {
                    personagem.setBounds(personagem.getBounds().x - 5, personagem.getBounds().y, personagem.getBounds().width, personagem.getBounds().height);
                }else if(e.getKeyCode() == 32){
                    atirar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    
    private void atirar(){
        tiro.setBackground(Color.BLACK);
        tiro.setBounds((personagem.getBounds().x + personagem.getWidth() / 2) -2,personagem.getBounds().y - 10, 5, 5);
        jPanel1.add(tiro);       
    }

    private void criaQuadrado() {
        JPanel primeiro = new JPanel();
        primeiro.setBounds(10, 10, 20, 20);
        primeiro.setBackground(new Color(cor.nextInt(255),cor.nextInt(255),cor.nextInt(255)));
        jPanel1.add(primeiro);
        quadrados[0] = primeiro;
        for (int i = 1; i < quadrados.length; i++) {
            JPanel quadrado = new JPanel();
            quadrado.setBounds(quadrados[i - 1].getBounds().x + quadrados[i -1].getWidth() + 7, 10, 20, 20);
            quadrado.setBackground(new Color(cor.nextInt(255),cor.nextInt(255),cor.nextInt(255)));
            jPanel1.add(quadrado);
            quadrados[i] = quadrado;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        personagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        personagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/nave.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(personagem)
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(332, Short.MAX_VALUE)
                .addComponent(personagem)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel personagem;
    // End of variables declaration//GEN-END:variables
}
