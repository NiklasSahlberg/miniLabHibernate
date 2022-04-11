package com.example.minilabhibernate.repositories;

import com.example.minilabhibernate.models.Kompis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KompisRepository extends CrudRepository<Kompis, Long> {
    List<Kompis>findByName(String name);
    List<Kompis>findByEmail(String email);
    List<Kompis>findByPhoneNumber(String phoneNumber);

}
