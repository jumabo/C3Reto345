package com.example.retos345.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
public class Message implements Serializable{

    //***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText")
    private String messageText;

    //***** RELACIONES *****
    //Relacion Muchos a uno. El Message tiene enlazados un Client y Un Farm
    
    
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
	@JoinColumn(name = "farm_id")
	private Farm farm;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
	@JoinColumn(name = "client_id")
	private Client client;


    //***** METODOS *****

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    
}
