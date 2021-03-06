/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Devoir;
import Entity.Etudiant;
import Model.DAO_Devoir;
import Model.DAO_Etudiant;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jérôme
 */
public class IHM_ListerDevoir extends javax.swing.JFrame {

    private DefaultListModel model = null;
    public List<Entity.Devoir> listeDevoir;
    protected Devoir devoir = null;

    /**
     * Creates new form ListerDevoir
     */
    public IHM_ListerDevoir() throws UnknownHostException {
        initComponents();
        model = new DefaultListModel();
        updateListeDevoir();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void updateListeDevoir() throws UnknownHostException {
        listeDevoir = new ArrayList<Entity.Devoir>();
        DAO_Devoir dao = new DAO_Devoir(null);
        listeDevoir = dao.findAll();
        model.clear();
        for (int i = 0; i < listeDevoir.size(); i++) {
            model.addElement(listeDevoir.get(i));
        }
        jList1.setModel(model);
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
        jList1 = new javax.swing.JList();
        bt_ajouter_devoir = new javax.swing.JButton();
        btTabDevoirEleve = new javax.swing.JButton();
        btImport = new javax.swing.JButton();
        btTabGroupeCritere1 = new javax.swing.JButton();
        cbxClasse = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lister les devoirs");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        bt_ajouter_devoir.setText("Ajouter un devoir");
        bt_ajouter_devoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajouter_devoirActionPerformed(evt);
            }
        });

        btTabDevoirEleve.setText("Tableau Note devoir/eleve");
        btTabDevoirEleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTabDevoirEleveActionPerformed(evt);
            }
        });

        btImport.setText("Import Elèves");
        btImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportActionPerformed(evt);
            }
        });

        btTabGroupeCritere1.setText("Tableau Note groupe/critère");
        btTabGroupeCritere1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTabGroupeCritere1ActionPerformed(evt);
            }
        });

        cbxClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASI 1", "ASI 2" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btTabDevoirEleve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_ajouter_devoir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTabGroupeCritere1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btImport)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_ajouter_devoir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTabDevoirEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTabGroupeCritere1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxClasse)
                            .addComponent(btImport, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap())
        );

        btTabDevoirEleve.getAccessibleContext().setAccessibleName("Tableau");
        btTabDevoirEleve.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ajouter_devoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajouter_devoirActionPerformed
        IHM_Devoir newDevoir = new IHM_Devoir(null, this);
        newDevoir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_ajouter_devoirActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        Integer index = jList1.getSelectedIndex();
        devoir = listeDevoir.get(index);

        IHM_Devoir modifDevoir = new IHM_Devoir(devoir, this);
        modifDevoir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        //pas utile
    }//GEN-LAST:event_jList1ValueChanged

    private void btTabDevoirEleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTabDevoirEleveActionPerformed
        IHM_TableauDevoirEleve tableauDevoirEleve;
        try {
            tableauDevoirEleve = new IHM_TableauDevoirEleve(this);
            tableauDevoirEleve.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(IHM_ListerDevoir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTabDevoirEleveActionPerformed

    private void btImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportActionPerformed

        JFileChooser choix = new JFileChooser();
        choix.showDialog(choix, null);
        File f = choix.getSelectedFile();

        try {
            FileInputStream file = new FileInputStream(f);

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // On copie les eleves de la classe dans notre collection archive
            DAO_Etudiant dao = new DAO_Etudiant(null);
            dao.archive(cbxClasse.getSelectedItem().toString());

            //Iterate through each rows one by one
            Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                org.apache.poi.ss.usermodel.Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();

                    if (!cell.getStringCellValue().equals("NOM")
                            && !cell.getStringCellValue().equals("Prénom")) {
                        String sNom = cell.getStringCellValue();
                        String sPrenom = "";

                        if (cellIterator.hasNext()) {
                            cell = cellIterator.next();
                            sPrenom = cell.getStringCellValue();
                        }

                        if (sNom != "" && sPrenom != "") {
                            Etudiant etud = new Etudiant(sNom, sPrenom, cbxClasse.getSelectedItem().toString());
                            System.out.println(etud.toString());
                            DAO_Etudiant dao_etud = new DAO_Etudiant(null);
                            dao_etud.create(etud);
                        }
                    }
//                    //Check the cell type and format accordingly
//                    switch (cell.getCellType())
//                    {
//                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + " ");
//                            break;
//                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue() + ";");
//                            break;
//                    }   
                }
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btImportActionPerformed

    private void btTabGroupeCritere1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTabGroupeCritere1ActionPerformed
        IHM_TableauCritereGroupe tableauCritereGroupe;
        try {
            tableauCritereGroupe = new IHM_TableauCritereGroupe(this);
            tableauCritereGroupe.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(IHM_ListerDevoir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTabGroupeCritere1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImport;
    private javax.swing.JButton btTabDevoirEleve;
    private javax.swing.JButton btTabGroupeCritere1;
    private javax.swing.JButton bt_ajouter_devoir;
    private javax.swing.JComboBox cbxClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
