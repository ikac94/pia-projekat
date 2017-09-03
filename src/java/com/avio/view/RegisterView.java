/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.view;

import com.avio.model.Sex;
import com.avio.model.persistence.User;
import com.avio.model.UserType;
import com.avio.service.UserRepository;
import com.avio.util.TimeUtils;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ilija Knezevic
 */
@Data
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
    
    public String register() throws ParseException {
        boolean error = false;
        String msg = null;
        User user = new User();
        user.setAirlineId(-1L);
        //Sat Jan 01 00:01:00 CET 2000
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
        Date date = new Date(format.parse(birthday).getTime());
        if (TimeUtils.getDateDiff(date, new Date(System.currentTimeMillis()), TimeUnit.DAYS) < 18*365L) {
            error = true;
            msg = "Samo za starije od 18 godina!";
        }
        user.setBirthday(date);
        user.setConfirmed(false);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setSex(Sex.ofValue(sex));
        user.setUserType(UserType.ofValue(userType));
        user.setUsername(username);
        
        if (!password.equals(passwordConfirm)) {
            error = true;
            msg = "Ponovo unesite lozinku!";
        }
        
        if (!error) {
            userRepository.save(user);
        }
        
        User savedUser = userRepository.findOne(username);
        if (savedUser != null) {
            return "index";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
            return "";
        }
    }
    
}
