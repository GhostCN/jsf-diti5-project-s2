/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByid", query = "SELECT l FROM Location l WHERE l.id = :id")
    , @NamedQuery(name = "Location.findByDate", query = "SELECT l FROM Location l WHERE l.date = :date")
    , @NamedQuery(name = "Location.findByNbjour", query = "SELECT l FROM Location l WHERE l.nbjour = :nbjour")
    , @NamedQuery(name = "Location.findByCommentaire", query = "SELECT l FROM Location l WHERE l.commentaire = :commentaire")
    , @NamedQuery(name = "Location.findByMontantlocation", query = "SELECT l FROM Location l WHERE l.montantlocation = :montantlocation")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbjour")
    private int nbjour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montantlocation")
    private float montantlocation;
    @JoinColumn(name = "idvehicule", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicule idvehicule;
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idclient;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Location(Integer id, Date date, int nbjour, String commentaire, float montantlocation) {
        this.id = id;
        this.date = date;
        this.nbjour = nbjour;
        this.commentaire = commentaire;
        this.montantlocation = montantlocation;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbjour() {
        return nbjour;
    }

    public void setNbjour(int nbjour) {
        this.nbjour = nbjour;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public float getMontantlocation() {
        return montantlocation;
    }

    public void setMontantlocation(float montantlocation) {
        this.montantlocation = montantlocation;
    }

    public Vehicule getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(Vehicule idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Location[ id=" + id + " ]";
    }
    
}
