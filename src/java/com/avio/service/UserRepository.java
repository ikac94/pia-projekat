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
    
    public List<User> findAll() {
        EntityManagerFactory sessionFactory = dBBean.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> result = entityManager.createQuery("from User", User.class).getResultList();
        result.forEach((user) -> {
            System.out.println( "User (" + user.getName()+ ") : " + user.getEmail());
        });
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
    
    
}
