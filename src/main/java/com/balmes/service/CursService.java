package com.balmes.service;

import com.balmes.exceptions.ResourceNotFoundException;
import com.balmes.model.Curs;
import com.balmes.model.Estudiant;
import com.balmes.repositories.CursRepository;
import com.balmes.repositories.EstudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursService {
    @Autowired
    private EstudiantRepository studentRepository;

    @Autowired
    private CursRepository cursRepository;

    public List<Curs> getCurs() {
        return cursRepository.findAll();
    }

    public Curs getCursById(int id) {
        Optional<Curs> curs = cursRepository.findById(id);
        return curs.get();
    }

    public Curs saveCurs(Curs curs) {
        return cursRepository.save(curs);
    }
}
