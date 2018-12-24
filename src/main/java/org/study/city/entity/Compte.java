/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.study.city.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lesli
 */
@Entity
@Table(name = "compte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c")
    , @NamedQuery(name = "Compte.findById", query = "SELECT c FROM Compte c WHERE c.id = :id")
    , @NamedQuery(name = "Compte.findByLogin", query = "SELECT c FROM Compte c WHERE c.login = :login")
    , @NamedQuery(name = "Compte.findByPassword", query = "SELECT c FROM Compte c WHERE c.password = :password")
    , @NamedQuery(name = "Compte.findByConfirmationToken", query = "SELECT c FROM Compte c WHERE c.confirmationToken = :confirmationToken")
    , @NamedQuery(name = "Compte.findByConfirmationAt", query = "SELECT c FROM Compte c WHERE c.confirmationAt = :confirmationAt")
    , @NamedQuery(name = "Compte.findByResetToken", query = "SELECT c FROM Compte c WHERE c.resetToken = :resetToken")
    , @NamedQuery(name = "Compte.findByResetAt", query = "SELECT c FROM Compte c WHERE c.resetAt = :resetAt")})
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "confirmation_at")
    @Temporal(TemporalType.DATE)
    private Date confirmationAt;
    @Size(max = 255)
    @Column(name = "reset_token")
    private String resetToken;
    @Column(name = "reset_at")
    @Temporal(TemporalType.DATE)
    private Date resetAt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compteId")
    private Bailleur bailleur;

    public Compte() {
    }

    public Compte(Integer id) {
        this.id = id;
    }

    public Compte(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getConfirmationAt() {
        return confirmationAt;
    }

    public void setConfirmationAt(Date confirmationAt) {
        this.confirmationAt = confirmationAt;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Date getResetAt() {
        return resetAt;
    }

    public void setResetAt(Date resetAt) {
        this.resetAt = resetAt;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Compte[ id=" + id + " ]";
    }
    
}
