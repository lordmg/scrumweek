/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Devoir;
import Entity.Note;
import Model.DAO_Devoir;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.System.out;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Maxime
 */
public class IHM_TableauCritereGroupe extends javax.swing.JFrame {

    /**
     * Creates new form IHM_TableauCritereGroupe
     */
    protected IHM_ListerDevoir IHM_ListerDevoir = null;
    protected List<Devoir> lstDevoir = new ArrayList<Devoir>();

    public IHM_TableauCritereGroupe(IHM_ListerDevoir pIHM_ListerDevoir) throws UnknownHostException {
        IHM_ListerDevoir = pIHM_ListerDevoir;
        DAO_Devoir dao = new DAO_Devoir(null);
        lstDevoir = dao.findAll();
        initComponents();
        jTable1.setVisible(false);

        jComboBox1.removeAllItems();
        for (int i = 0; i < lstDevoir.size(); i++) {
            jComboBox1.addItem(lstDevoir.get(i));
        }
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void initTableau(Devoir unDevoir) {
        List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();

        columns.add("Critère");

        for (int j = 0; j < unDevoir.getLstGroupe().size(); j++) {
            columns.add(unDevoir.getLstGroupe().get(j).getLibelle());

            unDevoir.getNoteCritere(unDevoir.getLstGroupe().get(j).getLstNote());
            List<Note> lolNote = new ArrayList<Note>();
            lolNote = unDevoir.getNoteCritere(unDevoir.getLstGroupe().get(j).getLstNote());

            for (int k = 0; k < lolNote.size(); k++) {
                String[] content = new String[1 + unDevoir.getLstGroupe().size() ];

                //out.println(unDevoir.getLstGroupe().get(j).getLstNote().get(k).getLibelle());
                content[0] = lolNote.get(k).getLibelle()
                        + "  /" + lolNote.get(k).getPoid();
                if (lolNote.get(k).getNote() != null) {
                    content[1 + j] = lolNote.get(k).getNote().toString();
                } else {
                    content[1 + j] = "0";
                }

                if (values.size() > k) {
                    String[] conTemp = new String[1 + unDevoir.getLstGroupe().size()];
                    conTemp = values.get(k);                   
                    conTemp[1+j] = content[1+j];
                    values.set(k, conTemp);
                } else {
                    values.add(content);
                }

            }

        }
        //values.add(new String[]{"val" + i + " col1", "val" + i + " col2", "val" + i + " col3"});

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
        jTable1.setModel(tableModel);
        jTable1.setVisible(true);
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
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tableau récapitulatif des critères en par groupes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Groupe", "Critère", "Critère", "Critère"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Retour à la liste des devoirs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        Devoir unDevoir = (Devoir) jComboBox1.getSelectedItem();
        if (unDevoir != null) {
            initTableau(unDevoir);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
