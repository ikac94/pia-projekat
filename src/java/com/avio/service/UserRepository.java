/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.service;

import com.avio.model.User;
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
    
    public User findOne(String username) {
        EntityManager entityManager = dBBean.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<User> query = entityManager.createQuery("from User u where u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (result != null && !result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }
    
    
    
    
}
