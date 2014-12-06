/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.cofares.entities.Matieres;

/**
 *
 * @author pascalfares
 */
@Stateless
public class MatieresFacade extends AbstractFacade<Matieres> {
    @PersistenceContext(unitName = "exemplePrimePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatieresFacade() {
        super(Matieres.class);
    }
    
}
