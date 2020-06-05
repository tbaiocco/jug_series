package com.sap.jugSession.repository;

import com.sap.jugSession.model.Musician;
import org.springframework.data.repository.CrudRepository;

public interface MusicianRepository extends CrudRepository<Musician, Integer>
{
}
