package com.example.Makersmarkt.service;

import com.example.Makersmarkt.Exception.RecordNotFoundException;
import com.example.Makersmarkt.model.MarktOndernemer;
import com.example.Makersmarkt.repository.MarktOndernemerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarktOndernemerService {

    private final MarktOndernemerRepository repository;

    public MarktOndernemerService(MarktOndernemerRepository repository) {
        this.repository = repository;
    }

    public List<MarktOndernemer> getMarktOndernemers() {
        return repository.findAll();
    }

    public MarktOndernemer getMarktOndernemer(Long ondernemerId) {
        return repository.findById(ondernemerId)
                .orElseThrow(() -> new RecordNotFoundException("MarktOndernemer with ID " + ondernemerId + " does not exist"));
    }

    public MarktOndernemer saveMarktOndernemer(MarktOndernemer ondernemer) {
        return repository.save(ondernemer);
    }

    public MarktOndernemer updateMarktOndernemer(Long ondernemerId, MarktOndernemer ondernemer) {
        return repository.findById(ondernemerId)
                .map(existingOndernemer -> {
                    if (ondernemer.getWebsite() != null) existingOndernemer.setWebsite(ondernemer.getWebsite());
                    if (ondernemer.getMarkten() != null) existingOndernemer.setMarkten(ondernemer.getMarkten());
                    return repository.save(existingOndernemer);
                })
                .orElseThrow(() -> new RecordNotFoundException("MarktOndernemer with ID " + ondernemerId + " does not exist"));
    }

    public void deleteMarktOndernemer(Long ondernemerId) {
        if (!repository.existsById(ondernemerId)) {
            throw new RecordNotFoundException("MarktOndernemer with ID " + ondernemerId + " does not exist");
        }
        repository.deleteById(ondernemerId);
    }

    public MarktOndernemer createMarktOndernemer(MarktOndernemer marktOndernemer) {
        return repository.save(marktOndernemer);
    }

    public List<MarktOndernemer> getAllMarktOndernemers() {
        return null;
    }
}
