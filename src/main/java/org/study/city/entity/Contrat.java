/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.study.city.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lesli
 */
@Entity
@Table(name = "contrat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c")
    , @NamedQuery(name = "Contrat.findById", query = "SELECT c FROM Contrat c WHERE c.id = :id")
    , @NamedQuery(name = "Contrat.findByDate", query = "SELECT c FROM Contrat c WHERE c.date = :date")
    , @NamedQuery(name = "Contrat.findByDuree", query = "SELECT c FROM Contrat c WHERE c.duree = :duree")
    , @NamedQuery(name = "Contrat.findByPrix", query = "SELECT c FROM Contrat c WHERE c.prix = :prix")
    , @NamedQuery(name = "Contrat.findByReste", query = "SELECT c FROM Contrat c WHERE c.reste = :reste")})
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duree")
    private int duree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private float prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reste")
    private float reste;
    @JoinColumn(name = "maison_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Maison maisonId;
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Locataire locataireId;

    public Contrat() {
    }

    public Contrat(Integer id) {
        this.id = id;
    }

    public Contrat(Integer id, Date date, int duree, float prix, float reste) {
        this.id = id;
        this.date = date;
        this.duree = duree;
        this.prix = prix;
        this.reste = reste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getReste() {
        return reste;
    }

    public void setReste(float reste) {
        this.reste = reste;
    }

    public Maison getMaisonId() {
        return maisonId;
    }

    public void setMaisonId(Maison maisonId) {
        this.maisonId = maisonId;
    }

    public Locataire getLocataireId() {
        return locataireId;
    }

    public void setLocataireId(Locataire locataireId) {
        this.locataireId = locataireId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Contrat[ id=" + id + " ]";
    }
    
}
