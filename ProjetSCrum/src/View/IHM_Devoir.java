/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Devoir;
import Entity.Groupe;
import Entity.Matiere;
import Entity.Rubrique;
import Model.DAO_Devoir;
import Model.DAO_Matiere;
import static java.lang.System.out;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.jdatepicker.impl.JDatePickerImpl;

/**
 *
 * @author FaivreQu
 */
public class IHM_Devoir extends javax.swing.JFrame {

    private JDatePickerImpl datePicker;
    protected Devoir devoir;
    protected Devoir newDevoir;
    protected IHM_RubriquesCriteres IHM_Rubrique = null;
    protected IHM_CreationGroupe IHM_CreationGroupe = null;
    private boolean isCreation;

    protected IHM_ListerDevoir IHM_ListerDevoir = null;

    /**
     * Creates new form Devoir
     */
    public IHM_Devoir(Entity.Devoir pDevoir, IHM_ListerDevoir pIHM_ListerDevoir) {

        newDevoir = new Devoir();
        devoir = new Devoir();
        isCreation = true;
        IHM_ListerDevoir = pIHM_ListerDevoir;
        

        try {
            initComponents();
            //updateMatiere();
            jButton1.setText("Créer");
            //si on est en modification, on charge la page de modification
            if (pDevoir != null) {
                jButton1.setText("Modifier");
                jButton5.setVisible(true);
                isCreation = false;
                
                devoir = new Devoir(pDevoir);
                newDevoir = new Devoir(pDevoir);
                
                matiereDevoir.setSelectedItem(devoir.getMatiere());
                titreDevoir.setText(devoir.getLibelle());
                jXDatePicker1.setDate(devoir.getDate());

                jLabel3.setText("Modification d'un devoir");
                jButton1.setText("Modifier");

                List<Rubrique> lstRubrique = devoir.getLstRubrique();
                DefaultListModel listeModel = new DefaultListModel();
                for (int i = 0; i < lstRubrique.size(); i++) {
                    listeModel.addElement(lstRubrique.get(i));
                }
                jList1.setModel(listeModel);
                
                updateListeGroupe();

                //Si on est en création d'un nouveau devoir
                //} else {
            }

        } catch (Exception ex) {
            Logger.getLogger(IHM_Devoir.class.getName()).log(Level.SEVERE, null, ex);
        }
        jXDatePicker1.getEditor().setEditable(false);
    }

    protected void updateListeGroupe()
    {
        List<Groupe> lstGroupe = newDevoir.getLstGroupe();
                DefaultListModel listeModelGroupe = new DefaultListModel();
                for(int i = 0; i < lstGroupe.size(); i++)
                {
                    listeModelGroupe.addElement(lstGroupe.get(i));
                }
                jList2.setModel(listeModelGroupe);
    }
    
    protected void addToListRubrique(Rubrique rub) {
        ListModel model = jList1.getModel();
        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < model.getSize(); i++) {
            listModel.addElement(model.getElementAt(i));
        }
        listModel.addElement(rub);

        jList1.setModel(listModel);
        out.println("lol");
        if (isCreation) {
            newDevoir.addToListRubrique(rub);
            out.println("lol1");
        } else {
            newDevoir.addToListRubrique(rub);
            out.println("lol2");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        matiereDevoir = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        titreDevoir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxChoixClasse = new javax.swing.JComboBox();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Création devoir : ");

        jLabel1.setText("Nom du devoir : ");

        matiereDevoir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Java", "CGI", "Mod", "SCRUM", "" }));
        matiereDevoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matiereDevoirActionPerformed(evt);
            }
        });

        jLabel2.setText("Matière : ");

        titreDevoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titreDevoirActionPerformed(evt);
            }
        });

        jLabel4.setText("Date du devoir : ");

        jButton1.setText("Valider");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Liste des rubriques");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("-");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jXDatePicker1.setDate(new Date());
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList2);

        jLabel6.setText("Liste des groupes");

        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Classe :");

        cbxChoixClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASI 1", "ASI 2" }));
        cbxChoixClasse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxChoixClasseItemStateChanged(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(titreDevoir)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxChoixClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(matiereDevoir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxChoixClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matiereDevoir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreDevoir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

        jButton5.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matiereDevoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matiereDevoirActionPerformed
        // TODO

    }//GEN-LAST:event_matiereDevoirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!titreDevoir.getText().equals("")
                && jXDatePicker1.getDate() != null
                && matiereDevoir.getSelectedItem() != null
                && jList1.getModel().getSize() != 0
                && jXDatePicker1.getDate() != null) {
            DAO_Devoir dao;
            try {
                dao = new DAO_Devoir(null);
                if (isCreation) {
                    this.newDevoir.setLibelle(titreDevoir.getText());
                    this.newDevoir.setMatiere((String) matiereDevoir.getSelectedItem());
                    this.newDevoir.setDate(jXDatePicker1.getDate());

                    dao.create(newDevoir);
                } else {
                    out.println(isCreation);
                    this.newDevoir.setLibelle(titreDevoir.getText());
                    this.newDevoir.setMatiere((String) matiereDevoir.getSelectedItem());
                    this.newDevoir.setDate(jXDatePicker1.getDate());

                    dao.update(devoir, newDevoir);
                }
            } catch (UnknownHostException ex) {
                Logger.getLogger(IHM_Devoir.class.getName()).log(Level.SEVERE, null, ex);

            }

            try {
                IHM_ListerDevoir.updateListeDevoir();
            } catch (UnknownHostException ex) {
                Logger.getLogger(IHM_Devoir.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.setVisible(false);
            IHM_ListerDevoir.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erreur, vous devez remplir tous les champs!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IHM_ListerDevoir.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Si il y a moins de 5 rubriques
        if(jList1.getModel().getSize() < 5)
        {    
            IHM_Rubrique = new IHM_RubriquesCriteres(this);
            IHM_Rubrique.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Erreur, vous ne pouvez pas créer plus de 5 rubriques.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Si un element de la liste est bien sélectionné
        if(!jList1.isSelectionEmpty())
        {
            DefaultListModel model = new DefaultListModel();
            List liste = new ArrayList();
            
            for(int i = 0; i < jList1.getModel().getSize(); i ++)
            {
                model.addElement(jList1.getModel().getElementAt(i));
                liste.add(jList1.getModel().getElementAt(i));
            }
            
            model.removeElement(jList1.getSelectedValue());
            liste.remove(jList1.getSelectedValue());
            
            jList1.setModel(model);
            
            newDevoir.setLstRubrique(liste);
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez selectionner une rubrique à supprimer svp");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void titreDevoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titreDevoirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titreDevoirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        this.setEnabled(false);
        
        IHM_CreationGroupe = new IHM_CreationGroupe(this);
        IHM_CreationGroupe.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Si un element de la liste est bien sélectionné
        if(!jList2.isSelectionEmpty())
        {
            DefaultListModel model = new DefaultListModel();
            List liste = new ArrayList();
            
            for(int i = 0; i < jList2.getModel().getSize(); i ++)
            {
                model.addElement(jList2.getModel().getElementAt(i));
                liste.add(jList2.getModel().getElementAt(i));
            }
            
            model.removeElement(jList2.getSelectedValue());
            liste.remove(jList2.getSelectedValue());
            
            jList2.setModel(model);
            
            newDevoir.setLstGroupe(liste);
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez selectionner un groupe à supprimer svp");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        IHM_ListerDevoir.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        
        
    }//GEN-LAST:event_jList1KeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        //Si rien n'est selectionné on sort de la méthode
        if(jList1.isSelectionEmpty())
            return;
        
        Rubrique rubrique = (Rubrique)jList1.getSelectedValue();
        
        IHM_Rubrique = new IHM_RubriquesCriteres(this, rubrique);
        IHM_Rubrique.setVisible(true);
    }//GEN-LAST:event_jList1MouseClicked

    private void cbxChoixClasseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxChoixClasseItemStateChanged
        try {
            updateMatiere(cbxChoixClasse.getSelectedItem().toString());
        } catch (UnknownHostException ex) {
            Logger.getLogger(IHM_Devoir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxChoixClasseItemStateChanged

    protected List<String> getLstNomGroupe()
    {
        List<String> lstNomGroupe = new ArrayList<String>();
        
        ListModel model = jList2.getModel();
        
        for(int i = 0; i < model.getSize(); i ++)
        {
            lstNomGroupe.add(model.getElementAt(i).toString());
        }
        
        return lstNomGroupe;
    }
            
    public void updateMatiere(String uneClasse) throws UnknownHostException {
        matiereDevoir.removeAllItems();
        DAO_Matiere dao = new DAO_Matiere(null);
        List<Matiere> liste = new ArrayList<Matiere>();
        liste = dao.findByClasse(uneClasse);
        for (Matiere matiere : liste) {
            matiereDevoir.addItem(matiere.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxChoixClasse;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JComboBox matiereDevoir;
    private javax.swing.JTextField titreDevoir;
    // End of variables declaration//GEN-END:variables
}
