/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;


import com.isi.diti5.model.Client;
import com.isi.diti5.utils.HibernateUtil;
import org.hibernate.Session;


import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author mac
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    private Session  session;
    @Override
    protected Session getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    public ClientFacade() {
        super(Client.class);
    }


    @Override
    public Client getClientByNumpiece(String numpiece) {
       List<Client> clients=  getSession().createQuery("SELECT c from Client c where c.numpiece  = :nump").setParameter("nump",numpiece).list();
       if(clients.size() > 0)
       {
           return  clients.get(0);
       }
        return null;
    }
}
