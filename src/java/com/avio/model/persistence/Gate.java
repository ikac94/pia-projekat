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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gate", catalog = "avio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gate.findAll", query = "SELECT g FROM Gate g")
    , @NamedQuery(name = "Gate.findById", query = "SELECT g FROM Gate g WHERE g.id = :id")
    , @NamedQuery(name = "Gate.findByTerminalId", query = "SELECT g FROM Gate g WHERE g.terminalId = :terminalId")
    , @NamedQuery(name = "Gate.findByName", query = "SELECT g FROM Gate g WHERE g.name = :name")})
public class Gate implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
    @JoinColumn(name = "terminal_id", referencedColumnName = "id", nullable = false)
    private Terminal terminal;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

}
