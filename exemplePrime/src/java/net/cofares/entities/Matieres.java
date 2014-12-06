/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cofares.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pascalfares
 */
@Entity
@Table(name = "matieres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matieres.findAll", query = "SELECT m FROM Matieres m"),
    @NamedQuery(name = "Matieres.findById", query = "SELECT m FROM Matieres m WHERE m.id = :id"),
    @NamedQuery(name = "Matieres.findByNom", query = "SELECT m FROM Matieres m WHERE m.nom = :nom")})
public class Matieres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom")
    private String nom;
    @JoinTable(name = "inscrit", joinColumns = {
        @JoinColumn(name = "id_m", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_u", referencedColumnName = "id")})
    @ManyToMany
    private List<User> userList;

    public Matieres() {
    }

    public Matieres(Integer id) {
        this.id = id;
    }

    public Matieres(Integer id, String nom) {
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
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        if (!(object instanceof Matieres)) {
            return false;
        }
        Matieres other = (Matieres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.entities.Matieres[ id=" + id + " ]";
    }
    
}
