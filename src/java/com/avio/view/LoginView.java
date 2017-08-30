/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.User;
import com.avio.model.UserType;
import com.avio.service.UserRepository;
import java.io.IOException;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
@SessionScoped
public class LoginView {
    public final Logger log = LoggerFactory.getLogger(getClass());
    
    String username;
    String password;
    String message = null;
    
    @ManagedProperty(value = "#{userRepository}")
    private UserRepository userRepository;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public String logIn() throws IOException {
        String msg = null;
        User user = userRepository.findOne(username);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (user == null) {
            msg = "Korisničko ime ne postoji";
            username = null;
            password = null;
        } else if (!password.equals(user.getPassword())) {
            msg = "Pogrešna lozinka";
            password = null;
        }
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)){
            
            facesContext.getExternalContext().getSessionMap().put("user", user);
            
            switch (user.getUserType()) {
                case ADMIN :            return "admin";
                case PILOT :            return "pilot";
                case FLIGHT_ATTENDANT : return "flight_attendant";
                case WORKER :           return "worker";
                default:                return "";
            }
        } else {
            facesContext.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
            UIViewRoot viewRoot = facesContext.getViewRoot();
            log.info("ViewRoot: {}", viewRoot.getChildren().toString());
            UIComponent component = viewRoot.findComponent("loginLayoutUnit");
            if (component != null) {
                Map<String, Object> attributes = component.getAttributes();
                Object size = attributes.get("size");
                log.info("Size: {}", size.toString());
            } else {
                log.error("Component is null");
            }
            
            return "";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
}
