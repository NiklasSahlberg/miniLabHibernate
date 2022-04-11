package com.example.minilabhibernate.controllers;

import com.example.minilabhibernate.models.Kompis;
import com.example.minilabhibernate.repositories.KompisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kompis")
public class KompisController {
    @Autowired
    private KompisRepository kompisRepository;


    @RequestMapping("/add")
    public String addNewKompis (@RequestParam String name, @RequestParam String email, @RequestParam String phoneNumber)
    {
        Kompis n = new Kompis();
        n.setName(name);
        n.setEmail(email);
        n.setPhoneNumber(phoneNumber);
        kompisRepository.save(n);
        return "saved";
    }
    @RequestMapping("/all")
    public Iterable<Kompis> getAllKompisar(){
        return kompisRepository.findAll();
    }


    @GetMapping ("/kompisByName")
    public Iterable<Kompis>getKompisByName(@RequestParam(required = false) String name)
    {
        if (name != null)
        {
            return kompisRepository.findByName(name);

        }

        return null;
    }

    @GetMapping("/kompisByNumber")
    public Iterable<Kompis>getKompisByNumber(@RequestParam(required = false) String phoneNumber)
    {
        if (phoneNumber != null)
        {
            return kompisRepository.findByPhoneNumber(phoneNumber);
        }
        return null;
    }

    @GetMapping("/deleteKompis")
    public String deleteKompisById(@RequestParam(required = false) long id)
    {

        kompisRepository.deleteById(id);

        return "Kompis deleted";
    }

    @GetMapping("/addOrUpdate")
    public String addOrUpdate(@RequestParam (required = false) String phoneNumber,@RequestParam(required = false) Long id)
    {
        Kompis n = new Kompis();
        n.setId(id);
        n.setPhoneNumber(phoneNumber);
        kompisRepository.save(n);
        return "Updated";
    }
}


