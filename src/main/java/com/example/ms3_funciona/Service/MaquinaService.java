package com.example.ms3_funciona.Service;

import com.example.ms3_funciona.Domain.Maquina;

import com.example.ms3_funciona.Infrastracture.MaquinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
public class MaquinaService {
    @Autowired
    public MaquinaRepository maquinaRepository;


    public List<Maquina> getAllMaquina() { return maquinaRepository.findAll(); }

    public Maquina saveMaquina(Maquina maquina){ return maquinaRepository.save(maquina); }

    public Optional<Maquina> updateMaquina(Long id, Maquina maquina){
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if(optionalMaquina.isPresent()){
            Maquina eixstingMaquina = optionalMaquina.get();
            eixstingMaquina.setUbicacion(maquina.getUbicacion());
            eixstingMaquina.setImg(maquina.getImg());
            eixstingMaquina.setTipo(maquina.getTipo());
            maquinaRepository.save(eixstingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> patchMaquina(Long id,Maquina maquina) {
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if (optionalMaquina.isPresent()) {
            Maquina existingMaquina = optionalMaquina.get();
            if (maquina.getUbicacion() != null) {
                existingMaquina.setUbicacion(maquina.getUbicacion());
            }
            if (maquina.getImg() != null) {
                existingMaquina.setImg(maquina.getImg());
            }
            if(maquina.getTipo() != null){
                existingMaquina.setTipo(maquina.getTipo());
            }
            maquinaRepository.save(existingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> deleteMaquina(Long id) {
        Optional<Maquina> optionalMaquina = maquinaRepository.findById(id);
        if (optionalMaquina.isPresent()) {
            Maquina existingMaquina = optionalMaquina.get();
            maquinaRepository.delete(existingMaquina);
        }
        return optionalMaquina;
    }

    public Optional<Maquina> getMaquina(Long id) {
        return maquinaRepository.findById(id);
    }

}
