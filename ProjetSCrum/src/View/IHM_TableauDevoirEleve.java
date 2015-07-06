/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Devoir;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Quentin
 */
public class IHM_TableauDevoirEleve extends javax.swing.JFrame {

    /**
     * Creates new form IHM_TableauDevoirEleve
     */
    protected IHM_ListerDevoir IHM_ListerDevoir = null;
    protected List<Devoir> lstDevoir = new ArrayList<Devoir>();

    public IHM_TableauDevoirEleve(IHM_ListerDevoir pIHM_ListerDevoir) {
        IHM_ListerDevoir = pIHM_ListerDevoir;
        lstDevoir = pIHM_ListerDevoir.listeDevoir;
        initComponents();
        initTableau();
    }

    private void initTableau() {
        List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();

        columns.add("Etudiant");
        //columns.add("col2");
        //columns.add("col3");
        
        for (int i = 0; i < lstDevoir.size(); i++) {
            for (int j = 0; j < lstDevoir.get(i).getLstGroupe().size(); j++) {

                for (int k = 0; k < lstDevoir.get(i).getLstGroupe().get(j).getLstEtudiant().size(); k++) {
                    columns.add(lstDevoir.get(i).getLibelle()+"  /"+lstDevoir.get(i).getLstGroupe().get(j).getTotalPoid());
                    
                    String[] content = new String[lstDevoir.size() + 1];
                    content[0] = lstDevoir.get(i).getLstGroupe().get(j).getLstEtudiant().get(k).toString();
                    content[i + 1] = lstDevoir.get(i).getLstGroupe().get(j).getTotalNote().toString();
                    values.add(content);
                }
            }
            //values.add(new String[]{"val" + i + " col1", "val" + i + " col2", "val" + i + " col3"});
        }

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
        jTable1.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tableau récapitulatif des devoirs par élèves");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Elèves", "Nom du devoir 1", "Nom du devoir 2", "Nom du devoir 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Retour à la liste des devoirs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
