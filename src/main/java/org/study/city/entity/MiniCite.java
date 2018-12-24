/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.study.city.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lesli
 */
@Entity
@Table(name = "mini_cite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MiniCite.findAll", query = "SELECT m FROM MiniCite m")
    , @NamedQuery(name = "MiniCite.findById", query = "SELECT m FROM MiniCite m WHERE m.id = :id")
    , @NamedQuery(name = "MiniCite.findByNom", query = "SELECT m FROM MiniCite m WHERE m.nom = :nom")})
public class MiniCite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miniCiteId")
    private List<Maison> maisonList;
    @JoinColumn(name = "bailleur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bailleur bailleurId;

    public MiniCite() {
    }

    public MiniCite(Integer id) {
        this.id = id;
    }

    public MiniCite(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Maison> getMaisonList() {
        return maisonList;
    }

    public void setMaisonList(List<Maison> maisonList) {
        this.maisonList = maisonList;
    }

    public Bailleur getBailleurId() {
        return bailleurId;
    }

    public void setBailleurId(Bailleur bailleurId) {
        this.bailleurId = bailleurId;
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
        if (!(object instanceof MiniCite)) {
            return false;
        }
        MiniCite other = (MiniCite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.MiniCite[ id=" + id + " ]";
    }
    
}
