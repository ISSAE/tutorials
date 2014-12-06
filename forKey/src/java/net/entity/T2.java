/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.entity;

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
 * @author pascalfares
 */
@Entity
@Table(name = "T2",catalog = "foreignKey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T2.findAll", query = "SELECT t FROM T2 t"),
    @NamedQuery(name = "T2.findById", query = "SELECT t FROM T2 t WHERE t.id = :id"),
    @NamedQuery(name = "T2.findByIdVoiture", query = "SELECT t FROM T2 t WHERE t.idVoiture = :idVoiture")})
public class T2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idVoiture")
    private String idVoiture;
    @JoinColumn(name = "id_t1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private T1 idT1;

    public T2() {
    }

    public T2(Integer id) {
        this.id = id;
    }

    public T2(Integer id, String idVoiture) {
        this.id = id;
        this.idVoiture = idVoiture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public T1 getIdT1() {
        return idT1;
    }

    public void setIdT1(T1 idT1) {
        this.idT1 = idT1;
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
        if (!(object instanceof T2)) {
            return false;
        }
        T2 other = (T2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.entity.T2[ id=" + id + " ]";
    }
    
}
