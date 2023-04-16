package ru.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ms.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    
}
