/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pascalfares
 */
@Embeddable
public class GroupePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "groupename")
    private String groupename;

    public GroupePK() {
    }

    public GroupePK(String username, String groupename) {
        this.username = username;
        this.groupename = groupename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupename() {
        return groupename;
    }

    public void setGroupename(String groupename) {
        this.groupename = groupename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (groupename != null ? groupename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupePK)) {
            return false;
        }
        GroupePK other = (GroupePK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if ((this.groupename == null && other.groupename != null) || (this.groupename != null && !this.groupename.equals(other.groupename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.entity.GroupePK[ username=" + username + ", groupename=" + groupename + " ]";
    }
    
}
