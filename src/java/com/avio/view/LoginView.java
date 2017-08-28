/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import javax.faces.bean.ManagedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
public class LoginView {
    public final Logger log = LoggerFactory.getLogger(getClass());
    
    String username;
    String password;

    public LoginView() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void logIn() {
        log.info("Username: {}, password: {}", username, password);
    }
}
