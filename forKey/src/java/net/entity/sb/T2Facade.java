/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.entity.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.entity.T2;

/**
 *
 * @author pascalfares
 */
@Stateless
public class T2Facade extends AbstractFacade<T2> {
    @PersistenceContext(unitName = "forKeyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public T2Facade() {
        super(T2.class);
    }
    
}
