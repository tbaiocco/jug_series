package com.sap.jugSession.controller;

import com.sap.jugSession.model.Musician;
import com.sap.jugSession.repository.MusicianRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/musicians")
public class MusicianController
{
    private MusicianRepository musicianRepository;

    public MusicianController(MusicianRepository musicianRepository) {
        super();
        this.musicianRepository = musicianRepository;
    }

    @PostMapping
    public ResponseEntity<Musician> save(@RequestBody Musician musician) {
        musicianRepository.save(musician);
        return new ResponseEntity<>(musician, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Musician> update(@PathVariable Integer id, @RequestBody Musician newMusician) {
        return musicianRepository.findById(id)
                .map(musician -> {
                    musician.setFirstName(newMusician.getFirstName());
                    musician.setLastName(newMusician.getLastName());
                    musician.setCareer(newMusician.getCareer());
                    Musician musicianUpd = musicianRepository.save(musician);
                    return ResponseEntity.ok(musicianUpd);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Musician>> findAll() {
        List<Musician> target = new ArrayList<>();
        musicianRepository.findAll().forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Musician>> findById(@PathVariable Integer id) {
        Optional<Musician> musician;
        try {
            musician = musicianRepository.findById(id);
            return new ResponseEntity<>(musician, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Musician>> deleteById(@PathVariable Integer id) {
        Optional<Musician> musician;
        try {
            musicianRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
