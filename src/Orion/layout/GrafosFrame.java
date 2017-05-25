/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import Orion.grafo.Grafo;
import Orion.grafo.No;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public final class GrafosFrame extends javax.swing.JFrame {

    private jpMapa mapa;
    private Grafo grafo;
    private List<No> nos; //Nós que serão mandados para o grafo

    public GrafosFrame() {
        initComponents();

        mapa = new jpMapa();
        mapa.setSize(getWidth(), getHeight());
        mapa.setLocation(0, 0);
        jpPanel.add(mapa);

        carregarGrafo();
    }

    public void carregarGrafo() {

        grafo = new Grafo();
        nos = new ArrayList<>();
        //Nó -> Nome do Nö ,  index dentro do vetor;
        No MAN = new No("MAN", 0);
        No BEL = new No("BEL", 1);
        No NTL = new No("NTL", 2);
        No REC = new No("REC", 3);
        No SLV = new No("SLV", 4);
        No BSB = new No("BSB", 5);
        No CUI = new No("CUI", 6);
        No CPG = new No("CPG", 7);
        No BAU = new No("BAU", 8);
        No RBP = new No("RBP", 9);
        No CMP = new No("CMP", 10);
        No BHO = new No("BHO", 11);
        No LON = new No("LON", 12);
        No SPO = new No("SPO", 13);
        No RJO = new No("RJO", 14);
        No SJC = new No("SJC", 15);
        No CUR = new No("CUR", 16);
        No BLU = new No("BLU", 17);
        No FLO = new No("FLO", 18);
        No POA = new No("POA", 19);
        //Criar ligações // nós destino,métrica a ,b,c
        //  nA.addAresta(nB, 1);

        MAN.addAresta(BEL, 1,18,2);
        MAN.addAresta(BSB, 1,22,6);
        MAN.addAresta(CUI, 1,20,3);

        BEL.addAresta(NTL, 1,21,3);
        BEL.addAresta(MAN, 1,18,2);

        NTL.addAresta(BEL, 1,21,3);
        NTL.addAresta(REC, 1,4,3);
        NTL.addAresta(SLV, 1,15,4);
        NTL.addAresta(BSB, 1,22,7);

        REC.addAresta(NTL, 1,4,3);
        REC.addAresta(SLV, 1,8,5);

        SLV.addAresta(NTL, 1,15,4);
        SLV.addAresta(REC, 1,8,5);
        SLV.addAresta(RJO, 1,20,6);

        BSB.addAresta(MAN, 1,22,6);
        BSB.addAresta(NTL, 1,22,7);
        BSB.addAresta(BHO, 1,9,6);
        BSB.addAresta(RBP, 1,8,4);

        CUI.addAresta(MAN, 1,20,3);
        CUI.addAresta(CPG, 1,8,2);

        CPG.addAresta(CUI, 1,8,2);
        CPG.addAresta(BAU, 1,10,3);

        BAU.addAresta(CPG, 1,10,3);
        BAU.addAresta(LON, 1,3,2);
        BAU.addAresta(CMP, 1,3,6);

        RBP.addAresta(BSB, 1,8,4);
        RBP.addAresta(CMP, 1,2,4);

        CMP.addAresta(RBP, 1,2,4);
        CMP.addAresta(SJC, 1,2,10);
        CMP.addAresta(BAU, 1,3,6);
        CMP.addAresta(SPO, 1, 1, 7);

        BHO.addAresta(BSB, 1,9,6);
        BHO.addAresta(RJO, 1,7,6);
        BHO.addAresta(SJC, 1,7,8);

        LON.addAresta(BAU, 1,3,2);
        LON.addAresta(SPO, 1,7,2);
        LON.addAresta(CUR, 1,6,2);

        SPO.addAresta(LON, 1,7,2);
        SPO.addAresta(CUR, 1,5,10);
        SPO.addAresta(CMP, 1,1,7);
        SPO.addAresta(SJC, 1,2,16);
        SPO.addAresta(RJO, 1,5,15);

        RJO.addAresta(FLO, 1,12,10);
        RJO.addAresta(SPO, 1,5,15);
        RJO.addAresta(SJC, 1,3,10);
        RJO.addAresta(BHO, 1,7,6);
        RJO.addAresta(SLV, 1,20,6);

        SJC.addAresta(SPO, 1,2,16);
        SJC.addAresta(CMP, 1,2,10);
        SJC.addAresta(BHO, 1,7,8);
        SJC.addAresta(RJO, 1,3,10);

        CUR.addAresta(LON, 1,6,2);
        CUR.addAresta(SPO, 1,5,10);
        CUR.addAresta(FLO, 1,2,5);
        CUR.addAresta(BLU, 1,2,5);

        BLU.addAresta(CUR, 1,2,5);
        BLU.addAresta(FLO, 1,1,3);
        BLU.addAresta(POA, 1,7,2);

        FLO.addAresta(CUR, 1,2,5);
        FLO.addAresta(BLU, 1,1,3);
        FLO.addAresta(POA, 1,6,2);
        FLO.addAresta(RJO, 1,12,10);

        POA.addAresta(BLU, 1,7,2);
        POA.addAresta(FLO, 1,6,2);

        //Adiciona nós com suas ligações no grafo
        nos.add(MAN);
        nos.add(BEL);
        nos.add(NTL);
        nos.add(REC);
        nos.add(SLV);
        nos.add(BSB);
        nos.add(CUI);
        nos.add(CPG);
        nos.add(BAU);
        nos.add(RBP);
        nos.add(CMP);
        nos.add(BHO);
        nos.add(LON);
        nos.add(SPO);
        nos.add(RJO);
        nos.add(SJC);
        nos.add(CUR);
        nos.add(BLU);
        nos.add(FLO);
         
        grafo.updateNoList(nos);
        
        
        // Testar
        List<No> caminho = grafo.encontrarCaminho(grafo, MAN, CUR);
        mostrarCaminhos(caminho);
    }
    //Tem que recriar o grafo toda vez que desativar ou ativar um nó
    public void mostrarCaminhos(List<No> caminho)
    {
        No tmp = null;
        for(No n : caminho)
        {
            JOptionPane.showMessageDialog(null, "Nó :"+n.getNome()+"Distância Percorrida"+n.getDistancia());
            tmp = n;
        } 
        JOptionPane.showMessageDialog(null, "Total Percorrido" + tmp.getDistancia());
        
    }
    
    public void recriarGrafo() {
        for (No n : this.nos) {

        }
    }

    public jpMapa getMapa() {
        return mapa;
    }

    public void setMapa(jpMapa mapa) {
        this.mapa = mapa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtInicio = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnHoops = new javax.swing.JButton();
        btnCusto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnDesabilitar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpPanel.setBackground(new java.awt.Color(255, 153, 153));
        jpPanel.setPreferredSize(new java.awt.Dimension(0, 600));

        javax.swing.GroupLayout jpPanelLayout = new javax.swing.GroupLayout(jpPanel);
        jpPanel.setLayout(jpPanelLayout);
        jpPanelLayout.setHorizontalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPanelLayout.setVerticalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Calcular", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        jLabel3.setText("Inicio:");

        jLabel2.setText("Destino:");

        jtInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        btnHoops.setText("Hoops");
        btnHoops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoopsActionPerformed(evt);
            }
        });

        btnCusto.setText("Custo");
        btnCusto.setPreferredSize(new java.awt.Dimension(85, 29));
        btnCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustoActionPerformed(evt);
            }
        });

        jButton3.setText("Distância");
        jButton3.setPreferredSize(new java.awt.Dimension(85, 29));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(jtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHoops))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoops)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Falhas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        jLabel5.setText("Habilitados:");

        btnDesabilitar.setText("Desabilitar");
        btnDesabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesabilitarActionPerformed(evt);
            }
        });

        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        jLabel6.setText("Desabilitados:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesabilitar))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesabilitar)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHabilitar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu2.setText("Sobre");

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Versão");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustoActionPerformed

        ArrayList<Plane.Pontos> pontos = new ArrayList<>();
        pontos.add(Plane.Pontos.MAN);
        pontos.add(Plane.Pontos.CUI);
        pontos.add(Plane.Pontos.CPG);
        pontos.add(Plane.Pontos.RBP);
        pontos.add(Plane.Pontos.MAN);
        mapa.makePath(pontos);

    }//GEN-LAST:event_btnCustoActionPerformed

    private void btnHoopsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoopsActionPerformed

    }//GEN-LAST:event_btnHoopsActionPerformed

    private void btnDesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesabilitarActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHabilitarActionPerformed

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
            java.util.logging.Logger.getLogger(GrafosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCusto;
    private javax.swing.JButton btnDesabilitar;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnHoops;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpPanel;
    private javax.swing.JComboBox<String> jtInicio;
    // End of variables declaration//GEN-END:variables

}
