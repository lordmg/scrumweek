/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */
public class Devoir {

    private ObjectId _id;
    private String libelle;
    private String matiere;
    private Date date;
    private List<Rubrique> lstRubrique;
    private List<Groupe> lstGroupe;

    public Devoir(ObjectId _id, String libelle, String matiere, Date date, List<Rubrique> lstRubrique, List<Groupe> lstGroupe) {
        this._id = _id;
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
        this.lstRubrique = lstRubrique;
        this.lstGroupe = lstGroupe;
    }

    public Devoir(String libelle, String matiere, Date date, List<Rubrique> lstRubrique, List<Groupe> lstGroupe) {
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
        this.lstRubrique = lstRubrique;
        this.lstGroupe = lstGroupe;
    }

    public Devoir(String libelle, String matiere, Date date, List<Rubrique> lstRubrique) {
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
        this.lstRubrique = lstRubrique;
        lstGroupe = new ArrayList<Groupe>();
    }

    public Devoir(String libelle, String matiere, Date date) {
        lstGroupe = new ArrayList<Groupe>();
        lstRubrique = new ArrayList<Rubrique>();
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
    }

    public Devoir(Devoir unDevoir) {
        this._id = unDevoir.getId();
        this.libelle = unDevoir.getLibelle();
        this.matiere = unDevoir.getMatiere();
        this.date = unDevoir.getDate();
        this.lstRubrique = unDevoir.getLstRubrique();
        this.lstGroupe = unDevoir.getLstGroupe();
    }

    public Devoir() {
        lstRubrique = new ArrayList<Rubrique>();
        lstGroupe = new ArrayList<Groupe>();
    }

    public int getTotalPoid() {
        int total = 0;
        for (int i = 0; i < this.getLstRubrique().size(); i++) {
            for (int j = 0; j < this.getLstRubrique().get(i).getLstCritere().size(); j++) {
                total = total + this.getLstRubrique().get(i).getLstCritere().get(j).getPoid();
            }
        }
        return total;
    }

    public List<Note> getNoteCritere(List<Note> noter) {
        List<Note> lstNoteCriterePoid = new ArrayList<Note>();
        for (int i = 0; i < this.getLstRubrique().size(); i++) {           
            for (int j = 0; j < this.getLstRubrique().get(i).getLstCritere().size(); j++) {
                String libelle = this.getLstRubrique().get(i).getLibelle() + "-";
                libelle = libelle + this.getLstRubrique().get(i).getLstCritere().get(j).getLibelle();
                Note uneNote = new Note(libelle, this.getLstRubrique().get(i).getLstCritere().get(j).getPoid());
                lstNoteCriterePoid.add(uneNote);
            }
        }
        for (int i = 0; i < lstNoteCriterePoid.size(); i++) {
            for (int j = 0; j < noter.size(); j++) {
                if(lstNoteCriterePoid.get(i).equals(noter.get(j))){
                Collections.replaceAll(lstNoteCriterePoid,lstNoteCriterePoid.get(i), noter.get(j));
                }
                
            }
        }

        return lstNoteCriterePoid;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Rubrique> getLstRubrique() {
        return this.lstRubrique;
    }

    public void addToListRubrique(Rubrique rub) {
        lstRubrique.add(rub);
    }

    public void addToListGroupe(Groupe grp) {
        lstGroupe.add(grp);
    }

    public List<Etudiant> getEtudiantInGroupe(List<Etudiant> lstEtud) {
        List<Etudiant> lstEtudiant = new ArrayList<Etudiant>();
        for (int i = 0; i < lstGroupe.size(); i++) {
            List<Etudiant> lstEtuTemp = new ArrayList<Etudiant>();
            lstEtuTemp = lstGroupe.get(i).getLstEtudiant();
            for (int j = 0; j < lstEtuTemp.size(); j++) {
                lstEtudiant.add(lstEtuTemp.get(j));
            }
        }
        lstEtud.removeAll(lstEtudiant);
        return lstEtud;
    }

    public List<Etudiant> getListEtudiantInGroupe() {
        List<Etudiant> lstEtudiant = new ArrayList<Etudiant>();
        for (int i = 0; i < lstGroupe.size(); i++) {
            List<Etudiant> lstEtuTemp = new ArrayList<Etudiant>();
            lstEtuTemp = lstGroupe.get(i).getLstEtudiant();
            for (int j = 0; j < lstEtuTemp.size(); j++) {
                lstEtudiant.add(lstEtuTemp.get(j));
            }
        }
        return lstEtudiant;
    }

    public List<Groupe> getLstGroupe() {
        return lstGroupe;
    }

    public void setLstRubrique(List<Rubrique> lstRubrique) {
        this.lstRubrique = lstRubrique;
    }

    public void setLstGroupe(List<Groupe> lstGroupe) {
        this.lstGroupe = lstGroupe;
    }

    public BasicDBList mapBddRubriques() {
        BasicDBList result = new BasicDBList();
        for (Rubrique rubrique : lstRubrique) {
            BasicDBObject dbRubriques = new BasicDBObject();
            //dbRubriques.append("_id", rubrique.getId());
            dbRubriques.append("libelle", rubrique.getLibelle());
            dbRubriques.append("lstCritere", rubrique.mapBddCritere());
            result.add(dbRubriques);
        }

        return result;
    }

    public BasicDBList mapBddGroupes() {
        BasicDBList result = new BasicDBList();
        for (Groupe groupe : lstGroupe) {
            BasicDBObject dbGroupes = new BasicDBObject();
            //dbRubriques.append("_id", groupe.getId());
            dbGroupes.append("libelle", groupe.getLibelle());
            dbGroupes.append("lstEtudiant", groupe.mapBddEtudiants());
            dbGroupes.append("lstNote", groupe.mapBddNotes());
            result.add(dbGroupes);
        }

        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this._id);
        hash = 53 * hash + Objects.hashCode(this.libelle);
        hash = 53 * hash + Objects.hashCode(this.matiere);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.lstRubrique);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Devoir other = (Devoir) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.matiere, other.matiere)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.lstRubrique, other.lstRubrique)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle + " - " + matiere + " - " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
    }
}
