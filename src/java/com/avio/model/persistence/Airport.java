/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.model.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Ilija Knezevic
 */
@Data
@Entity
@Table(name = "airport", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a")
    , @NamedQuery(name = "Airport.findById", query = "SELECT a FROM Airport a WHERE a.id = :id")
    , @NamedQuery(name = "Airport.findByIata", query = "SELECT a FROM Airport a WHERE a.iata = :iata")
    , @NamedQuery(name = "Airport.findByName", query = "SELECT a FROM Airport a WHERE a.name = :name")
    , @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city")
    , @NamedQuery(name = "Airport.findByCountry", query = "SELECT a FROM Airport a WHERE a.country = :country")
    , @NamedQuery(name = "Airport.findByRunwayNo", query = "SELECT a FROM Airport a WHERE a.runwayNo = :runwayNo")})
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "iata")
    private String iata;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @Column(name = "runway_no")
    private int runwayNo;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="airport")
    private List<Terminal> terminals;
}
