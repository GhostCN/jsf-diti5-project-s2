/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;


import com.isi.diti5.model.Location;
import com.isi.diti5.utils.HibernateUtil;
import org.hibernate.Session;


import javax.ejb.Stateless;

/**
 *
 * @author mac
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {

    private Session session;
    @Override
    protected Session getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    public LocationFacade() {
        super(Location.class);
    }



    
}
