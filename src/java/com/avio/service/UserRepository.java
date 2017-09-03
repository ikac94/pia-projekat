/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.service;

import com.avio.model.persistence.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean(name = "userRepository")
@ApplicationScoped
public class UserRepository {
    
    @ManagedProperty(value = "#{db}")
    private DBBean dBBean;

    public UserRepository() {
    }

    public DBBean getdBBean() {
        return dBBean;
    }

    public void setdBBean(DBBean dBBean) {
        this.dBBean = dBBean;
    }
    
    public User findOne(Long id) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }
    
    public User findOne(String username) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        List<User> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return (resultList != null && resultList.size() >= 1) ? resultList.get(0) : null;
    }
    
    public List<User> findNotConfirmed() {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByConfirmed", User.class);
        query.setParameter("confirmed", 0);
        List<User> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList != null ? resultList : new ArrayList<>();
    }
    
    public void save(User user) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void update(User user) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
     
}
