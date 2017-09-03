/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.service;

import com.avio.model.persistence.Airport;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean(name = "airportRepository")
@ApplicationScoped
public class AirportRepository {
    
    @ManagedProperty(value = "#{db}")
    private DBBean dBBean;
    
    public AirportRepository() {
    }
    
    public DBBean getdBBean() {
        return dBBean;
    }

    public void setdBBean(DBBean dBBean) {
        this.dBBean = dBBean;
    }
    
    public List<Airport> findOne(Long id) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("Airport.findAll", Airport.class);
        List<Airport> airports = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return airports;
    }
    
}
