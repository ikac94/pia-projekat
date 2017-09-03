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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "airplane_lease", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "AirplaneLease.findAll", query = "SELECT a FROM AirplaneLease a")
    , @NamedQuery(name = "AirplaneLease.findById", query = "SELECT a FROM AirplaneLease a WHERE a.id = :id")
    , @NamedQuery(name = "AirplaneLease.findByAirplaneId", query = "SELECT a FROM AirplaneLease a WHERE a.airplaneId = :airplaneId")
    , @NamedQuery(name = "AirplaneLease.findByLeaseBy", query = "SELECT a FROM AirplaneLease a WHERE a.leaseBy = :leaseBy")
    , @NamedQuery(name = "AirplaneLease.findByLeaseTo", query = "SELECT a FROM AirplaneLease a WHERE a.leaseTo = :leaseTo")
    , @NamedQuery(name = "AirplaneLease.findByLeaseStart", query = "SELECT a FROM AirplaneLease a WHERE a.leaseStart = :leaseStart")
    , @NamedQuery(name = "AirplaneLease.findByLeaseEnd", query = "SELECT a FROM AirplaneLease a WHERE a.leaseEnd = :leaseEnd")
    , @NamedQuery(name = "AirplaneLease.findByCompensationAmount", query = "SELECT a FROM AirplaneLease a WHERE a.compensationAmount = :compensationAmount")
    , @NamedQuery(name = "AirplaneLease.findByStatus", query = "SELECT a FROM AirplaneLease a WHERE a.status = :status")})
public class AirplaneLease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "airplane_id")
    private long airplaneId;
    
    @Basic(optional = false)
    @Column(name = "lease_by")
    private long leaseBy;
    
    @Basic(optional = false)
    @Column(name = "lease_to")
    private long leaseTo;
    
    @Basic(optional = false)
    @Column(name = "lease_start")
    @Temporal(TemporalType.DATE)
    private Date leaseStart;
    
    @Basic(optional = false)
    @Column(name = "lease_end")
    @Temporal(TemporalType.DATE)
    private Date leaseEnd;
    
    @Basic(optional = false)
    @Column(name = "compensation_amount")
    private int compensationAmount;
    
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

}
