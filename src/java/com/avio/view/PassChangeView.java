/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.persistence.User;
import com.avio.service.UserRepository;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

/**
 *
 * @author Ilija Knezevic
 */
@Data
@ManagedBean
@RequestScoped
public class PassChangeView {
    
    private String username;
    private String oldPass;
    private String newPass;
    private String passConfirm;
    
    @ManagedProperty(value = "#{userRepository}")
    private UserRepository userRepository;

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
