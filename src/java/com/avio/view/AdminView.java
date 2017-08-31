/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.User;
import com.avio.service.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
@SessionScoped
public class AdminView {
    
    List<User> requested;
    List<User> selected = new ArrayList<>();
    
    @ManagedProperty(value = "#{userRepository}")
    private UserRepository userRepository;

    public AdminView() {
        
    }
    
    @PostConstruct
    public void init() {
        requested = userRepository.findNotConfirmed();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getRequested() {
        return requested;
    }

    public void setRequested(List<User> requested) {
        this.requested = requested;
    }

    public List<User> getSelected() {
        return selected;
    }

    public void setSelected(List<User> selected) {
        this.selected = selected;
    }
    
    public void acceptMembership() {
        selected.forEach( user -> {
            user.setConfirmed(true);
            userRepository.update(user);
        });
        requested = userRepository.findNotConfirmed();
        selected = new ArrayList<>();
    }
    
    public void refresh() {
        requested = userRepository.findNotConfirmed();
    }
    
}
