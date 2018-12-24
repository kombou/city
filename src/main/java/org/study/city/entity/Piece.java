/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.study.city.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lesli
 */
@Entity
@Table(name = "piece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piece.findAll", query = "SELECT p FROM Piece p")
    , @NamedQuery(name = "Piece.findById", query = "SELECT p FROM Piece p WHERE p.id = :id")
    , @NamedQuery(name = "Piece.findByLongueur", query = "SELECT p FROM Piece p WHERE p.longueur = :longueur")
    , @NamedQuery(name = "Piece.findByLargeur", query = "SELECT p FROM Piece p WHERE p.largeur = :largeur")
    , @NamedQuery(name = "Piece.findByPhoto", query = "SELECT p FROM Piece p WHERE p.photo = :photo")})
public class Piece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longueur")
    private float longueur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "largeur")
    private float largeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photo")
    private String photo;
    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorie categorieId;
    @JoinColumn(name = "maison_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Maison maisonId;

    public Piece() {
    }

    public Piece(Integer id) {
        this.id = id;
    }

    public Piece(Integer id, float longueur, float largeur, String photo) {
        this.id = id;
        this.longueur = longueur;
        this.largeur = largeur;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Categorie getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Categorie categorieId) {
        this.categorieId = categorieId;
    }

    public Maison getMaisonId() {
        return maisonId;
    }

    public void setMaisonId(Maison maisonId) {
        this.maisonId = maisonId;
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
        if (!(object instanceof Piece)) {
            return false;
        }
        Piece other = (Piece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Piece[ id=" + id + " ]";
    }
    
}
