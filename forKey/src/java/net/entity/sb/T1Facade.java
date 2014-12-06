/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.entity.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.entity.T1;

/**
 *
 * @author pascalfares
 */
@Stateless
public class T1Facade extends AbstractFacade<T1> {
    @PersistenceContext(unitName = "forKeyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public T1Facade() {
        super(T1.class);
    }
    
}
