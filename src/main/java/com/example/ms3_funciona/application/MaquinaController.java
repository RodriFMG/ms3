package com.example.ms3_funciona.application;

import com.example.ms3_funciona.Service.MaquinaService;
import com.example.ms3_funciona.Domain.Maquina;

//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Maquina", description = "Maquina de productos")
@RestController
@RequestMapping("/maquina")
@CrossOrigin(origins = "http://localhost:19006")
public class MaquinaController {
    @Autowired
    private MaquinaService maquinaService;


    @GetMapping
    public ResponseEntity<List<Maquina>> AllMaquinas(){
        List<Maquina> maquina = maquinaService.getAllMaquina();
        return new ResponseEntity<>(maquina,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> PostMaquina(@RequestBody Maquina maquina){
        maquinaService.saveMaquina(maquina);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMaquina(@PathVariable Long id, @RequestBody Maquina maquina){
        Optional<Maquina> updatedMaquina = maquinaService.updateMaquina(id,maquina);
        return updatedMaquina.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchMaquina(@PathVariable Long id, @RequestBody Maquina maquina){
        Optional<Maquina> patchedMaquina = maquinaService.patchMaquina(id,maquina);
        return patchedMaquina.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaquina(@PathVariable Long id) {
        Optional<Maquina> deletedMaquina = maquinaService.deleteMaquina(id);
        return deletedMaquina.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }

}

