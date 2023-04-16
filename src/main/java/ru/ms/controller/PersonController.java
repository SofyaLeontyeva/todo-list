package ru.ms.controller;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ms.repository.PersonRepository;
import ru.ms.entity.*;
import ru.ms.dto.*;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    private Function<PersonEntity, PersonResponse> personMapper;

    @PostConstruct
    public void init(){
        personMapper = x->{
            PersonResponse p = new PersonResponse();
            p.setId(x.getId());
            p.setName(x.getName());
            p.setAge(x.getAge());
            return p;
        };
    }


    @GetMapping("/persons")
    public ResponseEntity<List<PersonResponse>> getPersons(){

        List<PersonEntity> persons = personRepository.findAll();
        
        List<PersonResponse> body = persons.stream()
        .map(personMapper)
        .collect(Collectors.toList());

        return ResponseEntity.ok(body);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable Integer id){

        PersonEntity person = personRepository.findById(id).orElse(null);
        
       
        if (person == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
       
        return ResponseEntity.ok(personMapper.apply(person));
       
    }

    @PostMapping("/persons")
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest request){

        Integer lastId = personRepository.findAll().stream()
        .map(x->x.getId()).max(Comparator.naturalOrder()).get();

        PersonEntity entity = new PersonEntity();
        entity.setId(lastId+1);
        entity.setName(request.getName());
        entity.setAge(request.getAge());

        try{
        entity = personRepository.save(entity);
        }catch(Exception e){
            System.out.println("Ошибка : "+ e.toString());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(entity.getId()));
    }



    
}
