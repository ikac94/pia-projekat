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
@Table(name = "flight_reservations", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "FlightReservations.findAll", query = "SELECT f FROM FlightReservations f")
    , @NamedQuery(name = "FlightReservations.findById", query = "SELECT f FROM FlightReservations f WHERE f.id = :id")
    , @NamedQuery(name = "FlightReservations.findByFlightId", query = "SELECT f FROM FlightReservations f WHERE f.flightId = :flightId")
    , @NamedQuery(name = "FlightReservations.findByName", query = "SELECT f FROM FlightReservations f WHERE f.name = :name")
    , @NamedQuery(name = "FlightReservations.findByPassport", query = "SELECT f FROM FlightReservations f WHERE f.passport = :passport")
    , @NamedQuery(name = "FlightReservations.findByCreditCard", query = "SELECT f FROM FlightReservations f WHERE f.creditCard = :creditCard")
    , @NamedQuery(name = "FlightReservations.findByConfirmationPass", query = "SELECT f FROM FlightReservations f WHERE f.confirmationPass = :confirmationPass")})
public class FlightReservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "flight_id")
    private long flightId;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "passport")
    private long passport;
    
    @Basic(optional = false)
    @Column(name = "credit_card")
    private long creditCard;
    
    @Basic(optional = false)
    @Column(name = "confirmation_pass")
    private String confirmationPass;

}
