/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascalfares
 */
@Entity
@Table(name = "groupe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByUsername", query = "SELECT g FROM Groupe g WHERE g.groupePK.username = :username"),
    @NamedQuery(name = "Groupe.findByGroupename", query = "SELECT g FROM Groupe g WHERE g.groupePK.groupename = :groupename")})
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupePK groupePK;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Groupe() {
    }

    public Groupe(GroupePK groupePK) {
        this.groupePK = groupePK;
    }

    public Groupe(String username, String groupename) {
        this.groupePK = new GroupePK(username, groupename);
    }

    public GroupePK getGroupePK() {
        return groupePK;
    }

    public void setGroupePK(GroupePK groupePK) {
        this.groupePK = groupePK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupePK != null ? groupePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.groupePK == null && other.groupePK != null) || (this.groupePK != null && !this.groupePK.equals(other.groupePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.entity.Groupe[ groupePK=" + groupePK + " ]";
    }
    
}
