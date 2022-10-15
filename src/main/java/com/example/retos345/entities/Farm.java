package com.example.retos345.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "farm")
public class Farm implements Serializable{

    //***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "extension")
    private Integer extension;

    @Column(name = "description")
    private String description;

    

    

    

    //***** RELACIONES *****
    //Relación uno a uno. Una Farm tiene un Category relacionada.
    @ManyToOne(optional = true)
    @JsonIgnoreProperties(value = {"farms"})
	@JoinColumn(name = "category_id")
	private Category category;
    // @OneToOne
	// @JoinColumn(name = "category_id")
	// private Category category;

    // Un Farm puede tener muchas Reservation y Messages.
    
    

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"client", "farm"})
    // @JsonIgnoreProperties("farm")
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    


    //***** METODOS *****
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    
}