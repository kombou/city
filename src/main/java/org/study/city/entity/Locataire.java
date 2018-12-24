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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "locataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locataire.findAll", query = "SELECT l FROM Locataire l")
    , @NamedQuery(name = "Locataire.findById", query = "SELECT l FROM Locataire l WHERE l.id = :id")
    , @NamedQuery(name = "Locataire.findByProfession", query = "SELECT l FROM Locataire l WHERE l.profession = :profession")})
public class Locataire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "profession")
    private String profession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locataireId")
    private List<Contrat> contratList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private User userId;

    public Locataire() {
    }

    public Locataire(Integer id) {
        this.id = id;
    }

    public Locataire(Integer id, String profession) {
        this.id = id;
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Locataire)) {
            return false;
        }
        Locataire other = (Locataire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Locataire[ id=" + id + " ]";
    }
    
}
