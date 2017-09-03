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
import javax.persistence.Lob;
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
@Table(name = "airplane", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Airplane.findAll", query = "SELECT a FROM Airplane a")
    , @NamedQuery(name = "Airplane.findById", query = "SELECT a FROM Airplane a WHERE a.id = :id")
    , @NamedQuery(name = "Airplane.findByModelId", query = "SELECT a FROM Airplane a WHERE a.modelId = :modelId")
    , @NamedQuery(name = "Airplane.findByAirlineId", query = "SELECT a FROM Airplane a WHERE a.airlineId = :airlineId")})
public class Airplane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "model_id")
    private long modelId;
    
    @Basic(optional = false)
    @Column(name = "airline_id")
    private long airlineId;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private byte[] image;

}
