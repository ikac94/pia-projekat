/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.model.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Ilija Knezevic
 */
@Data
@Entity
@Table(name = "pilot_licence", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "PilotLicence.findAll", query = "SELECT p FROM PilotLicence p")
    , @NamedQuery(name = "PilotLicence.findById", query = "SELECT p FROM PilotLicence p WHERE p.id = :id")
    , @NamedQuery(name = "PilotLicence.findByUserId", query = "SELECT p FROM PilotLicence p WHERE p.userId = :userId")
    , @NamedQuery(name = "PilotLicence.findByLicence", query = "SELECT p FROM PilotLicence p WHERE p.licence = :licence")})
public class PilotLicence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    
    @Basic(optional = false)
    @Column(name = "licence")
    private String licence;
  
}
