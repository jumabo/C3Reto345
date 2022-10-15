package com.example.retos345.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Farm;
import com.example.retos345.repositories.FarmRepository;


@Service
public class FarmService {
    
        @Autowired
        private FarmRepository farmRepository;

        public FarmService(FarmRepository farmRepository) {
            this.farmRepository = farmRepository;
        }

        // METODOS CRUD
        public List<Farm> getListFarms(){
            return this.farmRepository.findAll();
        }

        public Farm getFarm(int id){
            if(!this.farmRepository.findById(id).isEmpty()){
                return this.farmRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Farm crearFarm(Farm farm){
            return this.farmRepository.save(farm);
        }

        public void eliminarFarm(int id){
            if(!this.farmRepository.findById(id).isEmpty()){
                this.farmRepository.deleteById(id);
            }
        }

        public void actualizarFarm(int id, Farm farm){
            if(!this.farmRepository.findById(id).isEmpty()){
                Farm farmDB = this.farmRepository.findById(id).get();
                if(farm.getName() != null){
                    farmDB.setName(farm.getName());
                }
                if(farm.getAddress() != null){
                    farmDB.setAddress(farm.getAddress());
                }
                if(farm.getDescription() != null){
                    farmDB.setDescription(farm.getDescription());
                }
                if(farm.getExtension() != null){
                    farmDB.setExtension(farm.getExtension());
                }
                this.farmRepository.save(farmDB);
            }
        }
}
