/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cofares;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pascalfares
 */
@ManagedBean
@SessionScoped
public class MonBean {

    private int x;

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public int getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Creates a new instance of MonBean
     */
    public MonBean() {
    }
    
}
