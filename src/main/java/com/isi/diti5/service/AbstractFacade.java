/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 *
 * @author mac
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    protected abstract Session getSession();

    public void create(T entity) {
        Transaction tx = null;
        Session session = getSession();

        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }

    public void edit(T entity) {
        Transaction tx = null;
        Session session = getSession();

        try {
            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }



        //getSession().merge(entity);
    }

    public void remove(T entity) {
        Transaction tx = null;
        Session session = getSession();

        try {
            tx = session.beginTransaction();
            session.delete(session.merge(entity));
            tx.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }



      //  getSession().delete(getSession().merge(entity));
    }


    public T find(Long id) {

        return (T) getSession().get(entityClass, id);
    }

    public List<T> findAll() {
        return getSession().createCriteria(entityClass).list();
    }



    
}
