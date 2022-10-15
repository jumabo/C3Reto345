package com.example.retos345.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos345.entities.Farm;
import com.example.retos345.services.FarmService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Farm")
public class FarmController {    

    @Autowired
    FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Farm>> getFarms(){
        return new ResponseEntity<List<Farm>>(this.farmService.getListFarms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable("id") int id){
        return new ResponseEntity<Farm>(this.farmService.getFarm(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearFarm(@RequestBody Farm farm){
        this.farmService.crearFarm(farm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  eliminarFarm(@PathVariable("id") int id){
        this.farmService.eliminarFarm(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>  actualizarFarm(@RequestBody Farm farm){
        this.farmService.actualizarFarm(farm.getId(), farm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    

}
