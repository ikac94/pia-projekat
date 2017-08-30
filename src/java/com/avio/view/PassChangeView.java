/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.User;
import com.avio.service.UserRepository;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
@RequestScoped
public class PassChangeView {
    
    private String username;
    private String oldPass;
    private String newPass;
    private String passConfirm;
    
    @ManagedProperty(value = "#{userRepository}")
    private UserRepository userRepository;

    public PassChangeView() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getPassConfirm() {
        return passConfirm;
    }

    public void setPassConfirm(String passConfirm) {
        this.passConfirm = passConfirm;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public String changePass() {
        User user = userRepository.findOne(username);
        if (user != null && user.getPassword().equals(oldPass) && newPass.equals(passConfirm)) {
            user.setPassword(newPass);
            userRepository.update(user);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "index";
        } else {
            return "";
        }
    }
    
    
}
