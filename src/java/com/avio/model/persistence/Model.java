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
@Table(name = "model", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
    , @NamedQuery(name = "Model.findById", query = "SELECT m FROM Model m WHERE m.id = :id")
    , @NamedQuery(name = "Model.findByManufacturerId", query = "SELECT m FROM Model m WHERE m.manufacturerId = :manufacturerId")
    , @NamedQuery(name = "Model.findByName", query = "SELECT m FROM Model m WHERE m.name = :name")
    , @NamedQuery(name = "Model.findByLicence", query = "SELECT m FROM Model m WHERE m.licence = :licence")
    , @NamedQuery(name = "Model.findByCapacity", query = "SELECT m FROM Model m WHERE m.capacity = :capacity")})
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "manufacturer_id")
    private long manufacturerId;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "licence")
    private String licence;
    
    @Basic(optional = false)
    @Column(name = "capacity")
    private int capacity;
 
}
