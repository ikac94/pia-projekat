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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "airline", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Airline.findAll", query = "SELECT a FROM Airline a")
    , @NamedQuery(name = "Airline.findById", query = "SELECT a FROM Airline a WHERE a.id = :id")
    , @NamedQuery(name = "Airline.findByName", query = "SELECT a FROM Airline a WHERE a.name = :name")
    , @NamedQuery(name = "Airline.findByAddress", query = "SELECT a FROM Airline a WHERE a.address = :address")
    , @NamedQuery(name = "Airline.findByWebsite", query = "SELECT a FROM Airline a WHERE a.website = :website")
    , @NamedQuery(name = "Airline.findByEmail", query = "SELECT a FROM Airline a WHERE a.email = :email")})
public class Airline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
}
