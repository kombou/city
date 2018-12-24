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
@Table(name = "maison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maison.findAll", query = "SELECT m FROM Maison m")
    , @NamedQuery(name = "Maison.findById", query = "SELECT m FROM Maison m WHERE m.id = :id")
    , @NamedQuery(name = "Maison.findByNom", query = "SELECT m FROM Maison m WHERE m.nom = :nom")
    , @NamedQuery(name = "Maison.findByPhoto", query = "SELECT m FROM Maison m WHERE m.photo = :photo")
    , @NamedQuery(name = "Maison.findByPrix", query = "SELECT m FROM Maison m WHERE m.prix = :prix")
    , @NamedQuery(name = "Maison.findByStatus", query = "SELECT m FROM Maison m WHERE m.status = :status")})
public class Maison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private int prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maisonId")
    private List<Contrat> contratList;
    @JoinColumn(name = "mini_cite_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MiniCite miniCiteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maisonId")
    private List<Piece> pieceList;

    public Maison() {
    }

    public Maison(Integer id) {
        this.id = id;
    }

    public Maison(Integer id, String nom, String photo, int prix, boolean status) {
        this.id = id;
        this.nom = nom;
        this.photo = photo;
        this.prix = prix;
        this.status = status;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    public MiniCite getMiniCiteId() {
        return miniCiteId;
    }

    public void setMiniCiteId(MiniCite miniCiteId) {
        this.miniCiteId = miniCiteId;
    }

    @XmlTransient
    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void setPieceList(List<Piece> pieceList) {
        this.pieceList = pieceList;
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
        if (!(object instanceof Maison)) {
            return false;
        }
        Maison other = (Maison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Maison[ id=" + id + " ]";
    }
    
}
