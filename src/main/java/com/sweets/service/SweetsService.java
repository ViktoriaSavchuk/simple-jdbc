package com.sweets.service;

import com.sweets.entity.Sweet;
import com.sweets.repositoty.SweetRepo;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SweetsService {

    private SweetRepo sweetRepo;

    public SweetsService(SweetRepo sweetRepo) {
        this.sweetRepo = sweetRepo;
    }

    public List<Sweet> findAll() {
        return sweetRepo.findAll();
    }

    public Optional<Sweet> findEntityById(Long id) {
        return sweetRepo.findEntityById(id);
    }

    public Sweet addSweet(Sweet sweet) {
        return sweetRepo.createSweet(sweet);
    }

    public void close(Statement st) {
        sweetRepo.close(st);
    }
}
