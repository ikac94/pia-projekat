/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ilija Knezevic
 */
@ManagedBean
public class RegisterView {
    private String name;
    private String sex;
    private String birthday;
    private String email;
    private String airline;
    private String username;
    private String password;
    private String passwordConfirm;
    
    private List<SelectItem> sexes;
    private List<SelectItem> airlines;
    
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
    
    
    public void register() {
        
    }
    
}
