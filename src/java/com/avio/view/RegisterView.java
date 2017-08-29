/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.Sex;
import com.avio.model.User;
import com.avio.model.UserType;
import com.avio.service.UserRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
@RequestScoped
public class RegisterView {
    
    public final Logger log = LoggerFactory.getLogger(getClass());
    
    private String name;
    private String sex;
    private String birthday;
    private String email;
    private String airline;
    private String userType;
    private String username;
    private String password;
    private String passwordConfirm;
    
    private List<SelectItem> sexes;
    private List<SelectItem> airlines;
    private List<SelectItem> userTypes;
    
    @ManagedProperty(value = "#{userRepository}")
    private UserRepository userRepository;
    
    @PostConstruct
    public void init() {
        //sexes
        sexes = new ArrayList<>();
        sexes.add(new SelectItem("M", "Muški"));
        sexes.add(new SelectItem("F", "Ženski"));
        
        //airlines
        airlines = new ArrayList<>();
        //TODO populate airlines
        airlines.add(new SelectItem("placeholder", "placeholder"));
        
        //userTypes
        userTypes = new ArrayList<>();
        UserType.getValues().forEach(type -> {
            if (type != UserType.ADMIN) {
                userTypes.add(new SelectItem(type.getDesc(), type.getDesc()));
            }
        });
    }

    public RegisterView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<SelectItem> getSexes() {
        return sexes;
    }

    public void setSexes(List<SelectItem> sexes) {
        this.sexes = sexes;
    }

    public List<SelectItem> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<SelectItem> airlines) {
        this.airlines = airlines;
    }

    public List<SelectItem> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<SelectItem> userTypes) {
        this.userTypes = userTypes;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    public String register() {
        User user = new User();
        user.setAirlineId(-1L);
        log.info("Birthday : {}", birthday);
        user.setBirthday(Date.valueOf(birthday));
        user.setConfirmed(false);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setSex(Sex.ofValue(sex));
        user.setUserType(UserType.ofValue(userType));
        user.setUsername(username);
        
        userRepository.save(user);
        
        User savedUser = userRepository.findOne(username);
        if (savedUser != null) {
            return "index";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage("loginMsg", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška!", "Greška!"));
            return "";
        }
    }
    
}
