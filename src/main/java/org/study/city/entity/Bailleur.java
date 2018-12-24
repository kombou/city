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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lesli
 */
@Entity
@Table(name = "bailleur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bailleur.findAll", query = "SELECT b FROM Bailleur b")
    , @NamedQuery(name = "Bailleur.findById", query = "SELECT b FROM Bailleur b WHERE b.id = :id")})
public class Bailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "compte_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Compte compteId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bailleurId")
    private List<MiniCite> miniCiteList;

    public Bailleur() {
    }

    public Bailleur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Compte getCompteId() {
        return compteId;
    }

    public void setCompteId(Compte compteId) {
        this.compteId = compteId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<MiniCite> getMiniCiteList() {
        return miniCiteList;
    }

    public void setMiniCiteList(List<MiniCite> miniCiteList) {
        this.miniCiteList = miniCiteList;
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
        if (!(object instanceof Bailleur)) {
            return false;
        }
        Bailleur other = (Bailleur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Bailleur[ id=" + id + " ]";
    }
    
}
