/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import Orion.grafo.Grafo;
import Orion.grafo.No;
import Orion.layout.Plane.Pontos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public final class GrafosFrame extends javax.swing.JFrame {

    private jpMapa mapa = null;
    private Grafo grafo = null;
    private List<No> nos = null; //Nós que serão mandados para o grafo
    //Nós
    No MAN;
    No BEL;
    No NTL;
    No REC;
    No SLV;
    No BSB;
    No CUI;
    No CPG;
    No BAU;
    No RBP;
    No CMP;
    No BHO;
    No LON;
    No SPO;
    No RJO;
    No SJC;
    No CUR;
    No BLU;
    No FLO;
    No POA;

    public GrafosFrame() {
        initComponents();

        mapa = new jpMapa();
        mapa.setSize(getWidth(), getHeight());
        mapa.setLocation(0, 0);
        jpPanel.add(mapa);

    }

    public void carregarGrafo() {
        grafo = new Grafo();
        nos = new ArrayList<>();
        //Nó -> Nome do Nö ,  index dentro do vetor;

        //Criar ligações // nós destino,métrica a ,b,c
        //  nA.addAresta(nB, 1);
        //Adiciona nós com suas ligações no grafo
        MAN = new No("MAN", 0);
        BEL = new No("BEL", 1);
        NTL = new No("NTL", 2);
        REC = new No("REC", 3);
        SLV = new No("SLV", 4);
        BSB = new No("BSB", 5);
        CUI = new No("CUI", 6);
        CPG = new No("CPG", 7);
        BAU = new No("BAU", 8);
        RBP = new No("RBP", 9);
        CMP = new No("CMP", 10);
        BHO = new No("BHO", 11);
        LON = new No("LON", 12);
        SPO = new No("SPO", 13);
        RJO = new No("RJO", 14);
        SJC = new No("SJC", 15);
        CUR = new No("CUR", 16);
        BLU = new No("BLU", 17);
        FLO = new No("FLO", 18);
        POA = new No("POA", 19);

        MAN.addAresta(BEL, 1, 18, 2);
        MAN.addAresta(BSB, 1, 22, 6);
        MAN.addAresta(CUI, 1, 20, 3);

        BEL.addAresta(NTL, 1, 21, 3);
        BEL.addAresta(MAN, 1, 18, 2);

        NTL.addAresta(BEL, 1, 21, 3);
        NTL.addAresta(REC, 1, 4, 3);
        NTL.addAresta(SLV, 1, 15, 4);
        NTL.addAresta(BSB, 1, 22, 7);

        REC.addAresta(NTL, 1, 4, 3);
        REC.addAresta(SLV, 1, 8, 5);

        SLV.addAresta(NTL, 1, 15, 4);
        SLV.addAresta(REC, 1, 8, 5);
        SLV.addAresta(RJO, 1, 20, 6);

        BSB.addAresta(MAN, 1, 22, 6);
        BSB.addAresta(NTL, 1, 22, 7);
        BSB.addAresta(BHO, 1, 9, 6);
        BSB.addAresta(RBP, 1, 8, 4);

        CUI.addAresta(MAN, 1, 20, 3);
        CUI.addAresta(CPG, 1, 8, 2);

        CPG.addAresta(CUI, 1, 8, 2);
        CPG.addAresta(BAU, 1, 10, 3);

        BAU.addAresta(CPG, 1, 10, 3);
        BAU.addAresta(LON, 1, 3, 2);
        BAU.addAresta(CMP, 1, 3, 6);

        RBP.addAresta(BSB, 1, 8, 4);
        RBP.addAresta(CMP, 1, 2, 4);

        CMP.addAresta(RBP, 1, 2, 4);
        CMP.addAresta(SJC, 1, 2, 10);
        CMP.addAresta(BAU, 1, 3, 6);
        CMP.addAresta(SPO, 1, 1, 7);

        BHO.addAresta(BSB, 1, 9, 6);
        BHO.addAresta(RJO, 1, 7, 6);
        BHO.addAresta(SJC, 1, 7, 8);

        LON.addAresta(BAU, 1, 3, 2);
        LON.addAresta(SPO, 1, 7, 2);
        LON.addAresta(CUR, 1, 6, 2);

        SPO.addAresta(LON, 1, 7, 2);
        SPO.addAresta(CUR, 1, 5, 10);
        SPO.addAresta(CMP, 1, 1, 7);
        SPO.addAresta(SJC, 1, 2, 16);
        SPO.addAresta(RJO, 1, 5, 15);

        RJO.addAresta(FLO, 1, 12, 10);
        RJO.addAresta(SPO, 1, 5, 15);
        RJO.addAresta(SJC, 1, 3, 10);
        RJO.addAresta(BHO, 1, 7, 6);
        RJO.addAresta(SLV, 1, 20, 6);

        SJC.addAresta(SPO, 1, 2, 16);
        SJC.addAresta(CMP, 1, 2, 10);
        SJC.addAresta(BHO, 1, 7, 8);
        SJC.addAresta(RJO, 1, 3, 10);

        CUR.addAresta(LON, 1, 6, 2);
        CUR.addAresta(SPO, 1, 5, 10);
        CUR.addAresta(FLO, 1, 2, 5);
        CUR.addAresta(BLU, 1, 2, 5);

        BLU.addAresta(CUR, 1, 2, 5);
        BLU.addAresta(FLO, 1, 1, 3);
        BLU.addAresta(POA, 1, 7, 2);

        FLO.addAresta(CUR, 1, 2, 5);
        FLO.addAresta(BLU, 1, 1, 3);
        FLO.addAresta(RJO, 1, 12, 10);
        FLO.addAresta(POA, 1, 6, 2);

        
        POA.addAresta(FLO, 1, 6, 2);
        POA.addAresta(BLU, 1, 7, 2);

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
        nos.add(POA);
        
        grafo.updateNoList(nos);
        
    }

    public void calcularDistancia() {
        carregarGrafo();
        List<No> caminho = grafo.encontrarCaminho(transformSelectionSrcNo(), transformSelectionDstNo());

        criarAnimacao(caminho);
    }

    public void calcularCusto() {
        carregarGrafo();
        List<No> caminho = grafo.encontrarCaminho(transformSelectionSrcNo(), transformSelectionDstNo());
        criarAnimacao(caminho);
    }

    // ; )  
    public No transformSelectionDstNo() {
        return nos.get(this.cbDestino.getSelectedIndex());
    }

    // :)  
    public No transformSelectionSrcNo() {
        return nos.get(this.cbInicio.getSelectedIndex());
    }

    public void criarAnimacao(List<No> caminho) {
        String szCaminho = "";
        No n_final = null;
        ArrayList<Pontos> pontos = new ArrayList<>();
        for (No n : caminho) {
            pontos.add(Pontos.valueOf(n.getNome()));
            szCaminho += n.getNome()+" Peso :"+n.getDistancia();
            n_final = n;
        }

        mapa.setSzCaminho(szCaminho);
        mapa.makePath(pontos);
        
        //  mapa.setSzInformation(this.szCaminho);

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
        cbInicio = new javax.swing.JComboBox<>();
        cbDestino = new javax.swing.JComboBox<>();
        btnDistancia = new javax.swing.JButton();
        btnCusto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnDesabilitar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        cbHabilitado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbDesabilitado = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jtMenuSobre = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jtMenuVisualizar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

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

        cbInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        btnDistancia.setText("Distância");
        btnDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistanciaActionPerformed(evt);
            }
        });

        btnCusto.setText("Custo");
        btnCusto.setPreferredSize(new java.awt.Dimension(85, 29));
        btnCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustoActionPerformed(evt);
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
                        .addComponent(cbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDistancia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDistancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        cbHabilitado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

        jLabel6.setText("Desabilitados:");

        cbDesabilitado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "BEL", "NTL", "REC", "SLV", "BSB", "CUI", "CPG", "BAU", "RBP", "CMP", "BHO", "LON", "SPO", "RJO", "SJC", "CUR", "BLU", "FLO", "POA" }));

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
                        .addComponent(cbHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDesabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(cbHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbDesabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHabilitar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtMenuSobre.setText("Sobre");

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jtMenuSobre.add(jMenuItem1);

        jMenuItem2.setText("Versão");
        jtMenuSobre.add(jMenuItem2);

        jMenuBar1.add(jtMenuSobre);

        jtMenuVisualizar.setText("Visualizar Tabela");

        jMenuItem3.setText("Tabela");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jtMenuVisualizar.add(jMenuItem3);

        jMenuBar1.add(jtMenuVisualizar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
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


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustoActionPerformed

        calcularCusto();

        // ArrayList<Plane.Pontos> pontos = new ArrayList<>();
        // pontos.add(Plane.Pontos.MAN);
        // pontos.add(Plane.Pontos.CUI);
        // pontos.add(Plane.Pontos.CPG);
        // pontos.add(Plane.Pontos.RBP);
        // pontos.add(Plane.Pontos.MAN);
        // mapa.makePath(pontos);

    }//GEN-LAST:event_btnCustoActionPerformed

    private void btnDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistanciaActionPerformed
        calcularDistancia();
    }//GEN-LAST:event_btnDistanciaActionPerformed

    private void btnDesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesabilitarActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Tabela tab = new Tabela();
        tab.setVisible(true);
        //Thread th_tab = new Thread(new Tabela());

    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
    private javax.swing.JButton btnDistancia;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JComboBox<String> cbDesabilitado;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JComboBox<String> cbHabilitado;
    private javax.swing.JComboBox<String> cbInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpPanel;
    private javax.swing.JMenu jtMenuSobre;
    private javax.swing.JMenu jtMenuVisualizar;
    // End of variables declaration//GEN-END:variables

}
