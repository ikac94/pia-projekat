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
@Table(name = "checkpoint", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Checkpoint.findAll", query = "SELECT c FROM Checkpoint c")
    , @NamedQuery(name = "Checkpoint.findById", query = "SELECT c FROM Checkpoint c WHERE c.id = :id")
    , @NamedQuery(name = "Checkpoint.findByCityCountry", query = "SELECT c FROM Checkpoint c WHERE c.cityCountry = :cityCountry")})
public class Checkpoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "city_country")
    private String cityCountry;
   
}
