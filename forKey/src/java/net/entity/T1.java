/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author pascalfares
 */
@Entity
@Table(name = "T1", catalog = "foreignKey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T1.findAll", query = "SELECT t FROM T1 t"),
    @NamedQuery(name = "T1.findById", query = "SELECT t FROM T1 t WHERE t.id = :id"),
    @NamedQuery(name = "T1.findByDecription", query = "SELECT t FROM T1 t WHERE t.decription = :decription")})
public class T1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "decription")
    private String decription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idT1")
    private List<T2> t2List;

    public T1() {
    }

    public T1(Integer id) {
        this.id = id;
    }

    public T1(Integer id, String decription) {
        this.id = id;
        this.decription = decription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @XmlTransient
    public List<T2> getT2List() {
        return t2List;
    }

    public void setT2List(List<T2> t2List) {
        this.t2List = t2List;
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
        if (!(object instanceof T1)) {
            return false;
        }
        T1 other = (T1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.entity.T1[ id=" + id + " ]";
    }
    
}
