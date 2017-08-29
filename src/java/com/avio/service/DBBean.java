/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.service;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean(name = "db", eager = true)
@ApplicationScoped
public class DBBean {
    
    private EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default", null);;

    public DBBean() {
    }

    public EntityManagerFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(EntityManagerFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
