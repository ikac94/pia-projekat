/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avio.model.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Ilija Knezevic
 */
@Data
@Entity
@Table(name = "flight", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
    , @NamedQuery(name = "Flight.findById", query = "SELECT f FROM Flight f WHERE f.id = :id")
    , @NamedQuery(name = "Flight.findByAirlineId", query = "SELECT f FROM Flight f WHERE f.airlineId = :airlineId")
    , @NamedQuery(name = "Flight.findByFlightNo", query = "SELECT f FROM Flight f WHERE f.flightNo = :flightNo")
    , @NamedQuery(name = "Flight.findByDepAirportId", query = "SELECT f FROM Flight f WHERE f.depAirportId = :depAirportId")
    , @NamedQuery(name = "Flight.findByArrAirportId", query = "SELECT f FROM Flight f WHERE f.arrAirportId = :arrAirportId")
    , @NamedQuery(name = "Flight.findByDivAirportId", query = "SELECT f FROM Flight f WHERE f.divAirportId = :divAirportId")
    , @NamedQuery(name = "Flight.findByDepDt", query = "SELECT f FROM Flight f WHERE f.depDt = :depDt")
    , @NamedQuery(name = "Flight.findByArrDt", query = "SELECT f FROM Flight f WHERE f.arrDt = :arrDt")
    , @NamedQuery(name = "Flight.findByPlannedArrDt", query = "SELECT f FROM Flight f WHERE f.plannedArrDt = :plannedArrDt")
    , @NamedQuery(name = "Flight.findByEstArrDt", query = "SELECT f FROM Flight f WHERE f.estArrDt = :estArrDt")
    , @NamedQuery(name = "Flight.findByDuration", query = "SELECT f FROM Flight f WHERE f.duration = :duration")
    , @NamedQuery(name = "Flight.findByAirplaneId", query = "SELECT f FROM Flight f WHERE f.airplaneId = :airplaneId")
    , @NamedQuery(name = "Flight.findByStatus", query = "SELECT f FROM Flight f WHERE f.status = :status")
    , @NamedQuery(name = "Flight.findByCharter", query = "SELECT f FROM Flight f WHERE f.charter = :charter")
    , @NamedQuery(name = "Flight.findByDepGateId", query = "SELECT f FROM Flight f WHERE f.depGateId = :depGateId")
    , @NamedQuery(name = "Flight.findByArrGateId", query = "SELECT f FROM Flight f WHERE f.arrGateId = :arrGateId")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "airline_id")
    private long airlineId;
    
    @Basic(optional = false)
    @Column(name = "flight_no")
    private int flightNo;
    
    @Basic(optional = false)
    @Column(name = "dep_airport_id")
    private long depAirportId;
    
    @Basic(optional = false)
    @Column(name = "arr_airport_id")
    private long arrAirportId;
    
    @Basic(optional = false)
    @Column(name = "div_airport_id")
    private long divAirportId;
    
    @Basic(optional = false)
    @Column(name = "dep_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depDt;
    
    @Basic(optional = false)
    @Column(name = "arr_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrDt;
    
    @Basic(optional = false)
    @Column(name = "planned_arr_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedArrDt;
    
    @Basic(optional = false)
    @Column(name = "est_arr_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estArrDt;
    
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    
    @Basic(optional = false)
    @Column(name = "airplane_id")
    private long airplaneId;
    
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    
    @Basic(optional = false)
    @Column(name = "charter")
    private boolean charter;
    
    @Basic(optional = false)
    @Column(name = "dep_gate_id")
    private long depGateId;
    
    @Basic(optional = false)
    @Column(name = "arr_gate_id")
    private long arrGateId;

}
