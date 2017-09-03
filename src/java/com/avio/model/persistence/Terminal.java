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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "terminal", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t")
    , @NamedQuery(name = "Terminal.findById", query = "SELECT t FROM Terminal t WHERE t.id = :id")
    , @NamedQuery(name = "Terminal.findByAirportId", query = "SELECT t FROM Terminal t WHERE t.airportId = :airportId")
    , @NamedQuery(name = "Terminal.findByName", query = "SELECT t FROM Terminal t WHERE t.name = :name")})
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Airport.class)
    @JoinColumn(name = "airport_id", referencedColumnName = "id", nullable = false)
    private Airport airport;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="terminal")
    private List<Gate> gates;

}
