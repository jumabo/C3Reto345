package com.example.retos345.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Client;
import com.example.retos345.entities.ReportClient;
import com.example.retos345.entities.Reservation;
import com.example.retos345.repositories.ClientRepository;
import com.example.retos345.repositories.ReservationRepository;


@Service
public class ReservationService {
    
        @Autowired
        private ReservationRepository reservationRepository;

        @Autowired
        private ClientRepository clientRepository;

        public ReservationService(ReservationRepository reservationRepository) {
            this.reservationRepository = reservationRepository;
        }

        // METODOS CRUD
        // *******  INICIO REPORTES *********
        public List<ReportClient> getReservationsReportClients(){
            List<ReportClient> listReportClients = new ArrayList();
            List<Client> listClients = this.clientRepository.findAll();
            for(int i=0; i<listClients.size(); i++){
                ReportClient reportClient = new ReportClient(listClients.get(i));
                listReportClients.add(reportClient);
            }
            return listReportClients;
        }

        public String getReservationsReportStatus(){
            String result = "";
            List<Reservation> completed = this.reservationRepository.findByStatus("completed");
            List<Reservation> cancelled = this.reservationRepository.findByStatus("cancelled");
            result = "{" + "\"completed\":"+completed.size()+","
                +"\"cancelled\":"+cancelled.size()+"}";
            return result;
        }

        public List<Reservation> getReservationsReportDates(String start, String end){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
            formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));

            Date startDate = new Date();
            Date endDate = new Date(); 
            try {
                startDate = formatter.parse(start);
                endDate = formatter.parse(end);
            } catch (ParseException e) {
                e.printStackTrace(); 
            }
            return this.reservationRepository.findByStartDateBetween(startDate, endDate);
        }
        // *******  FIN REPORTES *********


        public List<Reservation> getListReservations(){
            return this.reservationRepository.findAll();
        }

        public Reservation getReservation(int id){
            if(!this.reservationRepository.findById(id).isEmpty()){
                return this.reservationRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Reservation crearReservation(Reservation reservation){
            return this.reservationRepository.save(reservation);
        }

        public void eliminarReservation(int id){
            if(!this.reservationRepository.findById(id).isEmpty()){
                this.reservationRepository.deleteById(id);
            }
        }

        public void actualizarReservation(int id, Reservation reservation){
            if(!this.reservationRepository.findById(id).isEmpty()){
                Reservation reservationDB = this.reservationRepository.findById(id).get();

                this.reservationRepository.save(reservationDB);
            }
        }
}
