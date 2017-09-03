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
@Table(name = "flight_crew", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "FlightCrew.findAll", query = "SELECT f FROM FlightCrew f")
    , @NamedQuery(name = "FlightCrew.findById", query = "SELECT f FROM FlightCrew f WHERE f.id = :id")
    , @NamedQuery(name = "FlightCrew.findByFlightId", query = "SELECT f FROM FlightCrew f WHERE f.flightId = :flightId")
    , @NamedQuery(name = "FlightCrew.findByUserId", query = "SELECT f FROM FlightCrew f WHERE f.userId = :userId")})
public class FlightCrew implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "flight_id")
    private long flightId;
    
    @Basic(optional = false)
    @Column(name = "user_id")
    private long userId;

}
