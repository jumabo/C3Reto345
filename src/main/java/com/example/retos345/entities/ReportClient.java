package com.example.retos345.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReportClient {
    private int total;
    private Client client;

    public ReportClient(Client client){
        this.client = client;
        this.total = client.getReservations().size();

        List<Reservation> listReservation = new ArrayList<>(client.getReservations());
        Collections.sort(listReservation, new Comparator<Reservation> (){
            @Override
            public int compare(Reservation r1, Reservation r2){
                return r1.getIdReservation().compareTo(r2.getIdReservation());
            }
        });

        Set<Reservation> hSet = new HashSet<Reservation>(listReservation);
        this.client.setReservations(hSet);
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    
}
